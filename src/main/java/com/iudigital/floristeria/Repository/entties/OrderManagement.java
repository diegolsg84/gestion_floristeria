package com.iudigital.floristeria.Repository.entties;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String clientName;
    private String clientLastName;
    private String clientEmail;
    private  String clientAddress;
    private String clientTelephone;
    private String typeArray;
    private String chance;
    private LocalDate deliveryDay;
    private BigDecimal budget;
    private String State;
}
