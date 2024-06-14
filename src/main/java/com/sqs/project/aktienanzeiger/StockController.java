package com.sqs.project.aktienanzeiger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stock/{timeSeries}/{symbol}")
    public String getStockData(@PathVariable String symbol,@PathVariable String timeSeries) throws Exception {
        return stockService.getStockData(symbol,timeSeries);
    }
}