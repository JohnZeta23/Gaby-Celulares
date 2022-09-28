package Conecciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Formularios.FormAgregarCelulares;
import Formularios.FormAgregarAccesorios;
import Formularios.FormVentaCelulares;
import Formularios.FormVentaAccesorios;
import Formularios.Menu;

public class Buscar {

	Conection conection = new Conection();
	public int filas;
	
	public void BuscarProductosPorMarca(String marca) {
		try {		
			ResultSet resultset = conection.statement().executeQuery("select * from productos where Marca = '"+marca+"'");
			
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
			
			ResultSet resultset2 = conection.statement().executeQuery("select * from accesorios where Marca = '"+marca+"'");
			
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
			conection.ConnectionClose();
		}
		catch(SQLException l) 
		{
			l.printStackTrace();
		}
	}
	
	public void BuscarProductosPorCodigo(int codigo) {
		try {		
			ResultSet resultset = conection.statement().executeQuery("select * from productos where ID_Producto = '"+codigo+"'");
			
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
			
			ResultSet resultset2 = conection.statement().executeQuery("select * from accesorios where ID_Accesorio = '"+codigo+"'");
			
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
			conection.ConnectionClose();
		}
		catch(SQLException l) 
		{
			l.printStackTrace();
		}
	}
		
	public void BuscarCelulares(String marca) {
		try {
			ResultSet resultset = conection.statement().executeQuery("select * from productos where Marca = '"+marca+"'");
			
			if(resultset.last()) {
			filas = resultset.getRow();	
			
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset.absolute(i)) 
					{
						FormVentaCelulares.ProductoCB.addItem(resultset.getString("Nombre"));	
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
	
	public void AgregarCelulares(String marca) {
		try {
			ResultSet resultset = conection.statement().executeQuery("select * from productos where Marca = '"+marca+"'");
			
			if(resultset.last()) {
			filas = resultset.getRow();	
	
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset.absolute(i)) 
					{
						FormAgregarCelulares.ProductoCB.addItem(resultset.getString("Nombre"));	
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
	
	public void BuscarAccesorios(String marca) {
		try {
			ResultSet resultset = conection.statement().executeQuery("select * from accesorios where Marca = '"+marca+"'");
			
			if(resultset.last()) {
			filas = resultset.getRow();	
			
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset.absolute(i)) 
					{
						FormVentaAccesorios.ProductoCB.addItem(resultset.getString("Producto"));
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
	
	public void AgregarAccesorios(String marca) {
		try {
			ResultSet resultset = conection.statement().executeQuery("select * from accesorios where Marca = '"+marca+"'");
			
			if(resultset.last()) {
			filas = resultset.getRow();	
			
				for (int i = 0; i <= filas; i++) 
				{
					if(resultset.absolute(i)) 
					{
						FormAgregarAccesorios.ProductoCB.addItem(resultset.getString("Producto"));	
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
	
	public void BuscarHistorial(String fecha) {
		try {
			ResultSet resultset = conection.statement().executeQuery("select * from historial where Fecha = '"+fecha+"'");
			
			if(resultset.first() == false) 
			{
				resultset = conection.statement().executeQuery("select * from historial");
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
			conection.ConnectionClose();
		}
		catch(SQLException l) 
		{
			l.printStackTrace();
		}
	}
	
	public void BuscarCompraPorCodigo(int codigo) {
		try {
			ResultSet resultset = conection.statement().executeQuery("select * from historial where ID_Codigo = '"+codigo+"'");
			
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
			conection.ConnectionClose();
		}
		catch(SQLException l) 
		{
			l.printStackTrace();
		}
	}
}
