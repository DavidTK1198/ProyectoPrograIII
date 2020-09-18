/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.Data;
import Data.XmlPersister;
import java.util.List;

/**
 *
 * @author DavidTK1198
 */
public class Service {

    private Data data;
    private XmlMaker maker;
    private static Service my_instance = null; //Singleton
    private PDFMaker my_pdf;

    public Service() {

        this.data = new Data();
        maker = new XmlMaker();
        this.my_pdf=new PDFMaker();
    }

    public static Service getInstance() {
        if (my_instance == null) {
            my_instance = new Service();
        }

        return my_instance;
    }

    public List<Factura> misFacturas() {
        return this.data.getFacturas();
    }

    public List<Cliente> getClientes() {
        return this.data.getClientes();
    }

    public List<Producto> getProductos() {
        return this.data.getProductos();
    }

    public void addFactura(Factura p) throws Exception {
        this.data.addFactura(p);
    }

    public void addProduct(Producto p) throws Exception {
        this.data.addProduct(p);
    }

    public void addClient(Cliente c) throws Exception {
        this.data.addClient(c);
    }

    public Producto getProducto(String id) throws Exception {
        return this.data.getProducto(id);
    }

    public Cliente getCliente(String ced) throws Exception {
        return this.data.getCliente(ced);
    }

    public void deleteProduct(Producto p) {
        this.data.removeElement(p);
    }

    public void Save(String p) throws Exception {
        XmlPersister.getInstance().setPath(p);
        XmlPersister.getInstance().store(data);
    }

    public void load(String p) {
        XmlPersister.getInstance().setPath(p);
        try {
            this.data = XmlPersister.getInstance().restore();
        } catch (Exception e) {
            this.data = new Data();

        }

    }
    
    public void createPDF(Factura p) throws Exception{
        my_pdf.createPDF(p);
    }

    public void makeFacturaXML(Factura p) throws Exception {
        this.maker.makeXml(p);
    }
    
   public Empresa my_Empresa(){
       return this.data.getEmp();
   }

}
