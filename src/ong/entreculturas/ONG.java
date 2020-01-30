package ong.entreculturas;
import javax.xml.bind.annotation.*;//Importamos librerias JAXB. Desde la versión 1.6 de JDK, JAXB forma parte del JDK.
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.*;

/**
 * La clase ONG, que por agregación se relaciona con la mayoría de las otras clases,
 * es una de las clases vertebrales del programa, conteniendo de forma directa o indirecta, las demás clases.
 *
 * @author Aware Developers
 * @version 1.3
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
     * @param lproyectos utilizando un tipo de colección List, recibe un listado de objetos de tipo Proyecto,
     *               que conforman los diferentes proyectos que tiene la ONG
     */
    public ONG(String nombre, String CIF, List<Personal> lequipo, List<Proyecto> lproyectos) {
        this.nombre = nombre;
        this.CIF = CIF;
        this.lequipo = lequipo;
        this.lproyectos = lproyectos;

    }

    /**Constructor sobrecargado. Pendiente eliminarlo...
     *
     * @param nombre nombre de la ONG
     * @param CIF CIF de la ONG
     */
    public ONG(String nombre, String CIF) {
        this.nombre = nombre;
        this.CIF = CIF;
        this.lequipo = new ArrayList<>();
        this.lproyectos = new ArrayList<>();

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
     * @param idPersonal int con el id de personal
     * @return devuelve un tipo Personal, que contiene un miembro concreto del personal según idPersonal
     */
    public Personal getMiembroDelEquipo(int idPersonal) {

        Personal pPersonaBuscada = null;

        for (Personal personal : lequipo) {

            try {

                if (personal.getId() == idPersonal) {
                    pPersonaBuscada = personal;
                    return pPersonaBuscada;
                } else {
                    return null;
                }

            } catch (Exception e) {
                System.out.println("ERROR: No existe ningún miembros del personal con el id proporcionado.");
            }
        }

        return pPersonaBuscada;

    }

//TODO DE AQUI EN ADELANTE ESTA POR REVISAR...

    public boolean addEquipo(Personal nuevoMiembro) {

        boolean addEquipo = true;

        for (Personal element:lequipo) {

            if (element.getId() == nuevoMiembro.getId()) {

                return false;

            }
        }

        lequipo.add(nuevoMiembro);

        return true;

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
                "Número de empleados: " + lequipo.size() + "\n" +
                "Número de proyectos: " + lproyectos.size() + "\n";
    }


}
