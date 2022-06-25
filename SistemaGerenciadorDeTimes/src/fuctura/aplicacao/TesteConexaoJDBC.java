package fuctura.aplicacao;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fuctura.TestadorAula4;
import fuctura.model.Jogador;
import fuctura.repository.JogadorRepository;
import fuctura.util.Conexao;

public class TesteConexaoJDBC {

	public static void main(String[] args) { // veja se tem algo

		Conexao c = new Conexao();
		Connection conexao = c.getConnection();

		TestadorAula4 t = new TestadorAula4();
		
		
		
		
	}
}
