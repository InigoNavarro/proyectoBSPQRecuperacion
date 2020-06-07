package es.deusto.SPQ.BD.Gestores;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.SPQ.BD.Objetos.Socio;

public class GestorSocio extends GestorBD {

	private static PersistenceManagerFactory pmf = null;
	private static PersistenceManager pm = null;


	public static void storeSocio(Socio s) {
		GestorBD.getInstance();
		GestorBD.getInstance().storeObjectInDB(s);
	}

	public static List<Socio> getTodosSocios() {
		GestorBD.getInstance();
		return GestorBD.getInstance().selectListaObjectos(Socio.class);
	}

	public static Socio selectSocio(String nombreApellido) {
		PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
		Transaction transaction = null;
		transaction = pm.currentTransaction();
		try {
			transaction.begin();
			Query<Socio> q = pm.newQuery(Socio.class);
			q.setFilter("nombreApellido == :nombreApellido");
			q.setParameters(nombreApellido);
			Socio s1 = (Socio) q.executeUnique();
			transaction.commit();
			return s1;
		} catch (Exception ex) {
			return null;
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			pm.close();
		}
	}

	public static void updateSocio(String nombreNuevo, int pts, String direccion,int telefono,
		String nombreApellido) {
		PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
		Transaction transaction = null;
		transaction = pm.currentTransaction();
		try {
			transaction.begin();
			Query<?> upQuery =
					pm.newQuery(
							"UPDATE "
									+ Socio.class.getName()
									+ " SET nombreApellido = '"
									+ nombreNuevo
									+ "', pts ="
									+ pts
									+ ", telefono ="
									+ telefono
									+"', direccion ="
									+ direccion
									+ "'"
									+ " WHERE nombreApellido = '"
									+ nombreApellido
									+ "'");
			upQuery.execute();
			transaction.commit();
		} catch (Exception ex) {
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			pm.close();
		}
	}

	/**
	 * Eliminar un juego de la bd
	 * @param nombre el nombre por el que se encontrara
	 */
	public static void borrarSocio(String nombre) {
		PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
		Transaction transaction = null;
		transaction = pm.currentTransaction();
		try {
			transaction.begin();
			Query<?> upQuery =
					pm.newQuery(
							"DELETE FROM "
									+ Socio.class.getName()
									+ " WHERE nombreApellido == '"
									+ nombre
									+ "'");
			upQuery.execute();
			transaction.commit();
		} catch (Exception ex) {
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			pm.close();
		}
	}
}