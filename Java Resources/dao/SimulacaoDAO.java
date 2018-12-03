package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import Inicio.Conexao;
import entidade.Simulacao;

public class SimulacaoDAO {
	
	private String cabecalhoInsert = "INSERT INTO simulacao (numeroPessoas, pratos, salada, carboidratos, proteina, suco, tempoTotal, TempoMedio) VALUES ";
	
	private static final Logger log = Logger.getLogger("SimulacaoDAO");
	
	private Statement stm;
	
	public SimulacaoDAO() throws SQLException {
		this.stm =  Conexao.connection.createStatement();
	}
	
	
	public void salvar(Simulacao simulacao) throws SQLException {
		try {
			this.stm.execute(cabecalhoInsert + "("
				+ simulacao.getNumeroPessoas() + ", "
				+ simulacao.getPratos() + ", "
				+ simulacao.getSalada() + ", "
				+ simulacao.getCarboidratos() + ", "
				+ simulacao.getProteina() + ", "
				+ simulacao.getSuco() + ", "
				+ simulacao.getTempoTotal() + ", "
				+ simulacao.getTempoMedio() + ");"
				);
		
			log.info("Simulação salva com sucesso!");

		} catch (Exception e) {
			System.out.println("FALHA AO SALVAR SIMULAÇÃO -> " + e.getMessage());
		}
	}

	public List<Simulacao> getAll() throws SQLException{
		try {
			List<Simulacao> all = new ArrayList<Simulacao>();

			ResultSet rs = this.stm.executeQuery("SELECT * FROM simulacao");

			while (rs.next()) {
				Simulacao s = new Simulacao();

				s.setCarboidratos(rs.getString("carboidratos"));
				s.setNumeroPessoas(rs.getString("numeroPessoas"));
				s.setPratos(rs.getString("pratos"));
				s.setProteina(rs.getString("proteina"));
				s.setSalada(rs.getString("salada"));
				s.setSuco(rs.getString("suco"));
				s.setTempoMedio(rs.getString("tempoMedio"));
				s.setTempoTotal(rs.getString("tempoTotal"));

				all.add(s);
			}

			log.info("Busca realizada com sucesso!");

			return all;

		} catch (Exception e) {
			System.out.println("FALHA AO BUSCAR SIMULAÇÃO -> " + e.getMessage());
		}

		return null;

	}

}
