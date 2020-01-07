package Test;

import ong.entreculturas.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class OngToXmlTest {

    private ONG ong;

    @Test
    public void testObjectToXml() throws JAXBException, FileNotFoundException {

            Direccion direccion;
            direccion = new Direccion(TipoVia.AVDA, "Mare de Deu", "100", "ENT","1", "A", "08041", Provincia.BAR, "Barcelones");
            PerVoluntario perVoluntario;
            perVoluntario = new PerVoluntario("Ramon", "Iglesias", "Pardo", direccion, "619201743", "asd@asd.com", "1", 1, 1, 1);
            List<Personal> lequipo = new ArrayList<Personal>();
            lequipo.add(perVoluntario);
            ONG ong = new ONG("Nombre de la ONG", "XXXXXXXX-X", lequipo);

            JAXBContext jaxbContext = JAXBContext.newInstance(ONG.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(ong, new File("XML/ong.xml"));
            marshaller.marshal(ong, System.out);
    }


}
