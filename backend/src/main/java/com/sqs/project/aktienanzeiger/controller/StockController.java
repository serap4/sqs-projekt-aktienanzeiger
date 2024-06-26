package com.sqs.project.aktienanzeiger.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.sqs.project.aktienanzeiger.service.StockService;
import com.sqs.project.aktienanzeiger.model.StockData;
import java.io.IOException;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:80", "http://localhost"})
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stock/{symbol}/{date}")
    public StockData getStockData(@PathVariable String symbol,@PathVariable String date) throws IOException {
        return stockService.getStockData(symbol, date);
    }

    @GetMapping("/stock/delete/{symbol}/{date}")
    public String deleteStockData(@PathVariable String symbol,@PathVariable String date) {
        return stockService.deleteStockData(symbol, date);
    }

}