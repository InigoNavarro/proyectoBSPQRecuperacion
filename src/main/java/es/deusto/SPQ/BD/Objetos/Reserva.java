package es.deusto.SPQ.BD.Objetos;
import javax.jdo.annotations.*;

@PersistenceCapable
public class Reserva {
	@PrimaryKey
	@Column(name = "reserva_ID")
	private String reservaId;

	@Persistent
	private String juegoID;
	@Persistent
	private String socioID;
	@Persistent
	private String juegoNombre;
	@Persistent
	private String socioNombreApellido;

	/**
	 * Constructor de un objeto reserva
	 * @param reservaId el codigo de la clase reserva
	 * @param juegoID el juego reservado
	 * @param socioID el socio que lo a reservado
	 * @param juegoNombre el nombre del juego reservado
	 * @param socioNombreApellido el nombre del socio que a reservado
	 */
	public Reserva(String reservaId, String juegoID, String socioID, String juegoNombre, String socioNombreApellido) {
		super();
		this.reservaId = reservaId;
		this.juegoID = juegoID;
		this.socioID = socioID;
		this.juegoNombre = juegoNombre;
		this.socioNombreApellido = socioNombreApellido;
	}

	/**
	 * Constructor vacio
	 */
	public Reserva() {
		super();
	}

	/**
	 * Metodo para obtener el id de una reserva
	 * @return ese id de la reserva
	 */
	public String getReservaId() {
		return reservaId;}

	/**
	 * Cambiar el id de una reserva
	 * @param reservaId el id al que se quiere cambiar
	 */
	public void setReservaId(String reservaId) {
		this.reservaId = reservaId;}

	/**
	 * Metodo para obtener el id del juego reservado
	 * @return ese id del juego 
	 */
	public String getJuegoID() {
		return juegoID;}

	/**
	 * Cambiar el id de u juego reservado
	 * @param juegoID el id al que se quiere cambiar
	 */
	public void setJuegoID(String juegoID) {
		this.juegoID = juegoID;}

	/**
	 * Metodo para obtener el id del socio que a reservado
	 * @return ese id del socio
	 */
	public String getSocioID() {
		return socioID;}

	/**
	 * Cambiar el id del socio que a reservado
	 * @param socioID el id al que se quiere cambiar
	 */
	public void setSocioID(String socioID) {
		this.socioID = socioID;}

	/**
	 * Metodo para obtener el nombre del juego reservado
	 * @return ese nombre del juego
	 */
	public String getJuegoNombre() {
		return juegoNombre;}

	/**
	 * Cambiar el nombre del juego que se a reservado
	 * @param juegoNombre el nombre al que se quiere cambiar
	 */
	public void setJuegoNombre(String juegoNombre) {
		this.juegoNombre = juegoNombre;}

	/**
	 * Metodo para obtener el nombre del socio que a reservado
	 * @return ese nombre del socio
	 */
	public String getSocioNombreApellido() {
		return socioNombreApellido;}

	/**
	 * Cambiar el nombre del socio que a reservado
	 * @param socioNombreApellido el nombre al que se quiere cambiar
	 */
	public void setSocioNombreApellido(String socioNombreApellido) {
		this.socioNombreApellido = socioNombreApellido;}

	/**
	 * To string de la clase reserva
	 */
  @Override
  public String toString() {
    return "La reserva "+ reservaId+ " es del juego "+ juegoNombre+ " y la ha realizado el socio " + socioNombreApellido;
  }
}