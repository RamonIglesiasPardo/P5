package ong.hibernate;


import java.util.List;
import ong.entreculturas.Persona;


public interface DAOHibernate {
    public void agregarPersona(personalNacional Persona);
    public List<personalNacional> mostrarPersonas();
    public void eliminarPersona(Integer id);
    public void actualizarPersona(personalNacional Persona);
    public personalNacional mostrarPersona(int id);
}
