/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author DavidTK1198
 */
public class XmlMaker {

    public void makeXml(Factura nueva) throws Exception {

        Cliente cl = nueva.getCurret();
        List<LineaDetalle> lineas = nueva.getLineas();
        Producto p;
        LineaDetalle miLinea;
        // Creo una instancia de DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Creo un documentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Creo un DOMImplementation
        DOMImplementation implementation = builder.getDOMImplementation();

        // Creo un documento con un elemento raiz
        Document documento = implementation.createDocument(null, "FacturaElectronica", null);
        documento.setXmlVersion("1.0");

        // Creo los elementos
        Element emisor = documento.createElement("Emisor");

        //Nombre Empresa
        Element nombreEmpresa = documento.createElement("Nombre");
        Text textnombreE = documento.createTextNode(Logic.Empresa.getInstance().getCorreo());
        nombreEmpresa.appendChild(textnombreE);
        emisor.appendChild(nombreEmpresa);

        // Direccion
        Element direccion = documento.createElement("Direccion");
        Text textdirec = documento.createTextNode(Logic.Empresa.getInstance().getDireccion());
        direccion.appendChild(textdirec);
        emisor.appendChild(direccion);

        // Correo
        Element correo = documento.createElement("Correo");
        Text textcorr = documento.createTextNode(Logic.Empresa.getInstance().getCorreo());
        correo.appendChild(textcorr);
        emisor.appendChild(correo);

        // CedulaJuridica
        Element ced = documento.createElement("CedulaJuridica");
        Text jur = documento.createTextNode(Logic.Empresa.getInstance().getCedulaJuridica());
        ced.appendChild(jur);
        emisor.appendChild(ced);

        // Añado al root el elemento emisor(Cuando se termina de agregar los elementos)
        documento.getDocumentElement().appendChild(emisor);
        
        

        Element receptor = documento.createElement("Receptor");//se hace igual que emisor
        
        

        // Añado al root el elemento emisor(Cuando se termina de agregar los elementos)
        documento.getDocumentElement().appendChild(receptor);
        
        
        
        //aquí esta la carnita
        for (int i = 0; i < lineas.size(); i++) {
            Element linea = documento.createElement("LineaDetalle");
            miLinea = lineas.get(i);
            p = miLinea.getCurret1();//este es el producto, ahora hay que sacarle los datos

            documento.getDocumentElement().appendChild(linea);
        }

        // Asocio el source con el Document
        Source source = new DOMSource(documento);
        // Creo el Result, indicado que fichero se va a crear
        Result result = new StreamResult(new File("Factura.xml"));

        // Creo un transformer, se crea el fichero XML
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);

    }

}
