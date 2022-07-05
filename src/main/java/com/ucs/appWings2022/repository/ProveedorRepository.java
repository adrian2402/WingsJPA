/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ucs.appWings2022.repository;

import com.ucs.appWings2022.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Victor Rosales
 */
@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{
    
}
