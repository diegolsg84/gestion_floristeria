package com.iudigital.floristeria.services;

import com.iudigital.floristeria.models.GestionPedidos;
import com.iudigital.floristeria.services.dtos.GestionPedidosDto;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public class GestionEntregaService {
    public Optional<GestionPedidos> getPedido(Long id){
        return pedidosRepository.findById(id);
    }
    public List<GestionPedidos> getAll() {
        return  pedidosRepository.findAll();
    }

    public GestionPedidos save(GestionPedidos pedidos) {
        return pedidosRepository.save(pedidos);
    }

    public GestionPedidos updatePedido(Long id, GestionPedidosDto pedidosDto) {
        Optional<GestionPedidos> pedidoExistente = pedidosRepository.findById(id);
        if (pedidoExistente.isPresent()) {
            GestionPedidos pedido = pedidoExistente.get();
            pedido.setNombreCliente(pedidosDto.getNombreCliente());
            pedido.setApellidoCliente(pedidosDto.getApellidoCliente());
            pedido.setEmailCliente(pedidosDto.getEmailCliente());
            pedido.setDireccionCliente(pedidosDto.getDireccionCliente());
            pedido.setTelefonoCliente(pedidosDto.getTelefonoCliente());
            pedido.setTipoArreglo(pedidosDto.getTipoArreglo());
            pedido.setOcasion(pedidosDto.getOcasion());
            pedido.setFechaEntrega(pedidosDto.getFechaEntrega());
            pedido.setPresupuesto(pedidosDto.getPresupuesto());
            pedido.setEstado(pedidosDto.getEstado());


            return pedidosRepository.save(pedido);
        } else {
            throw new EntityNotFoundException("Pedido no encontrado");
        }
    }
}
