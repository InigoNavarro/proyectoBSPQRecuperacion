package es.deusto.SPQ;

import es.deusto.SPQ.BD.Gestores.GestorJuego;
import es.deusto.SPQ.BD.Gestores.GestorReserva;
import es.deusto.SPQ.BD.Gestores.GestorSocio;
import es.deusto.SPQ.BD.Objetos.Juego;
import es.deusto.SPQ.BD.Objetos.Reserva;
import es.deusto.SPQ.BD.Objetos.Socio;


/**
 * Todos los datos de la BD (inicialmente, sin contar los insert que puede que se hagan al usar la app)
 * @author Ditto
 *
 */
public class CrearDatosBD {
	
	Juego J1 = new Juego("J001", "Transistor", 20, "Supergiant Games", 6000, true);
	Juego J2 = new Juego("J002", "Bastion", 20, "Supergiant Games", 2000, true);
	Juego J3 = new Juego("J003", "Pyre", 20, "Supergiant Games", 1500, true);
	Juego J4 = new Juego("J004", "Hades", 20, "Supergiant Games", 3000, true);
	Juego J5 = new Juego("J005", "Final Fantasy III", 12, "Square Enix", 2500, false);
	Juego J6 = new Juego("J006", "Final Fantasy IV", 12, "Squaresoft", 3000, true);
	Juego J7 = new Juego("J007", "Final Fantasy V", 15, "Squaresoft", 3500, false);
	Juego J8 = new Juego("J008", "Final Fantasy VI", 15, "Squaresoft", 4000, false);
	Juego J9 = new Juego("J009", "Final Fantasy XV", 30, "Square Enix", 500, true);
	Juego J10 = new Juego("J010", "Xenoblade Chronicle", 60, "Monolith Soft", 5999, true);
	Juego J11 = new Juego("J011", "Xenoblade Chronicles 2", 60, "Monolith Soft", 100, false);
	Juego J12 = new Juego("J012", "LEGO Stara Wars: The Complete Saga", 5, "TT Games", 5997, true);
	Juego J13 = new Juego("J013", "LEGO Star Wars III: The Clone Wars", 10, "TT Games", 4000, true);
	Juego J14 = new Juego("J014", "The Legend of Zelda: Breath of the  Wild", 60, "Nintendo", 2000, false);
	Juego J15 = new Juego("J015", "The Legend of Zelda: Ocarina of Time", 15, "Nintendo", 5996, true);
	Juego J16 = new Juego("J016", "The Legend of Zelda: Twilight Princess", 20, "Nintendo", 5998, false);
	Juego J17 = new Juego("J017", "The Legend of Zelda: Majoras Mask", 15, "Nintendo", 5995, true);
	Juego J18 = new Juego("J018", "Hollow Knight", 15, "Team Cherry", 5500, false);
	Juego J19 = new Juego("J019", "Katana Zero", 13, "Askiisoft", 4859, true);
	Juego J20 = new Juego("J020", "Left 4 Dead 2", 8, "Valve", 5800, false);
	
	Socio S1 = new Socio("S001", "Inigo Navarro", 500, "123445", 123454321, 20);
	Socio S2 = new Socio("S002", "Inigo Sanrro", 450, "123wqe", 111111111, 20);
	Socio S3 = new Socio("S003", "Unai Montim", 100, "1234rqd", 222222222, 21);
	Socio S4 = new Socio("S004", "Lopa Mopa", 125, "12345dwsa", 222222223, 21);
	Socio S5 = new Socio("S005", "Ismo Urrutia", 150, "1245gag", 333333333, 19);
	Socio S6 = new Socio("S006", "Gomi el Gomas", 300, "168ff", 333333334, 20);
	Socio S7 = new Socio("S007", "Romo Zabala", 350, "156uhasd", 444444444, 20);
	Socio S8 = new Socio("S008", "Alejandria Canadiense", 250, "qdeq2e", 444444445, 21);
	Socio S9 = new Socio("S009", "Billy Joel", 140, "wdaf", 555555555, 71);
	Socio S10 = new Socio("S010", "Bon Jovi", 180, "dasfag", 555555556, 58);
			
	Reserva R1 = new Reserva("R001", "J001", "S001", "Transistor", "Inigo Navarro");
	Reserva R2 = new Reserva("R002", "J010", "S001", "Xenoblade Chronicles", "Inigo Navarro");
	Reserva R3 = new Reserva("R003", "J016", "S001", "The Legend of Zelda: Twilight Princess", "Inigo Navarro");
	Reserva R4 = new Reserva("R004", "J012", "S001", "LEGO Stara Wars: The Complete Saga", "Inigo Navarro");
	Reserva R5 = new Reserva("R005", "J005", "S002", "Final Fantasy III", "Inigo Sanrro");
	Reserva R6 = new Reserva("R006", "J008", "S002", "Final Fantasy VI", "Inigo Sanrro");
	Reserva R7 = new Reserva("R007", "J018", "S002", "Hollow Knight", "Inigo Sanrro");
	Reserva R8 = new Reserva("R008", "J019", "S006", "Katana Zero", "Gomi el Gomas");
	Reserva R9 = new Reserva("R009", "J020", "S007", "Left 4 Dead 2", "Romo Zabala");
	Reserva R10 = new Reserva("R010", "J015", "S007", "The Legend of Zelda: Ocarina of Time", "Romo Zabala");
	
	public void cargarBase() {
		GestorJuego.storeJuego(J1);
		GestorSocio.storeSocio(S1);
		GestorReserva.storeReserva(R1);
	}
	
	public Juego obtenerJuego() {
		return J1;
	}
	
	public Socio obtenerSocio() {
		return S1;
	}
	
	public Reserva obtenerReserva() {
		return R1;
	}
}
