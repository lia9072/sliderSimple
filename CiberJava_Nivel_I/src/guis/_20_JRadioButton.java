package guis;

import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _20_JRadioButton extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JRadioButton rdbtnLoro;
	private JRadioButton rdbtnGato;
	private JRadioButton rdbtnPerro;
	private JRadioButton rdbtnConejo;
	private JRadioButton rdbtnCerdo;
	private ButtonGroup grupo;
	private JLabel lblAnimal;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_20_JRadioButton frame = new _20_JRadioButton();
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
	public _20_JRadioButton() {
		setTitle("_20_JRadioButton");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 262, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnLoro = new JRadioButton("Loro", true);
		rdbtnLoro.addActionListener(this);
		rdbtnLoro.setBounds(15, 10, 70, 20);
		contentPane.add(rdbtnLoro);
		
		rdbtnGato = new JRadioButton("Gato");
		rdbtnGato.addActionListener(this);
		rdbtnGato.setBounds(15, 35, 70, 20);
		contentPane.add(rdbtnGato);
		
		rdbtnPerro = new JRadioButton("Perro");
		rdbtnPerro.addActionListener(this);
		rdbtnPerro.setBounds(15, 60, 70, 20);
		contentPane.add(rdbtnPerro);
		
		rdbtnConejo = new JRadioButton("Conejo");
		rdbtnConejo.addActionListener(this);
		rdbtnConejo.setBounds(15, 85, 70, 20);
		contentPane.add(rdbtnConejo);
		
		rdbtnCerdo = new JRadioButton("Cerdo");
		rdbtnCerdo.addActionListener(this);
		rdbtnCerdo.setBounds(15, 110, 70, 20);
		contentPane.add(rdbtnCerdo);
		
		grupo = new ButtonGroup();
		
		grupo.add(rdbtnLoro);
		grupo.add(rdbtnGato);
		grupo.add(rdbtnPerro);
		grupo.add(rdbtnConejo);
		grupo.add(rdbtnCerdo);

		lblAnimal = new JLabel(new ImageIcon("imagenes/loro.gif"));
		lblAnimal.setBounds(100, 5, 121, 129);
		contentPane.add(lblAnimal);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == rdbtnLoro) {
			lblAnimal.setIcon(new ImageIcon("imagenes/loro.gif"));
		}
		if (arg0.getSource() == rdbtnGato) {
			lblAnimal.setIcon(new ImageIcon("imagenes/gato.gif"));
		}		
		if (arg0.getSource() == rdbtnPerro) {
			lblAnimal.setIcon(new ImageIcon("imagenes/perro.gif"));
		}
		if (arg0.getSource() == rdbtnConejo) {
			lblAnimal.setIcon(new ImageIcon("imagenes/conejo.gif"));
		}
		if (arg0.getSource() == rdbtnCerdo) {
			lblAnimal.setIcon(new ImageIcon("imagenes/cerdo.gif"));
		}
	}
	
}
