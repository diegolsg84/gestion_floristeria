package com.iudigital.floristeria.Controller;

import com.iudigital.floristeria.models.GestionPedidos;
import com.iudigital.floristeria.services.GestionPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
