package com.iudigital.floristeria.services;

import com.iudigital.floristeria.models.CreacionArreglos;
import com.iudigital.floristeria.Repository.CreacionArreglosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CreacionArreglosService {

    @Autowired
    private CreacionArreglosRepository creacionArreglosRepository;

    public CreacionArreglos crearArreglo(CreacionArreglos creacionArreglos) {
        return creacionArreglosRepository.save(creacionArreglos);
    }

    public List<CreacionArreglos> obtenerTodosLosArreglos() {
        return creacionArreglosRepository.findAll();
    }

    public Optional<CreacionArreglos> obtenerArregloPorId(Long id) {
        return creacionArreglosRepository.findById(id);
    }

    public CreacionArreglos actualizarArreglo(Long id, CreacionArreglos detallesActualizados) {
        Optional<CreacionArreglos> arregloExistente = creacionArreglosRepository.findById(id);

        if (arregloExistente.isPresent()) {
            CreacionArreglos arreglo = arregloExistente.get();
            arreglo.setFollaje(detallesActualizados.getFollaje());
            arreglo.setAdornos(detallesActualizados.getAdornos());
            arreglo.setGestionPedidos(detallesActualizados.getGestionPedidos());
            arreglo.setInventarioFlores(detallesActualizados.getInventarioFlores());
            arreglo.setVariedadesFlores(detallesActualizados.getVariedadesFlores());
            return creacionArreglosRepository.save(arreglo);
        }

        return null;
    }

    public void eliminarArreglo(Long id) {
        creacionArreglosRepository.deleteById(id);
    }
}
