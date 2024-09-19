package com.iudigital.floristeria.Repository.entties;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor

public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String typeFlower;
    private String color;
    private String variety;
    private Long availableQuantity;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;

}
