/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ucs.appWings2022.util.reportes;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.ucs.appWings2022.entity.Proveedor;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor Rosales
 */
public class ProveedorExporterPDF {
    private List<Proveedor> listaProductos;
    
    public ProveedorExporterPDF(List<Proveedor> listaProductos) {
        super();
        this.listaProductos = listaProductos;
    }
    
    private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
        PdfPCell celda = new PdfPCell();

        celda.setBackgroundColor(Color.ORANGE);
        celda.setPadding(4);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.WHITE);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Nombre", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Telefono", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Direccion", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Estado", fuente));
        tabla.addCell(celda);
    }
    
    private void escribirDatosDeLaTabla(PdfPTable tabla) {
        for (Proveedor producto : listaProductos) {
            tabla.addCell(String.valueOf(producto.getId()));
            tabla.addCell(producto.getNombre());
            tabla.addCell(String.valueOf(producto.getTelefono()));
            tabla.addCell(producto.getDireccion());
            tabla.addCell(String.valueOf(producto.getEstado()));
        }
    }
    
    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLACK);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de Proveedores", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        Image image = null;
        image = Image.getInstance("D:\\wingslogo.png");
        image.scaleAbsolute(70, 70);//cambia tamaño
        image.setAbsolutePosition(510, 760); //coloca la imagen en la posicion
        documento.add(image);
        documento.add(titulo);
        documento.add(Chunk.NEWLINE);

        PdfPTable tabla = new PdfPTable(5);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[]{1f, 2.3f, 2.3f, 4f, 2.9f});
        tabla.setWidthPercentage(110);

        escribirCabeceraDeLaTabla(tabla);
        escribirDatosDeLaTabla(tabla);

        documento.add(tabla);
        documento.close();
    }
    
    
    
    
    
    
}
