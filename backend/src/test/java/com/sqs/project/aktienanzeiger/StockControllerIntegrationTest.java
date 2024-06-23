package com.sqs.project.aktienanzeiger;

import com.sqs.project.aktienanzeiger.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StockControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StockService stockService;

    @Test
    void testGetStockData() throws Exception {
        mockMvc.perform(get("/stock/GOOGL/2024-06-18")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"symbol\":\"GOOGL\",\"from\":\"2024-06-18\",\"open\":177.14,\"high\":177.385,\"low\":174.1042,\"close\":175.09,\"volume\":21485723,\"afterHours\":175.09,\"preMarket\":177.36}"));
    }

    @Test
    void testDeleteStockData() throws Exception {
        mockMvc.perform(get("/stock/delete/GOOGL/2024-06-18")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Data deleted from cache"));
    }
}
