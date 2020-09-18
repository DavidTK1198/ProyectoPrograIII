/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Registros;

import Logic.Factura;
import java.util.List;
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
     private final int[] col = {0,1,2,4,5};
    private Presentation.Registros.TableModel tableFacturas;
    private List<Factura> lista;
    public Model() {
    
    table = new TableModel(lista,col);
     
    
    
    }
  public Presentation.Registros.TableModel getTableFacturas() {
        return tableFacturas;
    }

    public void setTableProducto(Presentation.Registros.TableModel tableFacturas) {
        this.tableFacturas = tableFacturas;
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

