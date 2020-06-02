package es.deusto.SPQ.Interfaces.Controllers;


import java.util.HashMap;

import es.deusto.SPQ.App;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class controllerGrafico {
	static ObservableList<String> juegos;
	HashMap<String, Integer> grafico = new HashMap<String, Integer>();
	HashMap<String, Integer> juegosTop = new HashMap<String, Integer>();

	@FXML
	private Button botonCargar;

	@FXML
	private Button botonRecargar;

	@FXML
	private Button botonVolver;

	@FXML
	private BarChart<String, Number> graficoJuegos;

	/**
	 * Boton que carga el grafico
	 * @param event
	 */
	@FXML
	void cargarGrafico(ActionEvent event) {
		graficoJuegos.getData().clear();
		int cont = 0;
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String,Number> bc = 
				new BarChart<String,Number>(xAxis,yAxis);
		bc.setTitle("Grafico juegos TOP");
		xAxis.setLabel("Juego");       
		yAxis.setLabel("Vendidos");
		XYChart.Series series = new XYChart.Series();
		for (String Key : juegosTop.keySet()) {
			series.getData().add(new XYChart.Data(Key, juegosTop.get(Key)));
			cont += 1;
			if (cont == 10) break;
		}
		graficoJuegos.getData().add(series);
		graficoJuegos.setLegendVisible(false);
	}

	/**
	 * Boton que recarga los juegos que ya no esten disponibles dentro del grafico
	 * @param event
	 */
	@FXML
	void recargarJuegos(ActionEvent event) {
		//Update en la BD + un alert

	}

	/**
	 * Boton para volver a la pagina principal
	 * @param event
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
