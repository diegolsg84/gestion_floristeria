package com.iudigital.floristeria.Controller;

import com.iudigital.floristeria.models.InventarioFlores;
import com.iudigital.floristeria.services.InventarioFloresService;
import com.iudigital.floristeria.services.dtos.InventarioFloresDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/Inventario")
public class InventarioFloresController {

    @Autowired
    private InventarioFloresService inventariosService;

    // Método para mostrar la lista
    @GetMapping("/lista")
    public String listarInventarios(Model model) {
        List<InventarioFlores> inventarios = inventariosService.getAll();
        model.addAttribute("inventarios", inventarios);
        return "inventario/listar"; // Ruta al template listar.html
    }

    @GetMapping("/crear")
    public String crearInventarioForm(Model model) {
        model.addAttribute("inventario", new InventarioFlores());
        return "inventario/crear"; // Ruta al template crear.html
    }

    @PostMapping("/crear")
    public String saveInventario(@ModelAttribute InventarioFlores inventario) {
        inventariosService.save(inventario);
        return "redirect:/Inventario/lista"; // Redirige a la lista después de guardar
    }

    // Método para mostrar el formulario de actualizar
    @GetMapping("/actualizar/{id}")
    public String actualizarInventarioForm(@PathVariable Long id, Model model) {
        InventarioFlores inventario = inventariosService.getinventarioFlores(id)
            .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
        model.addAttribute("inventario", inventario);
        return "inventario/actualizar"; // Ruta al template actualizar.html
    }

    // Método para manejar la actualización
    @PostMapping("/actualizar/{id}")
    public String actualizarInventario(@PathVariable Long id, @ModelAttribute InventarioFloresDto inventario) {
        inventariosService.updateinventarioFlores(id,inventario);
        return "redirect:/Inventario/lista"; // Redirige a la lista después de actualizar
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Long id) {
    inventariosService.deleteInventario(id);
    return ResponseEntity.noContent().build(); // Devuelve un código 204 No Content
    }
}
