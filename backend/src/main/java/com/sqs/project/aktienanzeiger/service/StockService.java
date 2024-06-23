package com.sqs.project.aktienanzeiger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sqs.project.aktienanzeiger.model.StockData;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class StockService {

    private ApiCommunicationService apiService;
    private CacheService cacheService;
    private DataProcessingService dataProcessingService;

    @Autowired
    public StockService(ApiCommunicationService apiService, CacheService cacheService, DataProcessingService dataProcessingService) {
        this.apiService = apiService;
        this.cacheService = cacheService;
        this.dataProcessingService = dataProcessingService;
    }

    public StockData getStockData(String symbol, String date) throws IOException {
        String key = symbol + ":" + date;

        // Try to get data from cache
        String jsonData = cacheService.getFromCache(key);
        if (jsonData == null) {
            // If data is not in cache, fetch from API
            jsonData = apiService.fetchData(symbol, date);
            // Save data to cache
            cacheService.saveToCache(key, jsonData, 1, TimeUnit.DAYS);
        }

        // Parse and return the stock data
        return dataProcessingService.parseStockData(jsonData);
    }
    public String deleteStockData(String symbol, String date) {
        String key = symbol + ":" + date;
        cacheService.deleteFromCache(key);
        return "Data deleted from cache";
    }
}
