/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;

/**
 *
 * @author DavidTK1198
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Empresa {

    private static Empresa single_instance = null; //Singleton
    @XmlID
    private String nombreEm;
    private String telefono;
    private String correo;
    private String CedulaJuridica;
    private String direccion;
     
    private Empresa() {
         this.nombreEm = "";
         this.telefono = "";
         this.direccion = "";
         this.correo = "";
         this.telefono = "";
    }
    private Empresa(String nombre,String actividad,String telefono,String direcion,String CedJuri,String correo) {
         this.nombreEm = nombre;
         this.telefono = telefono;
         this.direccion = direcion;
         this.CedulaJuridica = CedJuri;
         this.correo = correo;
    }

    public static Empresa getInstance() {
        if (single_instance == null) {
            single_instance = new Empresa();
        }

        return single_instance;
    }

    public String getNombre() {
        return nombreEm;
    }

    public void setNombre(String nombre) {
        this.nombreEm = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correoE) {
        this.correo = correo;
    }

    public String getCedulaJuridica() {
        return CedulaJuridica;
    }

    public void setCedulaJuridica(String CedulaJuridica) {
        this.CedulaJuridica = CedulaJuridica;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
   
    
}
