/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logic;

import Data.Data;
import java.util.List;

/**
 * 
 * @author DavidTK1198
 */
public class Service {
private final Data data;
  private static Service my_instance = null; //Singleton

    public Service() {
        data=new Data();
    }
    
     public static Service getInstance() {
        if (my_instance == null) {
            my_instance = new Service();
        }

        return my_instance;
    }

 public List<Cliente> getClientes(){
        return this.data.getClientes(); 
    }
    
     public List<Producto> getProductos(){
        return this.data.getProductos();
    }
    public void addProduct(Producto p) throws Exception{
        this.data.addProduct(p);
    }
    
    public void addClient(Cliente c) throws Exception{
        this.data.addClient(c);
    }
    
    public Producto getProducto(String id) throws Exception{
        return this.data.getProducto(id);
    }
    public void deleteProduct(Producto p){
           this.data.removeElement(p);
    }
    
     
}
