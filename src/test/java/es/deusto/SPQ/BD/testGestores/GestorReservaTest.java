package es.deusto.SPQ.BD.testGestores;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.deusto.SPQ.BD.Gestores.GestorReserva;
import es.deusto.SPQ.BD.Objetos.Reserva;

class GestorReservaTest {

	@BeforeEach
	void setUp() throws Exception {
			}

	@Test
	void testTodasLasReservas() {
		List<Reserva> lista;
		lista = GestorReserva.getTodasReservas();
		assertNotEquals(0, lista.size());
	}
	
	@Test
	void testGuardarReserva() {
		Reserva r = new Reserva("R", "J", "S", "JJ", "SS");
		GestorReserva.storeReserva(r);
		assertEquals("JJ", GestorReserva.selectReserva("SS", "JJ").getJuegoNombre());
	}
}
