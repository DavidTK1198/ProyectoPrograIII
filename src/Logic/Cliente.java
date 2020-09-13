/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

/**
 *
 * @author DavidTK1198
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente {//Persona

    @XmlID
    private String cedula;
    private String nombre;
    private String apellidos;
    private String CorreoE;
    @XmlIDREF
    private List<Factura> listaFacturas;

    public Cliente() {
        this.nombre = "";
        this.apellidos = "";
        this.cedula = "";
        this.CorreoE = "";
        this.listaFacturas = new ArrayList<>();
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public String getNombre() {
        return nombre;
    }
    public void agregarFacturas(Factura f){
        this.listaFacturas.add(f);
    }
    public Cliente(String nombre, String apellidos, String cedula, String CorreoE) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.CorreoE = CorreoE;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreoE() {
        return CorreoE;
    }

    public void setCorreoE(String CorreoE) {
        this.CorreoE = CorreoE;
    }

     @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }



  
}
