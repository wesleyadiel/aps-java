package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Inicio.Iniciar;
import dto.SimulacaoDTO;
import entidade.Simulacao;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class ConfiguracaoController implements Initializable{
	@FXML
	private Label lblNumeroPessoas;
	@FXML
	private Label lblPratos;
	@FXML
	private Label lblSalada;
	@FXML
	private Label lblCarboidrato;
	@FXML
	private Label lblProteina;
	@FXML
	private Label lblSuco;
	@FXML
	private Label lblTempoMinimoAlimentacao;
	@FXML
	private Label lblTempoMaximoAlimentacao;
	@FXML
	public TextField txfNumeroPessoas;
	@FXML
	public TextField txfPratos;
	@FXML
	public TextField txfSalada;
	@FXML
	public TextField txfCarboidratos;
	@FXML
	public TextField txfProteina;
	@FXML
	public TextField txfSuco;
	@FXML
	public TextField txfTempoMinimoAlimentacao;
	@FXML
	public TextField txfTempoMaximoAlimentacao;
	@FXML
	private Button btnSimular;
	@FXML
	private Button btnVoltar;
	
	public static SimulacaoDTO s = new SimulacaoDTO();
	
	public void getSimulacao() {
		s.setCarboidratos(Long.valueOf(txfCarboidratos.getText()));
		s.setNumeroPessoas(Long.valueOf(txfNumeroPessoas.getText()));
		s.setPratos(Long.valueOf(txfPratos.getText()));
		s.setProteina(Long.valueOf(txfProteina.getText()));
		s.setSalada(Long.valueOf(txfSalada.getText()));
		s.setSuco(Long.valueOf(txfSuco.getText()));
		s.setTempoMaximo(Double.valueOf(txfTempoMaximoAlimentacao.getText()));
		s.setTempoMinimo(Double.valueOf(txfTempoMinimoAlimentacao.getText()));
	}

	// Event Listener on Button[#btnSimular].onAction
	@FXML
	public void simular(ActionEvent event) throws Exception {
		getSimulacao();
		Parent root = FXMLLoader.load(getClass().getResource("../fxml/ResultadoFxml.fxml"));
		Iniciar.stage.setScene(new Scene(root));
		Iniciar.stage.centerOnScreen();	
	}
	// Event Listener on Button[#btnVoltar].onAction
	@FXML
	public void voltar(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../fxml/InicioFxml.fxml"));
		Iniciar.stage.setScene(new Scene(root));
		Iniciar.stage.centerOnScreen();
	}
	
	public String getTxfNumeroPessoas() {
		return txfNumeroPessoas.getText();
	}
	public void setTxfNumeroPessoas(String txfNumPessoas) {
		this.txfNumeroPessoas.setText(txfNumPessoas);
	}
	public String getTxfPratos() {
		return txfPratos.getText();
	}
	public void setTxfPratos(String txfPratos) {
		this.txfPratos.setText(txfPratos);;
	}
	public String getTxfSalada() {
		return txfSalada.getText();
	}
	public void setTxfSalada(String txfSalada) {
		this.txfSalada.setText(txfSalada);
	}
	public String getTxfCarboidratos() {
		return txfCarboidratos.getText();
	}
	public void setTxfCarboidratos(String txfCarboidratos) {
		this.txfCarboidratos.setText(txfCarboidratos);
	}
	public String getTxfProteina() {
		return txfProteina.getText();
	}
	public void setTxfProteina(String txfProteina) {
		this.txfProteina.setText(txfProteina);
	}
	public String getTxfSuco() {
		return txfSuco.getText();
	}
	public void setTxfSuco(String txfSuco) {
		this.txfSuco.setText(txfSuco);
	}
	public String getTxfTempoMinimoAlimentacao() {
		return txfTempoMinimoAlimentacao.getText();
	}
	public void setTxfTempoMinimoAlimentacao(String txfTempoMinimoAlimentacao) {
		this.txfTempoMinimoAlimentacao.setText(txfTempoMinimoAlimentacao);
	}
	public String getTxfTempoMaximoAlimentacao() {
		return txfTempoMaximoAlimentacao.getText();
	}
	public void setTxfTempoMaximoAlimentacao(String txfTempoMaximoAlimentacao) {
		this.txfTempoMaximoAlimentacao.setText(txfTempoMaximoAlimentacao);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.s = new SimulacaoDTO();
		
	}
}
