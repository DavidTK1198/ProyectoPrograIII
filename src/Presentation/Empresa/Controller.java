/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Empresa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author boyro
 */
public class Controller {

    private Presentation.Empresa.View vista;
    private Presentation.Empresa.Model model;

    public Controller(View vista, Model model) {
        this.vista = vista;
        this.model = model;
        vista.setControl(this);
        vista.setModel(model);
    }

    public void Mostrar() {
        vista.setVisible(true);
    }

    public void hide() {
        vista.setVisible(false);
    }

    public void editEmpresa(boolean editable, String nom,String cedJur,String direc,String activ, String tel,String correoE) {//a ver como manejamos la lista de telefonos

        if (!editable) {
            System.out.print(Logic.Empresa.getInstance().getNombre());
            Logic.Empresa.getInstance().setNombre(nom);
            Logic.Empresa.getInstance().setCorreo(correoE);
            Logic.Empresa.getInstance().setCedulaJuridica(cedJur);
            Logic.Empresa.getInstance().setDireccion(direc);
            Logic.Empresa.getInstance().setActividad(activ);
            Logic.Empresa.getInstance().setTelefono(tel);
            model.setInformacion(); 
        }
    }
}
