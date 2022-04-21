package Formularios;

import java.awt.Color;
import java.awt.Font;
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

public class FormAgregar3 implements Iniciador{

	JInternalFrame frame;
	 private JTextField CantidadCB;
	 private JTextField ProductoCB;
	 private JTextField PrecioTF;

	public FormAgregar3() {
		initialize();
	}

	public void initialize() {
		frame = new JInternalFrame();
		frame.setBounds(10, 33, 414, 252);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVenderCelulares = new JLabel("Agregar nuevos productos");
		lblVenderCelulares.setForeground(Color.RED);
		lblVenderCelulares.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblVenderCelulares.setBounds(32, 0, 356, 42);
		frame.getContentPane().add(lblVenderCelulares);
		
		
		JButton btnNewButton = new JButton("AGREGAR");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(148, 180, 111, 31);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProducto.setBounds(63, 83, 75, 14);
		frame.getContentPane().add(lblProducto);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(32, 141, 75, 14);
		frame.getContentPane().add(lblCantidad);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca.setBounds(81, 53, 57, 14);
		frame.getContentPane().add(lblMarca);
		
		JComboBox<String> MarcaCB = new JComboBox<String>();
		MarcaCB.setBounds(148, 53, 131, 22);
		frame.getContentPane().add(MarcaCB);
		MarcaCB.addItem("Samsung");
		MarcaCB.addItem("Apple");
		MarcaCB.addItem("Xiaomi");
		
		CantidadCB = new JTextField();
		CantidadCB.setBounds(115, 140, 57, 20);
		frame.getContentPane().add(CantidadCB);
		CantidadCB.setColumns(10);
		
		ProductoCB = new JTextField();
		ProductoCB.setBounds(148, 82, 131, 20);
		frame.getContentPane().add(ProductoCB);
		ProductoCB.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrecio.setBounds(222, 141, 57, 14);
		frame.getContentPane().add(lblPrecio);
		
		PrecioTF = new JTextField();
		PrecioTF.setColumns(10);
		PrecioTF.setBounds(284, 140, 75, 20);
		frame.getContentPane().add(PrecioTF);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipo.setBounds(98, 108, 40, 22);
		frame.getContentPane().add(lblTipo);
		
		JComboBox<String> TipoCB = new JComboBox<String>();
		TipoCB.setBounds(148, 107, 131, 22);
		frame.getContentPane().add(TipoCB);
		frame.setBounds(100, 100, 414, 252);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TipoCB.addItem("Celular");
		TipoCB.addItem("Accesorio");
		

		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Agregar conection = new Agregar();
			conection.Query3(MarcaCB.getSelectedItem().toString(), ProductoCB.getText(),Integer.parseInt(CantidadCB.getText()),TipoCB.getSelectedItem().toString(),Integer.parseInt(PrecioTF.getText()));
			}
		});
		
	}
}
