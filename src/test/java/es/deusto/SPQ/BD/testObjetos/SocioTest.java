package es.deusto.SPQ.BD.testObjetos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import es.deusto.SPQ.BD.Objetos.Socio;

/**
 * Clase que prueba los metodos de los objetos Socios usando mockito
 * @author Ditto
 *
 */
class SocioTest {

	@Before
	public void setUp() {	
		
	}

	@Test
	void socioGetTest() {
		Socio s = new Socio("S", "SS", 35, "ABAV", 12345);
		assertEquals("SS", s.getNombreApellido());
		assertEquals(35, s.getPts());
		assertEquals("ABAV", s.getDireccion());
		assertEquals(12345, s.getTelefono());
	}
	
	@Test
	void socioSetTest() {
		Socio s = new Socio("S", "SS", 35, "ABAV", 12345);
		s.setNombreApellido("S2");
		s.setDireccion("ADC");
		s.setPts(40);
		s.setTelefono(148);
		assertEquals("S2", s.getNombreApellido());
		assertEquals(40, s.getPts());
		assertEquals("ADC", s.getDireccion());
		assertEquals(148, s.getTelefono());
	}
}
