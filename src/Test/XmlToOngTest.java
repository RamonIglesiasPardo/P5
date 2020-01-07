package Test;

import ong.entreculturas.*;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

public class XmlToOngTest {

    private ONG ong;

    @Test
    public void testObjectToXml() throws JAXBException, FileNotFoundException {

        File file = new File("src/Test/XML/ong.xml");
        JAXBContext JABXContext = JAXBContext.newInstance(ONG.class);
        Unmarshaller unmarshaller = JABXContext.createUnmarshaller();
        ong = (ONG) unmarshaller.unmarshal(file);
        System.out.println(ong);
        ong.lequipo.forEach(Personal -> System.out.printf(Personal.toString()+"\n"));
        ong.lproyectos.forEach(Proyecto -> System.out.printf(Proyecto.toString()+"\n"));
    }

}
