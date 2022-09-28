package Conecciones;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conection {
	
	java.sql.Connection conexion = null;
	
	public Statement statement() {
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares?useSSL=false","root", "itla-2021");
			statement = conexion.createStatement();
		} 
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}

		return statement;
	}

	public void ConnectionClose() 
	{
		try {
			conexion.close();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
