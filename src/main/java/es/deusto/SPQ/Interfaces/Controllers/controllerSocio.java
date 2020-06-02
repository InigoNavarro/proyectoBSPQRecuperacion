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
/**
 * Controller de la ventana que permite ver, editar, crear... un socio
 * @author Ditto
 *
 */
public class controllerSocio {

	@FXML
	private TextField buscadorSocio;

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
	private TextField fieldApellido;

	@FXML
	private TextField fieldPuntos;

	@FXML
	private TextField fieldTelefono;

	@FXML
	private TextField fieldDireccion;

	@FXML
	private Button botonVolver;

	/**
	 * Boton para buscar a un socio
	 * @param event
	 */
	@FXML
	void buscarSocio(ActionEvent event) {
		fieldNombre.setText("");
		fieldApellido.setText("");
		fieldDireccion.setText("");
		fieldPuntos.setText("");
		fieldTelefono.setText("");
		fieldNombre.setEditable(false);
		fieldApellido.setEditable(false);
		fieldDireccion.setEditable(false);
		fieldPuntos.setEditable(false);
		fieldTelefono.setEditable(false);
	}

	/**
	 * Boton para crear a un socio
	 * @param event
	 */
	@FXML
	void crearSocio(ActionEvent event) {
		fieldNombre.setText("");
		fieldApellido.setText("");
		fieldDireccion.setText("");
		fieldPuntos.setText("");
		fieldTelefono.setText("");
		fieldNombre.setEditable(true);
		fieldApellido.setEditable(true);
		fieldDireccion.setEditable(true);
		fieldPuntos.setEditable(true);
		fieldTelefono.setEditable(true);
	}

	/**
	 * Boton para editar a un socio que ya se haya buscado
	 * @param event
	 */
	@FXML
	void editarSocio(ActionEvent event) {
		fieldNombre.setText("");
		fieldApellido.setText("");
		fieldDireccion.setText("");
		fieldPuntos.setText("");
		fieldTelefono.setText("");
		fieldNombre.setEditable(true);
		fieldApellido.setEditable(true);
		fieldDireccion.setEditable(true);
		fieldPuntos.setEditable(true);
		fieldTelefono.setEditable(true);
	}

	/**
	 * Boton para guardar un socio
	 * @param event
	 */
	@FXML
	void guardarSocio(ActionEvent event) {
		//Update BD
	}

	/**
	 * Boton para retirar un socio
	 * @param event
	 */
	@FXML
	void retirarSocio(ActionEvent event) {
		//Drop BD
	}

	/**
	 * Boton para volver a la pagina principal
	 * @param event
	 */
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