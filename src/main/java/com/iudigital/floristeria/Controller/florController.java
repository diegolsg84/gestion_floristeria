package com.iudigital.floristeria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/flores")
public class florController {

    @GetMapping("/listar")
    public String listarFlores() {
        return "flores";
    }

    @GetMapping("/registrar")
    public String registrarFlores() {
        return "regFlores";
    }

} // Asegúrate de que esta llave de cierre cierre la clase y no esté de más.
