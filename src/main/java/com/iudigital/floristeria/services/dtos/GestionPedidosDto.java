package com.iudigital.floristeria.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.iudigital.floristeria.models.VariedadFlores;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GestionPedidosDto {

    private  String nombreCliente;
    private String apellidoCliente;
    private String emailCliente;
    private  String direccionCliente;
    private String telefonoCliente;
    private List<VariedadFlores> tipoArreglo = new ArrayList<>();
    private String ocasion;
    private LocalDate fechaEntrega;
    private BigDecimal presupuesto;
    private String estado;

    public String getTipoArregloString() {
        if (tipoArreglo == null || tipoArreglo.isEmpty()) {
            return "Sin arreglo";
        }
        return tipoArreglo.stream()
                .map(variedad -> variedad.getTipoFlores() + " (" + variedad.getCantidad() + ")")
                .collect(Collectors.joining(", "));
    }
}
