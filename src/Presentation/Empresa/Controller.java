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
        vista.setControl(this);
        vista.setModel(model);
    }

    public void Mostrar() {
        vista.setVisible(true);
    }

    public void hide() {
        vista.setVisible(false);
    }

    public void editEmpresa(boolean editable, String nombre, String correoE, String juridica, String direccion) {//a ver como manejamos la lista de telefonos

        if (!editable) {
            Logic.Empresa.getInstance().setNombre(nombre);
            Logic.Empresa.getInstance().setCorreo(correoE);
            Logic.Empresa.getInstance().setCedulaJuridica(juridica);
            Logic.Empresa.getInstance().setDireccion(direccion);
        }

    }
}
