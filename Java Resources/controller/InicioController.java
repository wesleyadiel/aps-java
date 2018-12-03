package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import Inicio.Iniciar;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class InicioController {
	@FXML
	private Button btnIniciar;
	@FXML
	private Button btnConsultar;
	@FXML
	private Label lblProduce;
	@FXML
	private Text txtTitle;

	// Event Listener on Button[#btnIniciar].onAction
	@FXML
	public void iniciar(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../fxml/ConfiguracaoFxml.fxml"));
		Iniciar.stage.setScene(new Scene(root));
		Iniciar.stage.centerOnScreen();
	}

	// Event Listener on Button[#btnConsultar].onAction
	@FXML
	public void consultar(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../fxml/ConsultaFxml.fxml"));
		Iniciar.stage.setScene(new Scene(root));
		Iniciar.stage.centerOnScreen();
	}
	
	
	
}
