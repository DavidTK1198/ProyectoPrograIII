/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.MainWindow;

/**
 *
 * @author DavidTK1198
 */
public class Controller {

    private View vista;
    private Model model;
    Presentation.Producto.Model producto_Moddel;
    Presentation.Producto.View producto_View;
    Presentation.Producto.Controller producto_Controller;
    Presentation.Cliente.Model cliente_model;
    Presentation.Cliente.View cliente_Vista;
    Presentation.Cliente.Controller cliente_control;

    public Controller(View vista, Model model) {
        this.vista = vista;
        this.model = model;
        vista.setControl(this);
        vista.setModel(model);
        this.initOptions();
    }

    public void initOptions() {
        producto_Moddel = new Presentation.Producto.Model();
        producto_View = new Presentation.Producto.View(this.vista, true);
        producto_Controller = new Presentation.Producto.Controller(producto_View, this.producto_Moddel);
        cliente_model = new Presentation.Cliente.Model();
        cliente_Vista = new Presentation.Cliente.View(this.vista, true);
        cliente_control = new Presentation.Cliente.Controller(cliente_Vista, cliente_model);
    }

    public void productoShow() {
        this.producto_Controller.show();
    }

    public void clienteShow() {
        this.cliente_control.Mostrar();
    }

}
