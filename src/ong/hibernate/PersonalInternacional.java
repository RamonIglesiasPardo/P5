package ong.hibernate;

import javax.persistence.*;

@Entity
@Table(name="personalInternacional")
public class PersonalInternacional {

    @Id
    @Column(name="id",  updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="nombre")
    String nombre;
    @Column(name="apellido")
    String apellido;
    @Column(name="direccion")
    String direccion;
    @Column(name="telefono")
    String telefono;
    @Column(name="pais")
    String pais;
    @Column(name="mail")
    String mail;

    public PersonalInternacional(){
        this.nombre = "\"NOMBRE\"";
        this.apellido = "\"APELLIDO\"";
        this.direccion = "\"DIRECCION\"";
        this.telefono = "\"TELEFONO\"";
        this.pais = "\"ESTADO\"";
        this.mail = "\"CORREO\"";
    };

    public PersonalInternacional(String nombre, String apellido,  String direccion,  String telefono, String pais, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pais = pais;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion (String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "PersonalInternacional{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", pais='" + pais + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}