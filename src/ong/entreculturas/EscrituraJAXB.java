//he creado esta clase main para probar la generación de archivos XML
//he probado con la clase voluntario Internacional y funciona
/*

package ong.entreculturas;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
 */
/*
public class EscrituraJAXB {

    public static void main(String[] args) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Personal.class);

        Marshaller marshaller = context.createMarshaller();

        PerVolInternacional perVolInternacional = new PerVolInternacional();
        perVolInternacional.setNombre("Mariam");
        perVolInternacional.setPrimerApellido("Domingo");
        perVolInternacional.setSegundoApellido("Morillas");

    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    //marshaller.marshal(perVolInternacional,System.out);
        marshaller.marshal(perVolInternacional, new FileWriter("primeraprueba.xml"));

    }
}


