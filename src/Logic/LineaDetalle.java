/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Daniel Madrigal
 */
public class LineaDetalle {
    private Producto produc;
    private int cantidadProd;

    public LineaDetalle(Producto produc, int cantidadProd) {
        this.produc = produc;
        this.cantidadProd = cantidadProd;
    }

    LineaDetalle() {
       
    }

    public Producto getCurret() {
        return produc;
    }

    public void setCurret(Producto produc) {
        this.produc = produc;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }
    
    
    
}


