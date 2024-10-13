package com.iudigital.floristeria.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventario_flores")
public class InventarioFlores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipo_flores")
    private String tipoFlores;
    private String color;
    private String variedad;
    @Column(name = "cantidad_disponible")
    private Long cantidadDisponible;
    @Column(name = "precio_compra")
    private BigDecimal precioCompra;
    @Column(name = "precio_venta")
    private BigDecimal precioVenta;

}
