package br.com.fuctura.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Clube {
	@Id
	@GeneratedValue
	private Integer codigo;
	private String nome;
	@OneToOne
	private Time time;
}
