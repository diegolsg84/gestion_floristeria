package com.iudigital.floristeria.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gestion_pedidos")
public class GestionPedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombres_cliente")
    private  String nombreCliente;
    @Column(name = "apellidos_cliente")
    private String apellidoCliente;
    @Column(name = "email_cliente")
    private String emailCliente;
    @Column(name = "direccion_cliente")
    private  String direccionCliente;
    @Column(name = "telefono_cliente")
    private String telefonoCliente;

    private String tipoArreglo;
    private String ocasion;
    private LocalDate fechaEntrega;
    private BigDecimal presupuesto;
    private String estado;
}
