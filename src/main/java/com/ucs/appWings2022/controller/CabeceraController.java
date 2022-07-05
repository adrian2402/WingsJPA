/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.controller;

import com.ucs.appWings2022.entity.Cabecera;
import com.ucs.appWings2022.serviceImpl.CabeceraService;
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
@RequestMapping("/cabecera")
public class CabeceraController {

    @Autowired
    private CabeceraService cabeceraService;
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String indexProducto(Model model) {
        model.addAttribute("cabecera", cabeceraService.readAll());
        return "cabecera/listarCabecera";
    }

    @GetMapping("/add")
    public String addProducto(Model model) {
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("cabecera", new Cabecera());
        model.addAttribute("cliente", clienteService.readAll());
        return "cabecera/addCabecera";
    }

    @GetMapping("/save")
    public String saveProducto(Model model) {
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("cabecera", new Cabecera());
        return "cabecera/addCabecera";
    }

    @PostMapping("/save")
    public String addEditorial(@Valid @ModelAttribute Cabecera editorial, BindingResult result, Model model, RedirectAttributes attributes) {
        cabeceraService.create(editorial);
        return "redirect:/cabecera";
    }
    
    @GetMapping("/edit/{id}")
    public String editarEditorial(@PathVariable("id") int idcabecera, Model model) {  
        Cabecera cabecera = cabeceraService.read(idcabecera);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("cabecera", cabecera);
       model.addAttribute("cliente", clienteService.readAll());
        return "cabecera/addCabecera";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEditorial(@PathVariable("id") int idcabecera) {  
      cabeceraService.delete(idcabecera);
        return "redirect:/cabecera";
    }

}
