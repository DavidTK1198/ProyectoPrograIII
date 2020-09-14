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
    private List<String> filas;
    private final int[] columnas;
    private final String[] nombCol = {"Nombre Empresa","Ced. Juridica","Correo Electronico"};

    public TableModelEmpresa(int[] columnas) {
        this.columnas = columnas;
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch (columnIndex){
            case 0: return Logic.Empresa.getInstance().getNombre();
            case 1: return Logic.Empresa.getInstance().getCedulaJuridica();
            case 2: return Logic.Empresa.getInstance().getCorreo();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return nombCol[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
}



