package ong.hibernate;


import java.util.List;


public interface DAOHibernate {
    public void agregarPersona(personalNacional Persona);
    public List<personalNacional> mostrarPersonas();
    public void eliminarPersona(Integer id);
    public void actualizarPersona(personalNacional Persona);
    public personalNacional mostrarPersona(int id);
    public void agregarPersonaInternacional(PersonalInternacional Persona);
    public List<PersonalInternacional> mostrarPersonasInternacional();
    public void eliminarPersonaInternacional(Integer id);
    public void actualizarPersonaInternacional(PersonalInternacional Persona) ;
    public PersonalInternacional mostrarPersonaInternacional(int id);
}
