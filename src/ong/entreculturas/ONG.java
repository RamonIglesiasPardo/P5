package ong.entreculturas;
import javax.xml.bind.annotation.*;//Importamos librerias JAXB. Desde la versión 1.6 de JDK, JAXB forma parte del JDK.
import java.util.ArrayList;
import java.util.List;

/**
 * La clase ONG, que por agregación se relaciona con la mayoría de las otras clases,
 * es una de las clases vertebrales del programa, conteniendo de forma directa o indirecta, las demás clases.
 *
 * @author Ramón Iglesias
 */
@XmlRootElement(name = "ong")
@XmlAccessorType(XmlAccessType.NONE)
public class ONG {

    @XmlAttribute(name = "nombre")
    private String nombre;
    @XmlAttribute(name = "CIF")
    private String CIF;
    @XmlElement(name= "Personal")
    public List<Personal> lequipo;
    @XmlElement(name= "Proyectos")
    public List<Proyecto> lproyectos;

//    Estos atributos se comentan momentaniamente, a la espera de un merge y disponer de las clases Personal y Proyecto
//    Los siguientes atributos son omitidos intencionadamente. No implementaremos todas las funciones de la aplicación.
//    private SedeCentral sedeCentral;
//    private List<Delegacion> delegaciones;
//    private List<Socio> socios;
//    private List<IngresoPublico> ingresosPublicos;
//    private List<IngresoPrivado> ingresosPrivados;

    /**Constructor por defecto de ONG
     *
     * */
    public ONG() {}

    /** Constructor de ONG
     *
     * @param nombre recibe un string con el nombre de la ONG
     * @param CIF recibe un string con el CIF de la ONG
     * @param lequipo utilizando un tipo de colección List, recibe un listado de objetos de tipo Personal,
     *               que conforman los trabajadores de la ONG
     * //@param lproyectos utilizando un tipo de colección List, recibe un listado de objetos de tipo Proyecto,
     *               que conforman los diferentes proyectos que tiene la ONG
     */
    public ONG(String nombre, String CIF, List<Personal> lequipo, List<Proyecto> lproyectos) {
        this.nombre = nombre;
        this.CIF = CIF;
        this.lequipo = lequipo;
        this.lproyectos = lproyectos;

    }

    /**Constructor sobrecargado. Pendiente eliminarlo...*/
    public ONG(String nombre, String CIF) {
        this.nombre = nombre;
        this.CIF = CIF;
        this.lequipo = new ArrayList<Personal>();
        this.lproyectos = new ArrayList<Proyecto>();

    }

    /** Getter para obtener el nombre de la ONG
     *
     * @return nombre Devuelve un String con el nombre de la ONG
     */
    public String getNombre() {
        return nombre;
    }

    /** Setter para modificar el nombre de la ONG
     *
     * @param nombre contiene un String con el nuevo nombre de la ONG
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Getter para obtener el CIF de la ONG
     *
     * @return CIF Devuelve un String con el código de identificación fiscal
     */
    public String getCIF() {
        return CIF;
    }

    /** Setter para modificar el CIF de la ONG
     *
     * @param CIF Contiene un String con el nuevo código de identificación fiscal
     */
    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    /** Getter para obtener el listado con el personal
     *
     * @return lequipo devuelve un tipo de colección List, con un listado de objetos de tipo Personal,
     *         que conforman los trabajadores de la ONG.
     */
    public List<Personal> getEquipo() {
        return lequipo;
    }

    /** Getter para obtener un miembro del personal según su idPersonal.
     * Si no existe un miembro del personal con el id proporcionado devolverá una excepción controlada y
     * una instancia de tipo Personal vacia.
     *
     * @return devuelve un tipo Personal, que contiene un miembro concreto del personal según idPersonal
     */
    public Personal getMiembroDelEquipo(String idPersonal) {

        Personal pPersonaBuscada = null;


        for (Personal personal : lequipo) {

            try {

                if (personal.getId().equals(idPersonal)) {
                    pPersonaBuscada = personal;
                    return pPersonaBuscada;
                }

            } catch (Exception e) {
                System.out.println("ERROR: No existe ningún miembros del personal con el id proporcionado.");
            }
        }

        return pPersonaBuscada;

    }

    /**Este método devuelve un int con el número de Voluntarios nacionales registrados en el sistema
     * lequipo contiene instancias de tipo Personal, que a su vez tiene la subclase PerVoluntario
     * y esta otra subclase PerVoluntarioInternacional.
     *
     * Como al final lequipo solo contiene instancias de vol nacional o vol internacional calcularemos el
     * número de instancias de vol internacional (que es la que herera de todas las anteriores) y se la
     * restaremos al número total de elementos en lequipo.
     *
     * NOTA: No podemos aplicar un polimorfismo directo porque las instancias PerVolInternacional también
     * son instancias de PerVoluntario.
     *
     * @return int con el número de voluntarios nacionales registrados en el sistema.
     * */
    public int numVoluntariosNacionales(){

        int numVoluntariosInternacionales = 0;

        for (Personal miembroEquipo: lequipo){

            if (miembroEquipo instanceof PerVolInternacional){

                numVoluntariosInternacionales ++;

            }

        }

        return lequipo.size() - numVoluntariosInternacionales;
    }

    /**Este método devuelve un int con el número de Voluntarios internacionales registrados en el sistema
     * lequipo contiene instancias de tipo Personal, que a su vez tiene la subclase PerVoluntario
     * y esta otra subclase PerVoluntarioInternacional.
     *
     * Tan solo sumamos el número de instancias que son de la clase PerVolInternacional.
     *
     * @return int con el número de voluntarios nacionales registrados en el sistema.
     * */
    public int numVoluntariosInternacionales(){

        int numVoluntariosInternacionales = 0;

        for (Personal miembroEquipo: lequipo){

            if (miembroEquipo instanceof PerVolInternacional){

                numVoluntariosInternacionales ++;

            }

        }

        return numVoluntariosInternacionales;
    }

//TODO DE AQUÍ EN ADELANTE ESTA POR REVISAR...

    public boolean addEquipo(Personal nuevoMiembro) {

        boolean addEquipo = true;

        for (Personal element:lequipo) {

            if (element.getId().equals(nuevoMiembro.getId())) {

                return addEquipo = false;

            }
        }

        if (addEquipo) {

            lequipo.add(nuevoMiembro);

        }

        return addEquipo;

    }

    /** Getter
     *
     * //@param nombre
     */
//    public List<Proyecto> getProyectos() {
//        return proyectos;
//    }

//    public void setProyectos(List<Proyecto> proyectos) {
//        this.proyectos = proyectos;
//    }

    @Override
    public String toString() {
        return  "Nombre Organización: " + nombre + "\n" +
                "CIF Organización: " + CIF + "\n" +
                "Número de proyectos: " + lproyectos.size() + "\n" +
                "Número de empleados: " + lequipo.size() + "\n" +
                " ╠════ Número volutanrios nacionales: " + numVoluntariosNacionales() + "\n" +
                " ╚════ Número volutanrios internacionales: " + numVoluntariosInternacionales() + "\n\n";
    }


}
