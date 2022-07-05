/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ucs.appWings2022.serviceImpl;

import com.ucs.appWings2022.entity.Cliente;
import java.util.List;

/**
 *
 * @author Victor Rosales
 */
public interface ClienteService {
    Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
    void delete(int id);
    Cliente read(int id);
    List<Cliente> readAll();
}
