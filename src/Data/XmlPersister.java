/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author DavidTK1198
 */
public class XmlPersister {

    private String path;
    private static XmlPersister my_instance = null; //Singleton

    public XmlPersister() {
    }

    public void setPath(String p) {
        this.path = p;
    }

    public static XmlPersister getInstance() {
        if (my_instance == null) {
            my_instance = new XmlPersister();
        }
        return my_instance;
    }

    public void store(Data my_data) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        FileOutputStream os = new FileOutputStream(path);
        Marshaller nuevo = jaxbContext.createMarshaller();
        nuevo.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        nuevo.marshal(my_data, os);
        os.flush();
        os.close();

    }

    public Data restore() throws Exception {
        //this.read();
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        FileInputStream is = new FileInputStream(path);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Data result = (Data) unmarshaller.unmarshal(is);
        is.close();
        return result;
    }

    private void read() throws Exception {

        String nombre = "";
        String correo = "";
        String tel = "";
        String ced = "";
        String des = "";
        String direcc = "";

        Logic.Empresa.getInstance().setNombre(nombre);
        Logic.Empresa.getInstance().setActividad(des);
        Logic.Empresa.getInstance().setCedulaJuridica(ced);
        Logic.Empresa.getInstance().setCorreo(correo);
        Logic.Empresa.getInstance().setTelefono(tel);
        Logic.Empresa.getInstance().setDireccion(direcc);

    }

}
