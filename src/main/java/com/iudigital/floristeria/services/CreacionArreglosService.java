package com.iudigital.floristeria.services;

import com.iudigital.floristeria.Repository.CreacionArreglosRepository;
import com.iudigital.floristeria.models.CreacionArreglos;
import com.iudigital.floristeria.services.dtos.CreacionArreglosDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CreacionArreglosService {
    @Autowired
    private CreacionArreglosRepository creacionArreglosRepository;
    public Optional<CreacionArreglos> getcreacion(Long id){
        return creacionArreglosRepository.findById(id);
    }
    public List<CreacionArreglos> getAll() {
        return  creacionArreglosRepository.findAll();
    }

    public CreacionArreglos save(CreacionArreglos creacionArreglosDto) {
        return creacionArreglosRepository.save(creacionArreglosDto);
    }

    public CreacionArreglos updatecreacion(Long id, CreacionArreglosDto creacionArreglosDtoDto) {
        Optional<CreacionArreglos> creacionExistente = creacionArreglosRepository.findById(id);
        if (creacionExistente.isPresent()) {
            CreacionArreglos creacion = creacionExistente.get();
            creacion.setAdornos(creacionArreglosDtoDto.getAdornos());
            creacion.setFollaje(creacionArreglosDtoDto.getFollaje());



            return creacionArreglosRepository.save(creacion);
        } else {
            throw new EntityNotFoundException("creacion no encontrado");
        }
    }
}
