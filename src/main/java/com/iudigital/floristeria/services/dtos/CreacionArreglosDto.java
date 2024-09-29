package com.iudigital.floristeria.services.dtos;


import java.util.List;

import com.iudigital.floristeria.models.GestionPedidos;
import com.iudigital.floristeria.models.InventarioFlores;
import com.iudigital.floristeria.models.VariedadFlores;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@AllArgsConstructor

public class CreacionArreglosDto {
    private String follaje;
    private String adornos;
    private GestionPedidos gestionPedidos;
    private InventarioFlores inventarioFlores;
    private List<VariedadFlores> variedadesFlores;
}
