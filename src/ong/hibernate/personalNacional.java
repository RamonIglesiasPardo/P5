package ong.hibernate;

import javax.persistence.*;

@Entity
@Table(name="personalNacional")
public class personalNacional {


    @Id
    @Column(name="id")
    @GeneratedValue
    int id;
    @Column(name="nombre")
    String nombre;
    @Column(name="apellido1")
    String apellido1;
    @Column(name="apellido2")
    String apellido2;
    @Column(name="direccionCalle")
    String direccionCalle;
    @Column(name="direccionNumero")
    String direccionNumero;
    @Column(name="telefono")
    String telefono;
    @Column(name="provincia")
    String provincia;
    @Column(name="mail")
    String mail;

    public personalNacional(){

    };

    public personalNacional(String nombre, String apellido1, String apellido2, String direccionCalle, String direccionNumero, String telefono, String provincia, String mail) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccionCalle = direccionCalle;
        this.direccionNumero = direccionNumero;
        this.telefono = telefono;
        this.provincia = provincia;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccionCalle() {
        return direccionCalle;
    }

    public void setDireccionCalle(String direccionCalle) {
        this.direccionCalle = direccionCalle;
    }

    public String getDireccionNumero() {
        return direccionNumero;
    }

    public void setDireccionNumero(String direccionNumero) {
        this.direccionNumero = direccionNumero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "personalNacional{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", direccionCalle='" + direccionCalle + '\'' +
                ", direccionNumero='" + direccionNumero + '\'' +
                ", telefono='" + telefono + '\'' +
                ", provincia='" + provincia + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}

