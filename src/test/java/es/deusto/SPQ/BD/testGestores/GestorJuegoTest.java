package es.deusto.SPQ.BD.testGestores;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.deusto.SPQ.BD.Gestores.GestorJuego;
import es.deusto.SPQ.BD.Objetos.Juego;

class GestorJuegoTest {

  @BeforeEach
  void setUp() throws Exception {
  }

  @Test
  void obtenerTodosLosJuegos() {
	  List<Juego> lista;
	  lista = GestorJuego.getTodosJuegos();
	  assertNotEquals(0, lista.size());
  }
  
  @Test
  void obtenerUnJuego() {
	  assertEquals("Pyre", GestorJuego.selectJuego("Pyre").getNombreJuego());
  }
  
  @Test
  void eliminarUnJuego() {
	  GestorJuego.borrarJuego("Transistor");
	  assertNull(GestorJuego.selectJuego("Transistor"));  
  }
  
  @Test
  void actualizarUnJuego() {
	  GestorJuego.updateJuego("Pyre", 10, "ERP", 32, true, "Pyre");
	  assertEquals(10, GestorJuego.selectJuego("Pyre").getPrecio());  
  }
}
