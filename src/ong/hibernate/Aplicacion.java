package ong.hibernate;


import ong.entreculturas.*;

import java.util.List;

import static ong.entreculturas.Provincia.ALA;

public class Aplicacion {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        OngDAOHibernate componenteService=new OngDAOHibernate();
        List<personalNacional> listPersonal = componenteService.mostrarPersonas();
        
        for(personalNacional persona: listPersonal){

            System.out.println(persona.toString());
        }

    }

}