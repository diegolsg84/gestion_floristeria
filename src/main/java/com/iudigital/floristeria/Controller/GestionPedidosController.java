package com.iudigital.floristeria.Controller;

import com.iudigital.floristeria.models.GestionPedidos;
import com.iudigital.floristeria.services.GestionPedidosService;
import com.iudigital.floristeria.services.dtos.GestionPedidosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Pedidos")
public class GestionPedidosController {
    @Autowired
    private GestionPedidosService pedidosService;

    @GetMapping("/{id}")
    public Optional<GestionPedidos> findById(@PathVariable("id") Long id){
        return pedidosService.getPedido(id);
    }

    @GetMapping("/lista")
    public List<GestionPedidos> findAll() {
        return pedidosService.getAll();
    }

    @PostMapping("/crear")
    public ResponseEntity<GestionPedidos> savePedido(@RequestBody GestionPedidos pedidos) {
        GestionPedidos savedPedidos = pedidosService.save(pedidos);
        return new ResponseEntity<>(savedPedidos, HttpStatus.CREATED);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<GestionPedidos> updatePedido(@PathVariable Long id, @RequestBody GestionPedidosDto pedidosDto) {
        GestionPedidos actualizado = pedidosService.updatePedido(id, pedidosDto);
        return ResponseEntity.ok(actualizado);
    }
}
