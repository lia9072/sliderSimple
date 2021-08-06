package guis;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class _13_FechaHora extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnOk;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	//  Lanza la Aplicación
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_13_FechaHora frame = new _13_FechaHora();
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
	public _13_FechaHora() {
		setTitle("_13_FechaHora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setBounds(170, 228, 92, 23);
		contentPane.add(btnOk);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 415, 210);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
	//  Direcciona los eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnOk) {
			actionPerformedBtnOk(arg0);
		}
	}
	//  Procesa la pulsación del botón btnA	
	protected void actionPerformedBtnOk(ActionEvent arg0) {
		int dd, mm, aa, hh, mn, ss;
		Calendar c = new GregorianCalendar();
			
		dd = c.get(Calendar.DAY_OF_MONTH);
		mm = c.get(Calendar.MONTH)+1;
		aa = c.get(Calendar.YEAR);
		hh = c.get(Calendar.HOUR_OF_DAY);
		mn = c.get(Calendar.MINUTE);
		ss = c.get(Calendar.SECOND);
		
		imprimir("Fecha --> " + ajustar(dd) + "/" + 
		                        ajustar(mm) + "/" + 
				                aa);
		imprimir("Hora  --> " + ajustar(hh) + "h " + 
                                ajustar(mn) + "m " + 
                                ajustar(ss) + "s");
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	//  Métodos que retornan valor (con parámetros)	
	String ajustar(int numero) {
		return String.format("%02d", numero);
	}
	
}