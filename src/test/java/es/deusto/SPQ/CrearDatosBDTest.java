package es.deusto.SPQ;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import es.deusto.SPQ.BD.Objetos.Juego;
import es.deusto.SPQ.BD.Objetos.Reserva;
import es.deusto.SPQ.BD.Objetos.Socio;

/**
 * Test para probar la creacion de datos, al no tener la bd configurada todavia no se a testeado el guardar los datos
 * @author Ditto
 *
 */
class CrearDatosBDTest {

	CrearDatosBD cdBD = new CrearDatosBD();

	/**
	 * Test que comprueba que el metodo obtener juego usando los getters y setters ya testeados.
	 */
	@Test
	void obtenerJuegoTest() { 
		Juego JTest = cdBD.obtenerJuego();
		assertEquals("J001", JTest.getId());
		assertEquals("Transistor", JTest.getNombreJuego());
		assertEquals(20, JTest.getPrecio());
		assertEquals("Supergiant Games", JTest.getEmpresa());
		assertEquals(6000, JTest.getNumVendidos());
		assertTrue(JTest.isCopiasDisp());
	}
	
	/**
	 * Test que comprueba que el metodo obtener socio usando los getters y setters ya testeados.
	 */
	@Test
	void obtenerSocioTest() {
		Socio STest = cdBD.obtenerSocio();
		assertEquals("S001", STest.getSocioId());
		assertEquals("Inigo Navarro", STest.getNombreApellido());
		assertEquals(500, STest.getPts());
		assertEquals("123445", STest.getDireccion());
		assertEquals(123454321, STest.getTelefono());
		assertEquals(20, STest.getEdad());
	}
	
	/**
	 * Test que comprueba que el metodo obtener reserva usando los getters y setters ya testeados.
	 */
	@Test
	void obtenerReservaTest() {
		Reserva RTest = cdBD.obtenerReserva();
		assertEquals("R001", RTest.getReservaId());
		assertEquals("J001", RTest.getJuegoID());
		assertEquals("S001", RTest.getSocioID());
		assertEquals("Transistor", RTest.getJuegoNombre());
		assertEquals("Inigo Navarro", RTest.getSocioNombreApellido());
	}
}
