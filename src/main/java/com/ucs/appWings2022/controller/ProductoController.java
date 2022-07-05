/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.controller;

import com.ucs.appWings2022.entity.Producto;
import com.ucs.appWings2022.serviceImpl.ProductoService;
import com.ucs.appWings2022.serviceImpl.ProveedorService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Victor Rosales
 */
@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private ProveedorService proveedorService;
    
    @GetMapping
    public String indexLibro(Model model){
        model.addAttribute("producto", productoService.readAll());
        return "producto/listarProducto";
    }
    
    @GetMapping("/add")
    public String addLibro(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("producto", new Producto());
        model.addAttribute("proveedor", proveedorService.readAll());
        return "producto/addProducto";
    }
    
    @GetMapping("/save")
    public String saveLibro(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("producto", new Producto());
        return "producto/addProducto";
    }
    
    @PostMapping("/save")
    public String addLibro(@Valid @ModelAttribute Producto libro, BindingResult result, Model model, @RequestParam("imagen") MultipartFile imagen, RedirectAttributes attributes ) {  

        if(!imagen.isEmpty()){
            //Path dirimg = Paths.get("src//main//resources//static/images");
            String ruta = "D://wings//producto";
            //String ruta = dirimg.toFile().getAbsolutePath();
            //String ruta = "E://recursos//images//autor";
            
            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutacompleta = Paths.get(ruta+"//"+imagen.getOriginalFilename());
                Files.write(rutacompleta, bytesImg);
                libro.setImagen(imagen.getOriginalFilename());
                productoService.create(libro);
            } catch (IOException e) {
                System.out.println("Error: "+e);
            }
        }
        return "redirect:/producto";
    }
    
    @GetMapping("/edit/{id}")
    public String editarLibro(@PathVariable("id") int idproducto, Model model) {  
        Producto libro = productoService.read(idproducto);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("producto", libro);
        model.addAttribute("proveedor", proveedorService.readAll());
        return "producto/addProducto";
    }
    @GetMapping("/detalle/{id}")
    public String detalleLibro(@PathVariable("id") int idproducto, Model model) {
        
        Producto libro = productoService.read(idproducto);
        model.addAttribute("titulo", "Detalle");
        model.addAttribute("libro", libro);
        return "producto/detalleProducto";
    }
    @GetMapping("/delete/{id}")
    public String deleteLibro(@PathVariable("id") int idproducto) {  
       productoService.delete(idproducto);
        return "redirect:/producto";
    }
    
}
