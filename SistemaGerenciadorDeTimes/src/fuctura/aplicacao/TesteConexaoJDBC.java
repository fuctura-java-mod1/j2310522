package fuctura.aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexaoJDBC {
	
	public static void main(String[] args) throws ClassNotFoundException { //veja se tem algo 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String usuario = "java2";
		String senha = "123";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			
			inserir(conexao);
			
			System.out.println("Jogador inserido com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Conectado com sucesso!");
	}
	
	public static void inserir(Connection conexao) {
		try {
			Statement smt = conexao.createStatement();
			String comandoSql = "INSERT INTO jogador VALUES ('Ciro', 1.80, 70.0, 29)";
			smt.execute(comandoSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
