/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author DavidTK1198
 */
public class Cliente {//Persona

    private String nombre;
    private String apellidos;
    private String cedula;
    private String CorreoE;

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
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
    

}
