/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.controller;

import com.ucs.appWings2022.entity.Cliente;
import com.ucs.appWings2022.serviceImpl.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService productoService;
    
    
    @GetMapping
    public String indexProducto(Model model){
        model.addAttribute("cliente", productoService.readAll());
        return "cliente/listarCliente";
    }
    @GetMapping("/add")
    public String addProducto(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("cliente", new Cliente());
        return "cliente/addCliente";
    }
    @GetMapping("/save")
    public String saveProducto(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("cliente", new Cliente());
        return "cliente/addCliente";
    }
    
    @PostMapping("/save")
    public String addEditorial(@Valid @ModelAttribute Cliente editorial, BindingResult result, Model model, RedirectAttributes attributes ) {  
        productoService.create(editorial);
        return "redirect:/cliente";
    }
    
    @GetMapping("/edit/{id}")
    public String editarEditorial(@PathVariable("id") int idcliente, Model model) {  
        Cliente editorial = productoService.read(idcliente);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("cliente", editorial);
        return "cliente/addCliente";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEditorial(@PathVariable("id") int idcliente) {  
       productoService.delete(idcliente);
        return "redirect:/cliente";
    }
}
