package com.sqs.project.aktienanzeiger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stock/{symbol}/{timeSeries}")
    public String getStockData(@PathVariable String symbol,@PathVariable String timeSeries) throws Exception {
        String key = symbol + ":" + timeSeries;
        String data = stockService.getStockData(symbol, timeSeries);
        if (data == null) {
            data = stockService.fetchAndSaveStockData(symbol, timeSeries);
        }
        return data;
    }
}