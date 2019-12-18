package ong.entreculturas;

import java.util.ArrayList;
import java.util.List;

public class ONG {

    private String nombre;
    private String CIF;
    private List<Personal> equipo;
    private List<Proyecto> proyectos;

    /*
    ATRIBUTOS OMITIDOS:
    private SedeCentral sedeCentral;
    private List<Delegacion> delegaciones;
    private List<Socio> socios;
    private List<IngresoPublico> ingresosPublicos;
    private List<IngresoPrivado> ingresosPrivados;
    */

    public ONG(String nombre, String CIF) {
        this.nombre = nombre;
        this.CIF = CIF;
        List<Personal> equipo = new ArrayList<Personal>;
        List<Proyecto> proyectos = new ArrayList<Proyecto>;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public List<Personal> getEquipo() {
        return equipo;
    }

    public void setEquipo(List<Personal> equipo) {
        this.equipo = equipo;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public String toString() {
        return "ONG{" +
                "nombre='" + nombre + '\'' +
                ", CIF='" + CIF + '\'' +
                ", equipo=" + equipo +
                ", proyectos=" + proyectos +
                '}';
    }


}
