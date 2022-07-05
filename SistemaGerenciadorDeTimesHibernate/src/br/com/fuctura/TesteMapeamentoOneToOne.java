package br.com.fuctura;

import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entity.Jogador;
import br.com.fuctura.entity.Time;
import br.com.fuctura.repository.JogadorRepository;
import br.com.fuctura.repository.TimeRepository;
import br.com.fuctura.util.JPAUtil;

public class TesteMapeamentoOneToOne {

	public static void main(String[] args) {
		JPAUtil.getFabrica();

		JogadorRepository jogadorRepo = new JogadorRepository();
		TimeRepository timeRepo = new TimeRepository();
		
		
		Jogador j = new Jogador(1.90, 90.0, "Cafú");
		
		//jogadorRepo.create(j);
		
		List<Jogador> jogadores = new ArrayList<Jogador>();
		
		jogadores.add(j);
		
		Time selecao = new Time("Seleção Brasileira");
		
		selecao.setJogadores(jogadores);
		
		timeRepo.create(selecao);
		
		List<Jogador> consulta = jogadorRepo.findByNome("Cafú");
		
		consulta.forEach( jo -> System.out.println(jo) );
		
	}
}
