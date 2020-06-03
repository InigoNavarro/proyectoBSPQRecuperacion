package es.deusto.SPQ.Interfaces.Controllers;

import es.deusto.SPQ.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller de la ventana principal
 * @author Ditto
 *
 */
public class controllerPagPrincipal {

	@FXML
	private Button botonCatalogo;

	@FXML
	private Button botonGrafico;

	@FXML
	private Button botonReservas;

	@FXML
	private Button botonCliente;

	@FXML
	private Button botonJuegos;

	/**
	 * Boton que abre la ventana Catalogo y cierra la principal
	 *  @param event el click del raton
	 * @throws Exception que no encuentre ese fxml
	 */
	@FXML
	void irVentanaCatalogo(ActionEvent event)  throws Exception {    
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getClassLoader().getResource("es/deusto/SPQ/catalogo.fxml"));
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

	/**
	 * Boton que abre la ventana Cliente y cierra la principal
	 *  @param event el click del raton
	 * @throws Exception que no encuentre ese fxml
	 */
	@FXML
	void irVentanaCliente(ActionEvent event)  throws Exception {               
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getClassLoader().getResource("es/deusto/SPQ/socios.fxml"));
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

	/**
	 * Boton que abre la ventana Grafico y cierra la principal
	 * @param event el click del raton
	 * @throws Exception que no encuentre ese fxml
	 */
	@FXML
	void irVentanaGrafico(ActionEvent event)  throws Exception {               
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getClassLoader().getResource("es/deusto/SPQ/grafico.fxml"));
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

	/**
	 * Boton que abre la ventana Juegos y cierra la principal
	 *@param event el click del raton
	 * @throws Exception que no encuentre ese fxml
	 */
	@FXML
	void irVentanaJuegos(ActionEvent event)  throws Exception {               
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getClassLoader().getResource("es/deusto/SPQ/juegos.fxml"));
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

	/**
	 * Boton que abre la ventana Reservas y cierra la principal
	 * @param event el click del raton
	 * @throws Exception que no encuentre ese fxml
	 */
	@FXML
	void irVentanareservas(ActionEvent event)  throws Exception {               
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(App.class.getClassLoader().getResource("es/deusto/SPQ/reserva.fxml"));
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
