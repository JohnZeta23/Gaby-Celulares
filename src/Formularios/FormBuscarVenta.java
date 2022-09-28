package Formularios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ClasesAbstractas.Iniciador;
import Conecciones.Buscar;

public class FormBuscarVenta implements Iniciador{

	JInternalFrame frame;
	JTextField CodigoTF;

	public FormBuscarVenta() {
		initialize();
	}
	
	
	public void initialize() {
		frame = new JInternalFrame();
		frame.setBounds(10, 33, 416, 252);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVenderCelulares = new JLabel("Buscar venta por c\u00F3digo");
		lblVenderCelulares.setForeground(Color.RED);
		lblVenderCelulares.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblVenderCelulares.setBounds(43, 11, 331, 42);
		frame.getContentPane().add(lblVenderCelulares);
		
		JLabel Código = new JLabel("C\u00F3digo");
		Código.setFont(new Font("Tahoma", Font.BOLD, 15));
		Código.setBounds(61, 94, 75, 20);
		frame.getContentPane().add(Código);
		frame.setBounds(100, 100, 414, 252);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton BuscarBT = new JButton("Buscar");
		BuscarBT.setBackground(Color.ORANGE);
		BuscarBT.setFont(new Font("Tahoma", Font.BOLD, 14));
		BuscarBT.setForeground(Color.BLACK);
		BuscarBT.setBounds(74, 165, 126, 31);
		frame.getContentPane().add(BuscarBT);
		
		CodigoTF = new JTextField();
		CodigoTF.setBounds(151, 93, 108, 20);
		frame.getContentPane().add(CodigoTF);
		CodigoTF.setColumns(10);
		
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
				conection.BuscarCompraPorCodigo(Integer.parseInt(CodigoTF.getText()));
				
				Menu.LabelTabla.setText("Resultados del historial de ventas");
			}
		});

	}
	
	

}
