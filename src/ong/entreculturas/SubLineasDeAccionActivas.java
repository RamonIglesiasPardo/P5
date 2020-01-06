/** La clase enum SubLineasDeAccionActivas es una enumeración de las
 * distintas lineas de acción de la ONG.
 */
package ong.entreculturas;

public enum SubLineasDeAccionActivas {

    //variables

    PROMOCIONSOCIAL ("Promoción Social"),
    CALIDADAD ("Calidad"),
    UNIVERSALIZACIÓN ("Universalización"),
    AYUDAHUMANITARIA ("Ayuda Humanitaria"),
    FORTALECIMIENTO ("Fortalecimiento"),
    TÉCNICA ("Técnica"),
    EDUDESAROLLO ("Educación para el desarollo"),
    EMERGENCIA ("Emergencia");

    private String sublineaDeAcciónActiva;
    //¿¿¿Por definir algo más???

    //CONSTRUCTOR
    SubLineasDeAccionActivas(String sublineaDeAcciónActiva) {
        this.sublineaDeAcciónActiva = sublineaDeAcciónActiva;
    }

    //GETTER
    public String getSublineaDeAcciónActiva() {
        return sublineaDeAcciónActiva;
    }

    //SETTER
    public void setSublineaDeAcciónActiva(String sublineaDeAcciónActiva) {
        this.sublineaDeAcciónActiva = sublineaDeAcciónActiva;
    }
}
