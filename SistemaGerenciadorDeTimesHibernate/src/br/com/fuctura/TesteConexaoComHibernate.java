package br.com.fuctura;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.entity.Jogador;
import br.com.fuctura.repository.JogadorRepository;
import br.com.fuctura.util.JPAUtil;

public class TesteConexaoComHibernate {

	public static void main(String[] args) {
		String opcaoSelecionada = null;
		Scanner leituraEntrada = null;
		JogadorRepository jogadorRepositorio = new JogadorRepository();

		do {

			leituraEntrada = new Scanner(System.in);

			System.out.println("1 - Cadastrar Jogador - ");
			System.out.println("2 - Pesquisar Jogador - ");
			System.out.println("5 - Sair - ");
			System.out.println("Digite a opção selecionada: ");
			opcaoSelecionada = leituraEntrada.nextLine();

			if (opcaoSelecionada.equals("1")) {
				System.out.println("Digite o nome do Jogador: ");
				String nome = leituraEntrada.nextLine();
				System.out.println("Digite a altura do Jogador: ");
				String altura = leituraEntrada.nextLine();
					
				Jogador jogador = new Jogador();
				jogador.setNome(nome);
				jogador.setAltura(Double.valueOf(altura));

				jogadorRepositorio.create(jogador);

				System.out.println("Jogador Inserido Com Sucesso!");
			} else if (opcaoSelecionada.equals("2")) {
				System.out.println("1 - Consultar Por Nome");
				System.out.println("Digite a opção selecionada: ");
				opcaoSelecionada = leituraEntrada.nextLine();

				List<Jogador> resultado = null;

				if (opcaoSelecionada.equals("1")) {
					System.out.println("Digite o nome do jogador: ");
					
					String nome = leituraEntrada.nextLine();
					
					resultado = jogadorRepositorio.findByNome(nome);
					
					if(resultado != null) {
						System.out.println("Jogador Encontrado com sucesso:");
						resultado.forEach( e -> System.out.println(e.toString()) );
					}
					
					System.out.println("Fim da Consulta");
					
				}
			}

		} while (!opcaoSelecionada.equals("5"));

		leituraEntrada.close();
		JPAUtil.closeFabrica();

		System.out.println("Finalizando aplicacao");
	}
}
