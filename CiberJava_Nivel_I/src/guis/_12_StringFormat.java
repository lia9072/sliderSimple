package guis;

import java.util.Locale;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class _12_StringFormat extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtS;	
	private JButton btnCaracter;
	private JButton btnEntero;
	private JButton btnReal;
	private JButton btnCadena;
	private JButton btnTodos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_12_StringFormat frame = new _12_StringFormat();
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
	public _12_StringFormat() {
		setTitle("_12_StringFormat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 436, 240);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
		
		btnCaracter = new JButton("Caracter");
		btnCaracter.addActionListener(this);
		btnCaracter.setBounds(0, 239, 87, 23);
		contentPane.add(btnCaracter);
		
		btnEntero = new JButton("Entero");
		btnEntero.addActionListener(this);
		btnEntero.setBounds(87, 239, 87, 23);
		contentPane.add(btnEntero);
		
		btnReal = new JButton("Real");
		btnReal.addActionListener(this);
		btnReal.setBounds(174, 239, 87, 23);
		contentPane.add(btnReal);
		
		btnCadena = new JButton("Cadena");
		btnCadena.addActionListener(this);
		btnCadena.setBounds(261, 239, 87, 23);
		contentPane.add(btnCadena);
		
		btnTodos = new JButton("Todos");
		btnTodos.addActionListener(this);
		btnTodos.setBounds(348, 239, 87, 23);
		contentPane.add(btnTodos);
	}
	public void actionPerformed(ActionEvent arg0) {
	    txtS.setText("");	    
	    imprimir("1       10        20        30        40        50");
	    imprimir("|''''''''|'''''''''|'''''''''|'''''''''|'''''''''|");		
		if (arg0.getSource() == btnTodos) {
			actionPerformedBtnTodos(arg0);
		}
		if (arg0.getSource() == btnCadena) {
			actionPerformedBtnCadena(arg0);
		}
		if (arg0.getSource() == btnReal) {
			actionPerformedBtnReal(arg0);
		}
		if (arg0.getSource() == btnEntero) {
			actionPerformedBtnEntero(arg0);
		}
		if (arg0.getSource() == btnCaracter) {
			actionPerformedBtnCaracter(arg0);
		}
	}
	protected void actionPerformedBtnCaracter(ActionEvent arg0) {
		char caracter = 'A';
    	imprimir(String.format("%10c", caracter));
    	imprimir(String.format("%-10c", caracter));		
	}
	protected void actionPerformedBtnEntero(ActionEvent arg0) {
    	int entero = 123;
    	imprimir(String.format("%20d", entero));
    	imprimir(String.format("%-20d", entero));
    	imprimir(String.format("%+20d", entero));
    	imprimir(String.format("%+-20d", entero));
    	imprimir(String.format("%020d", entero));
    	imprimir(String.format("% -20d", entero));
     	entero = -321;
    	imprimir(String.format("% -20d", entero));		
	}
	protected void actionPerformedBtnReal(ActionEvent arg0) {
    	double real = 98.765432;  	
    	imprimir(String.format(Locale.US,"%30f", real));
    	imprimir(String.format("%-30f", real));
    	imprimir(String.format("%30.2f", real));
    	imprimir(String.format("%-30.2f", real));
    	imprimir(String.format("%+30.2f", real));
    	imprimir(String.format("%+-30.2f", real));
    	imprimir(String.format("%030.2f", real));
    	imprimir(String.format("% -30.2f", real));
    	real = -23.456789;
    	imprimir(String.format("% -30.2f", real));		
	}
	protected void actionPerformedBtnCadena(ActionEvent arg0) {
    	String cadena = "CiberJava";
		imprimir(String.format("%40s", cadena));
    	imprimir(String.format("%-40s", cadena));
		imprimir(String.format("%40.5s", cadena));
    	imprimir(String.format("%-40.5s", cadena));		
	}
	protected void actionPerformedBtnTodos(ActionEvent arg0) {
    	char caracter = 'A';
    	int entero = 123;
    	double real = 98.765432;
   		String cadena = "CiberJava";
    	imprimir(String.format("%-10c%-10d%-20.3f%-10.5s",
    	                       caracter, entero, real, cadena));		
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
}