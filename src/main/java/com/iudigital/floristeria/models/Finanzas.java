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
@Table(name = "finanzas")
public class Finanzas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "orden_completada")
    private Boolean ordenCompletada;
    @Column(name = "detalle_pedido")
    private String detallePedido;
    @Column(name = "precios_flores")
    private BigDecimal precioFlores;
    @Column(name = "costos_adicionales")
    private BigDecimal costosAdicionales;
    private BigDecimal total;
    @ManyToOne
    @JoinColumn(name = "gestion_pedidos_id")
    private GestionPedidos gestionPedidos;
}
