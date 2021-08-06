package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class _06_JComboBox extends JFrame implements ItemListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JComboBox <String> cboComboA;
	private JComboBox <String> cboComboB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_06_JComboBox frame = new _06_JComboBox();
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
	public _06_JComboBox() {
		setTitle("_06_JComboBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cboComboA = new JComboBox <String> ();
		cboComboA.addItemListener(this);
		cboComboA.setModel(new DefaultComboBoxModel <String> 
		                  (new String[] {"bebida", "verdura", "crema", "pan"}));
		cboComboA.setBounds(125, 100, 89, 23);
		contentPane.add(cboComboA);
		
		cboComboB = new JComboBox <String> ();
		cboComboB.setBounds(220, 100, 89, 22);
		contentPane.add(cboComboB);
		
		colocarItemsEnComboB();	
	}
	//  Direcciona los eventos de tipo ItemEvent
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboComboA) {
			itemStateChangedCboComboA(arg0);
		}
	}
	protected void itemStateChangedCboComboA(ItemEvent arg0) {
		//  Si cambió de item en cboComboA
       	if (arg0.getSource() == cboComboA)
       		colocarItemsEnComboB();	
	}
	//  Métodos tipo void (sin parámetros)
	void colocarItemsEnComboB() {
		cboComboB.removeAllItems();
       	switch(cboComboA.getSelectedIndex()) {
       		case 0:
       			cboComboB.addItem("coca cola");
				cboComboB.addItem("inca kola");
				cboComboB.addItem("fanta");
				cboComboB.addItem("sprite"); 
				break;
       		case 1: 
       			cboComboB.addItem("apio");
				cboComboB.addItem("poro");
				cboComboB.addItem("lechuga");
				cboComboB.addItem("tomate"); 
				break;
       		case 2:
       			cboComboB.addItem("ketchup");
				cboComboB.addItem("mayonesa");
				cboComboB.addItem("mostaza");
				cboComboB.addItem("golf"); 
				break;
       		default:
       			cboComboB.addItem("francés");	 
       			cboComboB.addItem("tolete");
				cboComboB.addItem("yema");
				cboComboB.addItem("baguette");
       	}
	}
	
}