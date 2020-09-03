/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Objects;



/**
 *
 * @author Daniel Madrigal
 */
public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precioUnitario;

    public Producto(String codigo , String descripcion, double precioUnitario,String nombre) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
    }

    public Producto() {
       this.codigo = "";
       this.descripcion = "";
       this.precioUnitario = 0;
       this.nombre = "";
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + '}';
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    
}




