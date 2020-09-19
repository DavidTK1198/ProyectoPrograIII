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
import Logic.Service;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * 
 * 
 * @author DavidTK1198
 * 
 * 
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
        model.updateTables();
        vista.setVisible(true);
    }


    public void hide() {
        vista.setVisible(false);
    }

    public void setProducto(int n) {
       Producto p=model.getTableProducto().getRowAt(n);
       model.setPd(p);
    }

    public void setCliente(int n) {
       Cliente cl=model.getTableCliente().getRowAT(n);
       model.setCl(cl);
    }

    void agregar(LineaDetalle nueva) {
        Factura p=model.getNueva();
       model.setLi(nueva);
       model.setLista(model.getNueva().getLineas());
       p.addLine(nueva);
       
    }

    public void hacerFactura() {
        Factura p;
        p=model.getNueva();
         p.setCurret(model.getCl());
         p.setTipoPago(this.vista.getTipo());
    try {
         Logic.Service.getInstance().addFactura(p);
         Logic.Service.getInstance().createPDF(p);
     } catch (Exception ex) {
       
        JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
       
    }
        this.model.setFlag(true);
        this.model.facturaUpdate();
        this.model.setLista(model.getNueva().getLineas()); 
    }

    public void buscarCliente(String ced) {
        try{
            Cliente client = Service.getInstance().getCliente(ced);
            List<Cliente> lc = new ArrayList<>();
            lc.add(client);
            model.setCliente(lc);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        model.setCl(new Cliente());
    }

    public void cargarTodosLosClientes() {
        List<Cliente> lc = Service.getInstance().getClientes();
        model.setCliente(lc);
    }

    public void busquedaProducto(String prod) {
        try{
            Producto product = Service.getInstance().getProducto(prod);
            List<Producto> lp = new ArrayList<>();
            lp.add(product);
            model.setProducto(lp);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        model.setPd(new Producto());
    }
    public void cargarTodosLosProductos(){
        List<Producto> lp = Service.getInstance().getProductos();
        model.setProducto(lp);
    }
    public void eliminarLineaDetalle(int numero){
        List<LineaDetalle> Ld = model.getNueva().getLineas();
        Ld.remove(numero);
        model.setLista(Ld);
    }
   
}
