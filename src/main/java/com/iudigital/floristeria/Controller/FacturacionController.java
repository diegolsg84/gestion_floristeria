package com.iudigital.floristeria.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iudigital.floristeria.Repository.FinanzasRepository;
import com.iudigital.floristeria.models.Finanzas;
import com.iudigital.floristeria.models.GestionPedidos;
import com.iudigital.floristeria.services.GestionPedidosService;
import com.iudigital.floristeria.util.InventarioUtil;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/facturacion")
public class FacturacionController {
    @Autowired
    private GestionPedidosService pedidosService;
    
    @Autowired
    private FinanzasRepository finanzasRepository;

    @Autowired
    private InventarioUtil inventarioUtil;

    @GetMapping
    public String mostrarFactura(@RequestParam Long pedidoId, Model model) {
        GestionPedidos pedido = pedidosService.getPedido(pedidoId)
            .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        
        Finanzas finanzas = finanzasRepository.findByGestionPedidos(pedido)
            .orElseThrow(() -> new RuntimeException("Finanzas no encontradas para este pedido"));
        
        model.addAttribute("pedido", pedido);
        model.addAttribute("finanzas", finanzas);
        model.addAttribute("inventarioUtil", inventarioUtil);
        return "facturacion";
    }
}
