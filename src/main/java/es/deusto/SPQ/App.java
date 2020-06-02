package es.deusto.SPQ;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase que actua como main
 * @author Ditto
 *
 */
public class App extends Application {

    private static Scene scene;

    public App() {
    	CrearDatosBD cdBD = new CrearDatosBD();
    	cdBD.cargarBase();
    }
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = getFXMLLoader("paginaPrin");
        scene = new Scene(loader.load(),650, 450);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static FXMLLoader getFXMLLoader(String fxml) throws IOException {
        return new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    }

    public static void main(String[] args) {
        launch();
    }
}