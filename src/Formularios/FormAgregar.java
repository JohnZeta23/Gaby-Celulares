package Formularios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ClasesAbstractas.Iniciador;
import Conecciones.Agregar;
import Conecciones.Buscar;

public class FormAgregar implements Iniciador{

	 JInternalFrame frame;
	 public static JComboBox<String> ProductoCB;
	 private JTextField CantidadCB;


	public FormAgregar() {
		initialize();
	}

	public void initialize() {
		frame = new JInternalFrame();
		frame.setBounds(10, 33, 414, 252);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVenderCelulares = new JLabel("Agregar celulares");
		lblVenderCelulares.setForeground(Color.RED);
		lblVenderCelulares.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblVenderCelulares.setBounds(90, 11, 231, 42);
		frame.getContentPane().add(lblVenderCelulares);
		
		ProductoCB = new JComboBox<String>();
		ProductoCB.setBounds(148, 102, 173, 22);
		frame.getContentPane().add(ProductoCB);
		
		
		JButton btnNewButton = new JButton("AGREGAR");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(148, 180, 111, 31);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProducto.setBounds(63, 104, 75, 14);
		frame.getContentPane().add(lblProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(63, 137, 75, 14);
		frame.getContentPane().add(lblCantidad);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca.setBounds(63, 71, 75, 14);
		frame.getContentPane().add(lblMarca);
		
		JComboBox<String> MarcaCB = new JComboBox<String>();
		MarcaCB.setBounds(148, 69, 173, 22);
		frame.getContentPane().add(MarcaCB);
		
		CantidadCB = new JTextField();
		CantidadCB.setBounds(148, 135, 173, 20);
		frame.getContentPane().add(CantidadCB);
		CantidadCB.setColumns(10);
		frame.setBounds(100, 100, 414, 252);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MarcaCB.addItem("Samsung");
		MarcaCB.addItem("Apple");
		MarcaCB.addItem("Xiaomi");
		

		MarcaCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			ProductoCB.removeAllItems();
				
			Buscar conection = new Buscar();
			
			conection.Query4(MarcaCB.getSelectedItem().toString());
			}
		});
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Agregar conection = new Agregar();
			conection.Query(MarcaCB.getSelectedItem().toString(), ProductoCB.getSelectedItem().toString(),Integer.parseInt(CantidadCB.getText()));
		
			}
		});
		
	}
}
