/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Producto;

import Logic.Producto;
import javax.swing.JOptionPane;

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
    }

    public void show() {
        vista.setVisible(true);
    }

    public void agregar(Boolean editable, Producto p) {

        try {
            if (!editable) {

                Logic.Service.getInstance().addProduct(p);
                model.setLista(Logic.Service.getInstance().getProductos());
            } else {
                //Falta esta parte... ahorita la hacemos...
            }
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage());
        }
    }

    public void hide() {
        vista.setVisible(false);
    }

    void selectedItem(String aux){
        Producto p;
        try {
            p = Logic.Service.getInstance().getSelectedProduct(aux);
            model.setProduct(p);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    void delete() {
        Producto p = model.getProduct();
        try {
            Logic.Service.getInstance().deleteProduct(p);
            model.setLista(Logic.Service.getInstance().getProductos());

        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc.getMessage());
        }

    }
}
