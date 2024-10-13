package com.iudigital.floristeria.Repository;

import com.iudigital.floristeria.models.InventarioFlores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioFloresRepository extends JpaRepository<InventarioFlores,Long> {
    Optional<InventarioFlores> findByTipoFlores(String tipoFlores);
    Optional<InventarioFlores> findById(Long id);
}
