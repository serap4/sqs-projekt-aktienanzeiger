package com.sqs.project.aktienanzeiger;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class StockService {

    private static final String API_KEY = "UZVKSEY1WHBOGDBL";
    private static final String BASE_URL = "https://www.alphavantage.co/query?";

    public String getStockData(String symbol, String timeseries) throws Exception {
        String url = "";
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
            return response.toString();
        } else {
            throw new RuntimeException("GET request not worked");
        }
    }
}
