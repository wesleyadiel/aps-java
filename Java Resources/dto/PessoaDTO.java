package dto;

public class PessoaDTO {
	
	private Long tempo;
	private Long posicao;
	private Long tempoAlimentacao;
	
	public Long getTempo() {
		return tempo;
	}
	public void setTempo(Long tempo) {
		this.tempo = tempo;
	}
	public Long getPosicao() {
		return posicao;
	}
	public void setPosicao(Long posicao) {
		this.posicao = posicao;
	}
	public Long getTempoAlimentacao() {
		return tempoAlimentacao;
	}
	public void setTempoAlimentacao(Long tempoAlimentacao) {
		this.tempoAlimentacao = tempoAlimentacao;
	}
	public void avancarPosicao() {
		this.posicao++;
	}
	public void avancarTempo() {
		this.tempo++;
	}

}
