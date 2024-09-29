package com.iudigital.floristeria.services.dtos;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventarioFloresDto {
    
    private String tipoFlores;
    private String color;
    private String variedad;
    private Long cantidadDisponible;
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
}
