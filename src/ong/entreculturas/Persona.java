package ong.entreculturas;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = {"nombre", "primerApellido", "segundoApellido", "direccion", "telefono", "mail", })
public abstract class Persona {


    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Direccion direccion;
    private String telefono;
    private String mail;

    /**Constructor de Persona por defecto
	 *
     */

    public Persona() {
        super();
    }

    /**Constructor de Persona
     * @param nombre          Nombre de la persona
     * @param primerApellido  Primer apellido de la persona
     * @param segundoApellido Segundo apellido de la persona
     * @param direccion       Dirección de la persona (no definida aún)
     * @param telefono        Teléfono de la persona
     * @param mail            Correo electrónico de la persona
     */

    public Persona(String nombre, String primerApellido,
                   String segundoApellido, Direccion direccion,
                   String telefono, String mail) {
        super();
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        setDireccion(direccion);
        this.telefono = telefono;
        this.mail = mail;
    }

    /**Obtiene el nombre de la persona
     * @return String con el nombre de la persona
     */

    @XmlElement(name = "nombre")
    public String getNombre() { return nombre; }

    /**Establece el nombre de la persona
     * @param nombre nombre de la persona
     */

    public void setNombre(String nombre) { this.nombre = nombre; }

    /**Obtiene el primer apellido de la persona
     * @return String con el primer apellido de la persona
     */

	@XmlElement(name = "primerApellido")
    public String getPrimerApellido() { return primerApellido; }

    /**Establece el primer apellido de la persona
     * @param primerApellido primer apellido de la persona
     */

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**Obtiene el segundo apellido de la persona
     * @return String con el segundo apellido de la persona
     */

	@XmlElement(name = "segundoApellido")
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**Establece el segundo apellido de la persona
     * @param segundoApellido segundo apellido la persona
     */

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

// --Commented out by Inspection START (8/1/20 15:41):
    /**Obtiene la dirección del empleado (utiliza el tipo de datos Direccion)
     * @return un objeto Direccion
     */

	@XmlElement(name = "direccion")
    public Direccion getDireccion() {
        return direccion;
    }
// --Commented out by Inspection STOP (8/1/20 15:41)

    /**Establece la dirección del empleado (utiliza el tipo de datos Direccion)
     * @param direccion nombre del objeto Direccion
     */

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**Obtiene el teléfono de la persona
     * @return String con el teléfono de la persona
     */

	@XmlElement(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    /**Establece el teléfono de la persona
     * @param telefono teléfono de la persona
     */

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**Obtiene el correo electrónico de la persona
     * @return String con el correo electrónico de la persona
     */

	@XmlElement(name = "email")
    public String getMail() {
        return mail;
    }

    /**Establece el correo electrónico de la persona
     * @param mail correo electrónico de la persona
     */

    public void setMail(String mail) {
        this.mail = mail;
    }

    /**Método abstracto para introducir los datos de la persona.
     * No se implementa en las clases abstractas, unicamente en las subclases concretas.
     */

    abstract public void introducirDatosPersona();

    /**Método abstracto para introducir la dirección de la persona.
     * No se implementa en las clases abstractas, unicamente en las subclases concretas.
     */

    abstract public Direccion introducirDireccion();

    /**Devuelve la representación String de un objeto Persona.
     * @return representación String de un objeto Persona.
     */

    public String toString() {
        return String.format("%s: %s %s, %s\n%s: %s\n%s: %s\n%s: %s",
                "Nombre", getPrimerApellido(), getSegundoApellido(), getNombre(),
                "Dirección", direccion.toString(),
                "Teléfono", getTelefono(), "E-mail", getMail());
    }

    public abstract void crearId(int idCount, String valueOf);
}