# j2310522 - Repositório da Turma de Java 2 - 31/05/22

# Aula 2

- Criação do projeto SistemaGerenciadorDeTimes
- Criação das entidades (Classes Java)
- Criação do script para gerar as tabelas
- Primeiro contato com a API do JDBC

#

# Utilizando API JDBC para Conectar-se ao SGBD:

```java
	public static void main(String[] args) { 
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String usuario = "MUDE-ME";
		String senha = "MUDE-ME";
		
		try {
			Connection c = DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Conectado com sucesso!");
	}
```

# Referências:
- [Baixar Driver do Oracle XE](https://www.oracle.com/database/technologies/appdev/jdbc.html")