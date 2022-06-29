package br.com.fuctura;

import br.com.fuctura.entity.Jogador;
import br.com.fuctura.repository.JogadorRepository;
import br.com.fuctura.util.JPAUtil;

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
		
		
		
		r.delete(j);
		
		System.out.println("Finalizando aplicacao");
		JPAUtil.closeFabrica();
	}
}
