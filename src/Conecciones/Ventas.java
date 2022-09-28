package Conecciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Formularios.Menu;

public class Ventas{
	
	Conection conection = new Conection();
	public int ID;
	int Cantidad;
	public int Precio;
	public int filas;
	public int numero;
	
	public void VenderCelulares(String marca, String producto, int cantidad) {
		try {
			
			ResultSet resultset = conection.statement().executeQuery("select * from productos where Marca = '"+marca+"'and Nombre = '"+producto+"'");
			
			if(resultset.first()) {
			if(resultset.getInt("Cantidad") <= 0) 
			{
				String Mensaje = "Este producto esta agotado";
				JOptionPane.showMessageDialog(null, Mensaje);
			}
			
			else {
			if(resultset.last()) 
			{
				ID = resultset.getInt("ID_Producto");
				Precio = resultset.getInt("Precio");
			}
			
			numero = (int)(Math.random()*1000+9999);
			
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);    
			
			String fecha = date.toString();
			
			conection.statement().executeUpdate("insert into cuentasporpagar values("+numero+",'"+producto+"','"+fecha+"',"+Precio*cantidad+","+cantidad+")");
			
			ResultSet resultset2 = conection.statement().executeQuery("select * from cuentasporpagar");
			
			if(resultset2.first()) {
				filas = resultset2.getRow();	
				
		
					for (int i = 0; i <= filas; i++) 
					{
						if(resultset2.absolute(i)) 
						{
							Menu.filas[0]=String.valueOf(resultset2.getInt("ID_Codigo"));
							Menu.filas[1]=String.valueOf(resultset2.getString("Producto"));
							Menu.filas[2]=String.valueOf(resultset2.getString("Fecha"));
							Menu.filas[3]= "RD$" + String.valueOf(resultset2.getInt("Precio"));
							Menu.filas[4]=String.valueOf(resultset2.getInt("Cantidad"));
							Menu.tabadd.addRow(Menu.filas);
						
						}
					}
					
				}
			}
		}
			conection.ConnectionClose();
		}
		
		catch(SQLException l) 
		{
			l.printStackTrace();
		}
		
	}
	
	public void VenderAccesorios(String marca, String producto, int cantidad) {
		try {
			ResultSet resultset = conection.statement().executeQuery("select * from accesorios where Marca = '"+marca+"'and Producto = '"+producto+"'");
			
			if(resultset.first()) {
			if(resultset.getInt("Cantidad") <= 0) 
			{
				String Mensaje = "Este producto esta agotado";
				JOptionPane.showMessageDialog(null, Mensaje);
			}
			
			else {
			if(resultset.last()) 
			{
				ID = resultset.getInt("ID_Accesorio");
				Precio = resultset.getInt("Precio");
			}
			
			numero = (int)(Math.random()*10000+99999);
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);   
			String fecha = date.toString();
			conection.statement().executeUpdate("insert into cuentasporpagar values("+numero+",'"+producto+"','"+fecha+"',"+Precio*cantidad+","+cantidad+")");
			
			ResultSet resultset2 = conection.statement().executeQuery("select * from cuentasporpagar");
			
			if(resultset2.first()) {
				filas = resultset2.getRow();	
				
					for (int i = 0; i <= filas; i++) 
					{
						if(resultset2.absolute(i)) 
						{
							Menu.filas[0]=String.valueOf(resultset2.getInt("ID_Codigo"));
							Menu.filas[1]=String.valueOf(resultset2.getString("Producto"));
							Menu.filas[2]=String.valueOf(resultset2.getString("Fecha"));
							Menu.filas[3]= "RD$" + String.valueOf(resultset2.getInt("Precio"));
							Menu.filas[4]=String.valueOf(resultset2.getInt("Cantidad"));
							Menu.tabadd.addRow(Menu.filas);
						
						}
					}	
				}
			}
		}
			conection.ConnectionClose();
	
		}
		
		catch(SQLException l) 
		{
			l.printStackTrace();
		}
	}
	
	public void FacturarCelulares() {
		try {
			
			int ID_Codigo = 0;
			String Producto = "";
			String fecha = "";
			int Precio = 0;
			int cantidad = 0;
			int canti = 0;
			
			ResultSet resultset = conection.statement().executeQuery("select * from productos");
			if(resultset.first()) 
			{
			ID = resultset.getInt("ID_Producto");
			canti = resultset.getInt("Cantidad");
			}
			
			ResultSet resultset2 = conection.statement().executeQuery("select * from cuentasporpagar");
			
			if(resultset2.first()) {
				ID_Codigo = resultset2.getInt("ID_Codigo");
				Producto = resultset2.getString("Producto");
				fecha = resultset2.getString("Fecha");
				Precio = resultset2.getInt("Precio");
				cantidad = resultset2.getInt("Cantidad");
				Cantidad = canti - cantidad;
			}
				
			conection.statement().executeUpdate("update productos set Cantidad = '"+Cantidad+"' where ID_Producto = '"+ID+"'");
			
			conection.statement().executeUpdate("insert into historial values("+ID_Codigo+",'"+Producto+"','"+fecha+"',"+Precio+","+cantidad+")");
			
			conection.statement().executeUpdate("Delete from cuentasporpagar where ID_codigo = "+ID_Codigo+"");
			
			String Mensaje = "Venta realizada existosamente";
			JOptionPane.showMessageDialog(null, Mensaje);
			
			conection.ConnectionClose();
		}
		catch(SQLException l) 
		{
			l.printStackTrace();
		}
	}
	
	public void FacturarAccesorios() {
		try {
			
			int ID_Codigo = 0;
			String Producto = "";
			String fecha = "";
			int Precio = 0;
			int cantidad = 0;
			int canti = 0;
			
			ResultSet resultset = conection.statement().executeQuery("select * from accesorios");
			if(resultset.first()) 
			{
			ID = resultset.getInt("ID_Accesorio");
			canti = resultset.getInt("Cantidad");
			}
			
			ResultSet resultset2 = conection.statement().executeQuery("select * from cuentasporpagar");
			
			if(resultset2.first()) {
				ID_Codigo = resultset2.getInt("ID_Codigo");
				Producto = resultset2.getString("Producto");
				fecha = resultset2.getString("Fecha");
				Precio = resultset2.getInt("Precio");
				cantidad = resultset2.getInt("Cantidad");
				Cantidad = canti - cantidad;
			}
			
			conection.statement().executeUpdate("update accesorios set Cantidad = '"+Cantidad+"' where ID_Accesorio = '"+ID+"'");
			
			conection.statement().executeUpdate("insert into historial values("+ID_Codigo+",'"+Producto+"','"+fecha+"',"+Precio+","+cantidad+")");
			
			conection.statement().executeUpdate("Delete from cuentasporpagar where ID_codigo = "+ID_Codigo+"");
			
			String Mensaje = "Venta realizada existosamente";
			JOptionPane.showMessageDialog(null, Mensaje);
			
			conection.ConnectionClose();
		}
		
		catch(SQLException l) 
		{
			l.printStackTrace();
		}
	}
}
