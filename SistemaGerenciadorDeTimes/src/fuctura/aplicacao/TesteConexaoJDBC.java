package fuctura.aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fuctura.model.Jogador;

public class TesteConexaoJDBC {
	
	public static void main(String[] args) { //veja se tem algo 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String usuario = "java2";
		String senha = "123";
		
		try {
			
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			
			Jogador j = new Jogador();
			j.setNome("Messi");
			j.setAltura(1.90);
			
			//inserir(conexao, j);
			inserirComPreparedStatement(conexao, j);
			
			System.out.println("Jogador inserido com sucesso!");
			
			listarTodos(conexao);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Conectado com sucesso!");
	}
	
	public static void inserir(Connection conexao, Jogador j) {
		try {
			Statement smt = conexao.createStatement();
			String comandoSql = "INSERT INTO jogador VALUES (" + j.getNome() + "," + j.getAltura() + "," + j.getPeso() + "," +  j.getIdade() + ")";
			smt.execute(comandoSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void inserirComPreparedStatement(Connection conexao, Jogador j) {
		try {
			                                               //1, 2  3  4
			String comandoSql = "INSERT INTO jogador VALUES (?, ?, ?, ?)";
			PreparedStatement psmt = conexao.prepareStatement(comandoSql);
				
			psmt.setInt(4, j.getIdade());
			psmt.setString(1, j.getNome()); 
			psmt.setDouble(3, j.getPeso());
			psmt.setDouble(2, j.getAltura());
			
			psmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void listarTodos(Connection conexao) throws SQLException {
		String comandoSql = "SELECT * FROM jogador";
		PreparedStatement pstm = conexao.prepareStatement(comandoSql);
		ResultSet resultado = pstm.executeQuery();//Query = consulta
		
		while( resultado.next() ) {
			String nome = resultado.getString(1);
			int idade = resultado.getInt(4);
			System.out.println("Nome: " + nome);
			System.out.println("Idade: " + idade);
		}
		
	}
	
	
}
