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
@RunWith(MockitoJUnitRunner.class)
class SocioTest {

	@Mock
	Socio s;

	@Before
	public void setUp() {	
		MockitoAnnotations.initMocks(this.getClass());
	}

	@Test
	void socioTest() {
		Mockito.when(s.getNombreApellido()).thenReturn("Inigo Navarro");
		Mockito.when(s.getPts()).thenReturn(500);
		Mockito.when(s.getDireccion()).thenReturn("123445");
		Mockito.when(s.getTelefono()).thenReturn(123454321);
		Mockito.when(s.getEdad()).thenReturn(20);

		assertEquals("Inigo Navarro", s.getNombreApellido());
		assertEquals(500, s.getPts());
		assertEquals("123445", s.getDireccion());
		assertEquals(123454321, s.getTelefono());
		assertEquals(20, s.getEdad());
	}
}
