package guis;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class _19_JCheckBox extends JFrame implements ItemListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JCheckBox chckbxLoro;
	private JCheckBox chckbxGato;
	private JCheckBox chckbxPerro;
	private JCheckBox chckbxConejo;
	private JCheckBox chckbxCerdo;
	private JLabel lblAnimal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_19_JCheckBox frame = new _19_JCheckBox();
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
	public _19_JCheckBox() {
		setTitle("_19_CheckBox");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		chckbxLoro = new JCheckBox("Loro");
		chckbxLoro.addItemListener(this);
		chckbxLoro.setBounds(10, 10, 70, 20);
		contentPane.add(chckbxLoro);
		
		chckbxGato = new JCheckBox("Gato");
		chckbxGato.addItemListener(this);
		chckbxGato.setBounds(10, 35, 70, 20);
		contentPane.add(chckbxGato);
		
		chckbxPerro = new JCheckBox("Perro");
		chckbxPerro.addItemListener(this);
		chckbxPerro.setBounds(10, 60, 70, 20);
		contentPane.add(chckbxPerro);
		
		chckbxConejo = new JCheckBox("Conejo");
		chckbxConejo.addItemListener(this);
		chckbxConejo.setBounds(10, 85, 70, 20);
		contentPane.add(chckbxConejo);
		
		chckbxCerdo = new JCheckBox("Cerdo");
		chckbxCerdo.addItemListener(this);
		chckbxCerdo.setBounds(10, 110, 70, 20);
		contentPane.add(chckbxCerdo);
		
		lblAnimal = new JLabel("", JLabel.CENTER);
		lblAnimal.setBounds(90, 5, 177, 129);
		lblAnimal.setBackground(Color.cyan);
		lblAnimal.setOpaque(true);		
		contentPane.add(lblAnimal);
	}
	public void itemStateChanged(ItemEvent arg0) {
		String s = " ";
		if (chckbxLoro.isSelected())
			s += "loro ";
		if (chckbxGato.isSelected())
			s += "gato ";
		if (chckbxPerro.isSelected())
			s += "perro ";
		if (chckbxConejo.isSelected())
			s += "conejo ";
		if (chckbxCerdo.isSelected())
			s += "cerdo ";
		lblAnimal.setText(s);	
	}
	
}
