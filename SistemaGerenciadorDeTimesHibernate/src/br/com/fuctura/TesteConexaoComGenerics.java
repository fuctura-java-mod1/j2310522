package br.com.fuctura;

import br.com.fuctura.entity.Jogador;
import br.com.fuctura.repository.JPARepositorio;
import br.com.fuctura.repository.JPARepositorioImpl;

public class TesteConexaoComGenerics {
	public static void main(String[] args) {
		JPARepositorio<Jogador> repoJogador = new JPARepositorioImpl<Jogador>();
		
		repoJogador.create(null);
		
	}
}
