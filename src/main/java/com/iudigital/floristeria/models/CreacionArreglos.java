package com.iudigital.floristeria.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "creacion_arreglos")
public class CreacionArreglos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    private String follaje;
    private String adornos;
    @ManyToOne
    @JoinColumn(name = "gestion_pedidos_id")
    private GestionPedidos gestionPedidos;
    @ManyToOne
    @JoinColumn(name = "inventario_flores_id") // Relación con InventarioFlores
    private InventarioFlores inventarioFlores;
    @OneToMany(mappedBy = "creacionArreglos", cascade = CascadeType.ALL)
    private List<VariedadFlores> variedadesFlores;

}
