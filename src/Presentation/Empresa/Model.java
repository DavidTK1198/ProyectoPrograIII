/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Empresa;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author boyro
 */
public class Model extends Observable {

    private boolean editable;
    private boolean bandera;
    @Override

    public void addObserver(Observer a) {

        super.addObserver(a);
        refresh();
    }

    public Model() {
        editable = false;
        bandera = false;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    private void refresh() {
        this.setChanged();
        this.notifyObservers();
    }

}
