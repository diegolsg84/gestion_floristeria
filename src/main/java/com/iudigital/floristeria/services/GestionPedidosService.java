package com.iudigital.floristeria.services;


import com.iudigital.floristeria.Repository.FinanzasRepository;
import com.iudigital.floristeria.Repository.GestionPedidosRepository;
import com.iudigital.floristeria.Repository.InventarioFloresRepository;
import com.iudigital.floristeria.models.Finanzas;
import com.iudigital.floristeria.models.GestionPedidos;
import com.iudigital.floristeria.models.InventarioFlores;
import com.iudigital.floristeria.models.VariedadFlores;
import com.iudigital.floristeria.services.dtos.GestionPedidosDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class GestionPedidosService {
    @Autowired
    private GestionPedidosRepository pedidosRepository;
    
    @Autowired
    private InventarioFloresRepository inventarioRepository;
    
    @Autowired
    private FinanzasRepository finanzasRepository;

    @Transactional
    public GestionPedidos crearPedidoConArreglo(GestionPedidosDto pedidoDto) {
        GestionPedidos pedido = new GestionPedidos();
        // Mapear los campos del DTO al objeto GestionPedidos
        pedido.setNombreCliente(pedidoDto.getNombreCliente());
        pedido.setApellidoCliente(pedidoDto.getApellidoCliente());
        pedido.setEmailCliente(pedidoDto.getEmailCliente());
        pedido.setDireccionCliente(pedidoDto.getDireccionCliente());
        pedido.setTelefonoCliente(pedidoDto.getTelefonoCliente());
        pedido.setOcasion(pedidoDto.getOcasion());
        pedido.setFechaEntrega(pedidoDto.getFechaEntrega());
        pedido.setPresupuesto(pedidoDto.getPresupuesto());
        pedido.setEstado("Pendiente"); // Estado inicial
    
        BigDecimal precioTotal = BigDecimal.ZERO;
        StringBuilder tipoArreglo = new StringBuilder();
        
        List<VariedadFlores> arregloFinal = new ArrayList<>();
        
        for (VariedadFlores variedad : pedidoDto.getTipoArreglo()) {
            InventarioFlores inventario = inventarioRepository.findById(variedad.getTipoFlores())
                .orElseThrow(() -> new EntityNotFoundException("Flor no encontrada en inventario con ID: " + variedad.getTipoFlores()));
            
            if (inventario.getCantidadDisponible() < variedad.getCantidad()) {
                throw new RuntimeException("No hay suficientes flores disponibles para: " + inventario.getTipoFlores());
            }
            
            inventario.setCantidadDisponible(inventario.getCantidadDisponible() - variedad.getCantidad());
            inventarioRepository.save(inventario);
            
            VariedadFlores variedadFinal = new VariedadFlores();
            variedadFinal.setTipoFlores(variedad.getTipoFlores());
            variedadFinal.setCantidad(variedad.getCantidad());
            variedadFinal.setGestionPedidos(pedido);
            arregloFinal.add(variedadFinal);
            
            tipoArreglo.append(inventario.getTipoFlores()).append(", ");
            precioTotal = precioTotal.add(inventario.getPrecioVenta().multiply(new BigDecimal(variedad.getCantidad())));
        }
        
        // Eliminar la última coma y espacio
        if (tipoArreglo.length() > 0) {
            tipoArreglo.setLength(tipoArreglo.length() - 2);
        }
        pedido.setTipoArreglo(arregloFinal);
        
        pedido = pedidosRepository.save(pedido);
        
        BigDecimal costosAdicionales = precioTotal.multiply(new BigDecimal("0.20"));
        BigDecimal total = precioTotal.add(costosAdicionales);
        
        Finanzas finanzas = new Finanzas();
        finanzas.setOrdenCompletada(true);
        finanzas.setDetallePedido("Pedido #" + pedido.getId());
        finanzas.setPrecioFlores(precioTotal);
        finanzas.setCostosAdicionales(costosAdicionales);
        finanzas.setTotal(total);
        finanzas.setGestionPedidos(pedido);
        finanzasRepository.save(finanzas);
        
        return pedido;
    }



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
            pedido.setOcasion(pedidosDto.getOcasion());
            pedido.setFechaEntrega(pedidosDto.getFechaEntrega());
            pedido.setPresupuesto(pedidosDto.getPresupuesto());
            pedido.setEstado(pedidosDto.getEstado());


            return pedidosRepository.save(pedido);
        } else {
            throw new EntityNotFoundException("Pedido no encontrado");
        }
    }

    public void deletePedido(Long id) {
        if (pedidosRepository.existsById(id)) {
            pedidosRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Pedido no encontrado");
        }
    }
}
