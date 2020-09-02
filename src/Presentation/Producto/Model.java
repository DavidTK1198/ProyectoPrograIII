/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Producto;

import Logic.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private Map<String,Producto> productos;
    @Override
    
    public void addObserver(Observer a){
       
        super.addObserver(a);
        refresh();
    }

    public Model() {
        Product = new Producto();
        lista = new ArrayList<>();
        table = new TableModel(lista,col);
        editable = false;
        productos=new HashMap<>();
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
    
    public void addProduct(Producto p) throws Exception {
        Product = productos.get(p.getCodigo());
        if (Product == null) {
            productos.put(p.getCodigo(), p);
        } else {
            throw new Exception("El producto ya existe");
        }
    }

    public List<Producto> updateTable() {
        List<Producto>ls = new ArrayList<>();
        for (Map.Entry<String, Producto> entry : productos.entrySet()) {
            Producto ayudante = entry.getValue();
            ls.add(ayudante);
        }
        return ls;
    }
}
