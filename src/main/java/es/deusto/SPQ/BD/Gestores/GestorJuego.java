package es.deusto.SPQ.BD.Gestores;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.SPQ.BD.Objetos.Juego;
import javafx.collections.ObservableList;

/**
 * El gestor de la clase juego
 * @author Ditto
 *
 */
public class GestorJuego extends GestorBD {

    private static PersistenceManagerFactory pmf = null;
    private static PersistenceManager pm = null;
    
    /**
     * Guardar un juego en la BD
     * @param j el juego que se quiere anadir
     */
    public static void storeJuego(Juego j) {
        GestorBD.getInstance();
        GestorBD.getInstance().storeObjectInDB(j);
    }
    
    /**
     * Obtener la lista de todos los juegos guardados
     * @return la lista de los juegos
     */
    public static List<Juego> getTodosJuegos() {
        GestorBD.getInstance();
        return GestorBD.getInstance().selectListaObjectos(Juego.class);
    }
    
    /**
     * Obtener un juego en especial
     * @param nombreJuego nombre del juego a buscar
     * @return el juego buscado
     */
    public static Juego selectJuego(String nombreJuego) {
        pm = GestorBD.getPMF().getPersistenceManager();
        Transaction transaction = null;
        transaction = pm.currentTransaction();
        try {
            transaction.begin();
            Query<Juego> q = pm.newQuery(Juego.class);
            q.setFilter("nombreJuego == :nombreJuego");
            q.setParameters(nombreJuego);
            Juego j1 = (Juego) q.executeUnique();
//            pm.flush();
            transaction.commit();
            return j1;
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
     * Actualizar un juego
     * @param nombreNuevo nuevo nombre del juego
     * @param precioNuevo nuevo precio del juego
     * @param companiaNueva nueva compania del juego
     * @param numVentasNuevo nuevo ventas del juego
     * @param dispNuevo nueva disponibilidad del juego
     * @param nombre nombre actual del juego para buscarlo en la BD
     */
    public static void updateJuego(String nombreNuevo, float precioNuevo, String companiaNueva,int numVentasNuevo,
			boolean dispNuevo, String nombre) {
		pm = GestorBD.getPMF().getPersistenceManager();
		Transaction transaction = null;
		transaction = pm.currentTransaction();
		try {
			transaction.begin();
			Query<?> upQuery =
					pm.newQuery(
							"UPDATE "
									+ Juego.class.getName()
									+ " SET nombreJuego = '"
									+ nombreNuevo
									+ "', precio ="
									+ precioNuevo
									+ ", empresa ='"
									+ companiaNueva
									+"', numVendidos ="
									+ numVentasNuevo
									+ ", copiasDisp ="
									+ dispNuevo
									+ " WHERE nombreJuego == '"
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

	/**
	 * Eliminar un juego de la bd
	 * @param nombre el nombre por el que se encontrara
	 */
	public static void borrarJuego(String nombre) {
		pm = GestorBD.getPMF().getPersistenceManager();
		Transaction transaction = null;
		transaction = pm.currentTransaction();
		try {
			transaction.begin();
			Query<?> upQuery =
					pm.newQuery(
							"DELETE FROM "
									+ Juego.class.getName()
									+ " WHERE nombreJuego == '"
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
	
	/**
	 * Intento de obtener una lista ordenada
	 * @return la lista ordenadad de todos los juegos
	 */
	@SuppressWarnings("unchecked")
  public static List<Juego> listaJuegosOrdenada() {
		pm = GestorBD.getPMF().getPersistenceManager();
		Transaction transaction = null;
		transaction = pm.currentTransaction();
		List<Juego> re;
		try {
			transaction.begin();
			Query<?> upQuery =
					pm.newQuery(
							"SELECT FROM "
									+ Juego.class.getName()									
									+ " ORDER BY numVendidos ASC");
			re = (List<Juego>) upQuery.execute();
//			pm.flush();
			transaction.commit();
			return re;
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
	 * Cambiar la disp a true de un juego
	 * @param dispNuevo Siempre sera true
	 * @param nombre el nombre del juego del que se quiere cambiar su disponibilidad
	 */
	 public static void recargarJuego(boolean dispNuevo, String nombre) {
			pm = GestorBD.getPMF().getPersistenceManager();
			Transaction transaction = null;
			transaction = pm.currentTransaction();
			try {
				transaction.begin();
				Query<?> upQuery =
						pm.newQuery(
								"UPDATE "
										+ Juego.class.getName()
										+ " SET copiasDisp = "
										+  dispNuevo
										+ " WHERE nombreJuego == '"
										+ nombre
										+ "'");
				upQuery.execute();
//				pm.flush();
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