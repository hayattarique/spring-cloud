package org.inventorymanagement.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stock")
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_id")
    private Integer stockId;
    @Column(name = "product_name")
    private String productName;
    private String category;
    @Column(name = "model_no")
    private String modelNo;
    private int quantity;
    private double price;
}
