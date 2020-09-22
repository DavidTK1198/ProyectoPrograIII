/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Producto;

import Data.Data;
import Logic.Empresa;
import Logic.Producto;
import Logic.Service;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;


/**
 *
 * @author DavidTK1198
 */
public class Controller {

    private Presentation.Producto.View vista;
    private Presentation.Producto.Model model;

    public Controller(Presentation.Producto.View vista, Presentation.Producto.Model model) {
        this.vista = vista;
        this.model = model;
        vista.setControl(this);
        vista.setModel(model);
        model.setLista(Logic.Service.getInstance().getProductos());
    }

    public void show() {
        vista.setVisible(true);
    }

    public void agregar(Boolean editable, Producto p) {

        try {
            if (!editable) {

                Logic.Service.getInstance().addProduct(p);
                p.calculoIV();
                model.setLista(Logic.Service.getInstance().getProductos());
                
            } else {
                //Falta esta parte... ahorita la hacemos...
            }
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage());
        }
        model.setProduct(new Producto());
//        model.setEditable(false);
    }

    public void hide() {
        vista.setVisible(false);
    }

    void eliminar(int n) {
        Producto p=model.getRow(n);
        Logic.Service.getInstance().deleteProduct(p);
         model.setLista(Logic.Service.getInstance().getProductos());
    }

    public void cancelar() {
       model.setProduct(new Producto());
    }
    public void buscarPorCedula(String ced){
        
        try{
            Producto product = Service.getInstance().getProducto(ced);
            List<Producto> lp = new ArrayList<>();
            lp.add(product);
            model.setLista(lp);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        model.setProduct(new Producto());
    }

    public void cargarTodosLosProductos() {
            List<Producto> lp = Service.getInstance().getProductos();
            model.setLista(lp);
    }
    public void modificarProducto(Producto nuevo){
        Producto c = model.getProduct();
        String codigo = c.getCodigo();
        Logic.Service.getInstance().reemplazarProducto(codigo, nuevo);
        model.setLista(Logic.Service.getInstance().getProductos());
    }

   
}
