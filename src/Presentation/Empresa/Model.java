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
    private List<String> listaInfoEm;
    private boolean editable;
    @Override
    
    public void addObserver(Observer a){
       
        super.addObserver(a);
        refresh();
    }

    public Model() {
        //telefono = new Integer();
        listaInfoEm = new ArrayList<>();
        table = new TableModelEmpresa(listaInfoEm,col);
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

    public void setTable(List<String> tabl) {
        this.table = new TableModelEmpresa(tabl,col);
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public List<String> getLista() {
        return listaInfoEm;
    }

    public void setLista(List<String> a) {
        this.listaInfoEm = a;
        setTable(a);
        refresh();
    }
    
}
