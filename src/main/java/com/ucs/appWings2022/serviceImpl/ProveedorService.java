/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ucs.appWings2022.serviceImpl;


import com.ucs.appWings2022.entity.Proveedor;
import java.util.List;

/**
 *
 * @author Victor Rosales
 */
public interface ProveedorService {
    Proveedor create(Proveedor proveedor);
    Proveedor update(Proveedor proveedor);
    void delete(int id);
    Proveedor read(int id);
    List<Proveedor> readAll();
}
