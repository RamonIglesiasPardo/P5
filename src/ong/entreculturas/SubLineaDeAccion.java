package ong.entreculturas;

public class SubLineaDeAccion {
    private subLineasDeAccionActivas areaDeAccion ;
    private LineaDeAccion lineaDeAccion ;
    private  String descripcion;

    //Constructor

    public SubLineaDeAccion(subLineasDeAccionActivas areaDeAccion, LineaDeAccion lineaDeAccion, String descripcion) {
        this.areaDeAccion = areaDeAccion;
        this.lineaDeAccion = lineaDeAccion;
        this.descripcion = descripcion;
    }


    //Métodos Setters y Getters de los atributos

    public subLineasDeAccionActivas getAreaDeAccion() {
        return areaDeAccion;
    }

    public void setAreaDeAccion(subLineasDeAccionActivas areaDeAccion) {
        this.areaDeAccion = areaDeAccion;
    }

    public LineaDeAccion getLineaDeAccion() {
        return lineaDeAccion;
    }

    public void setLineaDeAccion(LineaDeAccion lineaDeAccion) {
        this.lineaDeAccion = lineaDeAccion;
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
        return "SubLineaDeAccion{" +
                "areaDeAccion=" + areaDeAccion +
                ", lineaDeAccion=" + lineaDeAccion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    
}
