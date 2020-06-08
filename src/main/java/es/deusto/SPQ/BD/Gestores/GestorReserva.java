package es.deusto.SPQ.BD.Gestores;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import es.deusto.SPQ.BD.Objetos.Reserva;

/**
 * El gestor de la clase reserva
 * @author Ditto
 *
 */
public class GestorReserva extends GestorBD {

	private static PersistenceManagerFactory pmf = null;
	private static PersistenceManager pm = null;

	/**
	 * Metodo para guardar una reserva
	 * @param r la reserva que se quiere guardar
	 */
	public static void storeReserva(Reserva r) {
		GestorBD.getInstance();
		GestorBD.getInstance().storeObjectInDB(r);
	}

	/**
	 * Metodo con el que se obtiene toda la lista de reservas
	 * @return toda la lista de reservas
	 */
	public static List<Reserva> getTodasReservas() {
		GestorBD.getInstance();
		return GestorBD.getInstance().selectListaObjectos(Reserva.class);
	}

	/**
	 * Obtener una sola reserva de un cliente
	 * @param socioNombreApellido El socio al que esta asignado esa reserva
	 * @return la reserva a obtener
	 */ 
	public static Reserva selectReserva(String socioNombreApellido) {
		pm = GestorBD.getPMF().getPersistenceManager();
		Transaction transaction = null;
		transaction = pm.currentTransaction();
		try {
			transaction.begin();
			Query<Reserva> q = pm.newQuery(Reserva.class);
			q.setFilter("socioNombreApellido == :socioNombreApellido");
			q.setParameters(socioNombreApellido);
			Reserva res1 = q.executeUnique();
//			pm.flush();
			transaction.commit();
			return res1;

		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			pm.close();
		}
	}
	
	/**
	 * Obtener todas las reservas de un cliente
	 * @param socioNombreApellido El socio al que estan asignadas esas reservas
	 * @return la reserva a obtener
	 */ 
	public static List<Reserva> selectReservas(String socioNombreApellido) {
		pm = GestorBD.getPMF().getPersistenceManager();
		Transaction transaction = null;
		transaction = pm.currentTransaction();
		try {
			transaction.begin();
			Query<Reserva> q = pm.newQuery(Reserva.class);
			q.setFilter("socioNombreApellido == :socioNombreApellido");
			q.setParameters(socioNombreApellido);
			List<Reserva> res1 = q.executeList();
//			pm.flush();
			transaction.commit();
			return res1;

		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			pm.close();
		}
	}
}