package com.sqs.project.aktienanzeiger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Service
public class StockService {
    private static final Logger logger = LoggerFactory.getLogger(StockService.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${polygon.api.key}")
    private String API_KEY;

    private static final String BASE_URL = "https://api.polygon.io/v1/open-close/";

    public StockData getStockData(String symbol, String date) throws Exception {
        // Erstellen Sie einen eindeutigen Schlüssel für Ihre Daten
        String key = symbol + ":" + date;

        // Versuchen Sie, die Daten aus Redis zu holen
        String jsonData = redisTemplate.opsForValue().get(key);
        // Wenn die Daten nicht in Redis gespeichert sind, holen Sie sie von der API
        if (jsonData == null) {
            String url = BASE_URL + symbol + "/" + date + "?adjusted=true&apiKey=" + API_KEY;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                jsonData = response.toString();
                saveStockData(symbol, date, jsonData);
            } else {
                throw new RuntimeException("GET request not worked");
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Konvertieren Sie den JSON-String in ein StockData-Objekt
            StockData data = objectMapper.readValue(jsonData, StockData.class);
            return data;
        } catch (JsonProcessingException e) {
            logger.error("Fehler beim Verarbeiten von JSON-Daten", e);
        }

        // Wenn die Daten nicht in Redis gespeichert sind oder ein Fehler auftritt, geben Sie null zurück
        return null;
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

            long ttl = 60*60*24;
            redisTemplate.expire(key, ttl, TimeUnit.SECONDS);
        } catch (JsonProcessingException e) {
            logger.error("Fehler beim Verarbeiten von JSON-Daten", e);
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