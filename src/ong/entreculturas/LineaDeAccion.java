package ong.entreculturas;



//Clase linea de acción representa un itinerario dentro de un proyecto.

public class LineaDeAccion {

private  LineasDeAccion tipoAccion;
private List <subLineasDeAccion> SubLineaDeAccion;
private  String descripcion;

    //Constructor

    public LineaDeAccion(LineasDeAccion tipoAccion, List<subLineasDeAccion> subLineaDeAccion, String descripcion) {
        this.tipoAccion = tipoAccion;
        SubLineaDeAccion = subLineaDeAccion;
        this.descripcion = descripcion;
    }

    //Métodos Setters y Getters de los atributos


    public LineasDeAccion getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(LineasDeAccion tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public List<subLineasDeAccion> getSubLineaDeAccion() {
        return SubLineaDeAccion;
    }

    public void setSubLineaDeAccion(List<subLineasDeAccion> subLineaDeAccion) {
        SubLineaDeAccion = subLineaDeAccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Método ToString


    @Override
    public String toString() {
        return "LineaDeAccion{" +
                "tipoAccion=" + tipoAccion +
                ", SubLineaDeAccion=" + SubLineaDeAccion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

