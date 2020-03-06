package ong.dao;

import ong.entreculturas.*;
import sql.UtilitySql;

import java.sql.SQLException;

/** La clase MySqlOngDAO forma parte del patrón DAO.
 *  Permite separar la lógica para la persistencia de la lógica del negocio.
 *
 *  MySqlOngDAO implementa la interfaz IOngDAO que declara los métodos que de deberán implementar
 *  todas las instancias DAO ONG, ya sean XmlOngDAO o MySQLDAO.
 *
 *  En el caso de MySqlOngDAO se implementa toda la lógica necesaria para que ONG trabaje con MySQL,
 *  tan solo implementamos los métodos básicos CRUD (Create, Read, Update y Delete).
 *
 *  @author Aware Developers
 *  @version 1.0
 * */
public class MySqlOngDAO implements IOngDAO{

    private ONG ong;

    public MySqlOngDAO() {

        //Implementación de la lógica
        //Inicialización
    }

    @Override
    public void createOngDAO(ONG ong) {

        UtilitySql utilitySql = new UtilitySql();

       

        //Recorremos personal para insertarlo en la BD MySQL.
        for (int i = 0; i < ong.lequipo.size(); i++) {

            String nombre, primerApellido, segundoApellido, direccion, telefono, mail, paisOrigen = null;

            nombre = ong.lequipo.get(i).getNombre();
            primerApellido = ong.lequipo.get(i).getPrimerApellido();
            segundoApellido = ong.lequipo.get(i).getSegundoApellido();
            mail = ong.lequipo.get(i).getMail();
            PerVoluntario perVoluntario = (PerVoluntario) ong.lequipo.get(i);
            int numHoras = perVoluntario.getNumHorasVol();

            //En función de que sea personal internacional o nacional tabla destino y campos varian
            if (!(ong.lequipo.get(i) instanceof PerVolInternacional)) {
                //Se ejecuta cuando es personal nacional
                telefono = ong.lequipo.get(i).getTelefono();
                direccion = ong.lequipo.get(i).getDireccion().toString();

            } else {
                //Se ejecuta cuando es personal internacional
                PerVolInternacional perVolutarioInternacional = (PerVolInternacional) ong.lequipo.get(i);
                telefono = perVolutarioInternacional.getCodInternaTelefono() + " " + perVolutarioInternacional.getTelefono();
                direccion = perVolutarioInternacional.getDir();
                paisOrigen = perVolutarioInternacional.getPaisOrigen();

            }

            try {

                utilitySql.insertPersona(nombre, primerApellido, segundoApellido, direccion, telefono, mail);

                int idPersona = utilitySql.consultarIdGenerado("Persona");

                utilitySql.insertPersonal(idPersona);

                int idPersonal = utilitySql.consultarIdGenerado("Personal");

                utilitySql.insertPerVoluntario(numHoras, idPersona, idPersonal);

                //Hasta este punto todos las instancias son PerVoluntario, ahora verificamos si además son voluntarios
                //internacionales, para actuar en consecuencia.
                if ((ong.lequipo.get(i) instanceof PerVolInternacional)) {

                    int idPerVol = utilitySql.consultarIdGenerado("PerVoluntario");

                    utilitySql.insertPerVolInternacional(idPersona, idPersonal, idPerVol, direccion, paisOrigen, telefono);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public ONG readOngDAO() {
        return null;
    }

    @Override
    public boolean updateOngDAO(ONG pONG) {
        return false;
    }

    @Override
    public boolean deleteOngDAO(ONG pONG) {
        return false;
    }
}
