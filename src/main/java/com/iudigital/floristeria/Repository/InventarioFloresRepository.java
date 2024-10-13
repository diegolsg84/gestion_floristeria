package com.iudigital.floristeria.Repository;

import com.iudigital.floristeria.models.InventarioFlores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventarioFloresRepository extends JpaRepository<InventarioFlores,Long> {
    Optional<InventarioFlores> findByTipoFlores(String tipoFlores);
    Optional<InventarioFlores> findById(Long id);
}
