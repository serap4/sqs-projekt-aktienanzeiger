package com.sqs.project.aktienanzeiger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class StockControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockService stockService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testGetStockData() throws Exception {
        String symbol = "AAPL";
        String date = "2023-01-09";
        StockData mockData = new StockData();
        mockData.setSymbol(symbol);
        mockData.setFrom(date);
        // Set other properties of mockData...

        when(stockService.getStockData(symbol, date)).thenReturn(mockData);

        mockMvc.perform(get("/stock/{symbol}/{date}", symbol, date))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(mockData)));
    }

    @Test
    public void testDeleteStockData() throws Exception {
        String symbol = "AAPL";
        String date = "2023-01-09";
        String expectedResponse = "Data deleted successfully";

        when(stockService.deleteStockData(symbol, date)).thenReturn(expectedResponse);

        mockMvc.perform(get("/stock/delete/{symbol}/{date}", symbol, date))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }
}