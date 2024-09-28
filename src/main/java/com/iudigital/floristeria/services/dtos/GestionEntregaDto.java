package com.iudigital.floristeria.services.dtos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@AllArgsConstructor

public class GestionEntregaDto {

    private String conductor;
    private String ruta;
    private LocalDate fechaEntrega;
    private String estado;
    
}
