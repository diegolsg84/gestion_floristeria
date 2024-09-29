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

import com.iudigital.floristeria.models.finanzas;
import com.iudigital.floristeria.services.FinanzasService;
import com.iudigital.floristeria.services.dtos.finanzasDto;

@RestController
@RequestMapping("/finanzas")

public class FinanzasController {
    
    @Autowired
    private FinanzasService FinanzasService;

    @GetMapping("/{id}")
    public Optional<finanzas> findById(@PathVariable("id") Long id){
        return FinanzasService.getfinanzas(id);
    }

    @GetMapping("/lista")
    public List<finanzas> findAll() {
        return FinanzasService.getAll();
    }

    @PostMapping("/crear")
    public ResponseEntity<finanzas> savefinanzas(@RequestBody finanzas finanzas) {
        finanzas savedfinanzas = FinanzasService.save(finanzas);
        return new ResponseEntity<>(savedfinanzas, HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<finanzas> updatefinanzas(@PathVariable Long id, @RequestBody finanzasDto finanzasDto) {
        finanzas actualizado = FinanzasService.updatefinanzas(id, finanzasDto);
        return ResponseEntity.ok(actualizado);
    }
}
