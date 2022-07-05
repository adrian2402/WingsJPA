/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.serviceImpl;

import com.ucs.appWings2022.entity.Cuerpo;
import com.ucs.appWings2022.repository.CuerpoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Rosales
 */
@Service
public class CuerpoServiceImpl implements CuerpoService {

    @Autowired
    private CuerpoRepository clienteRepository;

    @Override
    public Cuerpo create(Cuerpo cuerpo) {
        return clienteRepository.save(cuerpo);
    }

    @Override
    public Cuerpo update(Cuerpo cuerpo) {
        return clienteRepository.save(cuerpo);
    }

    @Override
    public void delete(int id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cuerpo read(int id) {
        return clienteRepository.findById(id).get();
    }

    @Override
    public List<Cuerpo> readAll() {
        return clienteRepository.findAll();
    }
}
