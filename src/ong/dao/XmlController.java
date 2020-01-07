/**
 *
 *
 *
 *
 *
 *  TODO Eliminarla. aunque primero debemos acabar con el DAO Factory y JABX.
 *
 *
 *
 *
 *

 * */



package ong.dao;

import ong.entreculturas.ONG;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Pruebas utilizando patrón DAO y presistencia en XML
 * */
public class XmlController {

    public ONG getXMLONG() {

        try {

            File fXmlFile = new File("XML/foo.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //Opcional pero recomenedado
            //Leer esto: http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

//            System.out.println("Nombre root del XML:" + doc.getDocumentElement().getNodeName());
//            System.out.println("----------------------------");
            String name = doc.getDocumentElement().getElementsByTagName("nombre").item(0).getFirstChild().getNodeValue();
            String cif = doc.getDocumentElement().getElementsByTagName("CIF").item(0).getFirstChild().getNodeValue();
//            System.out.println("Nombre : " + name);
//            System.out.println("CIF: " + cif);

            /*Devolvemos la instancia de ONG con los datos contenidos en el XML*/
            return new ONG(name, cif);


//            for (int temp = 0; temp < nList.getLength(); temp++) {
//
//                Node nNode = nList.item(temp);
//
//                System.out.println("\nCurrent Element :" + nNode.getNodeName());
//
//                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//
//                    Element eElement = (Element) nNode;
//
//                    System.out.println("Staff id : " + eElement.getAttribute("id"));
//                    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
//                    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
//                    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
//                    System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
//
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
