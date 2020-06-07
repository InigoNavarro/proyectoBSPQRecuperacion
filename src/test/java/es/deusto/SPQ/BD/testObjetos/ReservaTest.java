package es.deusto.SPQ.BD.testObjetos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import es.deusto.SPQ.BD.Objetos.Reserva;

/**
 * JUnit que se centrar en comprobar el funcionamiento correcto de los getter y setters del objeto Reserva
 * @author Ditto
 *
 */
class ReservaTest {


	@Before
	public void setUp() {}

	//	@Test
	//	void reservaTest() {
	//		
	//		Mockito.when(r.getJuegoNombre()).thenReturn("Transistor");
	//		Mockito.when(r.getSocioNombreApellido()).thenReturn("Inigo Navarro");
	//
	//		assertEquals("Transistor", r.getJuegoNombre());
	//		assertEquals("Inigo Navarro", r.getSocioNombreApellido());
	//	}



	Reserva R1Test = new Reserva("R", "J", "S", "JN", "SNA");

	/**
	 * Metodo que comprueba que el get y set de id de juego funcione
	 */
	@Test
	void setGetterJuegoID() {
		assertEquals("J", R1Test.getJuegoID());
		R1Test.setJuegoID("J2");
		assertEquals("J2", R1Test.getJuegoID());
	}

	/**
	 * Metodo que comprueba que el get y set de nombre de juego funcione
	 */
	@Test
	void setGetterNombreJuego() {
		assertEquals("JN", R1Test.getJuegoNombre());
		R1Test.setJuegoNombre("JN2");
		assertEquals("JN2", R1Test.getJuegoNombre());
	}

	/**
	 * Metodo que comprueba que el get y set del id de socio funcione
	 */
	@Test
	void setGetterSocioID() {
		assertEquals("S", R1Test.getSocioID());
		R1Test.setSocioID("S2");
		assertEquals("S2", R1Test.getSocioID());
	}

	/**
	 * Metodo que comprueba que el get y set de numero del nombre apellido del socio funcione
	 */
	@Test
	void setGetterVentas() {
		assertEquals("SNA", R1Test.getSocioNombreApellido());
		R1Test.setSocioNombreApellido("SNA2");
		assertEquals("SNA2", R1Test.getSocioNombreApellido());
	}
}