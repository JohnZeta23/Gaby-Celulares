package Conecciones;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import ClasesAbstractas.AgregarOVender;
import Formularios.Menu;

public class Agregar implements AgregarOVender{
	
	Conection conection = new Conection();
	int ID;
	int Cantidad;
	public int Precio;
	
	public void AumentarCantidadCelulares(String marca, String producto, int cantidad) {
		try {
			ResultSet resultset = conection.statement().executeQuery("select * from productos where Marca = '"+marca+"'and Nombre = '"+producto+"'");
			
			if(resultset.last()) {
				ID = resultset.getInt("ID_Producto");
				Cantidad = resultset.getInt("Cantidad") + cantidad;
				Precio = resultset.getInt("Precio");
			}
			
			conection.statement().executeUpdate("update productos set Cantidad = '"+Cantidad+"' where ID_Producto = '"+ID+"'");
			
			int numero = (int)(Math.random()*1000+9999);
			String fecha = Menu.Date.getText();
			conection.statement().executeUpdate("insert into historial values("+numero+",'"+producto+"','"+fecha+"',"+Precio*cantidad+","+cantidad+")");
			
			String Mensaje = "Elementos agregados existosamente";
			JOptionPane.showMessageDialog(null, Mensaje);
			
			conection.ConnectionClose();
		}

		catch(SQLException l) 
		{
			l.printStackTrace();
		}		
	}
	
	public void AumentarCantidadAccesorios(String marca, String producto, int cantidad) {
		try {
			ResultSet resultset = conection.statement().executeQuery("select * from accesorios where Marca = '"+marca+"'and Producto = '"+producto+"'");
			
			if(resultset.last()) {
				ID = resultset.getInt("ID_Accesorio");
				Cantidad = resultset.getInt("Cantidad") + cantidad;
				Precio = resultset.getInt("Precio");
			}
			
			conection.statement().executeUpdate("update accesorios set Cantidad = '"+Cantidad+"' where ID_Accesorio = '"+ID+"'");
			
			int numero = (int)(Math.random()*1000+9999);
			String fecha = Menu.Date.getText();
			conection.statement().executeUpdate("insert into historial values("+numero+",'"+producto+"','"+fecha+"',"+Precio*cantidad+","+cantidad+")");
			
			String Mensaje = "Elementos agregados existosamente";
			JOptionPane.showMessageDialog(null, Mensaje);
			
			conection.ConnectionClose();	
		}
	
		catch(SQLException l) 
		{
			l.printStackTrace();
		}
	}
	
	public void RegistrarProductosNuevos(String marca, String producto, int cantidad, String tipo, int precio) {
		try {
			
			int ID = (int)(Math.random()*1000+9999);
			
			if (tipo == "Celular") {
				conection.statement().executeUpdate("insert into productos values ("+ID+",'"+producto+"','"+marca+"',"+precio+","+cantidad+")");	
				String Mensaje = "Producto agregado existosamente";
				JOptionPane.showMessageDialog(null, Mensaje);
			}
			
			else {
				conection.statement().executeUpdate("insert into accesorios values ("+ID+",'"+producto+"','"+marca+"',"+precio+","+cantidad+")");
				String Mensaje = "Producto agregado existosamente";
				JOptionPane.showMessageDialog(null, Mensaje);
			}
			conection.ConnectionClose();
		}
		
		catch(SQLException l) 
		{
			l.printStackTrace();
		}
	}
}
