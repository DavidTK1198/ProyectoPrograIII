/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;


/**
 *
 * @author Daniel Madrigal
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Factura {
  @XmlIDREF
    List<LineaDetalle> misLineas;
  
    @XmlID
    String numeroFactura;
    
    @XmlIDREF
    Cliente actual;
    String fecha;
    String tipoPago;
    

    public Factura() {
        misLineas = new ArrayList<>();
        Date date = new Date();
        fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
    }

    public void addLine(LineaDetalle nueva) {
       
        this.misLineas.add(nueva);
    }

    public List<LineaDetalle> getLineas() {
        return misLineas;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Cliente getCurret() {
        return actual;
    }

    public void setCurret(Cliente curret) {
        this.actual = curret;
        this.actual.agregarFacturas(this);
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
    public double calcularTotal(){
        double total = 0;
        Producto prod;
        for(int i=0; i<this.misLineas.size();i++){
            prod = this.misLineas.get(i).getCurret1();
            total+= (prod.getPrecioUnitario()+prod.getImpuestoVenta())*this.misLineas.get(i).getCantidadProd();
        }
        return total;
    }
    public double subTotal(){
        double total = 0;
        Producto prod;
        for(int i=0; i<this.misLineas.size();i++){
            prod = this.misLineas.get(i).getCurret1();
            total+= (prod.getPrecioUnitario())*this.misLineas.get(i).getCantidadProd();
        }
        return total;
    }
    public double totalImpuesto(){
        double total = 0;
        Producto prod;
            for(int i=0; i<this.misLineas.size();i++){
            prod = this.misLineas.get(i).getCurret1();
            total+= (prod.getImpuestoVenta()*this.misLineas.get(i).getCantidadProd());
        }
        return total;
    }
    //10----> 525---> 25----> (525 + 25)* 10
}













