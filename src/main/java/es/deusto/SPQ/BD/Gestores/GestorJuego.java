package es.deusto.SPQ.BD.Gestores;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import es.deusto.SPQ.BD.Objetos.Juego;

/**
 * Gestor que controla la clase Juego de la bd
 * @author Ditto
 *
 */
public class GestorJuego {
	
	/**
	 * Obtener todos los juegos
	 * @return la lista de los juegos
	 */
	public static List<Juego> getTodosCircuitos() {
        return GestorBD.getInstance().selectListaObjectos(Juego.class);
    }
	
	/**
	 * Solo obtener un juego en vez de todos
	 * @param nomJuego el nombre del juego que se quiere obtener
	 * @return el juego que se ha encontrado
	 */
	 public static Juego selectJuego(String nomJuego) {
	        PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
	        Transaction transaction = null;
	        transaction = pm.currentTransaction();
	        try {
	            transaction.begin();
	            Query<Juego> q = pm.newQuery(Juego.class);
	            q.setFilter("juegoNombre  == :nomJuego");
	            q.setParameters(nomJuego);
	            Juego res = q.executeUnique();
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
	 
	 /**
	  * Actualizar la informacion de un juego
	  * @param nombreNuevo el nuevo nombre del juego
	  * @param precioNuevo el nuevo precio del nombre
	  * @param companiaNueva la nueva compania del juego
	  * @param numVentasNuevo el nuevo numero de ventas del juego
	  * @param dispNuevo si esta disponile o no
	  * @param nombre el nombre del juego por el que se encontrara
	  */
	 public static void updateJuego(String nombreNuevo, float precioNuevo, String companiaNueva,int numVentasNuevo,
			boolean dispNuevo, String nombre) {
	        PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
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
		        PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
		        Transaction transaction = null;
		        transaction = pm.currentTransaction();
		        try {
		            transaction.begin();
		            Query<?> upQuery =
		                    pm.newQuery(
		                            "DELETE FROM"
		                                    + Juego.class.getName()
		                                    + " WHERE nombreJuego == '"
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
	 
	 /**
	  * Con el store de gestorBD no deberia hacer falta este metodo pero por si acaso
	  * @param nombreNuevo el nombre del nuevo juego
	  * @param precioNuevo el precio del nuevo juego
	  * @param companiaNueva la compania que ha creado el juego
	  * @param numVentasNuevo el numero de ventas del nuevo juego (siempre sera 0)
	  * @param dispNuevo La disponibilidad del nuevo juego (siempre sera true)
	  */
	 public static void crearJuego(String nombreNuevo, float precioNuevo, String companiaNueva,int numVentasNuevo,
				boolean dispNuevo) {
	        PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
	        Transaction transaction = null;
	        transaction = pm.currentTransaction();
	        try {
	            transaction.begin();
	            Query<?> upQuery =
	                    pm.newQuery(
	                            "INSERT INTO"
	                                    + Juego.class.getName()
	                                    + "VALUES('"
	                                    + nombreNuevo
	                                    + "',"
	                                    +precioNuevo
	                                    + ", '"
	                                    + companiaNueva
	                                    + "',"
	                                    + numVentasNuevo
	                                    + ", "
	                                    + dispNuevo
	                                    + ")");
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
	  * Metodo para guardar un juego
	  * @param juego el juego que se quiere guardar
	  */
	 public static void storeJuego(Juego juego) {
	        GestorBD.getInstance();
	        GestorBD.getInstance().storeObjectInDB(juego);
	    }
}
