package com.iudigital.floristeria.services.dtos;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@AllArgsConstructor

public class finanzasDto {
    private Boolean ordenCompletada;
    private String detallePedido;
    private BigDecimal precioFlores;
    private BigDecimal costosAdicionales;
    private BigDecimal total;
}
