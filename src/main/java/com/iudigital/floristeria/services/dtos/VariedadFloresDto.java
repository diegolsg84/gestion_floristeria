package com.iudigital.floristeria.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VariedadFloresDto {

    private Long tipoFlores; // Cambiado a Long para almacenar el ID de la flor
    
    private Long cantidad;
    
}
