package es.deusto.SPQ.BD.testObjetos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import es.deusto.SPQ.BD.Objetos.Juego;

/**
 * JUnit que se centrar en comprobar el funcionamiento correcto de los getter y setters del objeto Juego
 * @author Ditto
 *
 */
class JuegoTest {
	Juego J1Test = new Juego("J001", "Transistor", 20, "Supergiant Games", 6000, true);

	/**
	 * Metodo que comprueba que el get y set de nombre funcione
	 */
	@Test
	void setGetterNombre() {
		assertEquals("Transistor", J1Test.getNombreJuego());
		J1Test.setNombreJuego("Bastion");
		assertEquals("Bastion", J1Test.getNombreJuego());
	}

	/**
	 * Metodo que comprueba que el get y set de precio funcione
	 */
	@Test
	void setGetterPrecio() {
		assertEquals(20, J1Test.getPrecio());
		J1Test.setPrecio(10);
		assertEquals(10, J1Test.getPrecio());
	}
	
	/**
	 * Metodo que comprueba que el get y set de la compania funcione
	 */
	@Test
	void setGetterCompania() {
		assertEquals("Supergiant Games", J1Test.getEmpresa());
		J1Test.setEmpresa("Nintendo");
		assertEquals("Nintendo", J1Test.getEmpresa());
	}
	
	/**
	 * Metodo que comprueba que el get y set de numero de ventas funcione
	 */
	@Test
	void setGetterVentas() {
		assertEquals(6000, J1Test.getNumVendidos());
		J1Test.setNumVendidos(1000000);
		assertEquals(1000000, J1Test.getNumVendidos());
		J1Test.setNumVendidos(6000);
	}
	
	/**
	 * Metodo que comprueba que el is y set de la disponibilidad funciona
	 */
	@Test
	void setGetterDisp() {
		assertEquals(true, J1Test.isCopiasDisp());
		J1Test.setCopiasDisp(false);
		assertEquals(false, J1Test.isCopiasDisp());
	}
	
	/**
	 * Metodo que comprueba el metodo comprar de la clase juego.
	 */
	@Test
	void compra() {
		J1Test.comprar();
		assertEquals(6001, J1Test.getNumVendidos());
	}
	
}
