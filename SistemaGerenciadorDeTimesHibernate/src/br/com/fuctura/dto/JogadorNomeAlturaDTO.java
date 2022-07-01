package br.com.fuctura.dto;

public class JogadorNomeAlturaDTO {

	private String nome;
	private Double altura;
	
	public JogadorNomeAlturaDTO(Double altura, String nome) {
		this.nome = nome;
		this.altura = altura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}
}
