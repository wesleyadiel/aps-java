package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Inicio.Iniciar;
import dao.SimulacaoDAO;
import dto.PessoaDTO;
import dto.SimulacaoDTO;
import entidade.Simulacao;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ResultadoController implements Initializable{
	@FXML
	private Label lblPratos;
	@FXML
	private Label lblNumeroPessoas;
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
	private TextField txfNumeroPessoas;
	@FXML
	private TextField txfTempoTotal;
	@FXML
	private TextField txfTempoMedio;
	@FXML
	private TextField txfPratos;
	@FXML
	private TextField txfSalada;
	@FXML
	private TextField txfProteina;
	@FXML
	private TextField txfCarboidratos;
	@FXML
	private TextField txfSuco;
	@FXML
	private TextField txfTempoMinimoAlimentacao;
	@FXML
	private TextField txfTempoMaximoAlimentacao;
	@FXML
	private Label lblTempoTotal;
	@FXML
	private Label lblTempoMedio;
	@FXML
	private Button btnVoltar;
	@FXML
	private Button btnSalvar;
	
	public Simulacao simu = new Simulacao();
	
	public SimulacaoDTO simuDto = new SimulacaoDTO();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			ConfiguracaoController config = new ConfiguracaoController();
			this.simuDto = config.s;
			calcular();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	// Event Listener on Button[#btnSalvar].onAction
	@FXML
	public void salvar() throws SQLException {
		SimulacaoDAO dao = new SimulacaoDAO();
		dao.salvar(this.simu);
		
	}
	// Event Listener on Button[#btnVoltar].onAction
	@FXML
	public void voltar(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../fxml/InicioFxml.fxml"));
		Iniciar.stage.setScene(new Scene(root));
		Iniciar.stage.centerOnScreen();
	}
	
	public void calcular() throws SQLException {
		SimulacaoDTO s = this.simuDto;
		
		Long pratos = s.getPratos();
		Long salada = s.getSalada();
		Long carboidratos = s.getCarboidratos();
		Long proteina = s.getProteina();
		Long suco = s.getSuco();
		Double min = s.getTempoMinimo();
		Double max = s.getTempoMaximo();
		
		Long tempoTotal = 0L;
		Long tempoMedio = 0L;
		
		Long aux = 0L;
		
		List<PessoaDTO> pessoas = criaPessoas(s.getNumeroPessoas());

		for (int i = 0; i < s.getNumeroPessoas(); i++) {
			for (int j = 0; j <= 5; j++) {
				
				if(pessoas.get(i).getPosicao() == 0) {
					
					pessoas.get(i).avancarPosicao();
					pessoas.get(i).avancarTempo();
				
				} else if (pessoas.get(i).getPosicao() == 1) {
					
					if(pratos == 0) {
						pratos = s.getPratos();
						pessoas.get(i).avancarTempo();
						pratos--;
						pessoas.get(i).avancarTempo();
						pessoas.get(i).avancarPosicao();
					} else {
						pratos--;
						pessoas.get(i).avancarTempo();
						pessoas.get(i).avancarPosicao();
					}
					
				} else if (pessoas.get(i).getPosicao() == 2) {
					
					if(salada == 0) {
						salada = s.getSalada();
						pessoas.get(i).avancarTempo();
						salada--;
						pessoas.get(i).avancarTempo();
						pessoas.get(i).avancarPosicao();
					} else {
						salada--;
						pessoas.get(i).avancarTempo();
						pessoas.get(i).avancarPosicao();
					}
					
				} else if (pessoas.get(i).getPosicao() == 3) {
					
					if(carboidratos == 0) {
						carboidratos = s.getCarboidratos();
						pessoas.get(i).avancarTempo();
						carboidratos--;
						pessoas.get(i).avancarTempo();
						pessoas.get(i).avancarPosicao();
					} else {
						carboidratos--;
						pessoas.get(i).avancarTempo();
						pessoas.get(i).avancarPosicao();
					}
					
				} else if (pessoas.get(i).getPosicao() == 4) {
					
					if(proteina == 0) {
						proteina = s.getProteina();
						pessoas.get(i).avancarTempo();
						proteina--;
						pessoas.get(i).avancarTempo();
						pessoas.get(i).avancarPosicao();
					} else {
						proteina--;
						pessoas.get(i).avancarTempo();
						pessoas.get(i).avancarPosicao();
					}
					
				} else if (pessoas.get(i).getPosicao() == 5) {
					
					if(suco == 0) {
						suco = s.getSuco();
						pessoas.get(i).avancarTempo();
						suco--;
						pessoas.get(i).avancarTempo();
						pessoas.get(i).avancarPosicao();
					} else {
						suco--;
						pessoas.get(i).avancarTempo();
						pessoas.get(i).avancarPosicao();
					}
				}				
			}
			
			tempoTotal++;
		
			
			pessoas.get(i).setTempoAlimentacao((min.longValue() + (int)(Math.random() * (max.longValue() - min.longValue()))));
			
			aux = (aux == 0L ? pessoas.get(i).getTempoAlimentacao() : (pessoas.get(i).getTempoAlimentacao() > aux ? pessoas.get(i).getTempoAlimentacao() : aux)); 
			
			tempoMedio += pessoas.get(i).getTempo() + (min.longValue() + (int)(Math.random() * (max.longValue() - min.longValue()))) ;
			
		}
		
		tempoTotal += aux;		
		
		if(tempoMedio > 0 && pessoas.size() > 0) {
			tempoMedio = tempoMedio/pessoas.size();
		}
		
		
		Simulacao simulacao = new Simulacao();
		
		simulacao.setCarboidratos(s.getCarboidratos().toString());
		simulacao.setNumeroPessoas(s.getNumeroPessoas().toString());
		simulacao.setPratos(s.getPratos().toString());
		simulacao.setProteina(s.getProteina().toString());
		simulacao.setSalada(s.getSalada().toString());
		simulacao.setSuco(s.getSuco().toString());
		simulacao.setTempoMedio(tempoMedio.toString());
		simulacao.setTempoTotal(tempoTotal.toString());
		
		this.simu = simulacao;
		
		postValues();
	}

	
	private void postValues() {
		this.txfCarboidratos.setText(this.simu.getCarboidratos());
		this.txfNumeroPessoas.setText(this.simu.getNumeroPessoas());
		this.txfPratos.setText(this.simu.getPratos());
		this.txfProteina.setText(this.simu.getProteina());
		this.txfSalada.setText(this.simu.getSalada());
		this.txfSuco.setText(this.simu.getSuco());
		this.txfTempoMaximoAlimentacao.setText(String.valueOf(this.simuDto.getTempoMaximo()));
		this.txfTempoMinimoAlimentacao.setText(String.valueOf(this.simuDto.getTempoMinimo()));
		this.txfTempoMedio.setText(this.simu.getTempoMedio());
		this.txfTempoTotal.setText(this.simu.getTempoTotal());		
	}

	private List<PessoaDTO> criaPessoas(Long tamanho){
		List<PessoaDTO> pessoas =  new ArrayList<>();
		System.out.println(tamanho);
		for(int i = 0; i < tamanho; i++) {
			PessoaDTO p = new PessoaDTO();
			
			p.setPosicao(0L);
			p.setTempo(0L);
			p.setTempoAlimentacao(0L);
			
			pessoas.add(p);
		}
		
		return pessoas;
	}

}
