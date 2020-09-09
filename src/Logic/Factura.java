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


/**
 *
 * @author Daniel Madrigal
 */
public class Factura {

    List<LineaDetalle> misLineas;
    String numeroFactura;
    Cliente curret;
    String fecha;
    String tipoPago;

    public Factura() {
        misLineas = new ArrayList<>();
        Date date = new Date();
        fecha = new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

    public void addLine(Producto p, int n) {
        LineaDetalle nueva;
        nueva = new LineaDetalle(p, n);
        this.misLineas.add(nueva);

    }

    public List<LineaDetalle> getLineas() {
        return misLineas;
    }

}



