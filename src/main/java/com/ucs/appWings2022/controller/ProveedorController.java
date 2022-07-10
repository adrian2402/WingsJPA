/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.controller;

import com.lowagie.text.DocumentException;
import com.ucs.appWings2022.entity.Proveedor;
import com.ucs.appWings2022.serviceImpl.ProveedorService;
import com.ucs.appWings2022.util.reportes.LibroExporterPDF;
import com.ucs.appWings2022.util.reportes.ProveedorExporterExcel;
import com.ucs.appWings2022.util.reportes.ProveedorExporterPDF;
import java.io.IOException;
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
    
    @GetMapping("/exportarPDF")
    public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Proveedores_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        List<Proveedor> producto = productoService.readAll();

        ProveedorExporterPDF exporter = new ProveedorExporterPDF(producto);
        exporter.exportar(response);
    }
    
    @GetMapping("/exportarExcel")
    public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/octet-stream");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Proveedores_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);

        List<Proveedor> libros = productoService.readAll();

        ProveedorExporterExcel exporter = new ProveedorExporterExcel(libros);
        exporter.exportar(response);
    }
    
    
}
