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

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

    @Test
    public void testApiConnection() throws IOException {
        String symbol = "AAPL";
        String date = "2023-01-09";
        String apiKey = "78ZrTQclvalv24rx04zz1_mOVrAf66Wl";
        String url = "https://api.polygon.io/v1/open-close/AAPL/2023-01-09?adjusted=true&apiKey=78ZrTQclvalv24rx04zz1_mOVrAf66Wl";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        assertEquals(HttpURLConnection.HTTP_OK, responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String jsonData = response.toString();

        ObjectMapper objectMapper = new ObjectMapper();
        StockData stockData = objectMapper.readValue(jsonData, StockData.class);
        assertEquals("OK", stockData.getStatus());
        assertEquals("2023-01-09", stockData.getFrom());
        assertEquals("AAPL", stockData.getSymbol());
        assertEquals(130.465, stockData.getOpen());
        assertEquals(133.41, stockData.getHigh());
        assertEquals(129.89, stockData.getLow());
        assertEquals(130.15, stockData.getClose());
        assertEquals(7.0790813E7, stockData.getVolume());
        assertEquals(129.85, stockData.getAfterHours());
        assertEquals(129.6, stockData.getPreMarket());

    }


    @Test
    public void testSaveStockDataToRedis() throws IOException {
        String symbol = "AAPL";
        String date = "2023-01-09";
        String data = "{\"status\":\"OK\",\"from\":\"2023-01-09\",\"symbol\":\"AAPL\",\"open\":130.465,\"high\":133.41,\"low\":129.89,\"close\":130.15,\"volume\":7.0790813E7,\"afterHours\":129.85,\"preMarket\":129.6}";
        StockData stockData = new StockData();
        stockData.setStatus("OK");
        stockData.setFrom("2023-01-09");
        stockData.setSymbol("AAPL");
        stockData.setOpen(130.465);
        stockData.setHigh(133.41);
        stockData.setLow(129.89);
        stockData.setClose(130.15);
        stockData.setVolume(7.0790813E7);
        stockData.setAfterHours(129.85);
        stockData.setPreMarket(129.6);


        // Use mockObjectMapper in your test
        stockService.saveStockData(symbol, date, data);

        verify(redisTemplate, times(1)).opsForValue();
        verify(valueOperations, times(1)).set(eq(symbol + ":" + date), eq(data));
    }

    @Test
    public void testTTLonRedis() throws InterruptedException {
        int ttl = 2; // Set TTL to 1 second for testing

        String symbol = "AAPL";
        String date = "2023-01-09";
        String data = "{\"status\":\"OK\",\"from\":\"2023-01-09\",\"symbol\":\"AAPL\",\"open\":130.465,\"high\":133.41,\"low\":129.89,\"close\":130.15,\"volume\":7.0790813E7,\"afterHours\":129.85,\"preMarket\":129.6}";
        String key = symbol + ":" + date;

        stockService.saveStockData(symbol, date, data);

        verify(valueOperations, times(1)).set(eq(key), eq(data));

        // Wait for the TTL to expire
        Thread.sleep((ttl + 1) * 10L); // Wait for more than the TTL

        // Check if the data is still in Redis
        String dataAfterTTL = valueOperations.get(key);
        assertNull(dataAfterTTL, "Data should be null after TTL expiry");
    }
}


