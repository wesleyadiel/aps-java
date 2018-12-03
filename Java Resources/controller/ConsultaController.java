package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Inicio.Iniciar;
import dao.SimulacaoDAO;
import entidade.Simulacao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class ConsultaController implements Initializable {
	@FXML
	private Button btnVoltarInicio;
	@FXML
	private TableView tbvSimulacao;
	@FXML
	private TableColumn tbvcPessoas;
	@FXML
	private TableColumn tbvcPratos;
	@FXML
	private TableColumn tbvcSalada;
	@FXML
	private TableColumn tbvcCarboidratos;
	@FXML
	private TableColumn tbvcProteina;
	@FXML
	private TableColumn tbcvSuco;
	@FXML
	private TableColumn tbvcTempoTotal;
	@FXML
	private TableColumn tbvcTempoMedio;

	// Event Listener on Button[#btnVoltarInicio].onAction
	@FXML
	public void voltar(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../fxml/InicioFxml.fxml"));
		Iniciar.stage.setScene(new Scene(root));
		Iniciar.stage.centerOnScreen();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			
			this.tbvcCarboidratos.setCellValueFactory(new PropertyValueFactory<>("carboidratos"));
			this.tbvcPessoas.setCellValueFactory(new PropertyValueFactory<>("numeroPessoas"));
			this.tbvcPratos.setCellValueFactory(new PropertyValueFactory<>("pratos"));
			this.tbvcSalada.setCellValueFactory(new PropertyValueFactory<>("salada"));
			this.tbvcProteina.setCellValueFactory(new PropertyValueFactory<>("proteina"));
			this.tbcvSuco.setCellValueFactory(new PropertyValueFactory<>("suco"));
			this.tbvcTempoTotal.setCellValueFactory(new PropertyValueFactory<>("tempoTotal"));
			this.tbvcTempoMedio.setCellValueFactory(new PropertyValueFactory<>("tempoMedio"));
			
			
			List<Simulacao> simulacoes = new ArrayList<>();
			SimulacaoDAO dao = new SimulacaoDAO();
			simulacoes = dao.getAll(); 
			tbvSimulacao.setItems(FXCollections.observableArrayList(simulacoes));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
