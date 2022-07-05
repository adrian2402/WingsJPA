/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.controller;

import com.ucs.appWings2022.entity.Cuerpo;
import com.ucs.appWings2022.serviceImpl.CabeceraService;
import com.ucs.appWings2022.serviceImpl.CuerpoService;
import com.ucs.appWings2022.serviceImpl.ProductoService;
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
@RequestMapping("/cuerpo")
public class CuerpoController {

    @Autowired
    private CuerpoService cuerpoService;

    @Autowired
    private CabeceraService cabeceraService;

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String indexProducto(Model model) {
        model.addAttribute("cuerpo", cuerpoService.readAll());
        return "cuerpo/listarCuerpo";
    }

    @GetMapping("/add")
    public String addProducto(Model model) {
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("cuerpo", new Cuerpo());
        model.addAttribute("cabecera", cabeceraService.readAll());
        model.addAttribute("producto", productoService.readAll());
        return "cuerpo/addCuerpo";
    }

    @GetMapping("/save")
    public String saveProducto(Model model) {
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("cuerpo", new Cuerpo());
        return "cuerpo/addCuerpo";
    }

    @PostMapping("/save")
    public String addEditorial(@Valid @ModelAttribute Cuerpo editorial, BindingResult result, Model model, RedirectAttributes attributes) {
        cuerpoService.create(editorial);
        return "redirect:/cuerpo";
    }

    @GetMapping("/edit/{id}")
    public String editarEditorial(@PathVariable("id") int idcuerpo, Model model) {
        Cuerpo editorial = cuerpoService.read(idcuerpo);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("cuerpo", editorial);
        model.addAttribute("cabecera", cabeceraService.readAll());
        model.addAttribute("producto", productoService.readAll());
        return "cuerpo/addCuerpo";
    }

    @GetMapping("/delete/{id}")
    public String deleteEditorial(@PathVariable("id") int idcuerpo) {
        cuerpoService.delete(idcuerpo);
        return "redirect:/cuerpo";
    }
}
