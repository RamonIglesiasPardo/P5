package ong.hibernate;
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

    @Override
    public void agregarPersonaInternacional(PersonalInternacional Persona) {

    }

    @Override
    public List<PersonalInternacional> mostrarPersonasInternacional() {
        return null;
    }

    @Override
    public void eliminarPersonaInternacional(Integer id) {

    }

    @Override
    public void actualizarPersonaInternacional(PersonalInternacional Persona) {

    }

    @Override
    public PersonalInternacional mostrarPersonaInternacional(int id) {
        return null;
    }
}
