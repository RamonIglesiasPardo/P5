package ong.hibernate;


import java.util.List;
import ong.entreculturas.Persona;


public interface DAOHibernate {
    public void agregarPersona(Persona Persona);
    public List<Persona> mostrarPersonas();
    public void eliminarPersona(Integer id);
    public void actualizarPersona(Persona Persona);
    public Persona mostrarPersona(int id);
}
