package es.deusto.SPQ.BD.Gestores;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import es.deusto.bd.Gestor.GestorBD;
import es.deusto.util.LogTracker;


public class GestorBD {
	private static boolean DEBUG = false;
    private static GestorBD instance = null;
    private static PersistenceManagerFactory pmf = null;
    private static PersistenceManager pm = null;
    private static Logger logger = null;
    
    public GestorBD() {

        logger = Logger.getLogger(GestorBD.class.getName());
        logger.setUseParentHandlers(false);
        // Para los errors SEVERE
        logger.addHandler(
                new Handler() {

                    @Override
                    public void publish(LogRecord record) {
                        if (record.getLevel() == Level.SEVERE) {
                            String exception = "";
                            if (record.getThrown() != null) {
                                StringWriter writer = new StringWriter();
                                PrintWriter printWriter = new PrintWriter(writer);
                                record.getThrown().printStackTrace(printWriter);
                                exception = writer.toString();
                            }
                            LogTracker.addMessage(record.getMessage() + exception);
                        }
                        flush();
                    }

                    @Override
                    public void flush() {}

                    @Override
                    public void close() throws SecurityException {}
                });
        // desactivar los mensajes si no estamos en debug
        logger.addHandler(
                new ConsoleHandler() {
                    @Override
                    public void publish(LogRecord record) {
                        if (DEBUG) {
                            super.publish(record);
                        }
                        flush();
                    }
                });
    }

    public static GestorBD getInstance() {
        if (instance == null) {
            instance = new GestorBD();
            instance.conectar();
        }
        return instance;
    }
}
