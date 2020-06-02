package es.deusto.SPQ.Interfaces.Controllers;

import es.deusto.SPQ.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * Controller de la ventana que permite gestionar las reservas
 * @author Ditto
 *
 */
public class controllerReserva {

	public static ObservableList<String> reservas = FXCollections.observableArrayList();

	@FXML
	private TextField textoReserva;

	@FXML
	private Button botonReserva;

	@FXML
	private Button botonBorrar;

	@FXML
	private Button botonVolver;

	@FXML
	private ListView<String> listaReservas;

	/**
	 * Boton que borra el historial
	 * @param event el click del raton
	 */
	@FXML
	void borrarHist(ActionEvent event) {
		reservas.clear();
		listaReservas.setItems(reservas);
	}

	/**
	 * Boton de busqueda de un juego
	 * @param event el click del raton
	 */
	@FXML
	void buscarReserva(ActionEvent event) {
		//Configurar la BD
		Alert alert = new Alert(AlertType.INFORMATION, "La reserva no existe en nuestra Base de Datos."
				, ButtonType.OK);
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.show();
		reservas.add("La reserva no existe en nuestra Base de Datos.");
		listaReservas.setItems(reservas);
	}

	/**
	 * Boton de volver a la pagina anterior
	 * @param event el click del raton
	 */
	@FXML
	void volverPagPrin(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getClassLoader().getResource("es/deusto/SPQ/paginaPrin.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));  
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Node source = (Node) event.getSource();
		Stage stageCatalog = (Stage) source.getScene().getWindow();
		stageCatalog.close();
	}
}