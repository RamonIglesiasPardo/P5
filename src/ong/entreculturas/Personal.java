package ong.entreculturas;

import javax.xml.bind.annotation.*;
import java.util.Scanner;

/** La clase abstracta Personal hereda de la clase Persona, y a su vez
 *	tiene las subclases PerEmpleado, PerColaborador y PerVoluntario.
 *	Representa a un empleado de la ONG (de cualquier tipo)
 *
 *	@author Aware Developers
 *  @version 1.5
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
    // --Commented out by Inspection (8/1/20 16:21):private List<Proyecto> proyectosAsignados;
    // TODO: ¿Incluir campo List<Personal> listaEmpleados?

    /**Constructor por defecto
     *
     */

    public Personal() { super(); }

    /**Constructor de Personal
     *  @param nombre Nombre de la persona (se pasa al constructor de la superclase)
     *  @param primerApellido Primer apellido de la persona (se pasa al constructor de la superclase)
     *	@param segundoApellido Segundo apellido de la persona (se pasa al constructor de la superclase)
     *	@param direccion Dirección de la persona (se pasa al constructor de la superclase)
     *	@param telefono Teléfono de la persona (se pasa al constructor de la superclase)
     *	@param mail Correo electrónico de la persona (se pasa al constructor de la superclase)
     *	@param idPersonal Identificación de empleado
     *	@param idCount Contador del número de empleados
     */

    public Personal( String nombre, String primerApellido,
                     String segundoApellido, Direccion direccion,
                     String telefono, String mail, String idPersonal,
                     int idCount ) {
        super( nombre, primerApellido, segundoApellido, direccion, telefono, mail );
        this.idPersonal = idPersonal;
        //noinspection UnusedAssignment
        Personal.idCount = idCount++; // Revisar este último punto, no lo tengo claro...
    }

    /** Método protegido para crear un id de empleado.
     *	El identificador está formado por doce dígitos que representan
     *	el número de incorporación como personal, el número de incorporación
     *	como miembro del equipo y un dígito que identifique al equipo.
     *	Por ejemplo, el id 1011501000721 sería:
     *	Miembro #1150
     *	Empleado #72
     *  NOTA: este método equivale al setter de idPersonal
     * 	@param idHijo Identificador de la subclase
     *	@param idTpo Identificador del equipo
     */

    // TODO: ¿Debería ser este método abstracto, al estilo de introducirDireccion?
    public void crearId(int idHijo, String idTpo) {
        String a = Integer.toString( idHijo + 10000 );
        String b = Integer.toString( idCount + 10000 );
        idPersonal = a.concat(b).concat(idTpo);
    }

    /**Obtiene el idPersonal.
     * @return String con el id de personal.
     */

    @XmlAttribute(name = "id")
    public String getId() {

        return idPersonal;

    }

    /**Obtiene el idCount utilizado para crear la id del empleado.
     * @return Int con el idCount
     */

    public int getIdCount() { return idCount; }

    /**Método abstracto para introducir los datos de la persona.
     * No se implementa en las clases abstractas, unicamente en las subclases concretas.
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
        crearId( getIdCount(), String.valueOf(idCount)); // TODO: Revisar

    }

    /**Método abstracto para introducir la dirección de la persona.
     * No se implementa en las clases abstractas, unicamente en las subclases concretas.
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

        return String.format( "%s\n%s: %s",
                super.toString(), "Id de empleado",
                getId() );

    } // fin del método toString

}