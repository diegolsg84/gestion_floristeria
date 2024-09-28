package com.iudigital.floristeria.services.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GestionPedidosDto {

    private  String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private  String direccionCliente;
    private String telefonoCliente;
    private String tipoArreglo;
    private String ocasion;
    private LocalDate fechaEntrega;
    private BigDecimal presupuesto;
    private String estado;
}
