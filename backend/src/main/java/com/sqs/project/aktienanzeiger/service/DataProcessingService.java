package com.sqs.project.aktienanzeiger.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import com.sqs.project.aktienanzeiger.model.StockData;
@Service
public class DataProcessingService {

    private static final String ERROR_MESSAGE = "Fehler beim Verarbeiten von JSON-Daten";
    private ObjectMapper objectMapper = new ObjectMapper();

    public StockData parseStockData(String jsonData) throws JsonProcessingException {
        try {
            return objectMapper.readValue(jsonData, StockData.class);
        } catch (JsonProcessingException e) {
            throw new JsonProcessingException(ERROR_MESSAGE, e) {};
        }
    }
}
