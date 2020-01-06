package ong.entreculturas;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase ONG, que por agregación se relaciona con la mayoría de las otras clases,
 * es una de las clases vertebrales del programa, conteniendo de forma directa o indirecta, las demás clases.
 *
 * @author Ramón Iglesias
 */
public class ONG {

    private String nombre;
    private String CIF;
    public List<Personal> lequipo;
    private List<Proyecto> lproyectos;

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
     * @param lproyectos utilizando un tipo de colección List, recibe un listado de objetos de tipo Proyecto,
     *               que conforman los diferentes proyectos que tiene la ONG
     */
    public ONG(String nombre, String CIF) {
//    public ONG(String nombre, String CIF, List<Personal> lequipo, List<Proyecto> lproyectos) {
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
     * @nombre contiene un String con el nuevo nombre de la ONG
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
     * @CIF Contiene un String con el nuevo código de identificación fiscal
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


            for (int i=0; i < lequipo.size(); i++ ) {

                try {

                    if (lequipo.get(i).getId().equals(idPersonal)) {
                        pPersonaBuscada = lequipo.get(i);
                        return pPersonaBuscada;
                    }

                } catch (Exception e) {
                    System.out.println("ERROR: No existe ningún miembros del personal con el id proporcionado.");
                }
            }

        return pPersonaBuscada;

    }

//TODO DE AQUÍ EN ADELANTE ESTA POR REVISAR...

    public boolean addEquipo(Personal nuevoMiembro) {

        boolean addEquipo = true;

        for (Personal element:lequipo) {

            if (element.getId() == nuevoMiembro.getId()) {

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
     * @param nombre
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
