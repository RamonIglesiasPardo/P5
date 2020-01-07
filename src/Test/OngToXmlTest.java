package Test;

import ong.entreculturas.*;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;
import java.io.FileNotFoundException;

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
            perVoluntario1 = new PerVoluntario("Ramon", "Iglesias", "Pardo", direccion, "619201743", "asd@asd.com", "1", 105);
            perVoluntario2 = new PerVoluntario("Manolo", "Fernandez", "Cuesta", direccion, "871125554", "mailasd@hotmail.com", "1", 22);
            perVoluntario3 = new PerVoluntario("Antonio", "Carmona", "Ruiz", direccion, "671458444", "gmail@gmail.com", "1", 1141);
            PerVolInternacional perVoluntario4 = new PerVolInternacional("Michael", "Knight", "Hasselhoff", direccion, "+011 1251215", "gmail@gmail.com", "1", 10, 1200, "USA", "Baltimore, Maryland, Estados Unidos", "+001");


            //Creamos un listado de personal y añadimos el voluntario al listado.
            List<Personal> lequipo = new ArrayList<Personal>();
            lequipo.add(perVoluntario1);
            lequipo.add(perVoluntario2);
            lequipo.add(perVoluntario3);
            lequipo.add(perVoluntario4);

            //Creamos una línea de acción, proyecto, un listado de proyectos y añadimos uno al otro.
            Date fechaInicio = new Date(23/02/2015);
            Date fechaFin = new Date(01/01/2025);
            LineaDeAccion lineaDeAccion = new LineaDeAccion();
            List<Personal> lpersonalAsignado = new ArrayList<Personal>();
            Proyecto proyecto1 = new Proyecto(1001, "CONVENIO DE EDUCACIÓN TRANSFORMADORA (AECID) ", "El Salvador, República Dominicana, Haití, Perú, Colombia y Bolivia", "Varias", lineaDeAccion, fechaInicio, fechaFin, "Para cambiar una sociedad que ha naturalizado la violencia y la desigualdad de sexos es clave el papel de la educación. Por ello, el trabajo conjunto de Entreculturas, Alboan y las Fe y Alegría de Nicaragua, El Salvador, República Dominicana, Haití, Perú, Colombia y Bolivia, gracias a la financiación de la AECID, ha permitido que, a lo largo de 2017, 12.186 estudiantes (con una participación femenina mayoritaria) hayan organizado y participado en acciones que promueven la cultura de paz y la igualdad de género en sus escuelas y comunidades. Todo ello les ha permitido conocer y analizar las problemáticas que les rodean y convertirse en agentes de cambio en sus entornos más cercanos.", lpersonalAsignado);
            Proyecto proyecto2 = new Proyecto(1002, "FONDO “LA LUZ DE LAS NIÑAS”", "Nicaragua, Haití, Chad, Sudán del Sur y República Centroafricana", "Varias", lineaDeAccion, fechaInicio, fechaFin, "El Fondo “La LUZ de las NIÑAS” es una iniciativa que pusimos en marcha en 2012 para apoyar proyectos orientados específicamente a la mejora de las condiciones de vida y el desarrollo de niñas y jóvenes que viven situaciones de extrema vulnerabilidad. Con este fondo queremos, además, visibilizar y denunciar las prácticas dañinas que soportan las niñas, las jóvenes y las mujeres en todo el mundo: mutilación genital, violencia sexual, matrimonios precoces, prostitución infantil y cualquier tipo de vulneración de derechos. Estas prácticas atentan contra su integridad física y psíquica causándoles, a veces, la muerte. Cada año se han sumado nuevos proyectos en nuevos países. Durante el año 2017 continuamos el trabajo en Nicaragua, Haití, Chad, Sudán del Sur y República Centroafricana y comenzamos en Camerún, R.D. Congo, Guatemala, El Salvador, Perú, Honduras y Bolivia.", lpersonalAsignado);
            Proyecto proyecto3 = new Proyecto(1003, "PROGRAMA DE EDUCACIÓN DIGITAL (PROFUTURO)", "Guatemala y Colombia", "Varias", lineaDeAccion, fechaInicio, fechaFin, "En marzo de 2017 tuvo lugar la firma de un convenio de colaboración entre la Fundación Profuturo y Entreculturas para el desarrollo de dos proyectos piloto de educación digital en Guatemala y Colombia, encaminados a proveer acceso a una educación universal y de calidad a niños y jóvenes de entornos vulnerables. Este programa se enfoca en la adquisición de competencias a través de la tecnología y el empoderamiento de los docentes mediante la aplicación de metodologías innovadoras de enseñanza. En Guatemala el proyecto está beneficiando a 3.624 alumnos y 174 docentes mientras que en Colombia está beneficiando a 4.832 alumnos y 138 docentes.", lpersonalAsignado);
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
            marshaller.marshal(ong, new File("src/Test/XML/ong.xml"));
            marshaller.marshal(ong, System.out);
    }


}
