package fuctura.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public ArrayList<Jogador> listarTodos(Connection conexao) {
		ArrayList<Jogador> resultadoConsulta = new ArrayList<Jogador>(); 
		try {
			String comandoSql = "SELECT * FROM jogador";
			PreparedStatement pstm = conexao.prepareStatement(comandoSql);
			ResultSet resultado = pstm.executeQuery();// Query = consulta

			while (resultado.next()) {
				int codigo = resultado.getInt(1); //codigo
				String nome = resultado.getString(2);
				double altura = resultado.getDouble(3);
				double peso = resultado.getDouble(4);
				int idade = resultado.getInt(5);
				
				Jogador j = new Jogador();
				j.setCodigo(codigo);
				j.setNome(nome);
				j.setPeso(peso);
				j.setAltura(altura);
				j.setIdade(idade);
				
				resultadoConsulta.add(j);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel listar todos");
		}
		
		return resultadoConsulta;
	}
	
	public ArrayList<Jogador> listarJogadoresMaioresDe18(Connection conexao) {
		ArrayList<Jogador> resultadoConsulta = new ArrayList<Jogador>(); 
		
		try {
			String comandoSql = "select * from jogador where idade > 18";
			PreparedStatement pstm = conexao.prepareStatement(comandoSql);
			ResultSet resultado = pstm.executeQuery();// Query = consulta

			while (resultado.next()) {
				int codigo = resultado.getInt(1); //codigo
				String nome = resultado.getString(2);
				double altura = resultado.getDouble(3);
				double peso = resultado.getDouble(4);
				int idade = resultado.getInt(5);
				
				Jogador j = new Jogador();
				j.setCodigo(codigo);
				j.setNome(nome);
				j.setPeso(peso);
				j.setAltura(altura);
				j.setIdade(idade);
				
				resultadoConsulta.add(j);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel listar todos");
		}
		
		return resultadoConsulta;
	}
}
