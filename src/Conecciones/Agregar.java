package Conecciones;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import ClasesAbstractas.AgregarOVender;
import Formularios.Menu;

public class Agregar implements AgregarOVender{
	
	int ID;
	int Cantidad;
	public int Precio;
	
	public void Query(String marca, String producto, int cantidad) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares","root", "");
			
			
			Statement statement = conexion.createStatement();
			
			ResultSet resultset = statement.executeQuery("select * from productos where Marca = '"+marca+"'and Nombre = '"+producto+"'");
			
			if(resultset.last()) 
			{
				ID = resultset.getInt("ID_Producto");
				Cantidad = resultset.getInt("Cantidad") + cantidad;
				Precio = resultset.getInt("Precio");
			}
			
			statement.executeUpdate("update productos set Cantidad = '"+Cantidad+"' where ID_Producto = '"+ID+"'");
			
			int numero = (int)(Math.random()*1000+9999);
			String fecha = Menu.Date.getText();
			statement.executeUpdate("insert into historial values("+numero+",'"+producto+"','"+fecha+"',"+Precio*cantidad+","+cantidad+")");
			
			String Mensaje = "Elementos agregados existosamente";
			JOptionPane.showMessageDialog(null, Mensaje);
			
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
	
	public void Query2(String marca, String producto, int cantidad) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares","root", "");
			
			
			Statement statement = conexion.createStatement();
			
			ResultSet resultset = statement.executeQuery("select * from accesorios where Marca = '"+marca+"'and Producto = '"+producto+"'");
			
			if(resultset.last()) 
			{
				ID = resultset.getInt("ID_Accesorio");
				Cantidad = resultset.getInt("Cantidad") + cantidad;
				Precio = resultset.getInt("Precio");
			}
			
			statement.executeUpdate("update accesorios set Cantidad = '"+Cantidad+"' where ID_Accesorio = '"+ID+"'");
			
			int numero = (int)(Math.random()*1000+9999);
			String fecha = Menu.Date.getText();
			statement.executeUpdate("insert into historial values("+numero+",'"+producto+"','"+fecha+"',"+Precio*cantidad+","+cantidad+")");
			
			String Mensaje = "Elementos agregados existosamente";
			JOptionPane.showMessageDialog(null, Mensaje);
			
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
	
	public void Query3(String marca, String producto, int cantidad, String tipo, int precio) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares","root", "");
			
			int ID = (int)(Math.random()*1000+9999);
			
			if (tipo == "Celular") 
			{
				Statement statement = conexion.createStatement();
				
				statement.executeUpdate("insert into productos values ("+ID+",'"+producto+"','"+marca+"',"+precio+","+cantidad+")");
				
				String Mensaje = "Producto agregado existosamente";
				JOptionPane.showMessageDialog(null, Mensaje);
			}
			
			else 
			{
				Statement statement = conexion.createStatement();
				
				statement.executeUpdate("insert into accesorios values ("+ID+",'"+producto+"','"+marca+"',"+precio+","+cantidad+")");
				
				String Mensaje = "Producto agregado existosamente";
				JOptionPane.showMessageDialog(null, Mensaje);
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
