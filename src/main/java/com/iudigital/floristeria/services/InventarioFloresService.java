package com.iudigital.floristeria.services;

import com.iudigital.floristeria.models.InventarioFlores;
import com.iudigital.floristeria.services.dtos.InventarioFloresDto;
import com.iudigital.floristeria.Repository.InventarioFloresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioFloresService {

    @Autowired
    private InventarioFloresRepository inventarioFloresRepository;

    // Obtener un inventario por ID
    public Optional<InventarioFlores> getinventarioFlores(Long id) {
        return inventarioFloresRepository.findById(id);
    }

    // Obtener todos los inventarios
    public List<InventarioFlores> getAll() {
        return inventarioFloresRepository.findAll();
    }

    // Guardar un nuevo inventario
    public InventarioFlores save(InventarioFlores inventario) {
        return inventarioFloresRepository.save(inventario);
    }

    // Actualizar un inventario
    public InventarioFlores updateinventarioFlores(Long id, InventarioFloresDto inventarioFloresDto) {
        InventarioFlores inventarioFlores = inventarioFloresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));

        // Actualizar los campos
        inventarioFlores.setTipoFlores(inventarioFloresDto.getTipoFlores());
        inventarioFlores.setColor(inventarioFloresDto.getColor());
        inventarioFlores.setVariedad(inventarioFloresDto.getVariedad());
        inventarioFlores.setCantidadDisponible(inventarioFloresDto.getCantidadDisponible());
        inventarioFlores.setPrecioCompra(inventarioFloresDto.getPrecioCompra());
        inventarioFlores.setPrecioVenta(inventarioFloresDto.getPrecioVenta());

        return inventarioFloresRepository.save(inventarioFlores);
    }

    // Eliminar un inventario
    public void deleteInventario(Long id) {
        if (!inventarioFloresRepository.existsById(id)) {
            throw new RuntimeException("Inventario no encontrado");
        }
        inventarioFloresRepository.deleteById(id);
    }
}