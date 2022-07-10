/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.controller;

import com.lowagie.text.DocumentException;
import com.ucs.appWings2022.entity.Producto;
import com.ucs.appWings2022.serviceImpl.ProductoService;
import com.ucs.appWings2022.serviceImpl.ProveedorService;
import com.ucs.appWings2022.util.reportes.LibroExporterPDF;
import com.ucs.appWings2022.util.reportes.ProductoExporterExcel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
    
    @GetMapping("/exportarPDF")
    public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Productos_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        List<Producto> producto = productoService.readAll();

        LibroExporterPDF exporter = new LibroExporterPDF(producto);
        exporter.exportar(response);
    }
    
    
    @GetMapping("/exportarExcel")
    public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Productos_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);

        List<Producto> libros = productoService.readAll();

        ProductoExporterExcel exporter = new ProductoExporterExcel(libros);
        exporter.exportar(response);
    }
    
    
    
}
