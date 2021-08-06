package guis;

import javax.swing.ImageIcon;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class _16_JButton extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnA;
	private JButton btnB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_16_JButton frame = new _16_JButton();
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
	public _16_JButton() {
		setResizable(false);
		setTitle("_JButton");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnA = new JButton("<html>" +
			               "<h1> MN-Global ® </h1>" +
			               "<ul>" +
			               "<li> Capacitación </li>" +
			               "<li> Coaching </li>" +
			               "<li> Liderazgo </li>" +
			               "</ul>" +
			               "</html>");
		btnA.addActionListener(this);
		btnA.setBounds(0, 0, 200, 200);
		contentPane.add(btnA);
		
		btnB = new JButton(new ImageIcon("imagenes/PrimaTaxi_1.png"));
		btnB.addActionListener(this);
		btnB.setRolloverIcon(new ImageIcon("imagenes/PrimaTaxi_2.png"));
		btnB.setPressedIcon(new ImageIcon("imagenes/PrimaTaxi_3.png"));
		btnB.setBounds(200, 0, 200, 200);
		contentPane.add(btnB);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnB) {
			actionPerformedBtnB(e);
		}
		if (e.getSource() == btnA) {
			actionPerformedBtnA(e);
		}
	}
	protected void actionPerformedBtnA(ActionEvent e) {
	}
	protected void actionPerformedBtnB(ActionEvent e) {
	}
	
}