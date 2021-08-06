package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class _07_JComboBox extends JFrame implements ItemListener, ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblPosicion;
	private JComboBox <String> cboProducto;	
	private JButton btnEliminar;
	private JTextField txtProducto;
	private JButton btnAgregar;
	
	/**
	 * Launch the application.
	 */
	//  Lanza la Aplicación
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_07_JComboBox frame = new _07_JComboBox();
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
	public _07_JComboBox() {
		setTitle("_07_JComboBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPosicion = new JLabel("Posici\u00F3n : 0");
		lblPosicion.setBounds(10, 10, 70, 23);
		contentPane.add(lblPosicion);
		
		cboProducto = new JComboBox <String> ();
		cboProducto.addItemListener(this);
		cboProducto.setModel(new DefaultComboBoxModel <String>
		                    (new String[] {"lápiz", "borrador", "plumón", "regla"}));
		cboProducto.setBounds(90, 10, 100, 23);
		contentPane.add(cboProducto);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(195, 10, 80, 23);
		contentPane.add(btnEliminar);

		txtProducto = new JTextField();
		txtProducto.setBounds(280, 10, 67, 24);
		contentPane.add(txtProducto);
		txtProducto.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(350, 10, 80, 23);
		contentPane.add(btnAgregar);
	}
	//  Direcciona los eventos de tipo ItemEvent
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboProducto) {
			itemStateChangedCboProducto(arg0);
		}
	}
	//  Si cambió de item en cboProducto
	protected void itemStateChangedCboProducto(ItemEvent arg0) {
    	lblPosicion.setText("Posición : " + cboProducto.getSelectedIndex());
	}
	//  Direcciona los eventos de tipo ActionEvent
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}		
	}
	//  Procesa la pulsación del botón btnEliminar
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		int  posProducto = cboProducto.getSelectedIndex();
		if (posProducto >= 0) {
	    	cboProducto.removeItem(cboProducto.getSelectedItem());
	    	posProducto = cboProducto.getSelectedIndex();
			if (posProducto >= 0)
				lblPosicion.setText("Posición : " + posProducto);
			else
				lblPosicion.setText("vacío");
		}		
	}
	//  Procesa la pulsación del botón btnAgregar
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		String  producto = txtProducto.getText();
		if (producto.length() > 0) {
			cboProducto.addItem(producto);
			lblPosicion.setText("Posición : " + cboProducto.getSelectedIndex());	
			txtProducto.setText("");
		}
		txtProducto.requestFocus();			
	}
	
}