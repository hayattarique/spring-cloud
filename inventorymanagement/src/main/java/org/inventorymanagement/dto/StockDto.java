package org.inventorymanagement.dto;

import lombok.Builder;
import lombok.Data;
import org.inventorymanagement.manager.InventoryManager;

@Data
@Builder
public class StockDto {
    private int stockId;
    private String productName;
    private String modelNo;
    private int quantity;
    private double price;
    private InventoryManager manager;
}
