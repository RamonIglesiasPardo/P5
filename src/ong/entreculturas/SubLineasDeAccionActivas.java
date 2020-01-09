/** La clase enum SubLineasDeAccionActivas es una enumeración de las
 * distintas lineas de acción de la ONG.
 */
package ong.entreculturas;

public enum SubLineasDeAccionActivas {

    //variables

    PROMOCIONSOCIAL ("Promoción Social"),
    CALIDADAD ("Calidad"),
    UNIVERSALIZACION ("Universalización"),
    AYUDAHUMANITARIA ("Ayuda Humanitaria"),
    FORTALECIMIENTO ("Fortalecimiento"),
    TECNICA ("Técnica"),
    EDUDESAROLLO ("Educación para el desarollo"),
    EMERGENCIA ("Emergencia");

    private String sublineaDeAccionActiva;
    //¿¿¿Por definir algo más???

    //CONSTRUCTOR
    SubLineasDeAccionActivas(String sublineaDeAccionActiva) {
        this.sublineaDeAccionActiva = sublineaDeAccionActiva;
    }

    //GETTER
    public String getSublineaDeAccionActiva() {
        return sublineaDeAccionActiva;
    }

    //SETTER
    public void setSublineaDeAccionActiva(String sublineaDeAccionActiva) {
        this.sublineaDeAccionActiva = sublineaDeAccionActiva;
    }
}
