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
      public void show(){
        vista.setVisible(true);
    }  

    public void agregar(Boolean editable,Producto p) {
        
        try{
            if(!editable){
               
               Logic.Empresa.getInstance().addProduct(p);
               model.setLista(Logic.Empresa.getInstance().getProductos());
            }else{
                
            }
        }catch(Exception exc){
            JOptionPane.showMessageDialog(null, exc.getMessage());
        }
    }
}
