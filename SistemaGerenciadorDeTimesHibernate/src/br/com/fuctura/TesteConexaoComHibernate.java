package br.com.fuctura;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dto.JogadorNomeAlturaDTO;
import br.com.fuctura.entity.Clube;
import br.com.fuctura.entity.Jogador;
import br.com.fuctura.repository.ClubeRepository;
import br.com.fuctura.repository.JogadorRepository;
import br.com.fuctura.util.JPAUtil;

public class TesteConexaoComHibernate {

	public static void main(String[] args) {
		String opcaoSelecionada = null;
		Scanner leituraEntrada = null;
		
		JPAUtil.getFabrica();
		
		JogadorRepository jogadorRepositorio = new JogadorRepository();
		ClubeRepository clubeRepository = new ClubeRepository();

		do {

			leituraEntrada = new Scanner(System.in);
			
			exibirMenuInicial();
			
			opcaoSelecionada = leituraEntrada.nextLine();

			if (opcaoSelecionada.equals("1")) {
				
				exibirMenuGerenciamentoJogador();
				
				opcaoSelecionada = leituraEntrada.nextLine();
				
				if(opcaoSelecionada.equals("1")) {
					
					Jogador jogador = criarJogador(leituraEntrada);
					
					jogadorRepositorio.create(jogador);

					System.out.println("Jogador Inserido Com Sucesso!");

				}else if(opcaoSelecionada.equals("2")) {
					
					exibirMenuConsultasJogador();

					System.out.println("Digite a opção selecionada: ");
					opcaoSelecionada = leituraEntrada.nextLine();

					List<Jogador> resultado = null;

					if (opcaoSelecionada.equals("1")) {
						System.out.println("Digite o nome do jogador: ");

						String nome = leituraEntrada.nextLine();

						resultado = jogadorRepositorio.findByNome(nome);

						if (resultado != null) {
							System.out.println("Jogador Encontrado com sucesso:");
							resultado.forEach(e -> System.out.println(e.toString()));
						}

						System.out.println("Fim da Consulta");

					} else if (opcaoSelecionada.equals("2")) {
						System.out.println("Digite o nome do jogador: ");

						String nome = leituraEntrada.nextLine();
						
						System.out.println("Digite a altura do jogador: ");
						
						String altura = leituraEntrada.nextLine();

//						List<JogadorNomeAlturaDTO> resultado = jogadorRepositorio.findByNomeAndAltura2(nome, Double.valueOf(altura));
						
						if (resultado != null) {
							System.out.println("Jogador Encontrado com sucesso:");
							resultado.forEach(e -> System.out.println(e.toString()));
						}

						System.out.println("Fim da Consulta");

					}

				}
				
				} else if (opcaoSelecionada.equals("2")) {
							}

		} while (!opcaoSelecionada.equals("5"));

		leituraEntrada.close();
		JPAUtil.closeFabrica();

		System.out.println("Finalizando aplicacao");
	}

	private static Jogador criarJogador(Scanner leituraEntrada) {
		System.out.println("Digite o nome do Jogador: ");
		String nome = leituraEntrada.nextLine();
		System.out.println("Digite a altura do Jogador: ");
		String altura = leituraEntrada.nextLine();
		
		Jogador jogador = new Jogador();
		jogador.setNome(nome);
		jogador.setAltura(Double.valueOf(altura));
		
		return jogador;
	}

	private static void exibirMenuConsultasJogador() {
		System.out.println("1 - Consultar Por Nome");
		System.out.println("2 - Consultar Por Altura e Nome");
	}

	private static void exibirMenuGerenciamentoJogador() {
		System.out.println("-- Escolha Uma das Opções Abaixo --");
		System.out.println("1 - Cadastrar Jogador - ");
		System.out.println("2 - Pesquisar Jogador - ");
		System.out.println("3 - Voltar - ");
		System.out.println("Digite a opção selecionada: ");		
	}

	private static void exibirMenuInicial() {
		System.out.println("-- Escolha Uma das Opções Abaixo --");	
		System.out.println("1 - Gerenciar Jogador - ");
		System.out.println("2 - Gerenciar Clube - ");
		System.out.println("5 - Sair - ");
		System.out.println("Digite a opção selecionada: ");
	}

	private static void exibirTodos(List<Clube> clubesCadastrados) {
		// TODO Auto-generated method stub
		clubesCadastrados.forEach( o -> System.out.println(o.toString()) );
	}
}
