package com.iudigital.floristeria.Repository;

import com.iudigital.floristeria.models.Finanzas;
import com.iudigital.floristeria.models.GestionPedidos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanzasRepository extends JpaRepository<Finanzas,Long> {
    Optional<Finanzas> findByGestionPedidos(GestionPedidos gestionPedidos);

}
