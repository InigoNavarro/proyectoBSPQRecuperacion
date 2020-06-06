package es.deusto.SPQ.BD.testGestores;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.deusto.SPQ.CrearDatosBD;
import es.deusto.SPQ.BD.Gestores.GestorBD;
import es.deusto.SPQ.BD.Gestores.GestorJuego;
import es.deusto.SPQ.BD.Objetos.Juego;


class GestorBDTest {

	@BeforeEach
	void setUp() throws Exception {
		CrearDatosBD cdbd = new CrearDatosBD();
		cdbd.cargarBase();
	}

	@Test
	public void getInstance() {
		assertNotNull(GestorBD.getInstance());
	}

	@Test
	public void storeTest() {
		Juego j = new Juego("J001", "A", 13, "B", 12, true);
		GestorBD.getInstance().storeObjectInDB(j);
		Juego j2 = GestorJuego.selectJuego("A");
		assertEquals(j.getNombreJuego(), j2.getNombreJuego());
	}
	
	@Test
	public void selectListaTest() {
		List<Juego> listaJuego;
		listaJuego = GestorBD.getInstance().selectListaObjectos(Juego.class);
		assertNotEquals(0, listaJuego.size());
	}
}
