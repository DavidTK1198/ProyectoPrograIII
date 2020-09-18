/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Producto;

import Logic.Producto;
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
    private Producto Product;
    private int[] col = {0,1,2,3};
    private List<Producto> lista;
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
        Product = new Producto();
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
         Product = new Producto();
        this.setChanged();
        this.notifyObservers();
        
    }

    public TableModel getTable() {
        return table;
    }

    public void setTable(List<Producto> tablee) {
        table = new TableModel(tablee,col);
    }

    public Producto getProduct() {
        return Product;
    }

    public void setProduct(Producto Product) {
        this.Product = Product;
    }

    public List<Producto> getLista() {
        return lista;
    }

    public void setLista(List<Producto> a) {
        this.lista = a;
        setTable(a);
        refresh();
    }

    public Producto getRow(int n) {
       return  table.getRowAt(n);
    }
    
}
