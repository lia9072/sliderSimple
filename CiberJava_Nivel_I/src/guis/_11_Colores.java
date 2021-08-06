package guis;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class _11_Colores extends JFrame implements ItemListener {
	//  Variables globales
	int rojo = 0, verde = 0, azul = 0;
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JComboBox <String> cboRojo;
	private JComboBox <String> cboVerde;
	private JComboBox <String> cboAzul;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_11_Colores frame = new _11_Colores();
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
	public _11_Colores() {
		setTitle("_11_Colores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cboRojo = new JComboBox <String> ();
		cboRojo.addItemListener(this);
		cboRojo.setBounds(120, 100, 50, 25);
		colocarItems(cboRojo);
		contentPane.add(cboRojo);	
		
		cboVerde = new JComboBox <String> ();
		cboVerde.addItemListener(this);
		cboVerde.setBounds(190, 100, 50, 25);
		colocarItems(cboVerde);
		contentPane.add(cboVerde);
		
		cboAzul = new JComboBox <String> ();
		cboAzul.addItemListener(this);
		cboAzul.setBounds(260, 100, 53, 25);
		colocarItems(cboAzul);
		contentPane.add(cboAzul);
		
		colorDeFondo();
	}
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboRojo) {
			itemStateChangedCboRojo(arg0);
		}
		if (arg0.getSource() == cboVerde) {
			itemStateChangedCboVerde(arg0);
		}		
		if (arg0.getSource() == cboAzul) {
			itemStateChangedCboAzul(arg0);
		}		
	}
	protected void itemStateChangedCboRojo(ItemEvent arg0) {
		rojo = cboRojo.getSelectedIndex();
       	colorDeFondo();
	}
	protected void itemStateChangedCboVerde(ItemEvent arg0) {
		verde = cboVerde.getSelectedIndex();
		colorDeFondo();
	}
	protected void itemStateChangedCboAzul(ItemEvent arg0) {
		azul = cboAzul.getSelectedIndex();
		colorDeFondo();
	}
 	//  Métodos tipo void (sin parámetros)
 	void colorDeFondo() {
       	contentPane.setBackground(new Color(rojo, verde, azul)); 		
 	}
	//  Métodos tipo void (con parámetros)
	void colocarItems(JComboBox <String> cbo) {
		int i = 0;
		while (i < 256) {
			cbo.addItem("" + i);
			i++;
		}
	}
	
}