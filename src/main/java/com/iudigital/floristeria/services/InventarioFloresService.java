package com.iudigital.floristeria.services;

import com.iudigital.floristeria.Repository.InventarioFloresRepository;
import com.iudigital.floristeria.models.InventarioFlores;
import com.iudigital.floristeria.services.dtos.InventarioFloresDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class InventarioFloresService {
    @Autowired
    private InventarioFloresRepository inventarioFloresRepository;
    public Optional<InventarioFlores> getinventarioFlores(Long id){
        return inventarioFloresRepository.findById(id);
    }
    public List<InventarioFlores> getAll() {
        return  inventarioFloresRepository.findAll();
    }

    public InventarioFlores save(InventarioFlores inventarioFlores) {
        return inventarioFloresRepository.save(inventarioFlores);
    }

    public InventarioFlores updateinventarioFlores(Long id, InventarioFloresDto inventarioFloresDto) {
        Optional<InventarioFlores> inventarioFloresExistente = inventarioFloresRepository.findById(id);
        if (inventarioFloresExistente.isPresent()) {
            InventarioFlores inventarioFlores = inventarioFloresExistente.get();
            inventarioFlores.setCantidadDisponible(inventarioFloresDto.getCantidadDisponible());
            inventarioFlores.setColor(inventarioFloresDto.getColor());
            inventarioFlores.setPrecioCompra(inventarioFloresDto.getPrecioCompra());
            inventarioFlores.setPrecioVenta(inventarioFloresDto.getPrecioVenta());
            inventarioFlores.setTipoFlores(inventarioFloresDto.getTipoFlores());
            inventarioFlores.setVariedad(inventarioFloresDto.getVariedad());
        



            return inventarioFloresRepository.save(inventarioFlores);
        } else {
            throw new EntityNotFoundException("inventarioFlores no encontrado");
        }
    }
}
