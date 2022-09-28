package Formularios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

import ClasesAbstractas.Iniciador;
import Conecciones.Buscar;


public class FormHistorial implements Iniciador{

	JInternalFrame frame;
	JFormattedTextField FechaMTF;

	public FormHistorial() {
		initialize();
	}
	
	private MaskFormatter mascara() {
		
	     MaskFormatter mascara = new MaskFormatter();
	     try {
	         mascara = new MaskFormatter("####/##/##");
	     } catch (ParseException e) {
	         e.printStackTrace();
	     }
	     return mascara;
	 }
	
	public void initialize() {
		frame = new JInternalFrame();
		frame.setBounds(10, 33, 416, 252);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVenderCelulares = new JLabel("Revisar historial");
		lblVenderCelulares.setForeground(Color.RED);
		lblVenderCelulares.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblVenderCelulares.setBounds(89, 11, 254, 42);
		frame.getContentPane().add(lblVenderCelulares);
		
		JLabel lblMarca = new JLabel("Fecha");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMarca.setBounds(61, 94, 75, 14);
		frame.getContentPane().add(lblMarca);
		frame.setBounds(100, 100, 414, 252);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton BuscarBT = new JButton("Buscar");
		BuscarBT.setBackground(Color.ORANGE);
		BuscarBT.setFont(new Font("Tahoma", Font.BOLD, 14));
		BuscarBT.setForeground(Color.BLACK);
		BuscarBT.setBounds(74, 165, 126, 31);
		frame.getContentPane().add(BuscarBT);
		
		FechaMTF = new JFormattedTextField(mascara());
		FechaMTF.setBounds(151, 93, 108, 20);
		frame.getContentPane().add(FechaMTF);
		FechaMTF.setColumns(10);
		
		JButton ImprimirBT = new JButton("Imprimir tabla");
		ImprimirBT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
				     if (! Menu.table.print()) {
				         System.err.println("User cancelled printing");
				     } 
				 } catch (java.awt.print.PrinterException e1) {
				     System.err.format("Cannot print %s%n", e1.getMessage()); 
				 }
				
			}
		});
		ImprimirBT.setForeground(Color.BLACK);
		ImprimirBT.setFont(new Font("Tahoma", Font.BOLD, 14));
		ImprimirBT.setBackground(Color.ORANGE);
		ImprimirBT.setBounds(222, 165, 139, 31);
		frame.getContentPane().add(ImprimirBT);
		
		BuscarBT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Menu.tabadd.setRowCount(0);
				
				Menu.filas[0]= "Codigo"; 
				Menu.filas[1]= "Producto";
				Menu.filas[2]= "Fecha";
				Menu.filas[3]= "Precio";
				Menu.filas[4]= "Cantidad";
				
				Menu.tabadd.addRow(Menu.filas);
				
				Buscar conection = new Buscar();
				conection.BuscarHistorial(FechaMTF.getText());
				
				Menu.LabelTabla.setText("Resultados del historial de ventas");
				
			}
		});

	}
	
	
}
