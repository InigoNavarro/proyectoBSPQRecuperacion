package es.deusto.SPQ.Interfaces.Controllers;

import java.util.List;

import es.deusto.SPQ.App;
import es.deusto.SPQ.BD.Gestores.GestorJuego;
import es.deusto.SPQ.BD.Gestores.GestorReserva;
import es.deusto.SPQ.BD.Objetos.Juego;
import es.deusto.SPQ.BD.Objetos.Reserva;
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

	public static ObservableList<Reserva> reservas = FXCollections.observableArrayList();

	@FXML
	private Button botonReserva;

	@FXML
	private TextField textNomApellidoSocio;

	@FXML
	private Button botonBorrar;

	@FXML
	private Button botonVolver;

	@FXML
	private ListView<Reserva> listaReservas;

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
		reservas.clear();
		listaReservas.setItems(reservas);
		String nomApellidoSinEspacios = textNomApellidoSocio.getText().replaceAll(" ", "");
		List<Reserva> r1 = GestorReserva.selectReservas(textNomApellidoSocio.getText());
		if(nomApellidoSinEspacios.equals("")) {
			Alert alert = new Alert(AlertType.INFORMATION, "Hay que introducir un nombre de Socio"
					, ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		}else {
		if(r1 == null) {
			Alert alert = new Alert(AlertType.INFORMATION, "El cliente " + textNomApellidoSocio.getText() + " no ha realizado ninguna reserva."
					, ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		}else {
			for(Reserva r: r1) {
				reservas.add(r);
			}
		}
		listaReservas.setItems(reservas);
		}
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