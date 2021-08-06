package guis;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.Font;

public class _08_ControlMouse extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
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
					_08_ControlMouse frame = new _08_ControlMouse();
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
	public _08_ControlMouse() {
		setTitle("_08_ControlMouse");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProcesar = new JButton("Procesar");
		btnProcesar.addMouseListener(this);
		btnProcesar.setBounds(175, 11, 89, 23);
		contentPane.add(btnProcesar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 414, 209);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}
	public void mouseClicked(MouseEvent arg0) {
		imprimir("Al soltar el botón sólo si el mouse no se movió");
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnProcesar) {
			mouseEnteredBtnProcesar(arg0);
		}
	}
	public void mouseExited(MouseEvent arg0) {
		//  Si el mouse sale del interior
    	//  del btnProcesar regresa a puntero
		btnProcesar.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	public void mousePressed(MouseEvent arg0) {
		imprimir("Al mantener pulsado el botón");		
	}
	public void mouseReleased(MouseEvent arg0) {
		imprimir("Al soltar el botón");
	}
	protected void mouseEnteredBtnProcesar(MouseEvent arg0) {
		//  Si el mouse sobrevuela el interior
    	//	del btnProcesar se borra el txtS
    	//  y aparece una manito
		txtS.setText("");
		btnProcesar.setCursor(new Cursor(Cursor.HAND_CURSOR));		
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
}