package com.sqs.project.aktienanzeiger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class StockService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    private static final String API_KEY = "78ZrTQclvalv24rx04zz1_mOVrAf66Wl";
    private static final String BASE_URL = "https://api.polygon.io/v1/open-close/";

    public String getStockData(String symbol, String date) throws Exception {
        // Erstellen Sie einen eindeutigen Schlüssel für Ihre Daten
        String key = symbol + ":" + date;

        // Versuchen Sie, die Daten aus Redis zu holen
        String data = redisTemplate.opsForValue().get(key);

        // Wenn die Daten nicht in Redis gespeichert sind, holen Sie sie von der API
        if (data == null) {
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
                data = response.toString();
                saveStockData(symbol, date, data);
            } else {
                throw new RuntimeException("GET request not worked");
            }
        }

        return data;
    }
    public void saveStockData(String symbol, String date, String data) {
        // Erstellen Sie einen eindeutigen Schlüssel für Ihre Daten
        String key = symbol + ":" + date;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Konvertieren Sie das Datenobjekt in einen JSON-String
            String jsonData = objectMapper.writeValueAsString(data);

            // Speichern Sie den JSON-String in Redis
            redisTemplate.opsForValue().set(key, jsonData);

            long ttl = 60*60*24;
            redisTemplate.expire(key, ttl, TimeUnit.SECONDS);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
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
