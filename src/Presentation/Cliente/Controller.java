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
    
    private Presentation.Cliente.View vista;
    private Presentation.Cliente.Model model;

    public Controller(View vista, Model model) {
        this.vista = vista;
        this.model = model;
        vista.setControl(this);
        vista.setModel(model);
    }
    public void Mostrar(){
        vista.setVisible(true);
    }

    public void agregar(boolean editable, Cliente c) {
//        Cliente clien = new Cliente(nombre,apelli,iden,correo);
        
        try{
            if(!editable){
                Logic.Service.getInstance().addClient(c);
                model.setLista(Logic.Service.getInstance().getClientes());
            }else{
                
            }
        }catch(Exception exc){
            JOptionPane.showMessageDialog(null, exc.getMessage());
        }
    }

}
