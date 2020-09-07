/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Empresa;

import Presentation.Empresa.*;
import Logic.Empresa;
import javax.swing.JOptionPane;

/**
 *
 * @author boyro
 */

public class Controller {
    
    private Presentation.Empresa.View vista;
    

    public Controller(View vista, Model model) {
        this.vista = vista;
        vista.setControl(this);
        //vista.setModel(model);
    }
    public void Mostrar(){
        vista.setVisible(true);
    }
    
    public void hide(){
        vista.setVisible(false);
    }
/*
    public void agregar(boolean editable, Cliente c) {
        
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
*/
}
