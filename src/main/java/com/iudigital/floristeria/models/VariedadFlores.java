package com.iudigital.floristeria.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "variedad_flores")
public class VariedadFlores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tipo_flores")
    private Long tipoFlores; // Cambiado a Long para almacenar el ID de la flor
    
    private Long cantidad;
    
    @ManyToOne
    @JoinColumn(name = "gestion_pedidos_id")
    private GestionPedidos gestionPedidos;
}
