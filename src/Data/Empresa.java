/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Producto;

/**
 *
 * @author DavidTK1198
 */
public class Empresa {

    private static Empresa single_instance = null; //Singleton
    private String nombre;
    private String telefono;
    private String correoE;
    private String Cedula;
    private String direccion;

    private Empresa() {
    }

    public static Empresa getInstance() {
        if (single_instance == null) {
            single_instance = new Empresa();
        }

        return single_instance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
//    public void addProduct(Producto p) throws Exception{
//        Producto pro=productos.get(p.getCodigo());
//        
//        if(pro==null){
//            productos.put(p.getCodigo(), p);
//        }else{
//            throw new Exception("El Producto  ya  Existe");
//        }
//        
//    }
//    
//    public void addClient(Cliente c) throws Exception{
//        Cliente cliente=clientes.get(c.getCedula());
//        if(cliente==null){
//            clientes.put(c.getCedula(), c);
//        }else{
//            throw new Exception("El cliente ya  Existe");
//        }
//    } 
    
}
