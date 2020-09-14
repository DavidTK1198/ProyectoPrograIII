/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentation.Facturacion;

import Logic.Cliente;
import Logic.Factura;
import Logic.LineaDetalle;
import Logic.Producto;
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
    private Cliente cl;
    private Producto pd;
    private final int[] col = {0,1,2};/////////////////////Arreglar y ajustar con los parametros adecuados
      private final int[] productos = {0, 1, 2, 3};
    private final int[] clientes = {0, 1, 2, 3};
    private LineaDetalle li;
    private List<LineaDetalle> lista;
    private boolean editable;
    private Factura nueva;
    private Presentation.Cliente.TableModelClient tableCliente;
    private Presentation.Producto.TableModel tableProducto;
    private Boolean flag;
    
    @Override
    public void addObserver(Observer a){
       
        super.addObserver(a);
        refresh();
    }

    public Model() {
        pd=new Producto();
        cl=new Cliente();
        lista = new ArrayList<>();
        table = new TableModel(lista,col);
        editable = false;
        flag=false;
         nueva=new Factura();
       tableCliente = new Presentation.Cliente.TableModelClient(Logic.Service.getInstance().getClientes(), clientes);//vamos a
       tableProducto = new Presentation.Producto.TableModel(Logic.Service.getInstance().getProductos(), productos);//mostrar todos los cientes
                                                                                                                   // y productos
    }

    public Presentation.Cliente.TableModelClient getTableCliente() {
        return tableCliente;
    }

    public LineaDetalle getLi() {
        return li;
    }

    public void setLi(LineaDetalle li) {
        this.li = li;
    }

    public void setTableCliente(Presentation.Cliente.TableModelClient tableCliente) {
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

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    private void refresh(){
        cl=new Cliente();
        pd=new Producto();
        li=new LineaDetalle();
        this.setChanged();
        this.notifyObservers();   
    }
    
    public void facturaUpdate(){
        this.nueva=new Factura();
    }

    private void commit(){
       li=new LineaDetalle();
       this.setChanged();
        this.notifyObservers();    
    }
    public Factura getNueva() {
        return nueva;
    }

    public void setNueva(Factura nueva) {
        this.nueva = nueva;
    }

    public Cliente getCl() {
        return cl;
    }

    public void setCl(Cliente cl) {
        this.cl = cl;
    }

    public Producto getPd() {
        return pd;
    }

    public void setPd(Producto pd) {
        this.pd = pd;
    }

    public TableModel getTable() {
        return table;
    }

    public void setTable(List<LineaDetalle> tablee) {
        table = new TableModel(tablee,col);
        
    }
    
    public List<LineaDetalle> getLista() {
        return lista;
    }

    public void setLista(List<LineaDetalle> a) {
        this.lista = a;
        setTable(a);
        if(flag==false){
            commit();
        }else{
            refresh();
            this.setFlag(false);
        }
        
    }

    public LineaDetalle getRow(int n) {
       return  table.getRowAt(n);
    }
    
}
