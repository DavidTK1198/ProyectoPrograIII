/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Facturacion;

import Logic.Cliente;
import Logic.Factura;
import Logic.LineaDetalle;
import Logic.Producto;
import javax.swing.JOptionPane;

/**
 * 
 * @author DavidTK1198
 */
public class Controller {
private Presentation.Facturacion.View vista;
    private Presentation.Facturacion.Model model;

    public Controller(Presentation.Facturacion.View vista, Presentation.Facturacion.Model model) {
        this.vista = vista;
        this.model = model;
        vista.setControl(this);
        vista.setModel(model);
    }

    public void show() {
        vista.setVisible(true);
        model.updateTables();
    }


    public void hide() {
        vista.setVisible(false);
    }

    void setProducto(int n) {
       Producto p=model.getTableProducto().getRowAt(n);
       model.setPd(p);
    }

    void setCliente(int n) {
       Cliente cl=model.getTableCliente().getRowAT(n);
       model.setCl(cl);
    }

    void agregar(LineaDetalle nueva) {
        Factura p=model.getNueva();
       model.setLi(nueva);
       model.setLista(model.getNueva().getLineas());
       p.addLine(nueva);
       
    }

    void hacerFactura() {
        Factura p;
        LineaDetalle nueva=model.getLi();
        this.model.getNueva().addLine(nueva);
        p=model.getNueva();
    try {
        Logic.Service.getInstance().addFactura(p);
    } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
            
        }
        this.model.setFlag(true);
        this.model.facturaUpdate();
        this.model.setLista(model.getNueva().getLineas()); 
        
    }

   
}
