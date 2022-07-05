/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.serviceImpl;

import com.ucs.appWings2022.entity.Producto;
import com.ucs.appWings2022.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Rosales
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository clienteRepository;

    @Override
    public Producto create(Producto producto) {
        return clienteRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        return clienteRepository.save(producto);
    }

    @Override
    public void delete(int id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Producto read(int id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public List<Producto> readAll() {
        return clienteRepository.findAll();
    }

}
