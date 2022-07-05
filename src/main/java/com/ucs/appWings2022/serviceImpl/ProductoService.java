/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ucs.appWings2022.serviceImpl;

import com.ucs.appWings2022.entity.Producto;
import java.util.List;

/**
 *
 * @author Victor Rosales
 */
public interface ProductoService {
    Producto create(Producto producto);
    Producto update(Producto producto);
    void delete(int id);
    Producto read(int id);
    List<Producto> readAll();
}
