package br.com.fuctura.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_jogador")
@NamedQueries({ @NamedQuery(name = "Andre", query = "SELECT j FROM Jogador j WHERE j.nome = :parametro") })

public class Jogador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	private Double altura;
	private Double peso;
	private String nome;

	@OneToOne
	@JoinColumn(name = "clube_codigo")
	private Clube clube;

	public Jogador() {

	}

	public Jogador(Double altura, Double peso, String nome) {
		this.altura = altura;
		this.peso = peso;
		this.nome = nome;
	}

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

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {
		this.clube = clube;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// sobrescrever um método da classe Pai
	@Override
	public String toString() {
		return "Jogador [codigo=" + codigo + ", altura=" + altura + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, codigo, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		return Objects.equals(altura, other.altura) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(nome, other.nome);
	}
}
