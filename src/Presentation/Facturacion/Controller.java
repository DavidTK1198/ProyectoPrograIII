/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Facturacion;

import Logic.LineaDetalle;
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
    }


    public void hide() {
        vista.setVisible(false);
    }

   
}
