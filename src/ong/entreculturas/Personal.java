package ong.entreculturas;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;
import java.util.Scanner;

/** La clase Personal hereda de la clase Persona, y a su vez
 *	tiene las subclases PerEmpleado, PerColaborador y PerVoluntario.
 *	Representa a un empleado de la ONG (de cualquier tipo)
 *
 *	@author Alberto González Casado
 *  @version 1.4
 */

public class Personal extends Persona {

    //Variables de clase

    private int idPersonal;
    private static int idCount = 1;
    private List<Proyecto> proyectosAsignados;

    /**
     * Constructor por defecto
     */

    public Personal() {
        super();
        //Asignamos automáticamente un entero autoincrementable con el id de empleado al crear
        //un nuevo objeto Personal
        idPersonal = idCount;
        idCount++;
    }

    /**
     * Constructor de Personal
     *
     * @param nombre          Nombre de la persona (se pasa al constructor de la superclase)
     * @param primerApellido  Primer apellido de la persona (se pasa al constructor de la superclase)
     * @param segundoApellido Segundo apellido de la persona (se pasa al constructor de la superclase)
     * @param direccion       Dirección de la persona (se pasa al constructor de la superclase)
     * @param telefono        Teléfono de la persona (se pasa al constructor de la superclase)
     * @param mail            Correo electrónico de la persona (se pasa al constructor de la superclase)
     */

    public Personal(String nombre, String primerApellido,
                    String segundoApellido, Direccion direccion,
                    String telefono, String mail) {

        super(nombre, primerApellido, segundoApellido, direccion, telefono, mail);
        //Asignamos automáticamente un entero autoincrementable con el id de empleado al crear
        //un nuevo objeto Personal
        idPersonal = idCount;
        idCount++;
    }

    /**Constructor de Personal (para perVolInternacional)
     *
     * @param nombre nombre de la persona
     * @param primerApellido primer apellido de la persona
     * @param segundoApellido segundo apellido de la persona
     * @param telefono teléfono de la persona
     * @param mail mail de la persona
     */

    public Personal(String nombre, String primerApellido, String segundoApellido, String telefono, String mail) {
        super (nombre, primerApellido, segundoApellido, telefono, mail);
        //Asignamos automáticamente un entero autoincrementable con el id de empleado al crear
        //un nuevo objeto Personal
        idPersonal = idCount;
        idCount++;
    }

    //Getter y Setters

    /**
     * Obtiene el idPersonal.
     *
     * @return int con el id de personal.
     */

    @XmlAttribute(name = "id")
    public int getId() {
        return idPersonal;
    }

    //Métodos de clase

    /**Método para introducir los datos de la persona.
     * Es el método abstracto de las superclase, que aquí sí se implementa.
     */

    @Override
    public void introducirDatosPersona() {

        // crea un objeto Scanner para obtener los datos

        Scanner entrada = new Scanner(System.in);

        // Pide los datos al usuario

        System.out.print("Nombre: ");
        super.setNombre(entrada.nextLine());
        System.out.print("Primer apellido: ");
        super.setPrimerApellido(entrada.nextLine());
        System.out.print("Segundo apellido: ");
        super.setSegundoApellido(entrada.nextLine());
        super.setDireccion(introducirDireccion());
        System.out.print("Teléfono: ");
        super.setTelefono(entrada.nextLine());
        System.out.print("E-mail: ");
        super.setMail(entrada.nextLine());

    }

    /**Método para introducir la dirección de la persona.
     * Es el método abstracto de las superclase, que aquí sí se implementa.
     *
     * @return objeto Direccion
     */

    @Override
    public Direccion introducirDireccion() {

        // crea un objeto Scanner para obtener los datos
        Scanner entrada = new Scanner( System.in );
        // Creamos un objeto Direccion por defecto
        Direccion direccion = new Direccion();
        // Solicitamos la introducción de un tipo de via para añadirla a la instancia direccion.
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
        // Solicitamos la introducción de una povincia para añadirla a la instancia direccion.
        Provincia.introducirProvincia(direccion);
        System.out.println( "Localidad: " );
        direccion.setLocalidad( entrada.nextLine() );

        return direccion;

    } // fin del método introducirDireccion

    /**Devuelve la representación String de un objeto Personal
     *
     * @return Representación String de un objeto Personal
     */

    @Override
    public String toString() {

        return String.format("Id de empleado: %04d\n%s",
                getId(), super.toString());

    }

}
