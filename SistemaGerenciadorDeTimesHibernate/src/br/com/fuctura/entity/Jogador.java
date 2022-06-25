package br.com.fuctura.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "tb_jogador")
public class Jogador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	private Double altura;
	@Column(name = "nome_jogador", nullable = false, length = 20)
	private String nome;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@PrePersist
	public void antesDeInserir() {
		System.out.println("Invocando antes de inserir");
	}
}
