package ong.hibernate;


import java.util.List;

public class Aplicacion {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        OngDAOHibernate componenteService=new OngDAOHibernate();
        //Listamos el personal nacional
        List<personalNacional> listPersonal = componenteService.mostrarPersonas();
        
        for(personalNacional persona: listPersonal){

            System.out.println(persona.toString());
        }
        //Listamos el personal internacional

        List<PersonalInternacional> listPersonalInternacional = componenteService.mostrarPersonasInternacional();

        for(PersonalInternacional persona: listPersonalInternacional){

            System.out.println(persona.toString());
        }


        //Añadimos personal nacional

        personalNacional nacional=new personalNacional();

        nacional.setNombre("Luis");
        nacional.setApellido1("Dominguez");
        nacional.setApellido2("De la Calle");
        nacional.setDireccionCalle("Calle limon");
        nacional.setDireccionNumero("22");
        nacional.setProvincia("Albacete");
        nacional.setTelefono("67543234");
        nacional.setMail("ldd@hotmail.com");
        componenteService.agregarPersona(nacional);

        //Añadimos personal internacional

        PersonalInternacional internacional=new PersonalInternacional();

        internacional.setNombre("John");
        internacional.setApellido("Brown");
        internacional.setDireccion("Long Streat");
        internacional.setPais("USA");
        internacional.setTelefono("00543234");
        internacional.setMail("jbb@hotmail.com");
        componenteService.agregarPersonaInternacional(internacional);

        //Modificamos personal nacional

        nacional.setId(2);
        nacional.setNombre("Luis");
        nacional.setApellido1("Dominguez");
        nacional.setApellido2("De la Calle");
        nacional.setDireccionCalle("Calle limon");
        nacional.setDireccionNumero("22");
        nacional.setProvincia("Albacete");
        nacional.setTelefono("67543234");
        nacional.setMail("ldd@hotmail.com");
        componenteService.actualizarPersona(nacional);

        //Modificamos personal internacional

        internacional.setId(1);
        internacional.setNombre("John");
        internacional.setApellido("Brown");
        internacional.setDireccion("Sort Streat");
        internacional.setPais("Canada");
        internacional.setTelefono("00543234");
        internacional.setMail("jbb@hotmail.com");
        componenteService.actualizarPersonaInternacional(internacional);

        //Eliminamos personal nacional

        componenteService.eliminarPersona(1);

        //Eliminamos personal internacional

        componenteService.eliminarPersonaInternacional(1);




    }

}