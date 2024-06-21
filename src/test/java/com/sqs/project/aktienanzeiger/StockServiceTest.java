package com.sqs.project.aktienanzeiger;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {

    @Mock
    private RedisTemplate<String, String> redisTemplate;

    @Mock
    private ValueOperations<String, String> valueOperations;

    @InjectMocks
    private StockService stockService;

    @BeforeEach
    public void setUp() {
        lenient().when(redisTemplate.opsForValue()).thenReturn(valueOperations);
    }

    @Test
    public void testGetStockDataFromRedis() throws IOException {
        String symbol = "AAPL";
        String date = "2021-01-01";
        String key = symbol + ":" + date;
        String jsonData = "{\"status\":\"OK\",\"from\":\"2021-01-01\",\"symbol\":\"AAPL\",\"open\":133.52,\"high\":133.61,\"low\":126.76,\"close\":126.9,\"volume\":140843759,\"afterHours\":126.9,\"preMarket\":126.9}";
        when(valueOperations.get(key)).thenReturn(jsonData);

        StockData stockData = stockService.getStockData(symbol, date);

        verify(redisTemplate, times(1)).opsForValue();
        verify(valueOperations, times(1)).get(key);
        verifyNoMoreInteractions(redisTemplate, valueOperations);

        assertEquals("OK", stockData.getStatus());
        assertEquals("2021-01-01", stockData.getFrom());
        assertEquals("AAPL", stockData.getSymbol());
        assertEquals(133.52, stockData.getOpen());
        assertEquals(133.61, stockData.getHigh());
        assertEquals(126.76, stockData.getLow());
        assertEquals(126.9, stockData.getClose());
        assertEquals(140843759, stockData.getVolume());
        assertEquals(126.9, stockData.getAfterHours());
        assertEquals(126.9, stockData.getPreMarket());
    }

//    @Test
//    public void testGetStockDataFromApi() throws IOException {
//        String symbol = "AAPL";
//        String date = "2024-06-19";
//        String key = symbol + ":" + date;
//        String jsonData = "{\"status\":\"OK\",\"from\":\"2024-06-19\",\"symbol\":\"AAPL\",\"open\":133.52,\"high\":133.61,\"low\":126.76,\"close\":126.9,\"volume\":140843759,\"afterHours\":126.9,\"preMarket\":126.9}";
//
//        when(valueOperations.get(key)).thenReturn(null);
//
//        HttpURLConnection mockConnection = mock(HttpURLConnection.class);
//        when(mockConnection.getResponseCode()).thenReturn(HttpURLConnection.HTTP_OK);
//
//        InputStream is = new ByteArrayInputStream(jsonData.getBytes());
//        when(mockConnection.getInputStream()).thenReturn(is);
//
//        StockService spyStockService = spy(stockService);
//        doReturn(mockConnection).when(spyStockService).openConnection(anyString());
//
//        // Setzen Sie den API-Schlüssel mit ReflectionTestUtils
//        ReflectionTestUtils.setField(spyStockService, "apiKey", "78ZrTQclvalv24rx04zz1_mOVrAf66Wl");
//
//        StockData stockData = spyStockService.getStockData(symbol, date);
//        verify(redisTemplate, times(1)).opsForValue();
//        verify(valueOperations, times(1)).get(key);
//        verify(valueOperations, times(1)).set(anyString(), anyString(), anyLong(), any(TimeUnit.class));
//        verifyNoMoreInteractions(redisTemplate, valueOperations);
//
//        assertEquals("OK", stockData.getStatus());
//        assertEquals("2024-06-19", stockData.getFrom());
//        assertEquals("AAPL", stockData.getSymbol());
//        assertEquals(133.52, stockData.getOpen());
//        assertEquals(133.61, stockData.getHigh());
//        assertEquals(126.76, stockData.getLow());
//        assertEquals(126.9, stockData.getClose());
//        assertEquals(140843759, stockData.getVolume());
//        assertEquals(126.9, stockData.getAfterHours());
//        assertEquals(126.9, stockData.getPreMarket());
//    }

//    @Test
//    public void testSaveStockData() throws IOException {
//        String symbol = "AAPL";
//        String date = "2021-01-01";
//        String key = symbol + ":" + date;
//        String jsonData = "{\"status\":\"OK\",\"from\":\"2021-01-01\",\"symbol\":\"AAPL\",\"open\":133.52,\"high\":133.61,\"low\":126.76,\"close\":126.9,\"volume\":1.40843759E8,\"afterHours\":126.9,\"preMarket\":126.9}";
//
//        doNothing().when(valueOperations).set(key, jsonData);
//        when(redisTemplate.expire(key, 86400, TimeUnit.SECONDS)).thenReturn(true);
//
//        stockService.saveStockData(symbol, date, jsonData);
//
//        verify(valueOperations, times(1)).set(key, jsonData);
//        verify(redisTemplate, times(1)).expire(key, 86400, TimeUnit.SECONDS);
//        verifyNoMoreInteractions(redisTemplate, valueOperations);
//    }

    @Test
    public void testDeleteStockData() {
        String symbol = "AAPL";
        String date = "2021-01-01";
        String key = symbol + ":" + date;

        when(valueOperations.get(key)).thenReturn("some data");
        when(redisTemplate.delete(key)).thenReturn(true);

        String result = stockService.deleteStockData(symbol, date);

        assertEquals("Daten erfolgreich gelöscht!", result);
        verify(redisTemplate, times(1)).delete(key);
    }

    @Test
    public void testDeleteStockDataNotFound() {
        String symbol = "AAPL";
        String date = "2021-01-01";
        String key = symbol + ":" + date;

        when(valueOperations.get(key)).thenReturn(null);

        String result = stockService.deleteStockData(symbol, date);

        assertEquals("Daten nicht gefunden!", result);
        verify(redisTemplate, never()).delete(key);
    }
}
