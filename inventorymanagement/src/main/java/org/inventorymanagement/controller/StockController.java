package org.inventorymanagement.controller;

import lombok.RequiredArgsConstructor;
import org.inventorymanagement.dto.StockDto;
import org.inventorymanagement.exception.ProductNotFoundException;
import org.inventorymanagement.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/stock")
public class StockController {
    private final StockService stockService;

    @GetMapping("model/{modelNo}")
    public ResponseEntity<StockDto> getStocks(@PathVariable String modelNo) {
        return ResponseEntity.ok(stockService.findByModelNo(modelNo));
    }

    @GetMapping("product/{productName}")
    public ResponseEntity<StockDto> getStock(@PathVariable String productName) {
        return ResponseEntity.ok(stockService.findByProductName(productName));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handelException(ProductNotFoundException e) {
        return ResponseEntity.ok(e.getMessage());
    }
}
