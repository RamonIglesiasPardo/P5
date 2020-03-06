package ong.hibernate;
import ong.entreculturas.Persona;

import java.util.List;
public class ServiceImpl implements DAOHibernate{

    private DAOHibernate daoHibernate = new ServiceImpl();

    @Override
    public void agregarPersona(personalNacional Persona) {

    }

    @Override
    public List<personalNacional> mostrarPersonas() {
        return null;
    }

    @Override
    public void eliminarPersona(Integer id) {

    }

    @Override
    public void actualizarPersona(personalNacional Persona) {

    }

    @Override
    public personalNacional mostrarPersona(int id) {
        return null;
    }
}
