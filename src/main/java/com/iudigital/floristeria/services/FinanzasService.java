package com.iudigital.floristeria.services;

import com.iudigital.floristeria.Repository.FinanzasRepository;
import com.iudigital.floristeria.models.finanzas;
import com.iudigital.floristeria.services.dtos.finanzasDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FinanzasService {
    @Autowired
    private FinanzasRepository finanzasRepository;
    public Optional<finanzas> getfinanzas(Long id){
        return finanzasRepository.findById(id);
    }
    public List<finanzas> getAll() {
        return  finanzasRepository.findAll();
    }

    public finanzas save(finanzas finanzass) {
        return finanzasRepository.save(finanzass);
    }

    public finanzas updatefinanzas(Long id, finanzasDto finanzassDto) {
        Optional<finanzas> finanzasExistente = finanzasRepository.findById(id);
        if (finanzasExistente.isPresent()) {
            finanzas finanzas = finanzasExistente.get();
            finanzas.setCostosAdicionales(finanzassDto.getCostosAdicionales());
            finanzas.setDetallePedido(finanzassDto.getDetallePedido());
            finanzas.setOrdenCompletada(finanzassDto.getOrdenCompletada());
            finanzas.setPrecioFlores(finanzassDto.getPrecioFlores());
            finanzas.setTotal(finanzassDto.getTotal());



            return finanzasRepository.save(finanzas);
        } else {
            throw new EntityNotFoundException("finanzas no encontrado");
        }
    }
}
