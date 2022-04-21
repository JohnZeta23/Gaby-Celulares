package Formularios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import ClasesAbstractas.Iniciador;
import Conecciones.Buscar;
import javax.swing.JTextField;

public class FormBuscar2 implements Iniciador{

	JInternalFrame frame;
	private JTextField CodigoTF;

	public FormBuscar2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
		
		JLabel lblMarca = new JLabel("C\u00F3digo");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca.setBounds(61, 94, 75, 19);
		frame.getContentPane().add(lblMarca);
		frame.setBounds(100, 100, 414, 252);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton BuscarBT = new JButton("Buscar");
		BuscarBT.setBackground(Color.ORANGE);
		BuscarBT.setFont(new Font("Tahoma", Font.BOLD, 14));
		BuscarBT.setForeground(Color.BLACK);
		BuscarBT.setBounds(148, 180, 111, 31);
		frame.getContentPane().add(BuscarBT);
		
		CodigoTF = new JTextField();
		CodigoTF.setBounds(146, 93, 113, 20);
		frame.getContentPane().add(CodigoTF);
		CodigoTF.setColumns(10);
		
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
				conection.Query2(Integer.parseInt(CodigoTF.getText()));
				
				Menu.LabelTabla.setText("Resultados de búsqueda");
			}
		});

	}
}