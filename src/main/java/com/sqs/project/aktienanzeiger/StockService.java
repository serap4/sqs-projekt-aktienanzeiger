package com.sqs.project.aktienanzeiger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Service
public class StockService {
    private static final Logger logger = LoggerFactory.getLogger(StockService.class);
    private static final String ERROR_MESSAGE = "Fehler beim Verarbeiten von JSON-Daten";
    private RedisTemplate<String, String> redisTemplate;

    public StockService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    @Value("${polygon.api.key}")
    private String apiKey;

    private static final String BASE_URL = "https://api.polygon.io/v1/open-close/";

    public StockData getStockData(String symbol, String date) throws IOException {
        // Erstellen Sie einen eindeutigen Schlüssel für Ihre Daten
        String key = symbol + ":" + date;

        // Versuchen Sie, die Daten aus Redis zu holen
        String jsonData = redisTemplate.opsForValue().get(key);
        // Wenn die Daten nicht in Redis gespeichert sind, holen Sie sie von der API
        if (jsonData == null) {
            String url = BASE_URL + symbol + "/" + date + "?adjusted=true&apiKey=" + apiKey;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                jsonData = response.toString();
                saveStockData(symbol, date, jsonData);
            } else {
                throw new IOException("GET request not worked");
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Konvertieren Sie den JSON-String in ein StockData-Objekt
            StockData data = objectMapper.readValue(jsonData, StockData.class);
            return data;
        } catch (JsonProcessingException e) {
            logger.error(ERROR_MESSAGE, e);
            throw new IOException(ERROR_MESSAGE, e);
        }
    }

    public void saveStockData(String symbol, String date, String data) {
        // Erstellen Sie einen eindeutigen Schlüssel für Ihre Daten
        String key = symbol + ":" + date;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Konvertieren Sie den Antwort-String in ein Java-Objekt
            StockData stockData = objectMapper.readValue(data, StockData.class);

            // Konvertieren Sie das Java-Objekt in einen JSON-String
            String jsonData = objectMapper.writeValueAsString(stockData);

            // Speichern Sie den JSON-String in Redis
            redisTemplate.opsForValue().set(key, jsonData);

            int ttl = 86400;
            redisTemplate.expire(key, ttl, TimeUnit.SECONDS);
        } catch (JsonProcessingException e) {
            logger.error(ERROR_MESSAGE, e);
        }
    }

    public String deleteStockData(String symbol, String timeseries) {
        String key = symbol + ":" + timeseries;
        String data = redisTemplate.opsForValue().get(key);
        if (data != null) {
            redisTemplate.delete(key);
        }else {
            return "Daten nicht gefunden!";
        }
        return "Daten erfolgreich gelöscht!";
    }

}