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





    private static final String API_KEY = "UZVKSEY1WHBOGDBL";
    private static final String BASE_URL = "https://www.alphavantage.co/query?";

    public String getStockData(String symbol, String timeseries) throws Exception {
        String url;
        if(timeseries.equals("daily")){
            url = BASE_URL + "function=TIME_SERIES_DAILY&symbol=" + symbol +"&outputsize=compact&apikey=" + API_KEY;
        }else if(timeseries.equals("weekly")){
            url = BASE_URL + "function=TIME_SERIES_WEEKLY&symbol=" + symbol + "&apikey=" + API_KEY;
        }else if(timeseries.equals("monthly")){
            url = BASE_URL + "function=TIME_SERIES_MONTHLY&symbol=" + symbol + "&apikey=" + API_KEY;
        }else{
            throw new RuntimeException("Invalid time series");
        }

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            //return "GET request worked";
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            saveStockData(symbol, timeseries, response.toString());
            return response.toString();
        } else {
            throw new RuntimeException("GET request not worked");
        }
    }

    public void saveStockData(String symbol, String timeseries, String data) {
        // Erstellen Sie einen eindeutigen Schlüssel für Ihre Daten
        String key = symbol + ":" + timeseries;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Konvertieren Sie das Datenobjekt in einen JSON-String
            String jsonData = objectMapper.writeValueAsString(data);

            // Speichern Sie den JSON-String in Redis
            redisTemplate.opsForValue().set(key, jsonData);

            long ttl;
            switch (timeseries){
                case "daily":
                    ttl = 60*60*24;
                    break;
                case "weekly":
                    ttl = 60*60*24*7;
                    break;
                case "monthly":
                    ttl = 60*60*24*30;
                    break;
                default:
                    throw new RuntimeException("Invalid time series");
            }
            redisTemplate.expire(key, ttl, TimeUnit.SECONDS);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void deleteStockData(String symbol, String timeseries) {
        String key = symbol + ":" + timeseries;
        redisTemplate.delete(key);
    }

}
