/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.*;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.property.UnitValue;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author DavidTK1198
 */
public class PDFMaker {

    public PDFMaker() {

    }

    public void resize(File original, File nueva, int width, int height) throws Exception {
        BufferedImage original1 = ImageIO.read(original);
        BufferedImage nueva1 = new BufferedImage(width, height, original1.getType());
        Graphics2D g2 = nueva1.createGraphics();
        g2.drawImage(original1, 0, 0, width, height, null);
        g2.dispose();
        ImageIO.write(nueva1, "png", nueva);
    }

    public void createPDF(Factura p) throws Exception {
        String path = "prueba.pdf";
        PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
        PdfWriter writer = new PdfWriter(path);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4);
        document.setMargins(20, 20, 20, 20);
        List<LineaDetalle> list = p.getLineas();
        LineaDetalle linea;
        Producto pd;
        File imagen1 = new File("image.png");
        File imagen2 = new File("logo.png");

        FileUtils.copyFile(imagen1, imagen2);
        this.resize(imagen1, imagen2, 150, 150);

        ImageData data = ImageDataFactory.create("logo.png");
        Image img = new Image(data);

        document.add(img);

        document.add(new Paragraph(""));
      document.add(new Paragraph("Factura Electronica N°: " + p.getNumeroFactura()).setFont(font).setBold().setFontSize(12f).setTextAlignment(TextAlignment.RIGHT));
     
        document.add(new Paragraph("Nombre de la empresa:    " + Logic.Service.getInstance().my_Empresa().getNombre()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Cedula Juridica: " + Logic.Service.getInstance().my_Empresa().getCedulaJuridica()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Telefono:    " + Logic.Service.getInstance().my_Empresa().getTelefono()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Correo Electronico de la empresa:    " + Logic.Service.getInstance().my_Empresa().getCorreo()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Direccion de la empresa:     " + Logic.Service.getInstance().my_Empresa().getDireccion()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Cliente: " + p.getCurret().getNombre() + p.getCurret().getApellidos()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Correo del Cliente: " + p.getCurret().getCorreoE()).setFont(font).setBold().setFontSize(12f));
        document.add(new Paragraph("Cedula : " + p.getCurret().getCedula()).setFont(font).setBold().setFontSize(12f));
         document.add(new Paragraph("Tipo de pago  : " + p.getTipoPago()).setFont(font).setBold().setFontSize(12f).setTextAlignment(TextAlignment.RIGHT));

        document.add(new Paragraph("Fecha: " + p.getFecha2()).setFont(font).setBold().setFontSize(12f).setTextAlignment(TextAlignment.RIGHT));

        Table table = new Table(5);
        Cell c;
        Color bkg = ColorConstants.CYAN;
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
        table.setWidth(UnitValue.createPercentValue(100));
        document.add(table);
        document.add(new Paragraph("")).setFont(font).setBold().setFontSize(12f).setTextAlignment(TextAlignment.RIGHT);
         document.add(new Paragraph("Tipo de Pago   "+p.getTipoPago())).setFont(font).setBold().setFontSize(12f).setTextAlignment(TextAlignment.RIGHT);
        document.add(new Paragraph("Total de  la compra    " + Double.toString(p.calcularTotal()))).setFont(font).setBold().setFontSize(12f).setTextAlignment(TextAlignment.RIGHT);
        document.add(new Paragraph("SubTotal   " + Double.toString(p.subTotal()))).setFont(font).setBold().setFontSize(12f).setTextAlignment(TextAlignment.RIGHT);
        document.add(new Paragraph("IVA   " + Double.toString(p.totalImpuesto()))).setFont(font).setBold().setFontSize(12f).setTextAlignment(TextAlignment.RIGHT);
        document.close();
    }

}
