package com.iudigital.floristeria.Controller;

import com.iudigital.floristeria.models.Finanzas;
import com.iudigital.floristeria.models.CreacionArreglos;
import com.iudigital.floristeria.models.GestionEntrega;
import com.iudigital.floristeria.services.FinanzasService;
import com.iudigital.floristeria.services.CreacionArreglosService;
import com.iudigital.floristeria.services.GestionEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class InformesController {
    @Autowired
    private FinanzasService finanzasService;

    @Autowired
    private CreacionArreglosService creacionArreglosService;

    @Autowired
    private GestionEntregaService gestionEntregaService;

    @GetMapping("/informes")
    public String mostrarInformes(Model model) {
        List<Finanzas> finanzas = finanzasService.getAll();
        List<CreacionArreglos> arreglos = creacionArreglosService.obtenerTodosLosArreglos();
        List<GestionEntrega> entregas = gestionEntregaService.getAll();

        model.addAttribute("finanzas", finanzas);
        model.addAttribute("arreglos", arreglos);
        model.addAttribute("entregas", entregas);

        return "informes";  // Nombre del archivo de la vista
    }
}
