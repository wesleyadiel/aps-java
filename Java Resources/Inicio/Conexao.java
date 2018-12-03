package Inicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection connection = null;

	public Conexao() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		String databaseURL = "jdbc:postgresql://localhost/ApsJava";
		String usuario = "postgres";
		String senha = "postgres";
		String driverName = "org.postgresql.Driver";
		Class.forName(driverName).newInstance();
		connection = DriverManager.getConnection(databaseURL, usuario, senha);
	}

}
