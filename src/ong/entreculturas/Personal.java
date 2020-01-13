package ong.entreculturas;

import javax.xml.bind.annotation.*;
import java.util.Scanner;

/**
 * La clase Personal hereda de la clase Persona, y a su vez
 * tiene las subclases PerEmpleado, PerColaborador y PerVoluntario.
 * Representa a un empleado de la ONG (de cualquier tipo)
 *
 * @author Aware Developers
 * @version 1.5
 */
//Creo que @XmlSeeAlso se utiliza para mostrar únicamente los campos de las superclases
//ver: http://www.techferry.com/articles/jaxb-annotations.html#XmlSeeAlso
//@XmlSeeAlso({PerVoluntario.class, PerVolInternacional.class})
@XmlSeeAlso(Persona.class)
public class Personal extends Persona {

    // a falta de implementar la clase Sede
    //private Sede delegacionAsignada;
    private String idPersonal;
    // variable de clase utilizada para crear la Id de empleado
    private static int idCount = 1;

    /**
     * Constructor por defecto
     */

    public Personal() { super(); }

    /**
     * Constructor de Personal
     * @param nombre Nombre de la persona (se pasa al constructor de la superclase)
     * @param primerApellido Primer apellido de la persona (se pasa al constructor de la superclase)
     * @param segundoApellido Segundo apellido de la persona (se pasa al constructor de la superclase)
     * @param direccion Dirección de la persona (se pasa al constructor de la superclase)
     * @param telefono Teléfono de la persona (se pasa al constructor de la superclase)
     * @param mail Correo electrónico de la persona (se pasa al constructor de la superclase)
     */

    public Personal( String nombre, String primerApellido,
                     String segundoApellido, Direccion direccion,
                     String telefono, String mail ) {
        super( nombre, primerApellido, segundoApellido, direccion, telefono, mail );

    }

    /**
     * Método para crear un id de empleado.
     * El identificador está formado por una combinación alfanumérica que consiste
     * en las siglas EC seguidas de un número correlativo de cuatro cifras de empleado general
     * y unas siglas identificativas del subgrupo, más el número de empleado del subgrupo.
     * Por ejemplo, EC0001V0001 equivaldría al primer voluntario asignado.
     * NOTA: este método equivale al setter de idPersonal
     * @param idHijo Identificador de la subclase
     * @param idTipo Identificador del equipo
     */

    public void crearId(String idTipo, int idHijo) {
        String s = String.format("EC%04d", idCount);
        this.idPersonal = s + idTipo + String.format("%04d", idHijo);
        idCount++;
        idHijo++;
    }

    /**
     * Obtiene el idPersonal.
     * @return String con el id de personal.
     */

    @XmlAttribute(name = "idPersonal")
    public String getId() {
        return idPersonal;
    }

    /**
     * Obtiene el idCount utilizado para crear la id del empleado.
     * @return Int con el idCount
     */

    public int getIdCount() { return idCount; }

    /**
     * Método para introducir los datos de la persona.
     */

    @Override
    public void introducirDatosPersona() {
        Scanner entrada = new Scanner( System.in );

        System.out.print( "Nombre: " );
        super.setNombre( entrada.nextLine() );
        System.out.print( "Primer apellido: " );
        super.setPrimerApellido( entrada.nextLine() );
        System.out.print( "Segundo apellido: " );
        super.setSegundoApellido( entrada.nextLine() );
        super.setDireccion(introducirDireccion());
        System.out.print( "Teléfono: " );
        super.setTelefono( entrada.nextLine() );
        System.out.print( "E-mail: " );
        super.setMail( entrada.nextLine() );
    }

    /**
     * Método para introducir la dirección de la persona.
     */

    public Direccion introducirDireccion() {
        Scanner entrada = new Scanner( System.in );
        Direccion direccion = new Direccion();
        TipoVia.introducirTipoVia(direccion);
        System.out.println( "Nombre de la vía: " );
        direccion.setNombreVia( entrada.nextLine() );
        System.out.println( "Número: " );
        direccion.setNumero( entrada.nextLine() );
        System.out.println( "Piso: " );
        direccion.setPiso( entrada.nextLine() );
        System.out.println( "Puerta: " );
        direccion.setPuerta( entrada.nextLine() );
        System.out.println( "Escalera: " );
        direccion.setEscalera( entrada.nextLine() );
        System.out.println( "Código postal: " );
        direccion.setCodPostal( entrada.nextLine() );
        Provincia.introducirProvincia(direccion);
        System.out.println( "Localidad: " );
        direccion.setLocalidad( entrada.nextLine() );

        return direccion;
    }

    /**Devuelve la representación String de un objeto Personal.
     * @return Representación String de un objeto Personal.
     */

    @Override
    public String toString() {

        return String.format("Nombre: %s %s, %s\nDirección: %s\nTeléfono: %s\nE-mail: %s",
                super.getPrimerApellido(), super.getSegundoApellido(), super.getNombre(),
                super.getDireccion(), super.getTelefono(), super.getMail());
    }

}