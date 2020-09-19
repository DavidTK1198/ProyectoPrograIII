/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Empresa;

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

    public void editEmpresa(boolean editable, String nom, String cedJur, String direc, String activ, String tel, String correoE) {//a ver como manejamos la lista de telefonos

        if (!editable) {
            Logic.Service.getInstance().my_Empresa().setNombre(nom);
            Logic.Service.getInstance().my_Empresa().setCorreo(correoE);
            Logic.Service.getInstance().my_Empresa().setCedulaJuridica(cedJur);
            Logic.Service.getInstance().my_Empresa().setDireccion(direc);
            Logic.Service.getInstance().my_Empresa().setActividad(activ);
            Logic.Service.getInstance().my_Empresa().setTelefono(tel);

        }
    }

    public boolean empresaValidData() {
        return Logic.Service.getInstance().my_Empresa().validateData();
    }
}
