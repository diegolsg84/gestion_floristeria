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
@Table(name = "creacion_arreglos")
public class CreacionArreglos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    @Column(name = "variedad_flores")
    private String variedadFlores;
    private String follaje;
    private String adornos;
    @Column(name = "costos_adicionales")
    private BigDecimal costosAdicionales;
}
