package es.deusto.SPQ.Interfaces.Controllers;

import es.deusto.SPQ.App;
import es.deusto.SPQ.BD.Gestores.GestorJuego;
import es.deusto.SPQ.BD.Gestores.GestorSocio;
import es.deusto.SPQ.BD.Objetos.Juego;
import es.deusto.SPQ.BD.Objetos.Socio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
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
	private TextField fieldPuntos;

	@FXML
	private TextField fieldTelefono;

	@FXML
	private TextField fieldDireccion;

	@FXML
	private Button botonVolver;

	/**
	 * Boton para buscar a un socio
	 *@param event el click del raton
	 */
	@FXML
	void buscarSocio(ActionEvent event) {
		Socio s1 = GestorSocio.selectSocio(buscadorSocio.getText());
		if(s1 == null) {
			Alert alert = new Alert(AlertType.INFORMATION, "El socio " + buscadorSocio.getText() + " no existe en nuestra Base de Datos."
					, ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		}else {
			fieldNombre.setText(s1.getNombreApellido());
			fieldPuntos.setText(s1.getPts() + "");
			fieldTelefono.setText(s1.getTelefono() + "");
			fieldDireccion.setText(s1.getDireccion());
			fieldNombre.setEditable(false);
			fieldPuntos.setEditable(false);
			fieldTelefono.setEditable(false);
			fieldDireccion.setEditable(false);
		}
	}

	/**
	 * Boton para editar a un socio que ya se haya buscado
	 * @param event el click del raton
	 */
	@FXML
	void editarSocio(ActionEvent event) {
		fieldNombre.setEditable(true);
		fieldDireccion.setEditable(true);
		fieldPuntos.setEditable(true);
		fieldTelefono.setEditable(true);
	}

	/**
	 * Boton para guardar un socio
	 * @param event el click del raton
	 */
	@FXML
	void guardarSocio(ActionEvent event) {
		Socio s1 = GestorSocio.selectSocio(buscadorSocio.getText());
		if(s1 == null) {
			Alert alert = new Alert(AlertType.INFORMATION, "El socio " + buscadorSocio.getText() + " no existe en nuestra Base de Datos o el field esta vacio."
					, ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		}
		String nombreSinEspacios = fieldNombre.getText().replaceAll(" ", "");
		String direccionSinEspacios = fieldDireccion.getText().replaceAll(" ", "");
		String ptsSinEspacios = fieldPuntos.getText().replaceAll(" ", "");
		String telefonoSinEspacios = fieldTelefono.getText().replaceAll(" ", "");
		if(nombreSinEspacios.equals("") || direccionSinEspacios.equals("") || ptsSinEspacios.equals("") || telefonoSinEspacios.equals("")){
			Alert alert = new Alert(AlertType.INFORMATION, "Los fields tienen que tener contenido"
					, ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		}else {
			int telefono = Integer.parseInt(fieldTelefono.getText());
			int pts = Integer.parseInt(fieldPuntos.getText());
			GestorSocio.updateSocio(fieldNombre.getText(), pts, fieldDireccion.getText(), telefono, buscadorSocio.getText());
		}
	}


	/**
	 * Boton para retirar un socio
	 * @param event el click del raton
	 */
	@FXML
	void retirarSocio(ActionEvent event) {
		//Drop BD
		String nombreSinEspacios = buscadorSocio.getText().replaceAll(" ", "");
		if(nombreSinEspacios.equals("")) {
			Alert alert = new Alert(AlertType.INFORMATION, "El buscador esta vacio", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		}else {
		GestorSocio.borrarSocio(buscadorSocio.getText());
		}
	}

	/**
	 * Boton para volver a la pagina principal
	 * @param event el click del raton
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