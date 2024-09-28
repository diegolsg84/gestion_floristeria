package com.iudigital.floristeria.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gestion_pedidos")
public class GestionPedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_documento")
    private  Long nuemroDocumento;
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
    @Column(name = "tipo_arreglo")
    private String tipoArreglo;
    private String ocasion;
    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;
    private BigDecimal presupuesto;
    private String estado;
    @OneToMany(mappedBy = "gestionPedidos", cascade = CascadeType.ALL)
    private List<CreacionArreglos> creacionArreglos;
    @OneToMany(mappedBy = "gestionPedidos", cascade = CascadeType.ALL)
    private List<Finanzas> finanzas;
    @OneToOne(mappedBy = "gestionPedidos", cascade = CascadeType.ALL)
    private GestionEntrega gestionEntrega;
}
