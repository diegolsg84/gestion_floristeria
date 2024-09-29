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

import com.iudigital.floristeria.models.Finanzas;
import com.iudigital.floristeria.services.FinanzasService;
import com.iudigital.floristeria.services.dtos.finanzasDto;

@RestController
@RequestMapping("/Finanzas")

public class FinanzasController {
    
    @Autowired
    private FinanzasService FinanzasService;

    @GetMapping("/{id}")
    public Optional<Finanzas> findById(@PathVariable("id") Long id){
        return FinanzasService.getFinanzas(id);
    }

    @GetMapping("/lista")
    public List<Finanzas> findAll() {
        return FinanzasService.getAll();
    }

    @PostMapping("/crear")
    public ResponseEntity<Finanzas> saveFinanzas(@RequestBody Finanzas Finanzas) {
        Finanzas savedFinanzas = FinanzasService.save(Finanzas);
        return new ResponseEntity<>(savedFinanzas, HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Finanzas> updateFinanzas(@PathVariable Long id, @RequestBody finanzasDto FinanzasDto) {
        Finanzas actualizado = FinanzasService.updateFinanzas(id, FinanzasDto);
        return ResponseEntity.ok(actualizado);
    }
}
