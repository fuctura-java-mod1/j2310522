package fuctura.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fuctura.model.Jogador;

public class JogadorRepository {
	
	//inserir
	public void inserir(Connection conexao, Jogador j) {
		try {
			// 1, 2 3 4, 5
			String comandoSql = "INSERT INTO jogador VALUES (?, ?, ?, ?, ?)";
			PreparedStatement psmt = conexao.prepareStatement(comandoSql);

			psmt.setInt(1, j.getCodigo());
			psmt.setString(2, j.getNome());
			psmt.setDouble(3, j.getAltura());
			psmt.setDouble(4, j.getPeso());
			psmt.setInt(5, j.getIdade());

			psmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listarTodos(Connection conexao) {
		
		try {
			String comandoSql = "SELECT * FROM jogador";
			PreparedStatement pstm = conexao.prepareStatement(comandoSql);
			ResultSet resultado = pstm.executeQuery();// Query = consulta

			while (resultado.next()) {
				String nome = resultado.getString(2);
				int idade = resultado.getInt(5);
				System.out.println("Nome: " + nome);
				System.out.println("Idade: " + idade);
			}
		}catch (Exception e) {
			System.out.println("Nao foi possivel listar todos");
		}
		


	}
}
