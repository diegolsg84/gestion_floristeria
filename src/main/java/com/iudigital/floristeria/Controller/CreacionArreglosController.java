package com.iudigital.floristeria.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iudigital.floristeria.models.CreacionArreglos;
import com.iudigital.floristeria.services.CreacionArreglosService;
import com.iudigital.floristeria.services.dtos.CreacionArreglosDto;

@RestController
@RequestMapping("/Creacion")
public class CreacionArreglosController {
    @Autowired
    private CreacionArreglosService creacionArreglosService;

    @GetMapping("/{id}")
    public Optional<CreacionArreglos> findById(@PathVariable("id") Long id){
        return creacionArreglosService.obtenerArregloPorId(id);
    }

    @GetMapping("/lista")
    public List<CreacionArreglos> findAll() {
        return creacionArreglosService.obtenerTodosLosArreglos();
    }

    @PostMapping("/crear")
    public ResponseEntity<CreacionArreglos> savecreacion(@RequestBody CreacionArreglos Creacion) {
        CreacionArreglos savedCreacion = creacionArreglosService.crearArreglo(Creacion);
        return new ResponseEntity<>(savedCreacion, HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CreacionArreglos> updatecreacion(@PathVariable Long id, @RequestBody CreacionArreglos creacionDto) {
        CreacionArreglos actualizado = creacionArreglosService.actualizarArreglo(id, creacionDto);
        return ResponseEntity.ok(actualizado);
    }
}
