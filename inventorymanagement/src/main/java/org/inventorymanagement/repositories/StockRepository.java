package org.inventorymanagement.repositories;

import org.inventorymanagement.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {
   // @Cacheable("byModelNo")
    List<Stock> findByModelNo(String modelNo);

    //@Cacheable("byProductName")
    List<Stock> findByProductName(String productName);
}
