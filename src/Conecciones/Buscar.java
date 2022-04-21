package Conecciones;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Formularios.FormAgregar;
import Formularios.FormAgregar2;
import Formularios.FormVenta;
import Formularios.FormVenta2;
import Formularios.Menu;

public class Buscar {

	public int filas;
	
	public void Query(String marca) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares","root", "");
	
			Statement statement = conexion.createStatement();
			
			ResultSet resultset = statement.executeQuery("select * from productos where Marca = '"+marca+"'");
			
			if(resultset.last()) {
			filas = resultset.getRow();	
			
	
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset.absolute(i)) 
					{
						Menu.filas[0]=String.valueOf(resultset.getInt("ID_Producto"));
						Menu.filas[1]=String.valueOf(resultset.getString("Nombre"));
						Menu.filas[2]=String.valueOf(resultset.getString("Marca"));
						Menu.filas[3]= "RD$" + String.valueOf(resultset.getInt("Precio"));
						Menu.filas[4]=String.valueOf(resultset.getInt("Cantidad"));
						Menu.tabadd.addRow(Menu.filas);
					
					}
				}
			}
			
			ResultSet resultset2 = statement.executeQuery("select * from accesorios where Marca = '"+marca+"'");
			
			if(resultset2.last()) {
			filas = resultset2.getRow();	
			
	
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset2.absolute(i)) 
					{
						Menu.filas[0]=String.valueOf(resultset2.getInt("ID_Accesorio"));
						Menu.filas[1]=String.valueOf(resultset2.getString("Producto"));
						Menu.filas[2]=String.valueOf(resultset2.getString("Marca"));
						Menu.filas[3]= "RD$" + String.valueOf(resultset2.getInt("Precio"));
						Menu.filas[4]=String.valueOf(resultset2.getInt("Cantidad"));
						Menu.tabadd.addRow(Menu.filas);
					
					}
				}
				
				String Mensaje = "Estos son los resultados";
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
	
	public void Query2(int codigo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares","root", "");
	
			Statement statement = conexion.createStatement();
			
			ResultSet resultset = statement.executeQuery("select * from productos where ID_Producto = '"+codigo+"'");
			
			if(resultset.last()) {
			filas = resultset.getRow();	
			
	
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset.absolute(i)) 
					{
						Menu.filas[0]=String.valueOf(resultset.getInt("ID_Producto"));
						Menu.filas[1]=String.valueOf(resultset.getString("Nombre"));
						Menu.filas[2]=String.valueOf(resultset.getString("Marca"));
						Menu.filas[3]= "RD$" + String.valueOf(resultset.getInt("Precio"));
						Menu.filas[4]=String.valueOf(resultset.getInt("Cantidad"));
						Menu.tabadd.addRow(Menu.filas);
					
					}
				}
			}
			
			ResultSet resultset2 = statement.executeQuery("select * from accesorios where ID_Accesorio = '"+codigo+"'");
			
			if(resultset2.last()) {
			filas = resultset2.getRow();	
			
	
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset2.absolute(i)) 
					{
						Menu.filas[0]=String.valueOf(resultset2.getInt("ID_Accesorio"));
						Menu.filas[1]=String.valueOf(resultset2.getString("Producto"));
						Menu.filas[2]=String.valueOf(resultset2.getString("Marca"));
						Menu.filas[3]= "RD$" + String.valueOf(resultset2.getInt("Precio"));
						Menu.filas[4]=String.valueOf(resultset2.getInt("Cantidad"));
						Menu.tabadd.addRow(Menu.filas);
					
					}
				}
				
				String Mensaje = "Estos son los resultados";
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
		
	public void Query3(String marca) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares","root", "");
	
			Statement statement = conexion.createStatement();
			
			ResultSet resultset = statement.executeQuery("select * from productos where Marca = '"+marca+"'");
			
			if(resultset.last()) {
			filas = resultset.getRow();	
			
	
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset.absolute(i)) 
					{
						FormVenta.ProductoCB.addItem(resultset.getString("Nombre"));
					
					}
				}
				
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
	
	public void Query4(String marca) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares","root", "");
	
			Statement statement = conexion.createStatement();
			
			ResultSet resultset = statement.executeQuery("select * from productos where Marca = '"+marca+"'");
			
			if(resultset.last()) {
			filas = resultset.getRow();	
			
	
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset.absolute(i)) 
					{
						FormAgregar.ProductoCB.addItem(resultset.getString("Nombre"));
					
					}
				}
				
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
	
	public void Query5(String marca) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares","root", "");
	
			Statement statement = conexion.createStatement();
			
			ResultSet resultset = statement.executeQuery("select * from accesorios where Marca = '"+marca+"'");
			
			if(resultset.last()) {
			filas = resultset.getRow();	
			
	
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset.absolute(i)) 
					{
						FormVenta2.ProductoCB.addItem(resultset.getString("Producto"));
					
					}
				}
				
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
	
	public void Query6(String marca) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares","root", "");
	
			Statement statement = conexion.createStatement();
			
			ResultSet resultset = statement.executeQuery("select * from accesorios where Marca = '"+marca+"'");
			
			if(resultset.last()) {
			filas = resultset.getRow();	
			
	
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset.absolute(i)) 
					{
						FormAgregar2.ProductoCB.addItem(resultset.getString("Producto"));
					
					}
				}
				
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
	
	public void Query7(String fecha) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares","root", "");
	
			Statement statement = conexion.createStatement();
			
			
			ResultSet resultset = statement.executeQuery("select * from historial where Fecha = '"+fecha+"'");
			
			if(resultset.first() == false) 
			{
				resultset = statement.executeQuery("select * from historial");
			}
			
			if(resultset.last()) {
			filas = resultset.getRow();	
	
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset.absolute(i)) 
					{
						Menu.filas[0]=String.valueOf(resultset.getInt("ID_Codigo"));
						Menu.filas[1]=String.valueOf(resultset.getString("Producto"));
						Menu.filas[2]=String.valueOf(resultset.getString("Fecha"));
						Menu.filas[3]= "RD$" + String.valueOf(resultset.getInt("Precio"));
						Menu.filas[4]=String.valueOf(resultset.getInt("Cantidad"));
						Menu.tabadd.addRow(Menu.filas);
					
					}
				}
				
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
	
	public void Query8(int codigo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conexion = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendacelulares","root", "");
	
			Statement statement = conexion.createStatement();
			
			ResultSet resultset = statement.executeQuery("select * from historial where ID_Codigo = '"+codigo+"'");
			
			if(resultset.last()) {
			filas = resultset.getRow();	
			
	
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset.absolute(i)) 
					{
						Menu.filas[0]=String.valueOf(resultset.getInt("ID_Codigo"));
						Menu.filas[1]=String.valueOf(resultset.getString("Producto"));
						Menu.filas[2]=String.valueOf(resultset.getString("Fecha"));
						Menu.filas[3]= "RD$" + String.valueOf(resultset.getInt("Precio"));
						Menu.filas[4]=String.valueOf(resultset.getInt("Cantidad"));
						Menu.tabadd.addRow(Menu.filas);
					
					}
				}
				
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
