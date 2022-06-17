package fuctura.aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fuctura.model.Jogador;
import fuctura.repository.JogadorRepository;
import fuctura.util.Conexao;

public class TesteConexaoJDBC {

	public static void main(String[] args) { // veja se tem algo

		Conexao c = new Conexao();
		Connection conexao = c.getConnection();

//		Jogador j = new Jogador();
//		j.setCodigo(9);
//		j.setNome("Messi");
//		j.setAltura(1.90);

		JogadorRepository repository = new JogadorRepository();

//		repository.inserir(conexao, j);
		
		ArrayList<Jogador> resultadoConsulta = repository.listarJogadoresMaioresDe18(conexao);

		System.out.println("Quantidade jogadores encontrados: " + resultadoConsulta.size());
		
		System.out.println("Conectado com sucesso!");
	}
}
