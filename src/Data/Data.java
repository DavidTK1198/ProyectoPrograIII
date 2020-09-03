/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.Cliente;
import Logic.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

public class Data {

    private Map<String, Producto> productos;
    private Map<String, Cliente> clientes;

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

    public List<Producto> getProductos() {
        List<Producto> ls = new ArrayList<>();
        for (Map.Entry<String, Producto> entry : productos.entrySet()) {
            Producto ayudante = entry.getValue();
            ls.add(ayudante);
        }
        return ls;
    }
}


