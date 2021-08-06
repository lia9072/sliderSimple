package guis;

import java.awt.Color;
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
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class _09_CapturaTecla extends JFrame implements KeyListener, ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblNombre;
	private JLabel lblCodigo;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JButton btnProcesar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_09_CapturaTecla frame = new _09_CapturaTecla();
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
	public _09_CapturaTecla() {
		setTitle("_09_Captura_Tecla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.cyan);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		contentPane.add(lblNombre);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 36, 46, 14);
		contentPane.add(lblCodigo);
		
		txtNombre = new JTextField();
		txtNombre.addActionListener(this);
		txtNombre.addKeyListener(this);
		txtNombre.setBounds(76, 8, 200, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.addActionListener(this);
		txtCodigo.addKeyListener(this);
		txtCodigo.setBounds(76, 33, 100, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 414, 190);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}

	public void keyPressed(KeyEvent e) {
	   	//  Mientras mantenga pulsada una tecla
    	//  el JFrame cambia a verde
		contentPane.setBackground(Color.green);
	}
	public void keyReleased(KeyEvent e) {
    	//  Cuando suelte la tecla
    	//  el JFrame vuelve a cyan
		contentPane.setBackground(Color.cyan);
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtCodigo) {
			keyTypedTxtCodigo(e);
		}
		if (e.getSource() == txtNombre) {
			keyTypedTxtNombre(e);
		}
	}
	protected void keyTypedTxtNombre(KeyEvent e) {
		//  Si pulsó una tecla estando
		//  el cursor en txtNombre
		soloLetras(e, txtNombre, 20);		
	}
	protected void keyTypedTxtCodigo(KeyEvent e) {
		//  Si pulsó una tecla estando
		//  el cursor en txtCodigo
		soloNumeros(e, txtCodigo, 5);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtNombre) {
			actionPerformedTxtNombre(e);
		}
		if (e.getSource() == txtCodigo) {
			actionPerformedTxtDNI(e);
		}
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedTxtNombre(ActionEvent e) {
		//  Si dio <Enter> en txtNombre
		txtCodigo.requestFocus();	
	}
	protected void actionPerformedTxtDNI(ActionEvent e) {
		//  Si dio <Enter> en txtCodigo
		procesar();
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		procesar();
	}
	//  Métodos tipo void (sin parámetros)
	void procesar() {
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			try {
				int codigo = leerCodigo();
				imprimir("Nombre :  " + nombre);
				imprimir("Código :  " + codigo);
				limpieza();
			}
			catch (Exception e) {
				mensaje("No ingresó un CODIGO correcto");
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
		else {
			mensaje("No ingresó su NOMBRE");
			txtNombre.requestFocus();
		}
	}
	void limpieza() {
		txtNombre.setText("");
		txtNombre.requestFocus();		
		txtCodigo.setText("");
	}	
	//  Métodos tipo void (con parámetros)
	void soloLetras(KeyEvent e, JTextField txt, int maximo) {
	 	char x = e.getKeyChar();
	 	if (Character.isDigit(x)  &&  x != ' ') {
	 		e.consume();
			getToolkit().beep();
       	}
       	if (txt.getText().length() == maximo) {
       		e.consume();
			getToolkit().beep();
		}
    }
    void soloNumeros(KeyEvent e, JTextField txt, int maximo) {
    	char x = e.getKeyChar();	 
	 	if (!Character.isDigit(x)) {
			e.consume();
			getToolkit().beep();
       	}
       	if (txt.getText().length() == maximo) {
			e.consume();
			getToolkit().beep();
		}
    }
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	//  Métodos que retornan valor (sin parámetros)
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
}