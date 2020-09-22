/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Cliente;

import Logic.Cliente;
import Logic.Service;
import java.util.ArrayList;
import java.util.List;
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
        model.setLista(Logic.Service.getInstance().getClientes());
    }
    public void Mostrar(){
        vista.setVisible(true);
    }
    
    public void hide(){
        vista.setVisible(false);
    }

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

    void buscarCliente(String ced) {
        
        try{
            Cliente client = Service.getInstance().getCliente(ced);
            List<Cliente> lc = new ArrayList<>();
            lc.add(client);
            model.setLista(lc);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        model.setClient(new Cliente());
        
    }

    public void mostrarTodosLosClientes() {
        List<Cliente> lc = Service.getInstance().getClientes();
        model.setLista(lc);
    }

    public void eliminar(int n) {
        
        Cliente client = this.model.getTable().getRowAT(n);
        Logic.Service.getInstance().deleteCliente(client);
        model.setLista(Logic.Service.getInstance().getClientes());
    }
    public void modificar(Cliente nuevo){
        Cliente c = model.getClient();
        String cedula = c.getCedula();
        Logic.Service.getInstance().reemplazarCliente(cedula,nuevo);
        model.setLista(Logic.Service.getInstance().getClientes());
     
    }

    
}
