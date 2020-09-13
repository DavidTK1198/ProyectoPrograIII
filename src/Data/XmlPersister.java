/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
         JAXBContext jaxbContext=null;
        try{
       jaxbContext = JAXBContext.newInstance(Data.class);
        }catch(Exception e){
            System.out.println("Data.XmlPersister.store()");
  System.out.println(e.getClass());
    System.out.println(e.getCause());
        }
        FileOutputStream os = new FileOutputStream(path);
        Marshaller nuevo = jaxbContext.createMarshaller();
        nuevo.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        nuevo.marshal(my_data, os);
        os.flush();
        os.close();

    }

    public Data restore() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        FileInputStream is = new FileInputStream(path);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Data result = (Data) unmarshaller.unmarshal(is);
        is.close();
        return result;
    }
}
