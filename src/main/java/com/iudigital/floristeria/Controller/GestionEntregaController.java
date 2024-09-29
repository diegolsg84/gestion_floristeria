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

import com.iudigital.floristeria.models.GestionEntrega;
import com.iudigital.floristeria.services.GestionEntregaService;
import com.iudigital.floristeria.services.dtos.GestionEntregaDto;

@RestController
@RequestMapping("/Entregas")
public class GestionEntregaController {
    @Autowired
    private GestionEntregaService entregasService;

    @GetMapping("/{id}")
    public Optional<GestionEntrega> findById(@PathVariable("id") Long id){
        return entregasService.getEntrega(id);
    }

    @GetMapping("/lista")
    public List<GestionEntrega> findAll() {
        return entregasService.getAll();
    }

    @PostMapping("/crear")
    public ResponseEntity<GestionEntrega> saveentrega(@RequestBody GestionEntrega entregas) {
        GestionEntrega savedentregas = entregasService.save(entregas);
        return new ResponseEntity<>(savedentregas, HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<GestionEntrega> updateentrega(@PathVariable Long id, @RequestBody GestionEntregaDto entregasDto) {
        GestionEntrega actualizado = entregasService.updateentrega(id, entregasDto);
        return ResponseEntity.ok(actualizado);
    }
}
