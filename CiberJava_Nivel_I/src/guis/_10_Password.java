package guis;

import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _10_Password extends JFrame implements ActionListener {
	//  Usuario y contraseña
	String usuario = "admin",
	       contraseña = "12345";
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblContrasenia;
	private JTextField txtUsuario;
	private JPasswordField pswContrasenia;
	private JLabel lblFondo;
	private JButton btnProcesar;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_10_Password frame = new _10_Password();
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
	public _10_Password() {
		setResizable(false);
		setTitle("_10_Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(20, 20, 90, 23);
		lblUsuario.setForeground(Color.yellow);
		contentPane.add(lblUsuario);
		
		lblContrasenia = new JLabel("Contrase\u00F1a");
		lblContrasenia.setBounds(20, 50, 90, 23);
		lblContrasenia.setForeground(Color.yellow);
		contentPane.add(lblContrasenia);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(110, 20, 120, 23);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pswContrasenia = new JPasswordField();
		pswContrasenia.setBounds(110, 50, 120, 23);
		contentPane.add(pswContrasenia);
		
		btnProcesar = new JButton("Procesar", new ImageIcon("imagenes/procesar.gif"));
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(370, 20, 110, 23);
		contentPane.add(btnProcesar);
		
		btnBorrar = new JButton("Borrar", new ImageIcon("imagenes/borrar.gif"));
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(370, 50, 110, 23);
		contentPane.add(btnBorrar);
		
		lblFondo = new JLabel(new ImageIcon("imagenes/fondo.gif"));
		lblFondo.setBounds(0, 0, 500, 300);
		contentPane.add(lblFondo);		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		String xUsuario = leerUsuario();
		if (xUsuario.equals(usuario)) {
			String xContraseña = leerContrasenia();
			if (xContraseña.equals(contraseña))
				mensaje("B I E N V E N I D O . . .");
			else {
				mensaje("CONTRASEÑA incorrecta");
				pswContrasenia.setText("");
				pswContrasenia.requestFocus();	
			}
		}	
		else {
			mensaje("USUARIO incorrecto");
			txtUsuario.setText("");
			txtUsuario.requestFocus();			
		}		
	}
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtUsuario.setText("");
		pswContrasenia.setText("");
		txtUsuario.requestFocus();		
	}
	//  Métodos tipo void (con parámetros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}	
	//  Métodos que retornan valor (sin parámetros)
	String leerUsuario() {
		return txtUsuario.getText().trim();
	}
	String leerContrasenia() {
		return new String(pswContrasenia.getPassword());	
	}
	
}