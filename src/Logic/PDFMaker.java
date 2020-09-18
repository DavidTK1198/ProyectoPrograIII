/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.util.List;
//import javafx.stage.FileChooser;

/**
 *
 * @author DavidTK1198
 */
public class PDFMaker {

    public PDFMaker() {

    }

    public void createPDF(Factura p) throws Exception {
        String path = "prueba.pdf";
        PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        PdfWriter writer = new PdfWriter(path);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);
        List<LineaDetalle> list = p.getLineas();
        LineaDetalle linea;
        Producto pd;

//        ImageData data = ImageDataFactory.create("Images/cancel.png");        
////        Image img = new Image(data); 
//        document.add(img);
        document.add(new Paragraph(""));
        document.add(new Paragraph("Nombre de la empresa    " + Logic.Empresa.getInstance().getNombre()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Cedula Juridica " + Logic.Empresa.getInstance().getCedulaJuridica()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Telefono    " + Logic.Empresa.getInstance().getTelefono()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Correo Electronico de la empresa    " + Logic.Empresa.getInstance().getCorreo()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Direccion de la empresa     " + Logic.Empresa.getInstance().getDireccion()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Cliente: " + p.getCurret().getNombre() + p.getCurret().getApellidos()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Correo del Cliente " + p.getCurret().getCorreoE()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Cedula : " + p.getCurret().getCedula()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Fecha: " + p.getFecha2()).setFont(font).setBold().setFontSize(12f).setTextAlignment(TextAlignment.RIGHT));

        Table table = new Table(5);
        Cell c;
        Color bkg = ColorConstants.RED;
        Color frg = ColorConstants.WHITE;
        c = new Cell();
        c.add(new Paragraph("Cantidad")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        c = new Cell();
        c.add(new Paragraph("Codigo")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        c = new Cell();
        c.add(new Paragraph("Descripcion")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        c = new Cell();
        c.add(new Paragraph("Precio")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        c = new Cell();
        c.add(new Paragraph("Total")).setBackgroundColor(bkg).setFontColor(frg);
        table.addHeaderCell(c);
        for (int i = 0; i < list.size(); i++) {
            linea = list.get(i);
            pd = linea.getCurret1();
            table.addHeaderCell(Double.toString(linea.getCantidadProd()));
            table.addHeaderCell(pd.getCodigo());
            table.addHeaderCell(pd.getDescripcion());
            table.addHeaderCell(Double.toString(pd.getPrecioUnitario()));
            table.addHeaderCell(Double.toString(pd.getPrecioUnitario() * linea.getCantidadProd()));
        }
        table.addHeaderCell(Double.toString(p.calcularTotal()));
        c.add(new Paragraph("SubTotal   " + Double.toString(p.subTotal()))).setBackgroundColor(bkg).setFontColor(frg).setTextAlignment(TextAlignment.RIGHT);
        c.add(new Paragraph("Total de  la compra    " + Double.toString(p.calcularTotal()))).setBackgroundColor(bkg).setFontColor(frg).setTextAlignment(TextAlignment.RIGHT);
        c = new Cell(1, 4);
        c.add(new Paragraph("IVA   " + Double.toString(p.totalImpuesto()))).setBackgroundColor(bkg).setFontColor(frg).setTextAlignment(TextAlignment.RIGHT);
        table.addHeaderCell(c);
        c = new Cell();
        c.add(new Paragraph(Double.toString(p.subTotal()))).setBackgroundColor(bkg).setFontColor(frg).setTextAlignment(TextAlignment.RIGHT);
        table.setWidth(UnitValue.createPercentValue(100));
        table.addHeaderCell(c);
        document.add(table);
        document.close();
    }

}
