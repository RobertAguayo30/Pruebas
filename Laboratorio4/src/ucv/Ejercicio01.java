package ucv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Ejercicio01 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtxtNombres = configureText("Apellidos y Nombres", 20, 20, 392, 36);
	private JTextField jtxtNota1 = configureText("Nota 1", 20, 56, 100, 36);
	private JTextField jtxtNota2 = configureText("Nota 2", 20, 92, 100, 36);
	private JTextField jtxtNota3 = configureText("Nota 3", 20, 128, 100, 36);
	private JTextField jtxtCredito1 = configureText("Cr\u00E9dito 1", 130, 56, 100, 36);
	private JTextField jtxtCredito2 = configureText("Cr\u00E9dito 2", 130, 92, 100, 36);
	private JTextField jtxtCredito3 = configureText("Cr\u00E9dito 3", 130, 128, 100, 36);
	private JTextField jtxtNomPromMayor = configureText("Apellidos y Nombres", 10, 18, 260, 36);
	private JTextField jtxtPromMayor = configureText("El mayor promedio ponderado", 10, 61, 260, 36);

	private JButton jbtnNuevosDatos = crearBoton("NUEVOS DATOS", 240, 108, 172, 44, "Lista.jpg");
	private JButton jbtnGuardarEstudiante = crearBoton("GRABAR DATOS", 240, 67, 172, 44, "Guardar.jpg");
	private JButton jbtnMostrar = crearBoton("MOSTRAR", 442, 10, 280, 38);
	private JButton jbtnLimpiar = crearBoton("LIMPIAR", 442, 48, 162, 38);
	private JButton jbtnSalir = crearBoton("SALIR", 604, 48, 118, 38);

	// Datos a mostrar
	DefaultListModel<String> LNum, LNombres, LNota1, LNota2, LNota3, LCredito1, LCredito2, LCredito3, LPromSim,
			LPromPond;

	private static final DecimalFormat df = new DecimalFormat("##0.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio01 frame = new Ejercicio01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio01() {
		// Cargar los paneles
		setResizable(false);
		setTitle("Ejemplo 4 - Estructura Repetitiva FOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 552);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel datos = new JPanel();
		datos.setBorder(
				new TitledBorder(null, "DATOS DEL ESTUDIANTE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		datos.setBounds(10, 26, 422, 174);
		contentPane.add(datos);
		datos.setLayout(null);

		JPanel mejor_estudiante = new JPanel();
		mejor_estudiante.setBorder(new TitledBorder(null, "REPORTE DEL MEJOR ESTUDIANTE", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		mejor_estudiante.setBounds(442, 95, 280, 106);
		contentPane.add(mejor_estudiante);
		mejor_estudiante.setLayout(null);

		// Cargar los recuadros
		datos.add(jtxtNombres);
		datos.add(jtxtNota1);
		datos.add(jtxtNota2);
		datos.add(jtxtNota3);
		datos.add(jtxtCredito1);
		datos.add(jtxtCredito2);
		datos.add(jtxtCredito3);

		jtxtNomPromMayor.setEditable(false);
		jtxtPromMayor.setEditable(false);
		mejor_estudiante.add(jtxtNomPromMayor);
		mejor_estudiante.add(jtxtPromMayor);

		// Cargar las listas
		cargarModelos();

		// Carga los botones
		jbtnNuevosDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarEntradas();
			}
		});
		datos.add(jbtnNuevosDatos);

		jbtnGuardarEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String campo, nombres;
				double n1, n2, n3, c1, c2, c3, prom, pond;
				campo = verificarCampos();
				if (campo.equals("")) {
					nombres = jtxtNombres.getText();
					n1 = Double.parseDouble(jtxtNota1.getText().replace(",", "."));
					c1 = Double.parseDouble(jtxtCredito1.getText().replace(",", "."));
					n2 = Double.parseDouble(jtxtNota2.getText().replace(",", "."));
					c2 = Double.parseDouble(jtxtCredito2.getText().replace(",", "."));
					n3 = Double.parseDouble(jtxtNota3.getText().replace(",", "."));
					c3 = Double.parseDouble(jtxtCredito3.getText().replace(",", "."));

					prom = (n1 + n2 + n3) / 3;
					pond = (n1 * c1 + n2 * c2 + n3 * c3) / (c1 + c2 + c3);

					LNombres.addElement(nombres);
					LNota1.addElement(df.format(n1));
					LCredito1.addElement(df.format(c1));
					LNota2.addElement(df.format(n2));
					LCredito2.addElement(df.format(c2));
					LNota3.addElement(df.format(n3));
					LCredito3.addElement(df.format(c3));
					LPromSim.addElement(df.format(prom));
					LPromPond.addElement(df.format(pond));

					int num = LNombres.size();
					LNum.addElement(num + "");

					limpiarEntradas();
					jbtnNuevosDatos.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, "Verifique los datos en el campo de " + campo);
				}
			}
		});
		datos.add(jbtnGuardarEstudiante);

		jbtnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Evita que se muestre el -999
				if (LNombres.size() <= 0)
					return;

				int n, i;
				String nombre, dato = "";
				double pond, mayor = -999;

				n = LNombres.size();

				for (i = 0; i < n; i++) {
					nombre = LNombres.getElementAt(i).toString();
					pond = Double.parseDouble(LPromPond.getElementAt(i).toString().replace(",", "."));

					if (pond > mayor) {
						mayor = pond;
						dato = nombre;
					}
				}
				jtxtNomPromMayor.setText(dato);
				jtxtPromMayor.setText(df.format(mayor));
			}
		});
		contentPane.add(jbtnMostrar);

		jbtnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LNum.removeAllElements();
				LNombres.removeAllElements();
				LNota1.removeAllElements();
				LNota2.removeAllElements();
				LNota3.removeAllElements();
				LCredito1.removeAllElements();
				LCredito2.removeAllElements();
				LCredito3.removeAllElements();
				LPromPond.removeAllElements();
				LPromSim.removeAllElements();
				limpiarEntradas();
			}
		});
		contentPane.add(jbtnLimpiar);

		jbtnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(jbtnSalir);
	}

	private JButton crearBoton(String nombre, int x, int y, int w, int h) {
		JButton boton = new JButton(nombre);
		boton.setBounds(x, y, w, h);
		return boton;
	}

	private JButton crearBoton(String nombre, int x, int y, int w, int h, String iconName) {
		JButton boton = crearBoton(nombre, x, y, w, h);
		boton.setIcon(new ImageIcon(new File(".").getAbsolutePath() + "\\rss\\" + iconName));
		return boton;
	}

	private void cargarModelos() {
		LNum = new DefaultListModel<String>();
		LNombres = new DefaultListModel<String>();
		LNota1 = new DefaultListModel<String>();
		LNota2 = new DefaultListModel<String>();
		LNota3 = new DefaultListModel<String>();
		LCredito1 = new DefaultListModel<String>();
		LCredito2 = new DefaultListModel<String>();
		LCredito3 = new DefaultListModel<String>();
		LPromSim = new DefaultListModel<String>();
		LPromPond = new DefaultListModel<String>();

		// Crea los paneles y los añade
		contentPane.add(createScrollPane("N\u00B0", 10, 210, 36, 291, LNum));
		contentPane.add(createScrollPane("Apellidos y Nombres", 47, 210, 200, 291, LNombres));
		contentPane.add(createScrollPane("Nota 1", 248, 210, 56, 291, LNota1));
		contentPane.add(createScrollPane("Nota 2", 362, 210, 56, 291, LNota2));
		contentPane.add(createScrollPane("Nota 3", 476, 210, 56, 291, LNota3));
		contentPane.add(createScrollPane("Crd. 1", 305, 210, 56, 291, LCredito1));
		contentPane.add(createScrollPane("Crd. 2", 419, 210, 56, 291, LCredito2));
		contentPane.add(createScrollPane("Crd. 3", 533, 210, 56, 291, LCredito3));
		contentPane.add(createScrollPane("Prom. S", 590, 210, 72, 291, LPromSim));
		contentPane.add(createScrollPane("Prom. P", 663, 210, 80, 291, LPromPond));
	}

	private String verificarCampos() {
		if (jtxtNombres.getText().equals(""))
			return "Apellidos y Nombres";
		if (jtxtNota1.getText().equals("") || Double.parseDouble(jtxtNota1.getText().replace(",", ".")) < 0
				|| Double.parseDouble(jtxtNota1.getText().replace(",", ".")) > 20)
			return "Nota 1";
		if (jtxtCredito1.getText().equals("") || Double.parseDouble(jtxtCredito1.getText().replace(",", ".")) < 0
				|| Double.parseDouble(jtxtCredito1.getText().replace(",", ".")) > 20)
			return "Credito 1";
		if (jtxtNota2.getText().equals("") || Double.parseDouble(jtxtNota2.getText().replace(",", ".")) < 0
				|| Double.parseDouble(jtxtNota2.getText().replace(",", ".")) > 20)
			return "Nota 2";
		if (jtxtCredito2.getText().equals("") || Double.parseDouble(jtxtCredito2.getText().replace(",", ".")) < 0
				|| Double.parseDouble(jtxtCredito2.getText().replace(",", ".")) > 20)
			return "Credito 2";
		if (jtxtNota3.getText().equals("") || Double.parseDouble(jtxtNota3.getText().replace(",", ".")) < 0
				|| Double.parseDouble(jtxtNota3.getText().replace(",", ".")) > 20)
			return "Nota 3";
		if (jtxtCredito3.getText().equals("") || Double.parseDouble(jtxtCredito3.getText().replace(",", ".")) < 0
				|| Double.parseDouble(jtxtCredito3.getText().replace(",", ".")) > 20)
			return "Credito 3";

		return "";
	}

	private JTextField configureText(String title, int x, int y, int w, int h) {
		JTextField textField = new JTextField();
		textField.setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		textField.setBounds(x, y, w, h);
		textField.setColumns(10);
		return textField;
	}

	private JScrollPane createScrollPane(String title, int x, int y, int w, int h, DefaultListModel<String> model) {
		// Crea el ScrollPane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setBounds(x, y, w, h);

		// Crea la lista
		JList<String> list = new JList<String>();
		list.setBorder(new TitledBorder(null, title, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(list);

		// Asigna el modelo
		list.setModel(model);

		return scrollPane;
	}

	private void limpiarEntradas() {
		jtxtNombres.setText("");
		jtxtNota1.setText("");
		jtxtCredito1.setText("");
		jtxtNota2.setText("");
		jtxtCredito2.setText("");
		jtxtNota3.setText("");
		jtxtCredito3.setText("");
		jtxtNombres.requestFocus();
	}
}
