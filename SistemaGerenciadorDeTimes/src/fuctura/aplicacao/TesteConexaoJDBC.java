package fuctura.aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexaoJDBC {
	
	public static void main(String[] args) { //veja se tem algo 
		String url = "";
		String usuario = "";
		String senha = "";
		
		try {
			Connection c = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
