package es.deusto.SPQ.BD.Gestores;

import java.util.List;
import java.util.logging.Level;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

public class GestorBD {
    private static GestorBD instance = null;
    private static PersistenceManagerFactory pmf = null;
    private static PersistenceManager pm = null;

    public static GestorBD getInstance() {
        if (instance == null) {
            instance = new GestorBD();
            instance.conectar();
        }
        return instance;
    }
    
    protected static PersistenceManagerFactory getPMF() {
        getInstance();
        return pmf;
    }
    
    private void conectar() {
        pmf = JDOHelper.getPersistenceManagerFactory("CentralUnit");
    }
    
    public <T> void store(Class<T> object) {
        GestorBD.getInstance().storeObjectInDB(object);
    }
    
    public boolean storeObjectInDB(Object object) {
        if (object == null) {
            throw new NullPointerException("Objecto para guardar es null");
        }

        Transaction transaction = null;
        try {
            pm = getPMF().getPersistenceManager();
            transaction = pm.currentTransaction();
            transaction.begin();
            pm.setIgnoreCache(true);
            pm.makePersistent(object);
//            pm.flush();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return false;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            pm.close();
        }
        return true;
    }
    
    public <T> List<T> selectListaObjectos(Class<T> objectoClass) {
        List<T> resultados;
        PersistenceManager pm = getPMF().getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try {
            tx.begin();
            Query<T> q = pm.newQuery(objectoClass);
            q.ignoreCache(true);
            List<T> res = q.executeList();
//            pm.flush();
            tx.commit();
            resultados = res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }

        return resultados;
    }
}