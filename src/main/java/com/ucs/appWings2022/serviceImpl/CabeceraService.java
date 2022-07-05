/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ucs.appWings2022.serviceImpl;

import com.ucs.appWings2022.entity.Cabecera;
import java.util.List;

/**
 *
 * @author Victor Rosales
 */
public interface CabeceraService {
    Cabecera create(Cabecera cabecera);
    Cabecera update(Cabecera cabecera);
    void delete(int id);
    Cabecera read(int id);
    List<Cabecera> readAll();
}
