package guis;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class _21_MendoPaz extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblLema;
	private JLabel lblAudi;
	private JLabel lblFondo;
	
	Thread hilo;
	
	int contador = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_21_MendoPaz frame = new _21_MendoPaz();
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
	public _21_MendoPaz() {
		int ANCHO = 800, ALTO = 600,
			DX = 13, DY = 31;
		
		setResizable(false);
		setTitle("Mendo Paz SRL");
		setIconImage(new ImageIcon("imagenes/PrimaTaxi.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(ANCHO + DX, ALTO + DY);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLema = new JLabel();
		lblLema.setForeground(Color.WHITE);
		lblLema.setFont(new Font("Arial", Font.PLAIN, 20));
		lblLema.setHorizontalAlignment(0);
		lblLema.setBounds(0, 0, ANCHO, 58);
		contentPane.add(lblLema);

		lblAudi = new JLabel(new ImageIcon("imagenes/Audi.png"));
		lblAudi.setToolTipText("AUDI");
		lblAudi.setOpaque(true);
		lblAudi.setBackground(new Color(0, 0, 0, 50));
		lblAudi.setBounds(59, 100, 680, 310);
		contentPane.add(lblAudi);	
		
		lblFondo = new JLabel(new ImageIcon("imagenes/MendoPaz.png"));
		lblFondo.setBounds(1, 1, ANCHO, ALTO);
		getContentPane().add(lblFondo);
		
		hilo = new Thread(this);
 		hilo.start();
	}
	public void run() {
	 	while (hilo != null)
	 		try { 
	 			procesar();
	 			Thread.sleep(8000);
	 		}
	 		catch (Exception e) {
	 		}
	}
	void procesar() {
		lblLema.setText("\"" + lemaMP() + "\"");
		contador ++;
		if (contador == 43)
			contador = 0;
	}
	String lemaMP() {
		switch (contador) {
			case  0:
				return "Coraje es la fuerza que tiene el Ser para no dar su brazo a torcer.";
			case  1:
				return "Haciendo algo distinto, lograremos distinguirnos entre los dem�s.";
			case  2:
				return "Una buena ense�anza es aquella que nos conduce hacia un gran cambio.";
			case  3:
				return "La grandeza de una Naci�n se determina por el �xito de su poblaci�n.";
			case  4:
				return "Comunicaci�n y entendimiento es el primer paso para toda gran acci�n.";
			case  5:
				return "No se preocupe por el futuro de su esfuerzo y contin�e con su trabajo.";
			case  6:
				return "S�lo quienes dan un paso adelante viven la esperanza y la oportunidad.";
			case  7:
				return "Trabajar con dignidad significa respetar nuestro principio de lealtad.";
			case  8:
				return "Suerte es la palabra equivocada cuando el ��xito� sustituye al riesgo.";
			case  9:
				return "Debemos ser perseverantes si queremos escuchar del �xito una respuesta.";
			case 10:
				return "Persistir ante un obst�culo es m�s glorioso que pasarlo sin sacrificio.";
			case 11:
				return "Bondadoso es aquel Hombre que ayuda con el ejemplo y da con el coraz�n.";
			case 12:
				return "Busquemos siempre una alternativa m�s, pero no abandonemos a las dem�s.";
			case 13:
				return "La mente determina los actos, pero es el impulso lo que hace la acci�n.";
			case 14:
				return "Hagamos que los verbos crear e innovar sean ejercicios diarios de vida.";
			case 15:
				return "La humildad es una virtud que no debemos descuidar, mucho menos olvidar.";
			case 16:
				return "Quien no da un paso adelante vive s�lo de la esperanza y la oportunidad.";
			case 17:
				return "El talento es bendici�n Divina. Una gota de sabidur�a puesta en el Ser.";
			case 18:
				return "Vivir, crear y difundir es motivarse a continuar por el camino correcto.";
			case 19:
				return "El conocimiento te vuelve inteligente. El razonamiento te hace diferente.";
			case 20:
				return "Para aceptar el cambio no debemos esperar a que el mundo lo haga primero.";
			case 21:
				return "Contribuir con el desarrollo es fortalecer las bases de toda edificaci�n.";
			case 22:
				return "Ser tenaz en nuestro trabajo es hacerlo con esfuerzo, ah�nco y dedicaci�n.";
			case 23:
				return "Si queremos hacer algo y empezamos ya, habremos vencido el problema mayor.";
			case 24:
				return "No interesa cu�n dif�cil sea un problema si buscamos siempre una soluci�n.";
			case 25:
				return "El don de la virtud es la joya m�s valiosa que Dios puede darle al hombre.";
			case 26:
				return "No nos preocupemos por cometer errores, s�lo evitemos cometerlos otra vez.";
			case 27:
				return "Vivimos en un mundo de evoluci�n permanente. Por eso, aceptemos el cambio.";
			case 28:
				return "El Ser por naturaleza busca algo m�s, y por lo general encuentra algo m�s.";
			case 29:
				return "S�lo porque el mundo cambia, aprovecha la oportunidad y cambia t� tambi�n.";
			case 30:
				return "Admitiendo la posibilidad de un error, estaremos preparados para aceptarlo.";
			case 31:
				return "El hombre perseverante y el hombre testarudo tienen en com�n: la terquedad.";
			case 32:
				return "El l�der no mide las consecuencias de un posible fracaso, s�lo las analiza.";
			case 33:
				return "La iniciativa es la voluntad para transformar a la creatividad en creaci�n.";
			case 34:
				return "La grandeza de nuestro Per� est� en la voluntad y en el deseo de progresar.";
			case 35:
				return "Esfu�rzate por ser mejor y ver�s que s�lo t� eres el art�fice de tu destino.";
			case 36:
				return "Ilusi�n es la alegr�a que los seres humanos sentimos al momento de imaginar.";
			case 37:
				return "Un hombre y su trabajo ser�n productivos, si logran reflejarse en los dem�s.";
			case 38:
				return "Florezca su talento creativo y no deje que el talento por s� le eche flores.";
			case 39:
				return "Lo que queremos y podemos hacer no debe ser discutido: simplemente hag�moslo.";
			case 40:
				return "Si queremos lograr el �xito, debemos apurarnos por llegar a la meta y empezar.";
			case 41:
				return "La ense�anza logra su objetivo cuando hace del aprendizaje un h�bito natural.";
			default:
				return "El hombre busca siempre una explicaci�n, y encuentra en Dios una buena raz�n.";
		}
	}
	
}
