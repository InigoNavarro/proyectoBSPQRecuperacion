package es.deusto.SPQ.BD.Gestores;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import es.deusto.SPQ.BD.Objetos.Reserva;

/**
 * Gestor que controla la clase Reservas de la BD
 * @author Ditto
 *
 */
public class GestorReserva {

	/**
	 * Se obtienen todos los objetos Reserva
	 * @return la lista de reservas
	 */
	public static List<Reserva> getTodasReservas() {
		return GestorBD.getInstance().selectListaObjectos(Reserva.class);
	}

	/**
	 * Seleccionar una reserva basandose en el juego reservado y el socio que lo ha reservado
	 * @param juegoNombre el nombre del juego reservado
	 * @param socioNombreApellido el nombre y apellido del socio que ha hecho la reserva
	 * @return la reserva que se ha encontrado
	 */
	public static Reserva selectJuego(String juegoNombre, String socioNombreApellido) {
		PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
		Transaction transaction = null;
		transaction = pm.currentTransaction();
		try {
			transaction.begin();
			Query<Reserva> q = pm.newQuery(Reserva.class);
			q.setFilter("juegoNombre  == :juegoNombre");
			q.setFilter("socioNombreApellido == :socioNombreApellido");
			q.setParameters(juegoNombre);
			q.setParameters(socioNombreApellido);
			Reserva res = q.executeUnique();
			transaction.commit();
			return res;

		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			pm.close();
		}
	}
}

