package es.deusto.SPQ.BD.testGestores;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.deusto.SPQ.BD.Gestores.GestorSocio;
import es.deusto.SPQ.BD.Objetos.Socio;

class GestorSocioTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void conseguirTodosLosSociosTest() {
		List<Socio> lista;
		lista = GestorSocio.getTodosSocios();
		assertNotEquals(0, lista.size());
	}


	@Test
	void actualizarUnSocio() {
		Socio s = new Socio("S2", "SSSSSSS", 13, "ABA", 123);
		GestorSocio.storeSocio(s);
		GestorSocio.updateSocio("SSSSSSS2", 13, "ABA", 123, "SSSSSSS");
		assertEquals("SSSSSSS2", GestorSocio.selectSocio("SSSSSSS2").getNombreApellido());
	}

	@Test
	void borrarUnSocio() {
		GestorSocio.borrarSocio("SSSSSSS2");
		assertNull(GestorSocio.selectSocio("SSSSSSS2"));
	}

	@Test
	void anyadirUnSocio() {
		Socio s = new Socio("S1", "SS", 13, "ABA", 123);
		GestorSocio.storeSocio(s);
		assertEquals("SS", GestorSocio.selectSocio("SS").getNombreApellido());
	}



}
