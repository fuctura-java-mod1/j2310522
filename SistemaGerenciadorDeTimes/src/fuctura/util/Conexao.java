package fuctura.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String usuario = "java2";
		String senha = "123";
		
		try {
			Connection conexao = DriverManager
					.getConnection(url, usuario, senha);
			return conexao;
		}catch (Exception e) {
			System.out.println("Falha na conexão");
			e.printStackTrace();
		}
		return null;
	}
}
