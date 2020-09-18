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
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {

      private final  Map<String, Producto> productos;
      private final Map<String,Factura> facturas;
      private final Map<String, Cliente> clientes1;
      private Empresa Emp;

    public Data() {
        clientes1 = new HashMap<>();
        productos = new HashMap<>();
        facturas = new HashMap<>();
        Emp=Logic.Empresa.getInstance();
        
        
    }

    public List<Cliente> getClientes() {
        List<Cliente> ls = new ArrayList<>();
        for (Map.Entry<String, Cliente> entry : clientes1.entrySet()) {
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
        Cliente cl = clientes1.get(p.getCedula());
        if (cl == null) {
            clientes1.put(p.getCedula(), p);
        } else {
            throw new Exception("El producto ya existe");
        }
    }
    public void addFactura(Factura p) throws Exception{
        
          Factura fa = facturas.get(p.getNumeroFactura());
        if (fa == null) {
            facturas.put(p.getNumeroFactura(), p);
        } else {
            throw new Exception("La Factura ya existe");
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
    public void removeCliente(Cliente c){
        this.clientes1.remove(c.getCedula());
    }
    public void replaceCliente(String key,Cliente viejo,Cliente nuevo){
        this.clientes1.replace(key, viejo, nuevo);
    }
    public void replaceProducto(String key,Producto viejo,Producto nuevo){
        this.productos.replace(key, viejo, nuevo);
    }
    
   public Producto getProducto(String p) throws Exception{
        Producto prod=productos.get(p);
        if(prod==null){
            throw new Exception("No se encontro al elemento");
        }
        return prod;
    }
   public Cliente getCliente(String ced)throws Exception{
       Cliente client = this.clientes1.get(ced);
       if(client == null){
           throw new Exception("Cedula no encontrada");
       }
       return client;
   }

    public Empresa getEmp() {
        return Emp;
    }
  

}






















































