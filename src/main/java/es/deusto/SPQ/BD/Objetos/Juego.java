package es.deusto.SPQ.BD.Objetos;

import javax.jdo.annotations.*;

/**
 * La clase Juego de la BD
 * @author Ditto
 *
 */
@PersistenceCapable
public class Juego{

	@PrimaryKey
	@Persistent
	@Column(name = "juego_ID")
	private String juegoId;

	@Persistent
	private String nombreJuego;
	@Persistent
	private float precio;
	@Persistent
	private String empresa;
	@Persistent
	private int numVendidos;
	@Persistent
	private boolean copiasDisp;

	/**
	 * Metodo para obtener el id de un juego
	 * @return ese id del juego
	 */
	public String getId() {
		return juegoId;}

	/**
	 * Cambiar el id de un juego
	 * @param id el id al que se quiere cambiar
	 */
	public void setId(String id) {
		this.juegoId = id;}

	/**
	 * Metodo para obtener el nombre de un juego
	 * @return ese nombre del juego
	 */
	public String getNombreJuego() {
		return nombreJuego;}

	/**
	 * Cambiar el nombre del juego
	 * @param nombreJuego el nombre al que se quiere cambiar
	 */
	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;}

	/**
	 * Metodo para obtener el precio de un juego
	 * @return ese precio del juego
	 */
	public float getPrecio() {
		return precio;}

	/**
	 * Cambiar el precio de un juego
	 * @param precio el precio al que se quiere cambiar
	 */
	public void setPrecio(float precio) {
		this.precio = precio;}

	/**
	 * Metodo para obtener la empresa creadora de un juego
	 * @return la empresa creadora del juego
	 */
	public String getEmpresa() {
		return empresa;}

	/**
	 * Cambiar la empresa creadora de un juego
	 * @param empresa la empresa al que se quiere cambiar
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;}

	/**
	 * Metodo para obtener el numero de ventas de un juego
	 * @return el numero de ventas del juego
	 */
	public int getNumVendidos() {
		return numVendidos;}

	/**
	 * Cambiar el numero de ventas de un juego
	 * @param numVendidos el numero de ventas al que se quiere cambiar
	 */
	public void setNumVendidos(int numVendidos) {
		this.numVendidos = numVendidos;}

	/**
	 * Metodo para ver si el juego esta disponible en el almacen
	 * @return disponibilididad del juego
	 */
	public boolean isCopiasDisp() {
		return copiasDisp;}

	/**
	 * Cambiar la disponibilidad de un juego
	 * @param copiasDisp la disponibilidad a la que se quiere cambiar
	 */
	public void setCopiasDisp(boolean copiasDisp) {
		this.copiasDisp = copiasDisp;}

	/**
	 * Constructor del objeto juego
	 * @param juegoId Objeto clave de la clase
	 * @param nombreJuego	el nombre del juego
	 * @param precio	el precio del juego
	 * @param empresa	el nombre de la empresa
	 * @param numVendidos	el numero de ventas 
	 * @param copiasDisp	la disponibilidad del juego
	 */
	public Juego(String juegoId, String nombreJuego, float precio, String empresa, int numVendidos, boolean copiasDisp) {
		super();
		this.juegoId = juegoId;
		this.nombreJuego = nombreJuego;
		this.precio = precio;
		this.empresa = empresa;
		this.numVendidos = numVendidos;
		this.copiasDisp = copiasDisp;
	}

	/**
	 * Constructor vacio
	 */
	public Juego() {
		super();
	}
	
	/**
	 * Metodo que aumenta en uno los numeros vendidos
	 */
	public void comprar() {
		this.numVendidos += 1;
	}

	/**
	 * To string de la clase juegos.
	 */
	@Override
	public String toString() {
		return "El Juego: " + juegoId + "es el " + nombreJuego + ", cuesta "+ precio+ "�, lo hizo la empresa "+ empresa+ ", se han vendido "
				+ numVendidos+ " y, ahora mismo, su disponibilidad en tienda es "+ copiasDisp;
	}
}
