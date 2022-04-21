package Formularios;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ClasesAbstractas.Iniciador;
import Conecciones.Login;

public class LoginForm implements Iniciador{

	public JFrame frame;
	private JTextField CorreoTF;
	private JPasswordField ContrasenaTF;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		ImageIcon icon = new ImageIcon("C:\\Users\\user\\Downloads\\Telefono.png");
		frame = new JFrame();
		frame.setIconImage(icon.getImage());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(157, 64, 69, 14);
		frame.getContentPane().add(lblNewLabel);
		
		CorreoTF = new JTextField();
		CorreoTF.setColumns(10);
		CorreoTF.setBounds(157, 89, 103, 20);
		frame.getContentPane().add(CorreoTF);
		
		ContrasenaTF = new JPasswordField();
		ContrasenaTF.setColumns(10);
		ContrasenaTF.setBounds(157, 145, 103, 20);
		frame.getContentPane().add(ContrasenaTF);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContrasea.setBounds(157, 120, 103, 14);
		frame.getContentPane().add(lblContrasea);
		
		JLabel lblInicioDeSesin = new JLabel("Gaby Celulares");
		lblInicioDeSesin.setForeground(Color.RED);
		lblInicioDeSesin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblInicioDeSesin.setBounds(115, 11, 204, 42);
		frame.getContentPane().add(lblInicioDeSesin);
		
		JButton LoginButton = new JButton("Iniciar Sesi\u00F3n");
		LoginButton.setBackground(Color.ORANGE);
		LoginButton.setForeground(SystemColor.textHighlightText);
		LoginButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		LoginButton.setBounds(138, 187, 149, 29);
		frame.getContentPane().add(LoginButton);
		

		LoginButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
			Login conection = new Login();
			conection.Query(Integer.parseInt(CorreoTF.getText()), Integer.parseInt(ContrasenaTF.getText()));
			
			if(conection.Acceso == 1) 
			{
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Menu window = new Menu();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				frame.dispose();
			}
			
			}
		});
	}
	
}
