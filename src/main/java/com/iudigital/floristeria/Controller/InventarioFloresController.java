package com.iudigital.floristeria.Controller;

import com.iudigital.floristeria.services.InventarioFloresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Inventario")
public class InventarioFloresController {
    @Autowired
    private InventarioFloresService floresService;


}
