package es.deusto.SPQ.BD.Gestores;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.SPQ.BD.Objetos.Juego;

public class GestorJuego extends GestorBD {

    private static PersistenceManagerFactory pmf = null;
    private static PersistenceManager pm = null;
    
    
    public static void storeJuego(Juego j) {
        GestorBD.getInstance();
        GestorBD.getInstance().storeObjectInDB(j);
    }
    
    public static List<Juego> getTodosJuegos() {
        GestorBD.getInstance();
        return GestorBD.getInstance().selectListaObjectos(Juego.class);
    }
    
    public static Juego selectJuego(String nombreJuego) {
        PersistenceManager pm = GestorBD.getPMF().getPersistenceManager();
        Transaction transaction = null;
        transaction = pm.currentTransaction();
        try {
            transaction.begin();
            Query<Juego> q = pm.newQuery(Juego.class);
            q.setFilter("nombreJuego == :nombreJuego");
            q.setParameters(nombreJuego);
            Juego j1 = (Juego) q.executeUnique();
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
}