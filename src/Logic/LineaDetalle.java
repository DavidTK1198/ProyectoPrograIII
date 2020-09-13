/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

/**
 *
 * @author Daniel Madrigal
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class LineaDetalle {
    @XmlIDREF
    private Producto produc;
    @XmlID
    private int cantidadProd;

    public LineaDetalle(Producto produc, int cantidadProd) {
        this.produc = produc;
        this.cantidadProd = cantidadProd;
    }

    public LineaDetalle() {
       this.produc = null;
       this.cantidadProd = 0;
    }

    public Producto getCurret1() {
        return produc;
    }

    public void setCurret1(Producto produc) {
        this.produc = produc;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }
    
    
    
}









