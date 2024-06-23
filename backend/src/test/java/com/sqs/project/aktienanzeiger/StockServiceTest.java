package com.sqs.project.aktienanzeiger.service;

import com.sqs.project.aktienanzeiger.model.StockData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class StockServiceTest {

    @Mock
    private ApiCommunicationService apiService;

    @Mock
    private CacheService cacheService;

    @Mock
    private DataProcessingService dataProcessingService;

    @InjectMocks
    private StockService stockService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetStockData_FromCache() throws IOException {
        String symbol = "AAPL";
        String date = "2022-01-01";
        String key = symbol + ":" + date;
        String cachedData = "{\"symbol\":\"AAPL\",\"date\":\"2022-01-01\",\"price\":150.0}";

        when(cacheService.getFromCache(key)).thenReturn(cachedData);
        StockData expectedStockData = new StockData();
        expectedStockData.setSymbol("AAPL");
        expectedStockData.setFrom("2022-01-01");
        expectedStockData.setClose(150.0);
        when(dataProcessingService.parseStockData(cachedData)).thenReturn(expectedStockData);

        StockData actualStockData = stockService.getStockData(symbol, date);

        verify(cacheService, times(1)).getFromCache(key);
        verify(apiService, never()).fetchData(anyString(), anyString());
        verify(cacheService, never()).saveToCache(anyString(), anyString(), anyLong(), any(TimeUnit.class));
        verify(dataProcessingService, times(1)).parseStockData(cachedData);

        assertEquals(expectedStockData, actualStockData);
    }

    @Test
    void testGetStockData_FromApi() throws IOException {
        String symbol = "AAPL";
        String date = "2022-01-01";
        String key = symbol + ":" + date;
        String apiData = "{\"symbol\":\"AAPL\",\"date\":\"2022-01-01\",\"price\":150.0}";

        when(cacheService.getFromCache(key)).thenReturn(null);
        when(apiService.fetchData(symbol, date)).thenReturn(apiData);
        StockData expectedStockData = new StockData();
        expectedStockData.setSymbol("AAPL");
        expectedStockData.setFrom("2022-01-01");
        expectedStockData.setClose(150.0);
        when(dataProcessingService.parseStockData(apiData)).thenReturn(expectedStockData);

        StockData actualStockData = stockService.getStockData(symbol, date);

        verify(cacheService, times(1)).getFromCache(key);
        verify(apiService, times(1)).fetchData(symbol, date);
        verify(cacheService, times(1)).saveToCache(key, apiData, 1, TimeUnit.DAYS);
        verify(dataProcessingService, times(1)).parseStockData(apiData);

        assertEquals(expectedStockData, actualStockData);
    }

    @Test
    void testDeleteStockData() {
        String symbol = "AAPL";
        String date = "2022-01-01";
        String key = symbol + ":" + date;

        String result = stockService.deleteStockData(symbol, date);

        verify(cacheService, times(1)).deleteFromCache(key);
        assertEquals("Data deleted from cache", result);
    }
}
