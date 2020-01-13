package ong.entreculturas;

import java.util.Scanner;
import ong.entreculturas.Direccion;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * La clase PerVolInternacional es subclase directa de la clase
 * PerVoluntario.
 * Representa a un empleado voluntario internacional.
 *
 * @author Aware Developers
 * @version 1.4
 */

@XmlRootElement(name = "TipoVol")
public class PerVolInternacional extends PerVoluntario {

	private String idVolInt = "VI";
	private static int idVolIntCount = 1;
	private String paisOrigen;
	private String sDireccion;	// sobreescribe al campo de la superclase Persona
	private String codInternaTelefono;

	/**
	 * Constructor de PerVolInternacional sin argumentos
	 */

	public PerVolInternacional() {

		super();
		super.crearId(idVolInt, idVolIntCount);
		idVolIntCount++;

	} // fin del Constructor de PerVolInternacional sin argumentos

	/** Constructor de PerVolInternacional
	 *
	 *  @param nombre Nombre de la persona (se pasa al constructor de la superclase)
	 *  @param primerApellido Primer apellido de la persona (se pasa al constructor de la superclase)
	 *	@param segundoApellido Segundo apellido de la persona (se pasa al constructor de la superclase)
	 *	@param direccion Dirección de la persona (se pasa al constructor de la superclase)
	 *	@param telefono Teléfono de la persona (se pasa al constructor de la superclase)
	 *	@param mail Correo electrónico de la persona (se pasa al constructor de la superclase)
	 *	@param numHorasVol Número de horas trabajadas por el voluntario
	 *	@param paisOrigen País de origen del voluntario internacional
	 *	@param sDireccion Dirección internacional (sobreescribe al campo direccion de Persona)
	 *	@param codInternaTelefono Código (prefijo) internacional del teléfono
	 */

	public PerVolInternacional( String nombre, String primerApellido, String segundoApellido,
								Direccion direccion, String telefono, String mail, int numHorasVol,
								String paisOrigen, String sDireccion, String codInternaTelefono ) {

		super( nombre, primerApellido, segundoApellido, direccion, telefono, mail, numHorasVol );

		super.crearId(idVolInt, idVolIntCount);
		idVolIntCount++;
		this.paisOrigen = paisOrigen;
		this.sDireccion = sDireccion;
		this.codInternaTelefono = codInternaTelefono;

	}

	/**
	 *  Establece el pais de origen
	 *	@param paisOrigen País de origen del voluntario internacional
	 */

	public void setPaisOrigen( String paisOrigen ) {
		this.paisOrigen = paisOrigen;
	}

	/**
	 * Obtiene el pais de origen
	 * @return String con el país de origen del voluntario internacional
	 */

	public String getPaisOrigen() {
		return paisOrigen;
	}

	/**
	 * Establece la dirección (sobreescribe al campo de la superclase Persona)
	 * @param direccion Dirección internacional (sobreescribe al campo direccion de Persona)
	 */

	public void setDir( String direccion ) {
		this.sDireccion = direccion;
	}

	/**
	 * Obtiene la dirección (sobreescrita)
	 * @return String con la nueva dirección
	 */

	public String getDir() {
		return sDireccion;
	}

	/**
	 * Establece el código internacional del teléfono
	 * @param codInternaTelefono Código (prefijo) internacional del teléfono
	 */

	public void setCodInternaTelefono( String codInternaTelefono ) {
		this.codInternaTelefono = codInternaTelefono;

	}

	/**
	 * Obtiene el código internacional del teléfono
	 * @return String con el código (prefijo) internacional del teléfono
	 */

	public String getCodInternaTelefono() {

		return codInternaTelefono;

	}

	/**
	 *  Método para introducir los datos de la persona.
	 *  Es el método abstracto de las superclases, que aquí sí se implementa.
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
		setDatosPerVolInternacional();
		System.out.print( "Teléfono: " );
		super.setTelefono( entrada.nextLine() );
		System.out.print( "E-mail: " );
		super.setMail( entrada.nextLine() );
		System.out.print( "Número de horas de voluntariado: " );
		setNumHorasVol( entrada.nextInt() );

	}

	/** Método para establecer los datos específicos de un personal voluntario internacional
	 *
	 */

	public void setDatosPerVolInternacional() {

		Scanner entrada = new Scanner(System.in);

		System.out.print( "Dirección: " );
		setDir( entrada.nextLine() );
		System.out.print( "País: " );
		setPaisOrigen( entrada.nextLine() );
		System.out.print( "Prefijo telefónico internacional: " );
		setCodInternaTelefono( entrada.nextLine() );

	}

	/**
	 * Devuelve la representación String de un objeto PerVolInternacional
	 * NOTA: debería mostrar el campo teléfono con el código internacional
	 * y la dirección actualizada
	 *
	 * @return La representación String de un objeto PerVolInternacional
	 */

	public String toString() {
		return String.format("Id de Empleado: %s\nNombre: %s %s, %s\nDirección: %s\nPaís: " +
						"\nTeléfono: %s %s\nE-mail: %s\nTipo de empeado: empleado voluntario" +
						"\nNúmero de horas de voluntariado: %d",
				super.getId(), super.getPrimerApellido(), super.getSegundoApellido(), super.getNombre(),
				getDir(), getPaisOrigen(), getCodInternaTelefono(), super.getTelefono(),
				super.getMail(), getNumHorasVol());
	}

}