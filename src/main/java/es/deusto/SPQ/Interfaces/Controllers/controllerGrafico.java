package es.deusto.SPQ.Interfaces.Controllers;


import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import es.deusto.SPQ.App;
import es.deusto.SPQ.BD.Gestores.GestorJuego;
import es.deusto.SPQ.BD.Objetos.Juego;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller de la ventana que muestra el grafico de los 10 juegos mas vendidos
 * @author Ditto
 *
 */
public class controllerGrafico implements Initializable{
	static List<Juego> juegos;
	HashMap<String, Integer> juegosTop = new HashMap<String, Integer>();

	@FXML
	private Button botonCargar;

	@FXML
	private Button botonRecargar;

	@FXML
	private Button botonVolver;

	@FXML
	private LineChart<String, Number> graficoJuegos;

	/**
	 * Boton que carga el grafico
	 *  @param event el click del raton
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	@FXML
	void cargarGrafico(ActionEvent event) {
		graficoJuegos.getData().clear();

		for(int i = 0; i < 10; i ++) {
			juegosTop.put(juegos.get(i).getNombreJuego(), juegos.get(i).getNumVendidos());
		}
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		graficoJuegos.setTitle("Grafico juegos TOP");
		xAxis.setLabel("Juego");       
		yAxis.setLabel("Vendidos");
		XYChart.Series series = new XYChart.Series();
		for (String Key : juegosTop.keySet()) {
			series.getData().add(new XYChart.Data(Key, juegosTop.get(Key)));
		}
		graficoJuegos.getData().add(series);
		graficoJuegos.setLegendVisible(false);
	}

	/**
	 * Boton que recarga los juegos que ya no esten disponibles dentro del grafico
	 *  @param event el click del raton
	 */
	@FXML
	void recargarJuegos(ActionEvent event) {
		//Update en la BD + un alert

	}

	/**
	 * Boton para volver a la pagina principal
	 *  @param event el click del raton
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		juegos = FXCollections.observableArrayList();
		juegos.addAll(GestorJuego.listaJuegosOrdenada());
	}
}

