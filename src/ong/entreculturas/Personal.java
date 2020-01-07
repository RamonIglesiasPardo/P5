/** La clase abstracta Personal hereda de la clase Persona, y a su vez
 *	tiene las subclases PerEmpleado, PerColaborador y PerVoluntario.
 *	Representa a un empleado de la ONG (de cualquier tipo)
 *
 *	@author Alberto González Casado
 *  @version 1.4
 */

        package ong.entreculturas;

// a falta de implementar la clase Proyecto
//import ong.entreculturas.Proyecto;
import ong.entreculturas.Direccion;

public abstract class Personal extends Persona {

    // a falta de implementar la clase Sede
    //private Sede delegacionAsignada;
    private String idPersonal;
    // variable de clase para contar el número de empleados
    private static int idCount = 1;
    // a falta de implementar la clase Proyecto
    // declarar la variable tipo list de proyectosAsignados
    //private List<Proyecto> proyectosAsignados;


    /** Constructor de Personal sin parámetros
     *
     */

    public Personal() {

        super();

    } // fin del constructor de Personal sin parámetros

    /** Constructor de Personal con todos los parámetros
     *
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

        // pasa los campos comunes al constructor de la superclase

        super( nombre, primerApellido, segundoApellido, direccion, telefono, mail );

        this.idPersonal = idPersonal;
        Personal.idCount = idCount++;

    } // fin del constructor de Personal sin argumentos

    /** Método protegido para crear un id de empleado
     *	El identificador está formado por doce dígitos que representan
     *	el número de incorporación como personal, el número de incorporación
     *	como miembro del equipo y un dígito que identifique al equipo.
     *	Por ejemplo, el id 1011501000721 sería:
     *	Miembro #1150
     *	Empleado #72
     *  NOTA: este método equivale al setter de idPersonal
     *
     * 	@param idHijo Identificador de la subclase
     *	@param idTpo Identificador del equipo
     */

    protected void crearId( int idHijo, String idTpo ) {

        String a = Integer.toString( idHijo + 10000 );
        String b = Integer.toString( idCount + 10000 );
        idPersonal = a.concat(b).concat(idTpo);

    } // fin del método protegido crearId

    /** Obtiene el idPersonal
     *
     *	@return String con el id de personal
     */

    public String getId() {

        return idPersonal;

    } // fin del método getId

    /** Obtiene el número de empleado (por incorporación)
     *
     *	@return Int con el número de empleado (por incorporación)
     */

    public int getIdCount() {

        return idCount;

    } // fin del método getIdCount

    /** Devuelve la representación String de un objeto Personal
     *  NOTA: modificar si implementamos la clase Sede
     *
     *	@return Representación String de un objeto Personal
     */

    /** Método abstracto para introducir los datos de la persona.
     *  No se implementa en las clases abstractas, unicamente en las subclases concretas.
     *
     */

    abstract public void introducirDatosPersona();

    /** Método abstracto para introducir la direcció de la persona.
     *  No se implementa en las clases abstractas, unicamente en las subclases concretas.
     *
     */

    abstract public Direccion introducirDireccion();

    @Override
    public String toString() {

        return String.format( "%s\n%s: %s",
                super.toString(), "Id de empleado",
                getId() );

    } // fin del método toString

    // Podría implementarse al menos un método abstracto que nos permitiera
    // aplicar polimorfismo en las clases hijas

} // fin de la clase abstracta Personal
