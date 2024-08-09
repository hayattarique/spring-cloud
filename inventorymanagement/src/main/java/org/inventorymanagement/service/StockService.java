package org.inventorymanagement.service;

import lombok.RequiredArgsConstructor;
import org.inventorymanagement.dto.StockDto;
import org.inventorymanagement.entities.Stock;
import org.inventorymanagement.exception.ProductNotFoundException;
import org.inventorymanagement.manager.InventoryManager;
import org.inventorymanagement.repositories.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;
    private final InventoryManager inventoryManager;

    @Transactional(readOnly = true)
    public StockDto findByModelNo(String modelNo) {
        return stockRepository.findByModelNo(modelNo).stream().map(this::apply).findFirst().orElseThrow(() -> new ProductNotFoundException("Stock is not available please wait"));
    }

    @Transactional(readOnly = true)
    public StockDto findByProductName(String productName) {
        return stockRepository.findByProductName(productName)
                .stream().map(this::apply).findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Stock is not available please wait"));
    }

    private StockDto apply(Stock e) {
        return StockDto.builder().modelNo(e.getModelNo()).stockId(e.getStockId()).productName(e.getProductName()).manager(inventoryManager).quantity(e.getQuantity()).price(e.getPrice()).build();
    }
}
