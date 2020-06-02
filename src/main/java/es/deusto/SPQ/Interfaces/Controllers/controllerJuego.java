package es.deusto.SPQ.Interfaces.Controllers;

import es.deusto.SPQ.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class controllerJuego {

	@FXML
	private TextField buscadorJuego;

	@FXML
	private Button botonBuscar;

	@FXML
	private Button botonCrear;

	@FXML
	private Button botonRetirar;

	@FXML
	private Button botonEditar;

	@FXML
	private Button botonGuardar;

	@FXML
	private TextField fieldNombre;

	@FXML
	private TextField fieldPrecio;

	@FXML
	private TextField fieldCompania;

	@FXML
	private TextField fieldVentas;

	@FXML
	private TextField fieldCopiasDisp;

	@FXML
	private Button botonVolver;

	/**
	 * Boton para buscar un juego
	 * @param event
	 */
	@FXML
	void buscarJuego(ActionEvent event) {
		//Select de la bd
		fieldNombre.setText("");
		fieldCompania.setText("");
		fieldCopiasDisp.setText("");
		fieldPrecio.setText("");
		fieldVentas.setText("");
		fieldNombre.setEditable(false);
		fieldCompania.setEditable(false);
		fieldCopiasDisp.setEditable(false);
		fieldPrecio.setEditable(false);
		fieldVentas.setEditable(false);
	}

	/**
	 * Boton para crear un juego
	 * @param event
	 */
	@FXML
	void crearJuego(ActionEvent event) {
		fieldNombre.setText("");
		fieldCompania.setText("");
		fieldCopiasDisp.setText("");
		fieldPrecio.setText("");
		fieldVentas.setText("");
		fieldNombre.setEditable(true);
		fieldCompania.setEditable(true);
		fieldCopiasDisp.setEditable(true);
		fieldPrecio.setEditable(true);
		fieldVentas.setEditable(true);
	}

	/**
	 * Boton para editar un juego que ya se haya buscado
	 * @param event
	 */
	@FXML
	void editarJuego(ActionEvent event) {
		//Alert de primero buscar
		fieldNombre.setText("");
		fieldCompania.setText("");
		fieldCopiasDisp.setText("");
		fieldPrecio.setText("");
		fieldVentas.setText("");
		fieldNombre.setEditable(true);
		fieldCompania.setEditable(true);
		fieldCopiasDisp.setEditable(true);
		fieldPrecio.setEditable(true);
		fieldVentas.setEditable(true);
	}

	@FXML
	void guardarJuego(ActionEvent event) {
		//Update BD
	}

	@FXML
	void retirarJuego(ActionEvent event) {
		//Drop BD
	}

	@FXML
	void volverPaginaPrinc(ActionEvent event) {
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