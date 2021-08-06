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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class _05_ValidacionDeEntrada_2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblCdigo;
	private JLabel lblEdad;
	private JLabel lblTalla;
	private JLabel lblPeso;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCodigo;
	private JTextField txtEdad;
	private JTextField txtTalla;
	private JTextField txtPeso;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JComboBox <String> cboSexo;
	private JLabel lblSexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_05_ValidacionDeEntrada_2 frame = new _05_ValidacionDeEntrada_2();
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
	public _05_ValidacionDeEntrada_2() {
		setTitle("_05_ValidacionDeEntrada_2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 10, 46, 23);
		contentPane.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 40, 46, 23);
		contentPane.add(lblApellido);

		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 70, 46, 23);
		contentPane.add(lblSexo);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 100, 46, 23);
		contentPane.add(lblCdigo);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 130, 46, 23);
		contentPane.add(lblEdad);
		
		lblTalla = new JLabel("Talla");
		lblTalla.setBounds(10, 160, 46, 23);
		contentPane.add(lblTalla);
		
		lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 190, 46, 23);
		contentPane.add(lblPeso);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(80, 10, 100, 23);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addActionListener(this);  //  Para que acepte <Enter>
		
		txtApellido = new JTextField();
		txtApellido.setBounds(80, 40, 100, 23);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		txtApellido.addActionListener(this);  //  Para que acepte <Enter>
		
		cboSexo = new JComboBox <String> ();
		cboSexo.setModel(new DefaultComboBoxModel <String>
				        (new String[] {"Masculino", "Femenino"}));
		cboSexo.setBounds(80, 70, 99, 23);
		contentPane.add(cboSexo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(80, 100, 100, 23);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.addActionListener(this);  //  Para que acepte <Enter>
		
		txtEdad = new JTextField();
		txtEdad.setBounds(80, 130, 100, 23);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		txtEdad.addActionListener(this);  //  Para que acepte <Enter>
		
		txtTalla = new JTextField();
		txtTalla.setBounds(80, 160, 100, 23);
		contentPane.add(txtTalla);
		txtTalla.setColumns(10);
		txtTalla.addActionListener(this);  //  Para que acepte <Enter>
		
		txtPeso = new JTextField();
		txtPeso.setBounds(80, 190, 100, 23);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		txtPeso.addActionListener(this);  //  Para que acepte <Enter>
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 73, 224, 178);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
	public void actionPerformed(ActionEvent arg0) {
		//  Si dio <Enter> en txtNombre
		if (arg0.getSource() == txtNombre)
			txtApellido.requestFocus();
		//  Si dio <Enter> en txtApellido
		if (arg0.getSource() == txtApellido)
			txtCodigo.requestFocus();
		//  Si dio <Enter> en txtCodigo
		if (arg0.getSource() == txtCodigo)
			txtEdad.requestFocus();
		//  Si dio <Enter> en txtEdad
		if (arg0.getSource() == txtEdad)
			txtTalla.requestFocus();
		//  Si dio <Enter> en txtPeso
		if (arg0.getSource() == txtTalla)
			txtPeso.requestFocus();
		//  Si dio <Enter> en txtPeso o pulsó el botón Procesar
		if (arg0.getSource() == txtPeso  ||  arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		String nombre = leerCadena(txtNombre);
		if (nombre.length() > 0) {
			String apellido = leerCadena(txtApellido);
			if (apellido.length() > 0) {
				String sexo = leerItem(cboSexo);
				try {
					int codigo = leerEntero(txtCodigo);
					try {
						int edad = leerEntero(txtEdad);
						try {
							double talla = leerReal(txtTalla);
							try {
								double peso = leerReal(txtPeso);
								imprimir("Nombre   :  " + nombre);
								imprimir("Apellido :  " + apellido);
								imprimir("Sexo     :  " + sexo);
								imprimir("Código   :  " + codigo);
								imprimir("Edad     :  " + edad + " años");
								imprimir("Talla    :  " + talla + " mts");
								imprimir("Peso     :  " + peso + " kg");
							}
							catch (Exception e) {
								error("No ingresó un PESO correcto", txtPeso);
							}
						}
						catch (Exception e) {
							error("No ingresó una TALLA correcta", txtTalla);
						}
					}
					catch (Exception e) {
						error("No ingresó una EDAD correcta", txtEdad);
					}
				}
				catch (Exception e) {
					error("No ingresó un CODIGO correcto", txtCodigo);
				}
			}
			else
				error("No ingresó su APELLIDO", txtApellido);
		}
		else
			error("No ingresó su NOMBRE", txtNombre);
	}
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		limpieza();
		txtS.setText("");
	}
	//  Métodos tipo void sin parámetros
	void limpieza() {
		txtNombre.setText("");
		txtNombre.requestFocus();
		txtApellido.setText("");
		cboSexo.setSelectedIndex(0);
		txtCodigo.setText("");
		txtEdad.setText("");
		txtTalla.setText("");
		txtPeso.setText("");
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
	String leerCadena(JTextField txt) {
		return txtNombre.getText().trim();
	}
	int leerEntero(JTextField txt) {
		return Integer.parseInt(txt.getText().trim());
	}
	double leerReal(JTextField txt) {
		return Double.parseDouble(txt.getText().trim());
	}
	int leerPos(JComboBox <String> cbo) {
		return cbo.getSelectedIndex();
	}
	String leerItem(JComboBox <String> cbo) {
		return cbo.getSelectedItem().toString();
	}
	
}