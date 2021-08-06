package guis;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _17_Aleatorio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblDadoA;
	private JLabel lblDadoB;
	private JButton btnLanzar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_17_Aleatorio frame = new _17_Aleatorio();
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
	public _17_Aleatorio() {
		setResizable(false);
		setTitle("_17_Aleatorio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.green);
		
		lblDadoA = new JLabel("");
		lblDadoA.setBounds(10, 10, 304, 304);
		contentPane.add(lblDadoA);
		
		lblDadoB = new JLabel("");
		lblDadoB.setBounds(324, 10, 304, 304);
		contentPane.add(lblDadoB);
		
		btnLanzar = new JButton("Lanzar");
		btnLanzar.addActionListener(this);
		btnLanzar.setBounds(220, 320, 200, 25);
		contentPane.add(btnLanzar);
		
		lanzarDados();		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLanzar) {
			actionPerformedBtnLanzar(e);
		}
	}
	protected void actionPerformedBtnLanzar(ActionEvent e) {
		lanzarDados();		
	}
	//  Métodos tipo void (sin parámetros)
	void lanzarDados() {
		int dadoA = aleatorio(1,6),
		    dadoB = aleatorio(1,6);
		     
		lblDadoA.setIcon(imagenDado(dadoA));
		lblDadoB.setIcon(imagenDado(dadoB));
	}	
	//  Métodos que retornan valor (con parámetros)
	int aleatorio(int min, int max) {
	    return (int)((max - min + 1) * Math.random()) + min;
  	}
	ImageIcon imagenDado(int dado) {
		switch (dado) {
			case 1:
				return new ImageIcon("imagenes/uno.png");
			case 2:
				return new ImageIcon("imagenes/dos.png");
			case 3:
				return new ImageIcon("imagenes/tres.png");
			case 4:
				return new ImageIcon("imagenes/cuatro.png");
			case 5:
				return new ImageIcon("imagenes/cinco.png");
			default:
				return new ImageIcon("imagenes/seis.png");
		}
	}
	
}