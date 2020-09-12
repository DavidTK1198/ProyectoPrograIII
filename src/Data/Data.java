/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Cliente;
import Logic.Empresa;
import Logic.Factura;
import Logic.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Data {

    private Map<String, Producto> productos;
    private Map<String, Cliente> clientes;
    private Map<String,Factura> facturas;
    Empresa Emp=Logic.Empresa.getInstance();

    public Data() {
        clientes = new HashMap<>();
        productos = new HashMap<>();
    }

    public List<Cliente> getClientes() {
        List<Cliente> ls = new ArrayList<>();
        for (Map.Entry<String, Cliente> entry : clientes.entrySet()) {
            Cliente ayudante = entry.getValue();
            ls.add(ayudante);
        }
        return ls;
    }

    public void addProduct(Producto p) throws Exception {
        Producto Product = productos.get(p.getCodigo());
        if (Product == null) {
            productos.put(p.getCodigo(), p);
        } else {
            throw new Exception("El producto ya existe");
        }
    }
    
    public void addClient(Cliente p) throws Exception {
        Cliente cl = clientes.get(p.getCedula());
        if (cl == null) {
            clientes.put(p.getCedula(), p);
        } else {
            throw new Exception("El producto ya existe");
        }
    }

       public List<Factura> getFacturas() {
        List<Factura> ls = new ArrayList<>();
        for (Map.Entry<String, Factura> entry : facturas.entrySet()) {
            Factura ayudante = entry.getValue();
            ls.add(ayudante);
        }
        return ls;
    }
       
    public List<Producto> getProductos() {
        List<Producto> ls = new ArrayList<>();
        for (Map.Entry<String, Producto> entry : productos.entrySet()) {
            Producto ayudante = entry.getValue();
            ls.add(ayudante);
        }
        return ls;
    }
    
    public void removeElement(Producto p){//revisar
        
       productos.remove(p.getCodigo());
    }
    
   public Producto getProducto(String p) throws Exception{
        Producto prod=productos.get(p);
        if(prod==null){
            throw new Exception("No se encontro al elemento");
        }
        return prod;
    }

}


























