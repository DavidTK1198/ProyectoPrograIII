/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Empresa;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.TableModel;



/**
 *
 * @author boyro
 */

public class Model extends Observable {
    
    private TableModel table;
    private int telefono;
    private int[] col = {0,1,2};
    private boolean editable;
    @Override
    
    public void addObserver(Observer a){
       
        super.addObserver(a);
        refresh();
    }

    public Model() {
        table = new TableModelEmpresa(col);
        editable = false;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    private void refresh(){
        this.setChanged();
        this.notifyObservers();
    }

    public TableModel getTable() {
        return table;
    }

    public void setTable() {
        this.table = new TableModelEmpresa(col);
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }


    public void setInformacion() {
        setTable();
        refresh();
    }
    
}
