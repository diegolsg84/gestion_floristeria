package com.iudigital.floristeria.services;

import com.iudigital.floristeria.Repository.VariedadFloresRepository;
import com.iudigital.floristeria.models.InventarioFlores;
import com.iudigital.floristeria.models.VariedadFlores;
import com.iudigital.floristeria.services.dtos.VariedadFloresDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VariedadFloresService {
    @Autowired
    private VariedadFloresRepository VariedadFloresRepository;
    @Autowired
    private InventarioFloresService InventarioFloresService;
    
    public Optional<VariedadFlores> getVariedadFlores(Long id){
        return VariedadFloresRepository.findById(id);
    }
    public List<VariedadFlores> getAll() {
        return  VariedadFloresRepository.findAll();
    }

    public VariedadFlores save(VariedadFlores VariedadFlores) {
        return VariedadFloresRepository.save(VariedadFlores);
    }

    public VariedadFlores updateVariedadFlores(Long id, VariedadFloresDto VariedadFloresDto) {
        Optional<VariedadFlores> VariedadFloresExistente = VariedadFloresRepository.findById(id);
        if (VariedadFloresExistente.isPresent()) {
            VariedadFlores VariedadFlores = VariedadFloresExistente.get();
            VariedadFlores.setCantidad(VariedadFloresDto.getCantidad());
            VariedadFlores.setFlor(VariedadFloresDto.getFlor());

            return VariedadFloresRepository.save(VariedadFlores);
        } else {
            throw new EntityNotFoundException("VariedadFlores no encontrado");
        }
    }

    public void restarInventario(Long idVariedadFlores) {
        
        VariedadFlores variedad = VariedadFloresRepository.findById(idVariedadFlores)
            .orElseThrow(() -> new RuntimeException("Variedad no encontrada"));

        // Buscar el inventario correspondiente por tipo de flor (basado en el nombre de la flor)
        List<InventarioFlores> inventarios = InventarioFloresService.getAll();
        Optional<InventarioFlores> inventarioOpt = inventarios.stream()
            .filter(inventario -> inventario.getTipoFlores().equals(variedad.getFlor()))
            .findFirst();

        if (inventarioOpt.isEmpty()) {
            throw new RuntimeException("Inventario no encontrado para la flor: " + variedad.getFlor());
        }

        InventarioFlores inventario = inventarioOpt.get();

        // Restar la cantidad de flores usadas en la variedad
        Long nuevaCantidad = inventario.getCantidadDisponible() - variedad.getCantidad();

        if (nuevaCantidad < 0) {
            nuevaCantidad = 0L;
        }

        inventario.setCantidadDisponible(nuevaCantidad);
        InventarioFloresService.save(inventario); 
    }
}
