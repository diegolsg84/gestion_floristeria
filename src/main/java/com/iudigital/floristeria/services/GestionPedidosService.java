package com.iudigital.floristeria.services;

import com.iudigital.floristeria.Repository.GestionEntregaRepository;
import com.iudigital.floristeria.Repository.GestionPedidosRepository;
import com.iudigital.floristeria.models.GestionEntrega;
import com.iudigital.floristeria.models.GestionPedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
@Service
public class GestionPedidosService {
    @Autowired
    private GestionPedidosRepository pedidosRepository;

    public Optional<GestionPedidos> getPedido(Long id){
     return pedidosRepository.findById(id);
    }
}
