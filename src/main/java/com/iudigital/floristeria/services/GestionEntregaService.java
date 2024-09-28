package com.iudigital.floristeria.services;

import com.iudigital.floristeria.Repository.GestionEntregaRepository;
import com.iudigital.floristeria.models.GestionEntrega;
import com.iudigital.floristeria.services.dtos.GestionEntregaDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GestionEntregaService {
    @Autowired
    private GestionEntregaRepository entregaRepository;
    public Optional<GestionEntrega> getentrega(Long id){
        return entregaRepository.findById(id);
    }
    public List<GestionEntrega> getAll() {
        return  entregaRepository.findAll();
    }

    public GestionEntrega save(GestionEntrega entregas) {
        return entregaRepository.save(entregas);
    }

    public GestionEntrega updateentrega(Long id, GestionEntregaDto entregasDto) {
        Optional<GestionEntrega> entregaExistente = entregaRepository.findById(id);
        if (entregaExistente.isPresent()) {
            GestionEntrega entrega = entregaExistente.get();
            entrega.setConductor(entregasDto.getConductor());
            entrega.setEstado(entregasDto.getEstado());
            



            return entregaRepository.save(entrega);
        } else {
            throw new EntityNotFoundException("entrega no encontrado");
        }
    }
}
