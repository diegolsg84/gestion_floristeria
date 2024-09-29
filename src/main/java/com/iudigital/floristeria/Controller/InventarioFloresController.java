package com.iudigital.floristeria.Controller;

import com.iudigital.floristeria.models.InventarioFlores;
import com.iudigital.floristeria.services.InventarioFloresService;
import com.iudigital.floristeria.services.dtos.InventarioFloresDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Inventario")
public class InventarioFloresController {
    @Autowired
    private InventarioFloresService InventariosService;

    @GetMapping("/{id}")
    public Optional<InventarioFlores> findById(@PathVariable("id") Long id){
        return InventariosService.getinventarioFlores(id);
    }

    @GetMapping("/lista")
    public List<InventarioFlores> findAll() {
        return InventariosService.getAll();
    }

    @PostMapping("/crear")
    public ResponseEntity<InventarioFlores> saveInventario(@RequestBody InventarioFlores Inventarios) {
        InventarioFlores savedInventarios = InventariosService.save(Inventarios);
        return new ResponseEntity<>(savedInventarios, HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<InventarioFlores> updateInventario(@PathVariable Long id, @RequestBody InventarioFloresDto InventariosDto) {
        InventarioFlores actualizado = InventariosService.updateinventarioFlores(id, InventariosDto);
        return ResponseEntity.ok(actualizado);
    }
}
