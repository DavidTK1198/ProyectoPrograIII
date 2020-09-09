/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Empresa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author boyro
 */

public class TableModelEmpresa extends AbstractTableModel{
    private List<Integer> filas;
    private final int[] columnas;
    private final String[] nombCol = {"Numero(s) telefonico(s)"};
   

    public TableModelEmpresa(List<Integer> filas, int[] columnas) {
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
        int telefono = filas.get(rowIndex);
        switch (columnIndex){
            case 0: return telefono;
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return nombCol[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
}


