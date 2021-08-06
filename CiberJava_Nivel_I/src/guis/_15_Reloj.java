package guis;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _15_Reloj extends JFrame implements ActionListener, Runnable {

	//  Variables globales
	Thread hilo;
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblFechaHora;
	private JButton btnCongelar;
	private JButton btnDescongelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_15_Reloj frame = new _15_Reloj();
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
	public _15_Reloj() {
		setTitle("_15_Reloj");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFechaHora = new JLabel("", JLabel.CENTER);
		lblFechaHora.setBounds(0, 0, 434, 50);
		lblFechaHora.setFont(new Font("dialog", 0, 24));
		lblFechaHora.setOpaque(true);
		lblFechaHora.setBackground(Color.black);
		lblFechaHora.setForeground(Color.white);		
		contentPane.add(lblFechaHora);
		
		btnCongelar = new JButton("Congelar");
		btnCongelar.addActionListener(this);
		btnCongelar.setBounds(160, 123, 110, 23);
		contentPane.add(btnCongelar);
		
		btnDescongelar = new JButton("Descongelar");
		btnDescongelar.addActionListener(this);
		btnDescongelar.setBounds(160, 155, 110, 23);
		contentPane.add(btnDescongelar);
		btnDescongelar.setEnabled(false);
		
		hilo = new Thread(this);
	 	hilo.start();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCongelar) {
			actionPerformedBtnCongelar(arg0);
		}
		if (arg0.getSource() == btnDescongelar) {
			actionPerformedBtnDescongelar(arg0);
		}		
	}
	protected void actionPerformedBtnCongelar(ActionEvent arg0) {
		btnCongelar.setEnabled(false);
		btnDescongelar.setEnabled(true);
		hilo = null;		
	}
	protected void actionPerformedBtnDescongelar(ActionEvent arg0) {
		btnDescongelar.setEnabled(false);
		btnCongelar.setEnabled(true);
		hilo = new Thread(this);
	 	hilo.start();
	}
	//  Controla el tiempo
	public void run() {
	 	while (hilo != null)
	 		try {
	 			Thread.sleep(1);
	 			actualizarFechaYhora();	 			
	 		}
	 		catch (Exception e) {
	 		}
	}	
	//  Métodos tipo void (sin parámetros)
	void actualizarFechaYhora() {
		lblFechaHora.setText("Fecha = " + fecha() + "   " +
		                     "Hora = " + hora());
	}
	//  Métodos que retornan valor (sin parámetros)
	String fecha() {
		Calendar calendario = new GregorianCalendar();
		return String.format("%02d/",calendario.get(Calendar.DAY_OF_MONTH)) +
			   String.format("%02d/",calendario.get(Calendar.MONTH) + 1) +
			   calendario.get(Calendar.YEAR);
	}
	String hora() {
		Calendar calendario = new GregorianCalendar();
		return String.format("%02d:",calendario.get(Calendar.HOUR_OF_DAY)) +
			   String.format("%02d:",calendario.get(Calendar.MINUTE)) +
			   String.format("%02d",calendario.get(Calendar.SECOND));
	}
	
}