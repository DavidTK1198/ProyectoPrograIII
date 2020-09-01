/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Cliente;

import Logic.Cliente;
import javax.swing.JOptionPane;

/**
 * 
 * @author DavidTK1198
 */
public class Controller {
    
    private View vista;
    private Model model;

    public Controller(View vista, Model model) {
        this.vista = vista;
        this.model = model;
        vista.setControl(this);
        vista.setModel(model);
    }

    public void agregar(boolean editable, String nombre, String apelli, String correo, String iden) {
        Cliente clien = new Cliente(nombre,apelli,iden,correo);
        
        try{
            if(!editable){
//                Data.Empresa.getInstance().addClient(x);
            }else{
                
            }
        }catch(Exception exc){
            JOptionPane.showMessageDialog(null, exc.getMessage());
        }
    }

}
