/**La clase Persona es una clase abstracta que representa una persona.
 * Tiene las subclases directas Personal y Socio.
 *
 * @author Aware Developers
 * @version 1.5
 */

package ong.entreculturas;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Persona")
@Table(name="Persona")


@XmlType(propOrder = {"nombre", "primerApellido", "segundoApellido", "telefono", "mail", "direccion"})
public abstract class Persona {

    @Id
    private int id;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="PrimerApellido")
    private String primerApellido;
    @Column(name="SegundoApellido")
    private String segundoApellido;
    @Column(name="Direccion")
    private Direccion direccion;
    @Column(name="Telefono")
    private String telefono;
    @Column(name="Mail")
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
     * @param direccion       Dirección de la persona, de tipo Direccion
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

    /**Constructor de Persona (para perVolInternacional)
     *
     * @param nombre nombre de la persona
     * @param primerApellido primer apellido de la persona
     * @param segundoApellido segundo apellido de la persona
     * @param telefono teléfono de la persona
     * @param mail mail de la persona
     */

    public Persona(String nombre, String primerApellido, String segundoApellido, String telefono, String mail) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
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

    /**Obtiene la dirección del empleado (utiliza el tipo de datos Direccion)
     * @return un objeto Direccion
     */

	@XmlElement(name = "direccion")
    public Direccion getDireccion() {
        return direccion;
    }

    /**Establece la dirección del empleado (utiliza el tipo de datos Direccion)
     * @param direccion objeto Direccion
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
    public String getMail() { return mail; }

    /**Establece el correo electrónico de la persona
     * @param mail correo electrónico de la persona
     */

    public void setMail(String mail) {
        this.mail = mail;
    }

   //Métodos de clase

    /**Método abstracto para introducir los datos de la persona.
     * No se implementa en las clases abstractas, unicamente en las subclases concretas.
     */

    abstract public void introducirDatosPersona();

    /**Método abstracto para introducir la dirección de la persona.
     * No se implementa en las clases abstractas, unicamente en las subclases concretas.
     * @return objeto Direccion
     */

    abstract public Direccion introducirDireccion();

    /**Devuelve la representación String de un objeto Persona.
     * @return representación String de un objeto Persona.
     */

    public String toString() {
        return String.format("Nombre: %s %s, %s\nDirección: %s\nTeléfono: %s\nE-mail: %s",
                getPrimerApellido(), getSegundoApellido(), getNombre(),
                direccion.toString(), getTelefono(), getMail());
    }

}