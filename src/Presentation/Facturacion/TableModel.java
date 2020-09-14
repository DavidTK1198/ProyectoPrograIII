/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Facturacion;

import Logic.LineaDetalle;
import Logic.Producto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DavidTK1198
 */
public class TableModel extends AbstractTableModel {

    private List<LineaDetalle> filas;
    private int[] columnas;
    private String[] nombCol = {"Codigo", "Nombre", "Cantidad", };//Arreglar

    public TableModel(List<LineaDetalle> filas, int[] columnas) {
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
    public String getColumnName(int column) {
        return nombCol[column];
    }

    public LineaDetalle getRowAt(int n) {
        return filas.get(n);
    }
    
      @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LineaDetalle li = filas.get(rowIndex);
        Producto p=li.getCurret1();
        switch (columnIndex){
            case 0: return p.getCodigo();
            case 1: return p.getNombre();
            case 2: return li.getCantidadProd();
            default: return null;
        }
    }

}
