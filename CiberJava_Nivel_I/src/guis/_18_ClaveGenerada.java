package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class _18_ClaveGenerada extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblClave;
	private JTextField txtClave;
	private JButton btnGenerar;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_18_ClaveGenerada frame = new _18_ClaveGenerada();
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
	public _18_ClaveGenerada() {
		setTitle("_18_ClaveGenerada");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblClave = new JLabel(generarClave());
		lblClave.setHorizontalAlignment(SwingConstants.CENTER);
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClave.setForeground(Color.RED);
		lblClave.setBounds(125, 100, 89, 23);
		contentPane.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtClave.setForeground(Color.BLUE);
		txtClave.setBounds(220, 100, 89, 23);
		contentPane.add(txtClave);
		txtClave.setColumns(10);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(this);
		btnGenerar.setBounds(125,130, 89, 23);
		contentPane.add(btnGenerar);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(220, 130, 89, 23);
		contentPane.add(btnIngresar);
	}
	//  Direcciona los eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
		if (arg0.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(arg0);
		}	
	}
	//  Procesa la pulsación del botón btnGenerar
	protected void actionPerformedBtnGenerar(ActionEvent arg0) {
		lblClave.setText(generarClave());
		txtClave.setText("");
		txtClave.requestFocus();
	}
	//  Procesa la pulsación del botón btnIngresar
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		String claveGenerada, claveIngresada;
		claveGenerada = lblClave.getText();
		claveIngresada = txtClave.getText();
		if (claveGenerada.equals(claveIngresada))
			mensaje("Clave correcta");
		else
			mensaje("Clave incorrecta");
		txtClave.requestFocus();
	}
	//  Métodos tipo void (con parámetros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	//  Métodos que retornan valor (con parámetros)
	int aleatorio(int min, int max) {
	    return (int)((max - min + 1) * Math.random()) + min;
  	}
	String generarClave() {
		String clave = "";
		char caracter;
		for (int i=0; i<5; i++) {
			if (aleatorio(0,1) == 0)
				caracter = (char)aleatorio(48, 57);
			else
				caracter = (char)aleatorio(97, 122);
			clave += caracter;	
		}
		return clave;
	}
	
}
