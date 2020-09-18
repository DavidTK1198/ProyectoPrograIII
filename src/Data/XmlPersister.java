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
import org.w3c.dom.Document;
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
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        FileInputStream is = new FileInputStream(path);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Data result = (Data) unmarshaller.unmarshal(is);
        is.close();
//        this.read();
        return result;
    }

    private void read() throws Exception {

        String aux = "";
        // Creo una instancia de DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Creo un documentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Obtengo el documento, a partir del XML
        Document documento = builder.parse(new File("Facturas.xml"));

        // agarro la etiquete emp del documento
        NodeList miEmpresa = documento.getElementsByTagName("Emp");

        // Recorro las etiquetas
        for (int i = 0; i < miEmpresa.getLength(); i++) {
            // Cojo el nodo actual
            Node nodo = miEmpresa.item(i);
            // Compruebo si el nodo es un elemento
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                // Lo transformo a Element
                Element e = (Element) nodo;
                // Obtengo sus hijos
                NodeList hijos = e.getChildNodes();
                // Recorro sus hijos
                for (int j = 0; j < hijos.getLength(); j++) {
                    // Obtengo al hijo actual
                    Node hijo = hijos.item(j);
                    // Compruebo si es un nodo
                    if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                        
                        // evaluo el contenido
                        aux = hijo.getNodeName();
                        if ("nombreEm".equals(aux)) {
                            aux = hijo.getTextContent();
                            Logic.Empresa.getInstance().setNombre(aux);
                        }

                        if ("telefono".equals(aux)) {
                            aux = hijo.getTextContent();
                            Logic.Empresa.getInstance().setTelefono(aux);
                        }

                        if ("correo".equals(aux)) {
                            aux = hijo.getTextContent();
                            Logic.Empresa.getInstance().setCorreo(aux);
                        }

                        if ("actividad".equals(aux)) {
                            aux = hijo.getTextContent();
                            Logic.Empresa.getInstance().setActividad(aux);
                        }

                        if ("CedulaJuridica".equals(aux)) {
                            aux = hijo.getTextContent();
                            Logic.Empresa.getInstance().setCedulaJuridica(aux);
                        }
                        if ("direccion".equals(aux)) {
                            aux = hijo.getTextContent();
                            Logic.Empresa.getInstance().setDireccion(aux);
                        }

                    }

                }

            }

        }

    }

}
