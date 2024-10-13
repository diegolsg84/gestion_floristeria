package com.iudigital.floristeria.util;

import com.iudigital.floristeria.Repository.InventarioFloresRepository;
import com.iudigital.floristeria.models.InventarioFlores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InventarioUtil {

    private static InventarioFloresRepository inventarioFloresRepository;

    @Autowired
    public InventarioUtil(InventarioFloresRepository repo) {
        InventarioUtil.inventarioFloresRepository = repo;
    }

    public static BigDecimal getPrecioVenta(Long tipoFlores) {
        if (inventarioFloresRepository == null) {
            throw new IllegalStateException("InventarioFloresRepository no ha sido inicializado");
        }
        return inventarioFloresRepository.findById(tipoFlores)
                .map(InventarioFlores::getPrecioVenta)
                .orElse(BigDecimal.ZERO);
    }
}