package com.iudigital.floristeria.services;

import com.iudigital.floristeria.Repository.FinanzasRepository;
import com.iudigital.floristeria.models.Finanzas;
import com.iudigital.floristeria.services.dtos.finanzasDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FinanzasService {
    @Autowired
    private FinanzasRepository FinanzasRepository;
    public Optional<Finanzas> getFinanzas(Long id){
        return FinanzasRepository.findById(id);
    }
    public List<Finanzas> getAll() {
        return  FinanzasRepository.findAll();
    }

    public Finanzas save(Finanzas Finanzass) {
        return FinanzasRepository.save(Finanzass);
    }

    public Finanzas updateFinanzas(Long id, finanzasDto FinanzassDto) {
        Optional<Finanzas> FinanzasExistente = FinanzasRepository.findById(id);
        if (FinanzasExistente.isPresent()) {
            Finanzas Finanzas = FinanzasExistente.get();
            Finanzas.setCostosAdicionales(FinanzassDto.getCostosAdicionales());
            Finanzas.setDetallePedido(FinanzassDto.getDetallePedido());
            Finanzas.setOrdenCompletada(FinanzassDto.getOrdenCompletada());
            Finanzas.setPrecioFlores(FinanzassDto.getPrecioFlores());
            Finanzas.setTotal(FinanzassDto.getTotal());



            return FinanzasRepository.save(Finanzas);
        } else {
            throw new EntityNotFoundException("Finanzas no encontrado");
        }
    }
}

