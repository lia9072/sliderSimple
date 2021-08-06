package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _01_ShowMessageDialog extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnA;
	private JButton btnB;
	private JButton btnC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_01_ShowMessageDialog frame = new _01_ShowMessageDialog();
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
	public _01_ShowMessageDialog() {
		setTitle("_01_ShowMessageDialog");
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
	//  Procesa la pulsaci�n del bot�n btnA
	protected void actionPerformedBtnA(ActionEvent arg0) {
		mensaje("Hola que tal", "saluda no sabes saludar" );
	}
	//  Procesa la pulsaci�n del bot�n btnB
	protected void actionPerformedBtnB(ActionEvent arg0) {
		mensaje("Hola que tal", "MN-Global � >>> PrimaTaxi �");
	}
	protected void actionPerformedBtnC(ActionEvent arg0) {
		mensaje("Hola que tal", "MN-Global � >>> PrimaTaxi �", "imagenes/PrimaTaxi.png");
	}
	//  M�todos tipo void (con par�metros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void mensaje(String s1, String s2) {
		int icono = 2;
		// si icono es -1  -->  sin s�mbolo
		// si icono es  0  -->  s�mbolo [x]
		// si icono es  1  -->  s�mbolo [�]  (por defecto)
		// si icono es  2  -->  s�mbolo [!]
		// si icono es  3  -->  s�mbolo [?]
		JOptionPane.showMessageDialog(this, s1, s2, icono);
	}
	void mensaje(String s1, String s2, String s3) {
		JOptionPane.showMessageDialog(this, s1, s2, 3, new ImageIcon(s3));
	}
	
}