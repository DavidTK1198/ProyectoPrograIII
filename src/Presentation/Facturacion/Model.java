/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Facturacion;

import Logic.LineaDetalle;
import Presentation.Cliente.TableModelClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 * @author DavidTK1198
 * //
 */
//Arreglar
public class Model extends Observable {

    private TableModel table;
    private LineaDetalle linea;
    private final int[] col = {0,1,2,3};/////////////////////Arreglar y ajustar con los parametros adecuados
      private final int[] productos = {0, 1, 2, 3};
    private final int[] clientes = {0, 1, 2, 3};
    private List<LineaDetalle> lista;
    private boolean editable;
    private Presentation.Cliente.TableModelClient tableCliente;
    private Presentation.Producto.TableModel tableProducto;
    
    @Override
    public void addObserver(Observer a){
       
        super.addObserver(a);
        refresh();
    }

    public Model() {
        linea=new LineaDetalle();
        lista = new ArrayList<>();
        table = new TableModel(lista,col);
        editable = false;
       tableCliente = new Presentation.Cliente.TableModelClient(Logic.Service.getInstance().getClientes(), clientes);//vamos a
       tableProducto = new Presentation.Producto.TableModel(Logic.Service.getInstance().getProductos(), productos);//mostrar todos los cientes
                                                                                                                   // y productos
    }

    public TableModelClient getTableCliente() {
        return tableCliente;
    }

    public void setTableCliente(TableModelClient tableCliente) {
        this.tableCliente = tableCliente;
    }

    public Presentation.Producto.TableModel getTableProducto() {
        return tableProducto;
    }

    public void setTableProducto(Presentation.Producto.TableModel tableProducto) {
        this.tableProducto = tableProducto;
    }

    
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    private void refresh(){
         linea = new LineaDetalle();
        this.setChanged();
        this.notifyObservers();
        
    }

    public TableModel getTable() {
        return table;
    }

    public void setTable(List<LineaDetalle> tablee) {
        table = new TableModel(tablee,col);
    }

    public LineaDetalle getCurrent() {
        return linea;
    }

    public void setProduct(LineaDetalle li) {
        this.linea = li;
    }

    public List<LineaDetalle> getLista() {
        return lista;
    }

    public void setLista(List<LineaDetalle> a) {
        this.lista = a;
        setTable(a);
        refresh();
    }

    public LineaDetalle getRow(int n) {
       return  table.getRowAt(n);
    }
    
}
