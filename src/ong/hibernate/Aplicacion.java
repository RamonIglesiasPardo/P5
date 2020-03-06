package ong.hibernate;


import ong.entreculturas.*;

import java.util.List;

import static ong.entreculturas.Provincia.ALA;

public class Aplicacion {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        OngDAOHibernate componenteService=new OngDAOHibernate();
        List<Persona> listaPersonas;
        Direccion direccion = new Direccion(TipoVia.AVDA,"Cadiz","2","2","C","derecha","28100",Provincia.MAD,"Madrid");
        Persona persona=new Personal() ;
        persona.setNombre("test");
        persona.setPrimerApellido("Prueba");
        persona.setSegundoApellido("t");
        persona.setDireccion( direccion);
        persona.setTelefono("630189056");
        persona.setNombre("test@test.es");
        componenteService.agregarPersona(persona);//id=1
        listaPersonas = componenteService.mostrarPersonas();
        System.out.println(listaPersonas.toString());
        persona.setNombre("segundoTest");
        persona.setPrimerApellido("Prueba");
        persona.setSegundoApellido("t");
        persona.setDireccion(direccion);
        persona.setTelefono("630189056");
        persona.setNombre("test@test.es");
        componenteService.actualizarPersona(persona);
        System.out.println(componenteService.mostrarPersona(1).toString());
        componenteService.eliminarPersona(4);
        listaPersonas = componenteService.mostrarPersonas();
        System.out.println(listaPersonas.toString());
    }

}