package es.deusto.SPQ.BD.testGestores;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.deusto.SPQ.CrearDatosBD;
import es.deusto.SPQ.BD.Gestores.GestorSocio;
import es.deusto.SPQ.BD.Objetos.Socio;

class GestorSocioTest {

	@BeforeEach
	void setUp() throws Exception {
		CrearDatosBD cdBD = new CrearDatosBD();
		cdBD.cargarBase();
	}

	@Test
	void conseguirTodosLosSociosTest() {
		List<Socio> lista;
		lista = GestorSocio.getTodosSocios();
		assertNotEquals(0, lista.size());
	}


	@Test
	void actualizarUnSocio() {
		GestorSocio.updateSocio("SS", 13, "ABA", 123, "Inigo Navarro");
		assertEquals("SS", GestorSocio.selectSocio("SS").getNombreApellido());
	}

	@Test
	void borrarUnSocio() {
		GestorSocio.borrarSocio("SS");
		assertNull(GestorSocio.selectSocio("SS"));
	}

	@Test
	void anyadirUnSocio() {
		Socio s = new Socio("S1", "SS", 13, "ABA", 123);
		GestorSocio.storeSocio(s);
		assertEquals("SS", GestorSocio.selectSocio("SS").getNombreApellido());
	}



}
