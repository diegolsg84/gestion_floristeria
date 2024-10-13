package com.iudigital.floristeria.Controller;

import com.iudigital.floristeria.models.GestionPedidos;
import com.iudigital.floristeria.models.VariedadFlores;
import com.iudigital.floristeria.services.GestionPedidosService;
import com.iudigital.floristeria.services.InventarioFloresService;
import com.iudigital.floristeria.services.dtos.GestionPedidosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pedidos")
public class GestionPedidosController {

    @Autowired
    private GestionPedidosService pedidosService;

    @Autowired
    private InventarioFloresService inventarioFloresService;

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
        model.addAttribute("inventarioFlores", inventarioFloresService.getAll());
        return "pedidos/nuevo";
    }

    @PostMapping("/crear")
    public String crearPedido(@ModelAttribute GestionPedidosDto pedidoDto, 
                            RedirectAttributes redirectAttributes) {
        // La lista tipoArreglo ya viene incluida en el pedidoDto
        GestionPedidos pedido = pedidosService.crearPedidoConArreglo(pedidoDto);
        return "redirect:/facturacion?pedidoId=" + pedido.getId();
    }

    // Editar pedido
    @GetMapping("/editar/{id}")
    public String editarPedido(@PathVariable Long id, Model model) {
        Optional<GestionPedidos> pedidoOpt = pedidosService.getPedido(id);
        if (pedidoOpt.isPresent()) {
            GestionPedidos pedido = pedidoOpt.get();
            model.addAttribute("pedido", pedido);
            model.addAttribute("inventarioFlores", inventarioFloresService.getAll());
            
            // Si es necesario, prepara el arreglo de flores para la edición
            if (pedido.getTipoArreglo() == null || pedido.getTipoArreglo().isEmpty()) {
                pedido.setTipoArreglo(new ArrayList<>());
                pedido.getTipoArreglo().add(new VariedadFlores());
            }
            
            return "pedidos/editar";
        } else {
            return "redirect:/pedidos";
        }
    }

    @PostMapping("/actualizar/{id}")
    public String updatePedido(@PathVariable Long id, 
                               @ModelAttribute GestionPedidosDto pedidoDto,
                               RedirectAttributes redirectAttributes) {
        try {
            GestionPedidos pedidoActualizado = pedidosService.updatePedido(id, pedidoDto);
            redirectAttributes.addFlashAttribute("mensaje", "Pedido actualizado con éxito");
            return "redirect:/facturacion?pedidoId=" + pedidoActualizado.getId();
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el pedido: " + e.getMessage());
            return "redirect:/pedidos/editar/" + id;
        }
    }

    // Eliminar pedido
    @GetMapping("/eliminar/{id}")
    public String deletePedido(@PathVariable Long id) {
        pedidosService.deletePedido(id); // Asegúrate de que este método esté en tu servicio
        return "redirect:/pedidos"; // Redirigir después de eliminar
    }
}