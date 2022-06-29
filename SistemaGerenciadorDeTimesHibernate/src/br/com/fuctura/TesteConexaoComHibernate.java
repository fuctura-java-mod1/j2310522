package br.com.fuctura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.fuctura.entity.Jogador;
import br.com.fuctura.entity.Tecnico;
import br.com.fuctura.repository.JogadorRepository;

public class TesteConexaoComHibernate {

	public static void main(String[] args) {


		Jogador j = new Jogador();
		j.setNome("Pelé");
		j.setAltura(1.89);
		
		Jogador j2 = new Jogador();
		j2.setNome("Maradona");
		j2.setAltura(1.60);
		
		JogadorRepository r = new JogadorRepository();
		
		r.create(j);
		r.create(j2);
		
		
		
		
		
		
		
	}
}
