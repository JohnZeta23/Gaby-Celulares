package Formularios;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import ClasesAbstractas.Iniciador;
import Conecciones.Buscar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormBuscar implements Iniciador{

	JInternalFrame frame;

	public FormBuscar() {
		initialize();
	}

	public void initialize() {
		frame = new JInternalFrame();
		frame.setBounds(10, 33, 416, 252);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVenderCelulares = new JLabel("Buscar productos");
		lblVenderCelulares.setForeground(Color.RED);
		lblVenderCelulares.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblVenderCelulares.setBounds(89, 11, 254, 42);
		frame.getContentPane().add(lblVenderCelulares);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca.setBounds(61, 94, 75, 14);
		frame.getContentPane().add(lblMarca);
		
		JComboBox<String> MarcaCB = new JComboBox<String>();
		MarcaCB.setBounds(148, 92, 111, 22);
		frame.getContentPane().add(MarcaCB);
		frame.setBounds(100, 100, 414, 252);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MarcaCB.addItem("Samsung");
		MarcaCB.addItem("Apple");
		MarcaCB.addItem("Xiaomi");
		
		JButton BuscarBT = new JButton("Buscar");
		BuscarBT.setBackground(Color.ORANGE);
		BuscarBT.setFont(new Font("Tahoma", Font.BOLD, 14));
		BuscarBT.setForeground(Color.BLACK);
		BuscarBT.setBounds(148, 180, 111, 31);
		frame.getContentPane().add(BuscarBT);
		
		BuscarBT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Menu.tabadd.setRowCount(0);
				
				Menu.filas[0]= "Codigo"; 
				Menu.filas[1]= "Producto";
				Menu.filas[2]= "Marca";
				Menu.filas[3]= "Precio";
				Menu.filas[4]= "Cantidad";
				
				Menu.tabadd.addRow(Menu.filas);
				
				Buscar conection = new Buscar();
				conection.Query(MarcaCB.getSelectedItem().toString());
				
				Menu.LabelTabla.setText("Resultados de búsqueda");
			}
		});

	}
}
