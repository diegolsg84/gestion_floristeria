package com.iudigital.floristeria.services;

import com.iudigital.floristeria.Repository.VariedadFloresRepository;
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
}
