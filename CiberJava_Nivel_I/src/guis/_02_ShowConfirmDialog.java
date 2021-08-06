package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class _02_ShowConfirmDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnA;
	private JButton btnB;
	private JButton btnC;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_02_ShowConfirmDialog frame = new _02_ShowConfirmDialog();
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
	public _02_ShowConfirmDialog() {
		setTitle("_02_ShowConfirmDialog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnA = new JButton("A");
		btnA.addActionListener(this);
		btnA.setBounds(70, 228, 89, 23);
		contentPane.add(btnA);
		
		btnB = new JButton("B");
		btnB.addActionListener(this);
		btnB.setBounds(170, 228, 89, 23);
		contentPane.add(btnB);
		
		btnC = new JButton("C");
		btnC.addActionListener(this);
		btnC.setBounds(270, 228, 89, 23);
		contentPane.add(btnC);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 206);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
	//  Direcciona los eventos de tipo ActionEvent		
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnC) {
			actionPerformedBtnC(arg0);
		}
		if (arg0.getSource() == btnB) {
			actionPerformedBtnB(arg0);
		}
		if (arg0.getSource() == btnA) {
			actionPerformedBtnA(arg0);
		}
	}
	//  Procesa la pulsación del botón btnA	
	protected void actionPerformedBtnA(ActionEvent arg0) {
		int ok = confirmar("¿Es correcto?");
		imprimir("valor de pulsación :  " + ok);
	}
	//  Procesa la pulsación del botón btnB
	protected void actionPerformedBtnB(ActionEvent arg0) {
		int ok = confirmar("¿Es correcto?", "MN-Global ® >>> PrimaTaxi ®");
		imprimir("valor de pulsación :  " + ok);
	}
	//  Procesa la pulsación del botón btnC
	protected void actionPerformedBtnC(ActionEvent arg0) {
		int ok = confirmar("¿Es correcto?", "MN-Global ® >>> PrimaTaxi ®", "imagenes/PrimaTaxi.png");
		imprimir("valor de pulsación :  " + ok);
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	//  Métodos que retornan valor (con parámetros)
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);	
	}
	int confirmar(String s1, String s2) {
		int tipo = 2, icono = 1;
		// si tipo  es -1  -->  [Aceptar]
		// si tipo  es  0  -->  [Si] [No]
		// si tipo  es  1  -->  [Si] [No] [Cancelar]  (por defecto)
		// si tipo  es  2  -->  [Aceptar] [Cancelar]
		// si icono es -1  -->  sin símbolo
		// si icono es  0  -->  símbolo [x]
		// si icono es  1  -->  símbolo [¡]  
		// si icono es  2  -->  símbolo [!]
		// si icono es  3  -->  símbolo [?]  (por defecto)
		return JOptionPane.showConfirmDialog(this, s1, s2, tipo, icono, null);
	}
	int confirmar(String s1, String s2, String s3) {
		int tipo = 0;
		// si tipo  es -1  -->  [Aceptar]
		// si tipo  es  0  -->  [Si] [No]
		// si tipo  es  1  -->  [Si] [No] [Cancelar]  (por defecto)
		// si tipo  es  2  -->  [Aceptar] [Cancelar]
		return JOptionPane.showConfirmDialog(this, s1, s2, tipo, -1, new ImageIcon(s3));
	}
	
}