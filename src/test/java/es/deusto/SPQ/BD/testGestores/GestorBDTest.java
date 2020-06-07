package es.deusto.SPQ.BD.testGestores;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;

import es.deusto.SPQ.BD.Gestores.GestorBD;
import es.deusto.SPQ.BD.Gestores.GestorJuego;
import es.deusto.SPQ.BD.Objetos.Juego;


class GestorBDTest {

	@Rule
	public JUnitPerfRule perfTestRule = new JUnitPerfRule();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void getInstance() {
		assertNotNull(GestorBD.getInstance());
	}

	@JUnitPerfTest(threads = 1,
            durationMs = 1_000,
            rampUpPeriodMs = 200,
            warmUpMs = 200,
            maxExecutionsPerSecond = 11_000)
	@Test
	public void storeTest() {
		Juego j = new Juego("J001", "A", 13, "B", 12, true);
		GestorBD.getInstance().storeObjectInDB(j);
		Juego j2 = GestorJuego.selectJuego("A");
		assertEquals(j.getNombreJuego(), j2.getNombreJuego());
	}
	
	@JUnitPerfTest(threads = 1,
            durationMs = 1_000,
            rampUpPeriodMs = 200,
            warmUpMs = 200,
            maxExecutionsPerSecond = 11_000)
	@Test
	public void selectListaTest() {
		List<Juego> listaJuego;
		listaJuego = GestorBD.getInstance().selectListaObjectos(Juego.class);
		assertNotEquals(0, listaJuego.size());
	}
}
