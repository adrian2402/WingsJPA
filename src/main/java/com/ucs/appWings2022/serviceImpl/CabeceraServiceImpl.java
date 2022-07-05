/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.serviceImpl;

import com.ucs.appWings2022.entity.Cabecera;
import com.ucs.appWings2022.repository.CabeceraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Rosales
 */
@Service
public class CabeceraServiceImpl implements CabeceraService{

    @Autowired
    private CabeceraRepository cabeceraRepository;
    
        
        
    @Override
    public Cabecera create(Cabecera cabecera) {
        return cabeceraRepository.save(cabecera);}

    @Override
    public Cabecera update(Cabecera cabecera) {
       return cabeceraRepository.save(cabecera);  }

    @Override
    public void delete(int id) {
       cabeceraRepository.deleteById(id); }

    @Override
    public Cabecera read(int id) {
        return cabeceraRepository.findById(id).get(); }

    @Override
    public List<Cabecera> readAll() {
           return cabeceraRepository.findAll();
    }
    
}
