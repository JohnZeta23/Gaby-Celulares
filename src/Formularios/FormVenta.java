package Formularios;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import ClasesAbstractas.Iniciador;
import Conecciones.Buscar;
import Conecciones.Ventas;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FormVenta implements Iniciador{

	 JInternalFrame frame;
	 public static JComboBox<String> ProductoCB;
	 private JTextField CantidadCB;
	 
	 public FormVenta() {
		initialize();
	}

	public void initialize() {
		frame = new JInternalFrame();
		frame.setBounds(10, 33, 414, 252);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVenderCelulares = new JLabel("Vender celulares");
		lblVenderCelulares.setForeground(Color.RED);
		lblVenderCelulares.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblVenderCelulares.setBounds(90, 11, 219, 42);
		frame.getContentPane().add(lblVenderCelulares);
		
		ProductoCB = new JComboBox<String>();
		ProductoCB.setBounds(148, 102, 173, 22);
		frame.getContentPane().add(ProductoCB);
		
		
		JButton btnNewButton = new JButton("VENDER");
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
			
			conection.Query3(MarcaCB.getSelectedItem().toString());
			}
		});
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Menu.tabadd.setRowCount(0);
				
				Menu.filas[0]= "Codigo"; 
				Menu.filas[1]= "Producto";
				Menu.filas[2]= "Fecha";
				Menu.filas[3]= "Precio";
				Menu.filas[4]= "Cantidad";
				
				Menu.tabadd.addRow(Menu.filas);
				
			Ventas conection = new Ventas();
			conection.Query(MarcaCB.getSelectedItem().toString(), ProductoCB.getSelectedItem().toString(),Integer.parseInt(CantidadCB.getText()));
			
			int ITBIS = (conection.Precio*18)/100;
			
			String compra = "GABY CELULARES" + "\n" + "\n" + "RECIBO No. " + String.valueOf(conection.numero) + "\n" + "\n" + Menu.Date.getText() + "\n" + "\n" + "Producto: "+ MarcaCB.getSelectedItem().toString() + "\n" + "\n"
			+ "Precio: RD$" + String.valueOf(conection.Precio) + "\n" + "\n"
			+ "Cantidad: " + CantidadCB.getText() + "\n"  + "\n" + "ITBIS: RD$" + String.valueOf(ITBIS) + "\n"  + "\n"
			+ "Subtotal: RD$" + String.valueOf((Integer.parseInt(CantidadCB.getText())*conection.Precio)+ITBIS);
			
			Menu.TPRecibo.setText(compra);
			Menu.Factura = 1;
			
			Menu.LabelTabla.setText("Cuentas por cobrar");
			}
		});
		
	}
}
