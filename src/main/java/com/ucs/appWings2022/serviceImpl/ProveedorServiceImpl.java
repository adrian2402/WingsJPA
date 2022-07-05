/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.serviceImpl;

import com.ucs.appWings2022.entity.Proveedor;
import com.ucs.appWings2022.repository.ProveedorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Rosales
 */
@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository clienteRepository;

    @Override
    public Proveedor create(Proveedor proveedor) {
        return clienteRepository.save(proveedor);
    }

    @Override
    public Proveedor update(Proveedor proveedor) {
        return clienteRepository.save(proveedor);
    }

    @Override
    public void delete(int id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Proveedor read(int id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public List<Proveedor> readAll() {
        return clienteRepository.findAll();
    }

}
