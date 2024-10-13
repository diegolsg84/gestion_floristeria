package com.iudigital.floristeria.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.mapping.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "gestion_pedidos_id")
    private List<VariedadFlores> tipoArreglo = new ArrayList<>();
    private String ocasion;
    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;
    private BigDecimal presupuesto;
    private String estado;
    @OneToMany(mappedBy = "gestionPedidos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VariedadFlores> variedadFlores = new ArrayList<>();    
    @OneToMany(mappedBy = "gestionPedidos", cascade = CascadeType.ALL)
    private List<Finanzas> finanzas;
    @OneToOne(mappedBy = "gestionPedidos", cascade = CascadeType.ALL)
    private GestionEntrega gestionEntrega;


    public List<VariedadFlores> getTipoArreglo() {
        return tipoArreglo;
    }

    public void setTipoArreglo(List<VariedadFlores> tipoArreglo) {
        this.tipoArreglo = tipoArreglo;
    }

    public String getTipoArregloString() {
        if (tipoArreglo == null || tipoArreglo.isEmpty()) {
            return "Sin arreglo";
        }
        return tipoArreglo.stream()
                .map(variedad -> variedad.getCantidad() + " Flores")
                .collect(Collectors.joining(", "));
    }
}