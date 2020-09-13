/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Cliente;

import Logic.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Daniel Madrigal
 */
public class TableModelClient extends AbstractTableModel{
    private List<Cliente> filas;
    private final int[] columnas;
    private final String[] nombCol = {"Cedula","Nombre","Apellidos","Correo Electronico"};
   

    public TableModelClient(List<Cliente> filas, int[] columnas) {
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
        Cliente client = filas.get(rowIndex);
        switch (columnIndex){
            case 0: return client.getCedula();
            case 1: return client.getNombre();
            case 2: return client.getApellidos();
            case 3: return client.getCorreoE();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return nombCol[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
}


