package es.deusto.SPQ.BD.Gestores;

import java.util.List;
import java.util.logging.Level;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import es.deusto.SPQ.BD.Objetos.Reserva;
public class GestorReserva extends GestorBD {

	private static PersistenceManagerFactory pmf = null;
	private static PersistenceManager pm = null;

	public static void storeReserva(Reserva r) {
		GestorBD.getInstance();
		GestorBD.getInstance().storeObjectInDB(r);
	}

	public static List<Reserva> getTodasReservas() {
		GestorBD.getInstance();
		return GestorBD.getInstance().selectListaObjectos(Reserva.class);
	}

	public static Reserva selectReserva(String socioNombreApellido, String juegoNombre) {
		PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
		Transaction transaction = null;
		transaction = pm.currentTransaction();
		try {
			transaction.begin();
			Query<Reserva> q = pm.newQuery(Reserva.class);
			q.setFilter("socioNombreApellido == :socioNombreApellido && juegoNombre == :juegoNombre");
			q.setParameters(socioNombreApellido, juegoNombre);
			Reserva res1 = q.executeUnique();
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