package es.deusto.SPQ.BD.Gestores;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.SPQ.BD.Objetos.Socio;

/**
 * Gestor de la clase socio
 * @author Ditto
 *
 */
public class GestorSocio extends GestorBD {

	private static PersistenceManagerFactory pmf = null;
	private static PersistenceManager pm = null;

/**
 * Guardar un socio
 * @param s Socio que se quiee guardar
 */
	public static void storeSocio(Socio s) {
		GestorBD.getInstance();
		GestorBD.getInstance().storeObjectInDB(s);
	}

	/**
	 * Obtener una lista de todos los socios
	 * @return la lista de los socios
	 */
	public static List<Socio> getTodosSocios() {
		GestorBD.getInstance();
		return GestorBD.getInstance().selectListaObjectos(Socio.class);
	}

	/**
	 * Obtener un solo socio
	 * @param nombreApellido el nombre  apellido del socio que se quiere buscar
	 * @return el socio buscado
	 */
	public static Socio selectSocio(String nombreApellido) {
		pm = GestorBD.getPMF().getPersistenceManager();
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

	/**
	 * Actualizar la info de un socio
	 * @param nombreNuevo el nuevo nombre del socio
	 * @param pts los nuevos pts del socio
	 * @param direccion la nueva ireccion del socio
	 * @param telefono el nuevo telefono del socio
	 * @param nombreApellido el nuevo nombre del socio
	 */
	public static void updateSocio(String nombreNuevo, int pts, String direccion,int telefono,
		String nombreApellido) {
		pm = GestorBD.getPMF().getPersistenceManager();
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
									+", direccion ='"
									+ direccion
									+ "' WHERE nombreApellido == '"
									+ nombreApellido
									+ "'");
			upQuery.execute();
//			pm.flush();
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
	 * Eliminar un socio de la bd
	 * @param nombre el nombre por el que se encontrara
	 */
	public static void borrarSocio(String nombre) {
		pm = GestorBD.getPMF().getPersistenceManager();
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
//			pm.flush();
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