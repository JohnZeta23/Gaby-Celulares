package Conecciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login{

	Conection conection = new Conection();
	public int Acceso;
	int usuario;
	int contrase�a;
	
	public void Query(int Usuario, int Contrase�a) {
		try {
			usuario = Usuario;
			contrase�a = Contrase�a;
			
				ResultSet resultset = conection.statement().executeQuery("select * from usuarios where Contrase�a = '"+contrase�a+"' and Usuario = '"+usuario+"'");
				
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
