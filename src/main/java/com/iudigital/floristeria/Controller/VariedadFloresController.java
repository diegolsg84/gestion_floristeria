package com.iudigital.floristeria.Controller;

import com.iudigital.floristeria.models.VariedadFlores;
import com.iudigital.floristeria.services.VariedadFloresService;
import com.iudigital.floristeria.services.dtos.VariedadFloresDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Variedad")
public class VariedadFloresController {
    @Autowired
    private VariedadFloresService variedadFloresService;

    @GetMapping("/{id}")
    public Optional<VariedadFlores> findById(@PathVariable("id") Long id){
        return variedadFloresService.getVariedadFlores(id);
    }

    @GetMapping("/lista")
    public List<VariedadFlores> findAll() {
        return variedadFloresService.getAll();
    }

    @PostMapping("/crear")
    public ResponseEntity<VariedadFlores> saveVariedad(@RequestBody VariedadFlores variedadFlores) {
        VariedadFlores savedvariedadFlores = variedadFloresService.save(variedadFlores);
        return new ResponseEntity<>(savedvariedadFlores, HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<VariedadFlores> updateVariedad(@PathVariable Long id, @RequestBody VariedadFloresDto variedadFloresDto) {
        VariedadFlores actualizado = variedadFloresService.updateVariedadFlores(id, variedadFloresDto);
        return ResponseEntity.ok(actualizado);
    }

    @PostMapping("/restar-inventario/{id}")
    public ResponseEntity<Void> restarInventario(@PathVariable Long id) {
        variedadFloresService.restarInventario(id);
        return ResponseEntity.ok().build();  
    }
}
