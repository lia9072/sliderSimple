package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class _04_ValidacionDeEntrada_1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblNombre;
	private JLabel lblCodigo;
	private JLabel lblTalla;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JTextField txtTalla;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_04_ValidacionDeEntrada_1 frame = new _04_ValidacionDeEntrada_1();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//  Crea la Interfaz Gráfica de Usuario: GUI	
	public _04_ValidacionDeEntrada_1() {
		setTitle("_04_ValidacionDeEntrada_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(25, 25, 46, 14);
		contentPane.add(lblNombre);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(25, 55, 46, 14);
		contentPane.add(lblCodigo);
		
		lblTalla = new JLabel("Talla");
		lblTalla.setBounds(25, 85, 46, 14);
		contentPane.add(lblTalla);
		
		txtNombre = new JTextField();
		txtNombre.addActionListener(this);
		txtNombre.setBounds(80, 22, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.addActionListener(this);
		txtCodigo.setBounds(80, 52, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtTalla = new JTextField();
		txtTalla.addActionListener(this);
		txtTalla.setBounds(80, 82, 86, 20);
		contentPane.add(txtTalla);
		txtTalla.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(122, 228, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(221, 228, 89, 23);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 22, 218, 172);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
	//  Direcciona los eventos de tipo ActionEvent	
	public void actionPerformed(ActionEvent arg0) {
		//  Si dio <Enter> en txtNombre
		if (arg0.getSource() == txtNombre)
			txtCodigo.requestFocus();
		//  Si dio <Enter> en txtCodigo
		if (arg0.getSource() == txtCodigo)
			txtTalla.requestFocus();
		//  Si dio <Enter> en txtTalla o pulsó el botón Procesar
		if (arg0.getSource() == txtTalla  ||  arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
	}
	//  Procesa la pulsación del botón btnProcesar	
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		String nombre = leerNombre();
		if (nombre.length() > 0)
			try {
				int codigo = leerCodigo();
				try {
					double talla = leerTalla();
					imprimir("Nombre   :  " + nombre);	
					imprimir("Código   :  " + codigo);
					imprimir("Talla    :  " + talla + " kgs");	
				}
				catch (Exception e) {
					error("No ingresó una TALLA correcta", txtTalla);
				}
			}
			catch (Exception e) {
				error("No ingresó un CODIGO correcto", txtCodigo);
			}
		else
			error("No ingresó su NOMBRE", txtNombre);
	}
	//  Procesa la pulsación del botón btnBorrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		limpieza();
		txtS.setText("");		
	}
	//  Métodos tipo void (sin parámetros)
	void limpieza() {
		txtNombre.setText("");
		txtNombre.requestFocus();	
		txtCodigo.setText("");
		txtTalla.setText("");	
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	//  Métodos que retornan valor (sin parámetros)
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	double leerTalla() {
		return Double.parseDouble(txtTalla.getText().trim());
	}
	
}