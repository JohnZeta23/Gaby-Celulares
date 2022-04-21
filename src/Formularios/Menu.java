package Formularios;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ClasesAbstractas.Iniciador;
import Conecciones.Ventas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.Date;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JTextField;

public class Menu implements Iniciador{

	JFrame frame;
	public static JTable table;
	public static DefaultTableModel tabadd;
	public static String filas []= {"","","","",""};
	static String colms [][]= {{"","","","",""}};
	String e;
	public static JLabel Date;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	public static JTextPane TPRecibo;
	private JTextField NameTF;
	private JTextField DirectionTF;
	public static int Factura;
	public static JLabel LabelTabla;
	
	public Menu() {
		initialize();
		tabadd= (DefaultTableModel) table.getModel();
		LiveDateSwing();
	}

	public void initialize() {
		ImageIcon icon = new ImageIcon("C:\\Users\\user\\Downloads\\Telefono.png");
		frame = new JFrame();
		frame.setIconImage(icon.getImage());
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 660, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 341, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Vender");
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setBackground(Color.ORANGE);
		menuBar.add(mnNewMenu);
		
		JMenuItem MICelulares = new JMenuItem("Celulares");
		mnNewMenu.add(MICelulares);
		
		JMenuItem MIAccesorios = new JMenuItem("Accesorios");
		mnNewMenu.add(MIAccesorios);
		
		JMenu mnNewMenu_1 = new JMenu("Buscar");
		mnNewMenu_1.setBackground(Color.ORANGE);
		mnNewMenu_1.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem MICodigo = new JMenuItem("Por c\u00F3digo");
		mnNewMenu_1.add(MICodigo);
		
		JMenuItem MIBuscar = new JMenuItem("Por marca");
		mnNewMenu_1.add(MIBuscar);
		
		JMenu mnNewMenu_3 = new JMenu("Agregar mercanc\u00EDa");
		mnNewMenu_3.setBackground(Color.ORANGE);
		mnNewMenu_3.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_3);
		
		JMenuItem MIAgregar1 = new JMenuItem("Agregar celulares");
		mnNewMenu_3.add(MIAgregar1);
		
		JMenuItem MIAgregar2 = new JMenuItem("Agregar accesorios");
		mnNewMenu_3.add(MIAgregar2);
		
		JMenuItem MIAgregarNuevo = new JMenuItem("Agregar nuevos productos");
		mnNewMenu_3.add(MIAgregarNuevo);
		
		JMenu mnNewMenu_2 = new JMenu("Historial de ventas");
		mnNewMenu_2.setBackground(Color.ORANGE);
		mnNewMenu_2.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu_2);
		
		JMenuItem MIRevisar = new JMenuItem("Revisar historial ");
		mnNewMenu_2.add(MIRevisar);
		
		JMenuItem MIBuscarventa = new JMenuItem("Buscar venta por c\u00F3digo");
		mnNewMenu_2.add(MIBuscarventa);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 33, 414, 257);
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		table = new JTable(colms,filas);
		Menu.table.setModel(new DefaultTableModel(
				new Object[][] {
					{"","", "", "",""},
				},
				new String[] {
					"", "", "","",""
				}
			));
		
		JScrollPane SP = new JScrollPane(table);
		SP.setBounds(10, 312, 624, 198);
		frame.getContentPane().add(SP);
		
		TPRecibo = new JTextPane();
		TPRecibo.setFont(new Font("Tahoma", Font.BOLD, 12));
		TPRecibo.setBounds(450, 33, 132, 169);
		
		JScrollPane SP2 = new JScrollPane(TPRecibo);
		SP2.setBounds(460, 90, 132, 112);
		frame.getContentPane().add(SP2);
		
		JButton FacturaBT = new JButton("Facturar");
		FacturaBT.setBackground(Color.ORANGE);
		FacturaBT.setFont(new Font("Tahoma", Font.BOLD, 14));
		FacturaBT.setForeground(Color.BLACK);
		FacturaBT.setBounds(481, 267, 101, 23);
		frame.getContentPane().add(FacturaBT);
		
		NameTF = new JTextField();
		NameTF.setBounds(481, 236, 101, 20);
		frame.getContentPane().add(NameTF);
		NameTF.setColumns(10);
		
		DirectionTF = new JTextField();
		DirectionTF.setText("C:\\\\Users\\\\user\\\\Documents\\\\Facturas");
		DirectionTF.setBounds(434, 59, 200, 20);
		frame.getContentPane().add(DirectionTF);
		DirectionTF.setColumns(10);
		
		JLabel lblDireccionDeCarpeta = new JLabel("Direccion de carpeta");
		lblDireccionDeCarpeta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDireccionDeCarpeta.setBounds(460, 34, 142, 14);
		frame.getContentPane().add(lblDireccionDeCarpeta);
		
		JLabel lblNombreDelArchivo = new JLabel("Nombre \r\ndel archivo");
		lblNombreDelArchivo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDelArchivo.setBounds(470, 213, 132, 14);
		frame.getContentPane().add(lblNombreDelArchivo);
		
		LabelTabla = new JLabel("");
		LabelTabla.setFont(new Font("Tahoma", Font.BOLD, 16));
		LabelTabla.setBounds(10, 297, 331, 14);
		frame.getContentPane().add(LabelTabla);
		
		MICelulares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormVenta window = new FormVenta();
							window.frame.setVisible(true);
							panel.removeAll();
							panel.add(window.frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		

		MIAccesorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormVenta2 window = new FormVenta2();
							window.frame.setVisible(true);
							panel.removeAll();
							panel.add(window.frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		

		MIBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormBuscar window = new FormBuscar();
							window.frame.setVisible(true);
							panel.removeAll();
							panel.add(window.frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		MICodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormBuscar2 window = new FormBuscar2();
							window.frame.setVisible(true);
							panel.removeAll();
							panel.add(window.frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		

		MIAgregar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormAgregar window = new FormAgregar();
							window.frame.setVisible(true);
							panel.removeAll();
							panel.add(window.frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		
		MIAgregar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormAgregar2 window = new FormAgregar2();
							window.frame.setVisible(true);
							panel.removeAll();
							panel.add(window.frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		MIAgregarNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormAgregar3 window = new FormAgregar3();
							window.frame.setVisible(true);
							panel.removeAll();
							panel.add(window.frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		MIRevisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormHistorial window = new FormHistorial();
							window.frame.setVisible(true);
							panel.removeAll();
							panel.add(window.frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		MIBuscarventa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							FormHistorial2 window = new FormHistorial2();
							window.frame.setVisible(true);
							panel.removeAll();
							panel.add(window.frame);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		FacturaBT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(NameTF.getText().isEmpty()) 
				{
					String Mensaje = "Coloque un nombre para el archivo de la factura.";
					JOptionPane.showMessageDialog(null, Mensaje);
				}
			
				else 
				{	
					String factura = TPRecibo.getText();
					
					String direccion = DirectionTF.getText() + "\\" + NameTF.getText() + ".txt";
					
					File archivo = new File(direccion);
					
					try 
					{
						FileWriter writer = new FileWriter(archivo);
						
						PrintWriter escribir = new PrintWriter(writer);
						
						escribir.append("");
						escribir.println();
						escribir.append(factura);
						escribir.close();
						
						String Mensaje = "Factura hecha exitosamente!";
						JOptionPane.showMessageDialog(null, Mensaje);
						
						TPRecibo.setText("");
						tabadd.setRowCount(0);
						LabelTabla.setText("");
						NameTF.setText("");
					} 
					
					catch(Exception e2)
					{
						e2.printStackTrace();
					}
					
					if(Factura == 1) 
					{
						Ventas conection = new Ventas();
						conection.Query3();
					}
					
					else 
					{
						Ventas conection = new Ventas();
						conection.Query4();
					}
		
				}
			}
			
		});
	}
	
	public void LiveDateSwing() {
		Date = new JLabel("");
		Date.setBounds(460, 0, 152, 22);
		frame.getContentPane().add(Date);

	      Runnable runnable = new Runnable() {

	        @Override
	        public void run() {
	          while (true) {
	            Date date = getDate();
	            String dateString = formatter.format(date);
	            Date.setText(dateString);
	            try {
	              Thread.sleep(1000);
	            }
	            catch (InterruptedException e) {
	              e.printStackTrace();
	            }
	          }
	        }
	    };

	      Thread t = new Thread(runnable);
	      t.start();
	    }

	    public static java.util.Date getDate() {
	      java.util.Date date = new java.util.Date();
	      return date;
	    }
}
