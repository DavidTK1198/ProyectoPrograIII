/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Facturacion;

import Logic.LineaDetalle;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author DavidTK1198
 */
public class TableModel extends AbstractTableModel {

    private List<LineaDetalle> filas;
    private int[] columnas;
    private String[] nombCol = {"Codigo", "Nombre", "Descripcion", "Precio Unitario"};//Arreglar

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
    public Object getValueAt(int rowIndex, int columnIndex) {
        LineaDetalle li = filas.get(rowIndex);

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return nombCol[column];
    }

    public LineaDetalle getRowAt(int n) {
        return filas.get(n);
    }

}
