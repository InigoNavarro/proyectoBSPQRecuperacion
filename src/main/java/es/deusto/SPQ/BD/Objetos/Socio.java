package es.deusto.SPQ.BD.Objetos;

import javax.jdo.annotations.*;

/**
 * La clase socio de la BD
 * @author Ditto
 *
 */
@PersistenceCapable
public class Socio extends DataObject<Socio> {
	@PrimaryKey
	@Persistent
	@Column(name = "socio_ID")
	private String socioId;

	@Persistent
	private String nombreApellido;
	@Persistent
	private int pts;
	@Persistent
	private String direccion;
	@Persistent
	private int telefono;

	/**
	 * Constructor completo de un objeto Socio
	 * @param socioId la clave de un socio
	 * @param nombreApellido	el nombre y apellido de un socio
	 * @param pts	numero de puntos guardados
	 * @param direccion la direccion de un socio
	 * @param telefono el telefono de un socio
	 */
	public Socio(String socioId, String nombreApellido, int pts, String direccion, int telefono) {
		super();
		this.socioId = socioId;
		this.nombreApellido = nombreApellido;
		this.pts = pts;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	/**
	 * Constructor vacio
	 */
	public Socio(){super();}

	/**
	 * Metodo para obtener el id de un socio
	 * @return ese id del socio
	 */
	public String getSocioId() {
		return socioId;}

	/**
	 * Cambiar el id de un socio
	 * @param socioId el id al que se quiere cambiar
	 */
	public void setSocioId(String socioId) {
		this.socioId = socioId;}

	/**
	 * Metodo para obtener el nombre y apellido de un socio
	 * @return ese nombre y apellido del socio
	 */
	public String getNombreApellido() {
		return nombreApellido;}

	/**
	 * Cambiar el nombre y apellido de un socio
	 * @param nombreApellido el nombre y apellido al que se quiere cambiar
	 */
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;}

	/**
	 * Metodo para obtener los puntos que tiene un socio
	 * @return los puntos del socio
	 */
	public int getPts() {
		return pts;}

	/**
	 * Cambiar los puntos de un socio
	 * @param pts los puntos a los que se quiere cambiar
	 */
	public void setPts(int pts) {
		this.pts = pts;}

	/**
	 * Metodo para obtener la direccion de un socio
	 * @return esa direccion del socio
	 */
	public String getDireccion() {
		return direccion;}

	/**
	 * Cambiar la direccion de un socio
	 * @param direccion la direccion a la que se quiere cambiar
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;}

	/**
	 * Metodo para obtener el telefono de un socio
	 * @return ese telefono del socio
	 */
	public int getTelefono() {
		return telefono;}

	/**
	 * Cambiar el telefono de un socio
	 * @param telefono el telefono al que se quiere cambiar
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;}

	/**
	 * To string de la clase socio
	 */
	@Override
	public String toString() {
		return "El socio "+ socioId + " se llama "+ nombreApellido+ ", tiene "+ pts+ " puntos, su direccion es "+ direccion
				+ ", su telefono es "+ telefono+ ".";
	}
}
