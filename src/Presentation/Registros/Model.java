/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Registros;

import Logic.Factura;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author boyro
 * 
 */

public class Model  extends Observable {
    private TableModel table;
    private Factura factura;
    public Model() {
    
    
    
    
    
    }
  
    
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

