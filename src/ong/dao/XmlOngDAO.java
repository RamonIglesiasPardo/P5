package ong.dao;

import ong.entreculturas.*;

import javax.xml.bind.*;
import java.io.File;

/** En XmlOngDAO forma parte del patrón DAO.
 *  Permite separar la lógica para la persistencia de la lógica del negocio.
 *
 *  XmlOngDAO implementa la interfaz IOngDAO que declara los métodos que de deberán implementar
 *  todas las instancias DAO ONG, ya sean XmlOngDAO o MySQLDAO.
 *
 *  En el caso de XmlOngDAO se implementa toda la lógica necesaria para que ONG trabaje con XML,
 *  tan solo implementamos los métodos básicos CRUD (Create, Read, Update y Delete).
 *
 *  @author Aware Developers
 *  @version 1.0
 * */
public class XmlOngDAO implements IOngDAO {

       private ONG ong;

       public XmlOngDAO() {

              //Implementación de la lógica
              //Inicialización
       }

       @Override
       public void createOngDAO(ONG ong) {

              System.out.println("Por favor, no cierre la aplicación mientras guardamos los cambios...");

              try {

                     //Hacemos un marshaller para transformar la instancia ong en un archivo xml.
                     JAXBContext jaxbContext = JAXBContext.newInstance(ONG.class);
                     Marshaller marshaller = jaxbContext.createMarshaller();
                     marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                     marshaller.marshal(ong, new File("XML/ong.xml"));

                     System.out.println("¡Cambios guardados correctamente!");

              } catch (PropertyException e) {
                     e.printStackTrace();
              } catch (JAXBException e) {
                     e.printStackTrace();
              }

       }

       @Override
       public ONG readOngDAO() {

              try {

                     File file = new File("XML/ong.xml");
                     JAXBContext jaxbContext = JAXBContext.newInstance(ONG.class);
                     Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                     ong = (ONG) unmarshaller.unmarshal(file);

              } catch (JAXBException e) {
                     e.printStackTrace();
              }

              return ong;
       }

       @Override
       public boolean updateOngDAO(ONG pONG) {

              //Implementación de la lógica
              //Modifica la instancia de ONG.
              //Devuelve false si no se ha podido modificar los datos.

              return false;
       }

       @Override
       public boolean deleteOngDAO(ONG pONG) {

              //Implementación de la lógica
              //Elimina la instancia de ONG.
              //Devuelve false si no se ha podido eliminar los datos.

              return false;
       }
}
