/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Cliente;


import Logic.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;



/**
 * 
 * @author DavidTK1198
 */
public class Model extends Observable {
    
    private TableModel table;
    private Cliente client;
    private int[] col = {0,1,2,3};
    private List<Cliente> lista;
    private boolean editable;
    private boolean flag;
    @Override
    
    public void addObserver(Observer a){
       
        super.addObserver(a);
        refresh();
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Model() {
        client = new Cliente();
        lista = new ArrayList<>();
        table = new TableModel(lista,col);
        editable = false;
        flag = false;
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
        client = new Cliente();
    }

    public TableModel getTable() {
        return table;
    }
   
   
    public void setTable(List<Cliente> tablee) {
        table = new TableModel(tablee,col);
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public List<Cliente> getLista() {
        return lista;
    }

    public void setLista(List<Cliente> a) {
        this.lista = a;
        setTable(a);
        refresh();
    }
    
}
