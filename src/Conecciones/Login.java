package Conecciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login{

	Conection conection = new Conection();
	public int Acceso;
	int usuario;
	int contraseņa;
	
	public void Query(int Usuario, int Contraseņa) {
		try {
			usuario = Usuario;
			contraseņa = Contraseņa;
			
				ResultSet resultset = conection.statement().executeQuery("select * from usuarios where Contraseņa = '"+contraseņa+"' and Usuario = '"+usuario+"'");
				
				if(resultset.next() == true) 
				{
					String Mensaje = "Login exitoso";
					JOptionPane.showMessageDialog(null, Mensaje);
					Acceso = 1;
				}
				
				else 
				{
					String Mensaje = "Login erroneo";
					JOptionPane.showMessageDialog(null, Mensaje);
					Acceso = 2;
				}
				conection.ConnectionClose();
		} 
		catch(SQLException l) 
		{
			l.printStackTrace();
		}	
	}
}
