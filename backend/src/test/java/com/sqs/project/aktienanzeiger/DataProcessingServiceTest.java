package com.sqs.project.aktienanzeiger.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sqs.project.aktienanzeiger.model.StockData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataProcessingServiceTest {

    private DataProcessingService dataProcessingService;

    @BeforeEach
    public void setUp() {
        dataProcessingService = new DataProcessingService();
    }

    @Test
    public void testParseStockData_Success() throws JsonProcessingException {
        String jsonData = "{\"symbol\":\"AAPL\",\"from\":\"2022-01-01\",\"open\":150.0,\"high\":155.0,\"low\":148.0,\"close\":154.0,\"volume\":1000000,\"afterHours\":153.0,\"preMarket\":149.0}";

        StockData stockData = dataProcessingService.parseStockData(jsonData);

        assertNotNull(stockData);
        assertEquals("AAPL", stockData.getSymbol());
        assertEquals("2022-01-01", stockData.getFrom());
        assertEquals(150.0, stockData.getOpen());
        assertEquals(155.0, stockData.getHigh());
        assertEquals(148.0, stockData.getLow());
        assertEquals(154.0, stockData.getClose());
        assertEquals(1000000, stockData.getVolume());
        assertEquals(153.0, stockData.getAfterHours());
        assertEquals(149.0, stockData.getPreMarket());
    }

    @Test
    public void testParseStockData_InvalidJson() {
        String invalidJsonData = "{\"symbol\":\"AAPL\",\"from\":\"2022-01-01\",\"open\":150.0,\"high\":\"invalid\",\"low\":148.0,\"close\":154.0,\"volume\":1000000,\"afterHours\":153.0,\"preMarket\":149.0}";

        JsonProcessingException exception = assertThrows(JsonProcessingException.class, () -> {
            dataProcessingService.parseStockData(invalidJsonData);
        });

        assertTrue(exception.getMessage().contains("Fehler beim Verarbeiten von JSON-Daten"));
    }

    @Test
    public void testParseStockData_EmptyJson() throws JsonProcessingException {
        String emptyJsonData = "{}";

        StockData stockData = dataProcessingService.parseStockData(emptyJsonData);

        assertNotNull(stockData);
        assertNull(stockData.getSymbol());
        assertNull(stockData.getFrom());
        assertEquals(0.0, stockData.getOpen());
        assertEquals(0.0, stockData.getHigh());
        assertEquals(0.0, stockData.getLow());
        assertEquals(0.0, stockData.getClose());
        assertEquals(0.0, stockData.getVolume());
        assertEquals(0.0, stockData.getAfterHours());
        assertEquals(0.0, stockData.getPreMarket());
    }
}
