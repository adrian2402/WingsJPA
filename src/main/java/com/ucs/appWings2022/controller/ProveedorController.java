/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.controller;

import com.ucs.appWings2022.entity.Proveedor;
import com.ucs.appWings2022.serviceImpl.ProveedorService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Victor Rosales
 */
@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
    
     @Autowired
    private ProveedorService productoService;
   
     @GetMapping
    public String indexProducto(Model model){
        model.addAttribute("proveedor", productoService.readAll());
        return "proveedor/listarProveedor";
    }
    @GetMapping("/add")
    public String addProducto(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor/addProveedor";
    }
    
    @GetMapping("/save")
    public String saveProducto(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor/addProveedor";
    }
    @PostMapping("/save")
    public String addEditorial(@Valid @ModelAttribute Proveedor editorial, BindingResult result, Model model, RedirectAttributes attributes ) {  
        productoService.create(editorial);
        return "redirect:/proveedor";
    }
    
    @GetMapping("/edit/{id}")
    public String editarEditorial(@PathVariable("id") int idproveedor, Model model) {  
        Proveedor editorial = productoService.read(idproveedor);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("proveedor", editorial);
        return "proveedor/addProveedor";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEditorial(@PathVariable("id") int idproveedor) {  
       productoService.delete(idproveedor);
        return "redirect:/proveedor";
    }
    
}
