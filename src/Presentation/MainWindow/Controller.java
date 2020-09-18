/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.MainWindow;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

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
     Presentation.Empresa.Model empresa_model;
    Presentation.Empresa.View empresa_Vista;
    Presentation.Empresa.Controller empresa_control;
    Presentation.Facturacion.Controller factura;
    Presentation.Facturacion.Model model_factura;
    Presentation.Facturacion.View factura_View;
    Presentation.Registros.Controller registros;
    Presentation.Registros.Model registros_model;
    Presentation.Registros.View registros_View;

    public Controller(View vista, Model model) {
        this.vista = vista;
        this.model = model;
        vista.setControl(this);
        vista.setModel(model);
        initOptions();
       
    }

    public void initOptions() {
        producto_Moddel = new Presentation.Producto.Model();
        producto_View = new Presentation.Producto.View(this.vista, true);
        producto_Controller = new Presentation.Producto.Controller(producto_View, this.producto_Moddel);
        cliente_model = new Presentation.Cliente.Model();
        cliente_Vista = new Presentation.Cliente.View(this.vista, true);
        cliente_control = new Presentation.Cliente.Controller(cliente_Vista, cliente_model);
        empresa_model=new Presentation.Empresa.Model();
        empresa_Vista= new Presentation.Empresa.View(this.vista,true);
        empresa_control= new Presentation.Empresa.Controller(empresa_Vista,empresa_model);
        model_factura=new Presentation.Facturacion.Model();
        factura_View=new Presentation.Facturacion.View(vista, true);
        factura=new Presentation.Facturacion.Controller(factura_View, model_factura); 
        registros_model=new Presentation.Registros.Model();
        registros_View=new Presentation.Registros.View(vista, true);
        registros=new Presentation.Registros.Controller(registros_View, registros_model);
         if(empresa_model.isBandera() == false){
             empresa_control.Mostrar();
        }

        
    }

    public void productoShow() {
        this.producto_Controller.show();
    }

    public void clienteShow() {
        this.cliente_control.Mostrar();
    }
    public void empresaShow(){
        this.empresa_control.Mostrar();
    }
    
    public void facturacion_Show(){
        this.factura.show();
    }

    public void registros_Show(){
        this.registros.show();
    }
}
