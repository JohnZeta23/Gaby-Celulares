package Conecciones;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Login{

	public int Acceso;
	int usuario;
	int contraseņa;
	
	public void Query(int Usuario, int Contraseņa) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares","root", "");
	
			Statement statement = conexion.createStatement();
			
		
			usuario = Usuario;
			contraseņa = Contraseņa;
			
				ResultSet resultset = statement.executeQuery("select * from usuarios where Contraseņa = '"+contraseņa+"' and Usuario = '"+usuario+"'");
				
				if(resultset.first() == true) 
				{
					String Mensaje = "Login exitoso";
					JOptionPane.showMessageDialog(null, Mensaje);
					Acceso = 1;
				}
				
				if(resultset.first() == false) 
				{
					String Mensaje = "Login erroneo";
					JOptionPane.showMessageDialog(null, Mensaje);
					Acceso = 2;
				}
					
			conexion.close();
	
		} catch(ClassNotFoundException o) 
		{
			o.printStackTrace();
		} 
		
		catch(SQLException l) 
		{
			l.printStackTrace();
		}
		
	}
		
}
