package es.deusto.SPQ.BD.Gestores;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.SPQ.BD.Objetos.Socio;

/**
 * Gestor que controla la clase Socio de la bd
 * @author Ditto
 *
 */
public class GestorSocio {
	/**
	 * Obtener todos los Socios
	 * @return la lista de los socios
	 */
	public static List<Socio> getTodosSocios() {
        return GestorBD.getInstance().selectListaObjectos(Socio.class);
    }
	
	/**
	 * Solo obtener un socio en vez de todos
	 * @param nombreApellido el nombre y apellido por el que se encuentra el socio
	 * @return el socio que ha encontrado
	 */
	 public static Socio selectSocio(String nombreApellido) {
	        PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
	        Transaction transaction = null;
	        transaction = pm.currentTransaction();
	        try {
	            transaction.begin();
	            Query<Socio> q = pm.newQuery(Socio.class);
	            q.setFilter("nombreApellido  == :nombreApellido");
	            q.setParameters(nombreApellido);
	            Socio res = q.executeUnique();
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
	  * Actualizar la info de un socio en la BD
	  * @param nombreApellidoNuevo el nombre y apellido al que se quiere cambiar
	  * @param puntosNuevo los puntos que va a tener el cliente
	  * @param direccionNueva la nueva direccion del cliente
	  * @param telefonoNuevo el nuevo telefono del cliente
	  * @param edadNuevo la nueva edad del cliente (esto deberia ser autocalculable)
	  * @param nombreApellido El nombre y apellido que se usa para encontrar a ese cliente
	  */
	 public static void updateSocio(String nombreApellidoNuevo, int puntosNuevo, String direccionNueva,int telefonoNuevo,
			int edadNuevo, String nombreApellido) {
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
	                                    + nombreApellidoNuevo
	                                    + "', pts ="
	                                    + puntosNuevo
	                                    + ", direccion ='"
	                                    + direccionNueva
	                                    +"', telefono ="
	                                    + telefonoNuevo
	                                    + ", edad ="
	                                    + edadNuevo
	                                    + " WHERE nombreApellido == '"
	                                    + nombreApellidoNuevo
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
	  * Borrar un socio de la bd
	  * @param nombreApellido el nombre y apellido del socio que se quiere borrar
	  */
	 public static void borrarSocio(String nombreApellido) {
		        PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
		        Transaction transaction = null;
		        transaction = pm.currentTransaction();
		        try {
		            transaction.begin();
		            Query<?> upQuery =
		                    pm.newQuery(
		                            "DELETE FROM"
		                                    + Socio.class.getName()
		                                    + " WHERE nombreApellido == '"
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
	  * Con el store no haria falta este metodo pero sirve para meter un nuevo socio a la bd
	  * @param nombreApellidoNuevo Nombre y Apellido del nuevo socio
	  * @param puntosNuevo los puntos que tiene (siempre sera 0)
	  * @param direccionNueva la direccion del nuevo socio
	  * @param telefonoNuevo su telefono
	  * @param edadNuevo su edad (deberian ser mejor dos atributos, uno fecha nacimiento y otro edad siendo edad autocalculable)
	  */
	 public static void crearSocio(String nombreApellidoNuevo, int puntosNuevo, String direccionNueva,int telefonoNuevo,
				int edadNuevo) {
	        PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
	        Transaction transaction = null;
	        transaction = pm.currentTransaction();
	        try {
	            transaction.begin();
	            Query<?> upQuery =
	                    pm.newQuery(
	                            "INSERT INTO"
	                                    + Socio.class.getName()
	                                    + "VALUES('"
	                                    + nombreApellidoNuevo
	                                    + "',"
	                                    +puntosNuevo
	                                    + ", '"
	                                    + direccionNueva
	                                    + "',"
	                                    + telefonoNuevo
	                                    + ", "
	                                    + edadNuevo
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
}

