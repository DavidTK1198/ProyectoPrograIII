/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Cliente;


import Logic.Producto;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.TableModel;

/**
 * 
 * @author DavidTK1198
 */
public class Model extends Observable {
    
    private TableModel table;
    private Producto producto;
    private List<Producto> lista;
    @Override
    public void addObserver(Observer a){
       
        super.addObserver(a);
        refresh();
    }
    private void refresh(){
        this.setChanged();
        this.notifyObservers();
    }
}
