/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Producto;
import Logic.Producto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daniel Madrigal
 */
public class TableModel extends AbstractTableModel{
    private List<Producto> filas;
    private int[] columnas;
    private String[] nombCol;
   

    public TableModel(List<Producto> filas, int[] columnas) {
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
        Producto prod = filas.get(rowIndex);
        int contador = 0;
        switch (columnIndex){
            case 0: return contador++;
            case 1: return prod.getCodigo();
            case 2: return prod.getNombre();
            case 3: return prod.getDescripcion();
            case 4: return prod.getPrecioUnitario();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }
    
}
