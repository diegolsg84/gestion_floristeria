package com.iudigital.floristeria.Controller;

import com.iudigital.floristeria.models.GestionPedidos;
import com.iudigital.floristeria.services.GestionPedidosService;
import com.iudigital.floristeria.services.dtos.GestionPedidosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pedidos")
public class GestionPedidosController {

    @Autowired
    private GestionPedidosService pedidosService;

    // Listar pedidos
    @GetMapping
    public String listPedidos(Model model) {
        List<GestionPedidos> pedidos = pedidosService.getAll();
        model.addAttribute("pedidos", pedidos);
        return "pedidos/list"; // Nombre de la plantilla para listar pedidos
    }

    // Crear nuevo pedido
    @GetMapping("/nuevo")
    public String crearPedido(Model model) {
        model.addAttribute("pedido", new GestionPedidos());
        return "pedidos/nuevo"; // Nombre de la plantilla para crear un nuevo pedido
    }

    @PostMapping("/crear")
    public String savePedido(@ModelAttribute GestionPedidos pedido) {
        pedidosService.save(pedido);
        return "redirect:/pedidos"; // Redirigir después de guardar
    }

    // Editar pedido
    @GetMapping("/editar/{id}")
    public String editarPedido(@PathVariable Long id, Model model) {
        Optional<GestionPedidos> pedido = pedidosService.getPedido(id);
        if (pedido.isPresent()) {
            model.addAttribute("pedido", pedido.get());
            return "pedidos/editar"; // Nombre de la plantilla para editar un pedido
        } else {
            return "redirect:/pedidos"; // Redirigir si no se encuentra el pedido
        }
    }

    @PostMapping("/actualizar/{id}")
    public String updatePedido(@PathVariable Long id, @ModelAttribute GestionPedidosDto pedido) {
        pedidosService.updatePedido(id, pedido); // Asegúrate de que esto sea correcto
        return "redirect:/pedidos"; // Redirigir después de actualizar
    }

    // Eliminar pedido
    @GetMapping("/eliminar/{id}")
    public String deletePedido(@PathVariable Long id) {
        pedidosService.deletePedido(id); // Asegúrate de que este método esté en tu servicio
        return "redirect:/pedidos"; // Redirigir después de eliminar
    }
}