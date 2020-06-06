package es.deusto.SPQ.Interfaces.Controllers;

import java.awt.List;

import es.deusto.SPQ.App;
import es.deusto.SPQ.BD.Gestores.GestorBD;
import es.deusto.SPQ.BD.Gestores.GestorJuego;
import es.deusto.SPQ.BD.Objetos.Juego;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * Controller de la ventana que permite crear, editar, ver... la info de un juego
 * @author Ditto
 *
 */
public class controllerJuego {

	static ObservableList<Juego> listaJuegos = FXCollections.observableArrayList();

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
	 *  @param event el click del raton
	 */
	@FXML
	void buscarJuego(ActionEvent event) {
		Juego j1 = GestorJuego.selectJuego(buscadorJuego.getText());
		if(j1 == null) {
			Alert alert = new Alert(AlertType.INFORMATION, "El juego " + buscadorJuego.getText() + " no existe en nuestra Base de Datos."
					, ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		}else {
			fieldNombre.setText(j1.getNombreJuego());
			fieldCompania.setText(j1.getEmpresa());
			if(j1.isCopiasDisp()) {
				fieldCopiasDisp.setText("Hay disponibles");
			}else {
				fieldCopiasDisp.setText("No hay disponibles");
			}
			fieldPrecio.setText(j1.getPrecio() +" euros");
			fieldVentas.setText(j1.getNumVendidos() + " vendidos");
			fieldNombre.setEditable(false);
			fieldCompania.setEditable(false);
			fieldCopiasDisp.setEditable(false);
			fieldPrecio.setEditable(false);
			fieldVentas.setEditable(false);
		}
	}

	/**
	 * Boton para editar un juego que ya se haya buscado
	 *  @param event el click del raton
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

	/**
	 * Boton para guardar un juego que ya se haya editado
	 *  @param event el click del raton
	 */
	@FXML
	void guardarJuego(ActionEvent event) {
		//Update BD
		Juego j1 = GestorJuego.selectJuego(buscadorJuego.getText());
		if(j1 == null) {
			Alert alert = new Alert(AlertType.INFORMATION, "El juego " + buscadorJuego.getText() + " no existe en nuestra Base de Datos o el field esta vacio."
					, ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		}
		String nombreSinEspacios = fieldNombre.getText().replaceAll(" ", "");
		String companiaSinEspacios = fieldCompania.getText().replaceAll(" ", "");
		String precioSinEspacios = fieldPrecio.getText().replaceAll(" ", "");
		String ventasSinEspacios = fieldVentas.getText().replaceAll(" ", "");
		String copiasDispSinEspacios = fieldCopiasDisp.getText().replaceAll(" ", "");
		if(nombreSinEspacios.equals("") && companiaSinEspacios.equals("") && precioSinEspacios.equals("") && ventasSinEspacios.equals("") 
				&& copiasDispSinEspacios.equals("")) {
			Alert alert = new Alert(AlertType.INFORMATION, "Los fields tienen que tener contenido"
					, ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		}else {
			int precio = Integer.parseInt(fieldPrecio.getText());
			int ventas = Integer.parseInt(fieldVentas.getText());
			boolean b1;
			b1 = Boolean.parseBoolean(fieldCopiasDisp.getText());
			GestorJuego.updateJuego(fieldNombre.getText(), precio, fieldCompania.getText(), ventas, b1, j1.getNombreJuego());
		}
	}

	/**
	 * Boton para eliminar un juego que ya se haya buscado
	 *  @param event el click del raton
	 */
	@FXML
	void retirarJuego(ActionEvent event) {
		//Drop BD
		String nombreSinEspacios = buscadorJuego.getText().replaceAll(" ", "");
		if(nombreSinEspacios.equals(" ")) {
			Alert alert = new Alert(AlertType.INFORMATION, "El buscador esta vacio", ButtonType.OK);
			alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
			alert.show();
		}else {
		GestorJuego.borrarJuego(buscadorJuego.getText());
		}
	}

	/**
	 * Boton para guardar volver a la pagina principal
	 *  @param event el click del raton
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