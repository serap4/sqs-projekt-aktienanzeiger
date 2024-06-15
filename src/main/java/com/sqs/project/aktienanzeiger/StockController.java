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

    @GetMapping("/stock/{symbol}/{date}")
    public String getStockData(@PathVariable String symbol,@PathVariable String date) throws Exception {
        return stockService.getStockData(symbol, date);
    }

    @GetMapping("/stock/delete/{symbol}/{date}")
    public String deleteStockData(@PathVariable String symbol,@PathVariable String date) {
        return stockService.deleteStockData(symbol, date);
    }

}