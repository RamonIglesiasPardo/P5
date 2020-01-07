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

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OngToXmlTest {

    private ONG ong;

    @Test
    public void testObjectToXml() throws JAXBException, FileNotFoundException {

            //Creamos una dirección para el nuevo volutanrio.
            Direccion direccion;
            direccion = new Direccion(TipoVia.AVDA, "Mare de Deu", "100", "ENT","1", "A", "08041", Provincia.BAR, "Barcelones");

            //Creamos un voluntario para añadirlo al listado de voluntarios.
            PerVoluntario perVoluntario1, perVoluntario2, perVoluntario3;
            perVoluntario1 = new PerVoluntario("Ramon", "Iglesias", "Pardo", direccion, "619201743", "asd@asd.com", "1", 1);
            perVoluntario2 = new PerVoluntario("Manolo", "Fernandez", "Cuesta", direccion, "871125554", "mailasd@hotmail.com", "1", 1);
            perVoluntario3 = new PerVoluntario("Antonio", "Carmona", "Ruiz", direccion, "671458444", "gmail@gmail.com", "1", 1);


            //Creamos un listado de personal y añadimos el voluntario al listado.
            List<Personal> lequipo = new ArrayList<Personal>();
            lequipo.add(perVoluntario1);
            lequipo.add(perVoluntario2);
            lequipo.add(perVoluntario3);

            //Creamos una línea de acción, proyecto, un listado de proyectos y añadimos uno al otro.
            Date fechaInicio = new Date(23/02/2015);
            Date fechaFin = new Date(01/01/2025);
            LineaDeAccion lineaDeAccion = new LineaDeAccion();
            List<Personal> lpersonalAsignado = new ArrayList<Personal>();
            Proyecto proyecto1 = new Proyecto(1001, "España", "Madrid", lineaDeAccion, fechaInicio, fechaFin, "Acciones a realizar en Madrid", lpersonalAsignado);
            Proyecto proyecto2 = new Proyecto(1002, "España", "Barcelona", lineaDeAccion, fechaInicio, fechaFin, "Acciones a realizar en Barcelona", lpersonalAsignado);
            Proyecto proyecto3 = new Proyecto(1003, "Haiti", "Haiti capital", lineaDeAccion, fechaInicio, fechaFin, "Acciones a realizar en Haiti", lpersonalAsignado);
            List<Proyecto> lproyecto = new ArrayList<Proyecto>();
            lproyecto.add(proyecto1);
            lproyecto.add(proyecto2);
            lproyecto.add(proyecto3);

            //Creamos el objeto ONG con sus atributos y listados.
            ONG ong = new ONG("Entreculturas", "G-82409020", lequipo, lproyecto);

            //Hacemos un marshaller para transformar la instancia ong en un archivo xml.
            JAXBContext jaxbContext = JAXBContext.newInstance(ONG.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(ong, new File("XML/ong.xml"));
            marshaller.marshal(ong, System.out);
    }


}
