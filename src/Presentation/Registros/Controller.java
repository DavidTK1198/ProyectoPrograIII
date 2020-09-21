/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Registros;

import Logic.Factura;

/**
 * 
 * @author boyro
 * 
 */

public class Controller {
    
    private Presentation.Registros.View vista;
    private Presentation.Registros.Model model;

    public Controller(Presentation.Registros.View vista, Presentation.Registros.Model model) {
        this.vista = vista;
        this.model = model;
        vista.setControl(this);
        vista.setModel(model);
        model.setLista(Logic.Service.getInstance().misFacturas());
    }
    public void setFactura(int n) {
       Factura fac=model.getTable().getRowAt(n);
       model.setFactura(fac);
    }
    public void show() {
       model.setLista(Logic.Service.getInstance().misFacturas());
        vista.setVisible(true);
         
        
    }


    public void hide() {
        vista.setVisible(false);
    }
}


