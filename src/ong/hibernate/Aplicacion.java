package ong.hibernate;


import ong.entreculturas.Direccion;
import ong.entreculturas.Persona;
import ong.entreculturas.Personal;

import java.util.List;

public class Aplicacion {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        OngDAOHibernate componenteService=new OngDAOHibernate();
        List<Persona> listaPersonas;
        Persona persona=new Personal() ;
        persona.setNombre("test");
        persona.setPrimerApellido("Prueba");
        persona.setSegundoApellido("t");
        persona.setDireccion(AVDA, "Cadiz","2","2","C","derecha","28100",MADRID,"Madrid");
        persona.setTelefono("630189056");
        persona.setNombre("test@test.es");
        componenteService.agregarPersona(persona);//id=1
        listaPersonas = componenteService.mostrarPersonas();
        System.out.println(listaPersonas.toString());
        persona.setNombre("segundoTest");
        persona.setPrimerApellido("Prueba");
        persona.setSegundoApellido("t");
        persona.setDireccion(AVDA, "Cadiz","2","2","C","derecha","28100",MADRID,"Madrid");
        persona.setTelefono("630189056");
        persona.setNombre("test@test.es");
        componenteService.actualizarPersona(persona);
        System.out.println(componenteService.mostrarPersona(1).toString());
        componenteService.eliminarPersona(4);
        listaPersonas = componenteService.mostrarPersonas();
        System.out.println(listaPersonas.toString());
    }

}