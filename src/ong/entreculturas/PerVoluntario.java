package ong.entreculturas;

import javax.xml.bind.annotation.*;
import java.util.*;

/**
 * La clase PerVoluntario es subclase directa de la clase Personal
 * y tiene la subclase PerVolInternacional.
 * Representa a un empleado voluntario
 *
 * @author Aware Developers
 * @version 1.6
 */

//Creo que habría que utilizar también @XmlSeeAlso, que nos mostrará además
//	los campos de las superclases.
//	ver: http://www.techferry.com/articles/jaxb-annotations.html#XmlSeeAlso
@XmlRootElement(name = "TipoVol")
@XmlSeeAlso({Persona.class, Personal.class})
public class PerVoluntario extends Personal {

	private String idVol = "V";
	private static int idVolCount = 1;
	private int numHorasVol;

	/**
	 * Constructor por defecto
	 */

	public PerVoluntario() {
		super();
		super.crearId(idVol, idVolCount);
		idVolCount++;
		this.numHorasVol = 0; // si desconocemos las horas las establecemos a 0
	}

	/**
	 * Constructor de PerVoluntario
	 * @param nombre Nombre de la persona (se pasa al constructor de la superclase)
	 * @param primerApellido Primer apellido de la persona (se pasa al constructor de la superclase)
	 * @param segundoApellido Segundo apellido de la persona (se pasa al constructor de la superclase)
	 * @param direccion Dirección de la persona (se pasa al constructor de la superclase)
	 * @param telefono Teléfono de la persona (se pasa al constructor de la superclase)
	 * @param mail Correo electrónico de la persona (se pasa al constructor de la superclase)
	 * @param numHorasVol Número de horas trabajadas por el voluntario
	 */

	public PerVoluntario( String nombre, String primerApellido,
						  String segundoApellido, Direccion direccion,
						  String telefono, String mail, int numHorasVol ) {

		super( nombre, primerApellido, segundoApellido, direccion, telefono, mail);

		super.crearId(idVol, idVolCount);
		idVolCount++;
		this.numHorasVol = numHorasVol;

	}

	/**
	 * Establece el número de horas trabajadas como voluntario.
	 * @param numHorasVol Número de horas trabajadas por el voluntario.
	 */

	public void setNumHorasVol( int numHorasVol ) {
		this.numHorasVol = numHorasVol;
	}

	/**
	 * Obtiene el número de horas trabajadas como voluntario.
	 * @return Int con el número de horas trabajadas.
	 */

	@XmlElement(name = "NumHorasVoluntariado")
	public int getNumHorasVol() {
		return numHorasVol;
	}

	/**
	 * Método para introducir los datos de la persona.
	 */

	@Override
	public void introducirDatosPersona() {
		Scanner entrada = new Scanner( System.in );

		System.out.print( "Nombre: " );
		super.setNombre( entrada.nextLine() );
		System.out.print( "Primer apellido: " );
		super.setPrimerApellido( entrada.nextLine() );
		System.out.print( "Segundo apellido: " );
		super.setSegundoApellido( entrada.nextLine() );
		super.setDireccion(introducirDireccion());
		System.out.print( "Teléfono: " );
		super.setTelefono( entrada.nextLine() );
		System.out.print( "E-mail: " );
		super.setMail( entrada.nextLine() );
		System.out.print( "Número de horas de voluntariado: " );
		setNumHorasVol( entrada.nextInt() );
	}

	/**Método para introducir la dirección. Sobreescribe al de las superclases.
	 * @return un objeto Direccion.
	 */

	@Override
	public Direccion introducirDireccion() {
		Scanner entrada = new Scanner( System.in );
		Direccion direccion = new Direccion();
		TipoVia.introducirTipoVia(direccion);
		System.out.println( "Nombre de la vía: " );
		direccion.setNombreVia( entrada.nextLine() );
		System.out.println( "Número: " );
		direccion.setNumero( entrada.nextLine() );
		System.out.println( "Piso: " );
		direccion.setPiso( entrada.nextLine() );
		System.out.println( "Puerta: " );
		direccion.setPuerta( entrada.nextLine() );
		System.out.println( "Escalera: " );
		direccion.setEscalera( entrada.nextLine() );
		System.out.println( "Código postal: " );
		direccion.setCodPostal( entrada.nextLine() );
		Provincia.introducirProvincia(direccion);
		System.out.println( "Localidad: " );
		direccion.setLocalidad( entrada.nextLine() );

		return direccion;
	}

	/**
	 * Obtiene el id del voluntario.
	 * @return String con el id del voluntario.
	 */

	public String getIdVol() { return idVol; }

	/**
	 * Obtiene el idVolCount.
	 * @return Int con el idVolCount.
	 */

	public int getIdVolCount() { return idVolCount; }

	/**Devuelve la representación String de un objeto PerVoluntario.
	 * @return Representación String de un objeto PerVoluntario.
	 */

	@Override
	public String toString() {
		return String.format("Id de Empleado: %s\nNombre: %s %s, %s\nDirección: %s\nTeléfono: %s\nE-mail: %s"
				+ "\nTipo de empeado: empleado voluntario\nNúmero de horas de voluntariado: %d",
				super.getId(), super.getPrimerApellido(), super.getSegundoApellido(), super.getNombre(),
				super.getDireccion(), super.getTelefono(), super.getMail(), getNumHorasVol());
	}
}