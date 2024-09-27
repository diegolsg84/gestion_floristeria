package com.iudigital.floristeria.services;

import com.iudigital.floristeria.Repository.InventarioFloresRepository;
import com.iudigital.floristeria.models.InventarioFlores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class InventarioFloresService {
    @Autowired
    private InventarioFloresRepository floresRepository;

//    public List<InventarioFlores> getAll() {
//        List<InventarioFlores> flores = new ArrayList<>();
//        floresRepository.findAll().forEach(idInventario -> flores.add(idInventario.getId()));
//        return flores;
//    }


    public InventarioFlores save(InventarioFlores flores) {
        floresRepository.save(flores);
        return flores;
    }

//
//    public void delete(int idInventario) {
//        floresRepository.deleteById(idInventario);
//
//    }


//    public InventarioFlores getClient(int idInventario) {
//        return floresRepository.findById(idInventario);
//    }



}
