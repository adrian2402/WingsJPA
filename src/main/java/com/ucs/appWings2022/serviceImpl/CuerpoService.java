/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ucs.appWings2022.serviceImpl;

import com.ucs.appWings2022.entity.Cuerpo;
import java.util.List;

/**
 *
 * @author Victor Rosales
 */
public interface CuerpoService {
    Cuerpo create(Cuerpo cuerpo);
    Cuerpo  update(Cuerpo cuerpo);
    void delete(int id);
    Cuerpo  read(int id);
    List<Cuerpo> readAll();
}
