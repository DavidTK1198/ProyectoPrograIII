/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Registros;

import Logic.Factura;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author boyro
 */
public class TableModel extends AbstractTableModel{
    private List<Factura> filas;
    private int[] columnas;
    private String[] nombCol={"Fecha","# Factura","Cliente","SubTotal","+IVA"};
   

    public TableModel(List<Factura> filas, int[] columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Factura factura = filas.get(rowIndex);
        switch (columnIndex){
            case 0: return factura.getFecha();
            case 1: return factura.getNumeroFactura();
            case 2: return factura.getCurret().getNombre();
            case 3: return factura.subTotal();
            case 4: return factura.totalImpuesto();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return nombCol[column];
    }

    public Factura getRowAt(int n) {
        return filas.get(n);
    }
}

