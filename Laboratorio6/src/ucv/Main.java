package ucv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

	private JPanel contentPane;

	private JTextField txtComision = createText("Tasa de comisi\u00F3n", 10);
	private JTextField txtVentas = createText("Monto vendido", 160);

	private JTextField txtSueldoBase = createText("Sueldo Base", 10);
	private JComboBox<String> afiliacion = new JComboBox<String>();

	private PanelEmpleado panelVendedor = new PanelEmpleado(borrar());
	private PanelEmpleado panelPermanente = new PanelEmpleado(borrar());

	/**
	 * Inicia la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create el frame.
	 */
	public Main() {
		setResizable(false);
		setTitle("Aplicacion de Herencia: Clases y Subclases");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane.setBounds(10, 10, 575, 420);
		contentPane.add(tabbedPane);

		tabbedPane.addTab("Empleado Vendedor", null, panelVendedor, null);
		tabbedPane.addTab("Empleado Permanente", null, panelPermanente, null);

		panelVendedor.add(txtComision);
		panelVendedor.add(txtVentas);

		panelPermanente.add(txtSueldoBase);
		afiliacion.setBorder(
				new TitledBorder(null, "Tipo de Afiliaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		afiliacion.setModel(new DefaultComboBoxModel<String>(new String[] { "AFP", "SNP" }));
		afiliacion.setBounds(160, 60, 150, 40);
		panelPermanente.add(afiliacion);

		panelVendedor.add(crearVendedor());
		panelPermanente.add(crearPermanente());
	}

	private JTextField createText(String titulo, int x) {
		JTextField texto = new JTextField();
		texto.setBorder(new TitledBorder(null, titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		texto.setBounds(x, 60, 150, 40);
		texto.setColumns(10);
		return texto;
	}

	/**
	 * Crea el boton del empleado vendedor
	 * 
	 * @return Boton de crear empleado
	 */
	private JButton crearVendedor() {
		JButton empleado = new JButton("Crear Empleado");
		empleado.setBounds(10, 350, 190, 35);
		empleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!datosIngresados(panelVendedor)) {
					JOptionPane.showMessageDialog(null, "Compruebe los datos ingresados.");
					return;
				}

				EmpleadoVendedor vendedor = new EmpleadoVendedor(panelVendedor.getDni(), panelVendedor.getNombres(),
						panelVendedor.getApellidos(), Float.parseFloat(txtVentas.getText()),
						Float.parseFloat(txtComision.getText()));
				// Actualiza el panel
				panelVendedor.updateTextArea(vendedor, "VENDEDOR");
			}
		});
		return empleado;
	}

	/**
	 * Crea el boton del empleado permanente
	 * 
	 * @return Boton de crear empleado
	 */
	private JButton crearPermanente() {
		JButton empleado = new JButton("Crear Empleado");
		empleado.setBounds(10, 350, 190, 35);
		empleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!datosIngresados(panelPermanente)) {
					JOptionPane.showMessageDialog(null, "Compruebe los datos ingresados.");
					return;
				}

				EmpleadoPermanente permanente = new EmpleadoPermanente(panelPermanente.getDni(),
						panelPermanente.getNombres(), panelPermanente.getApellidos(),
						Float.parseFloat(txtSueldoBase.getText()), afiliacion.getSelectedItem().toString());
				// Actualiza el panel
				panelPermanente.updateTextArea(permanente, "PERMANENTE");
			}
		});
		return empleado;
	}

	/**
	 * Crea el boton de borrar
	 * 
	 * @return Boton de borrar
	 */
	private JButton borrar() {
		JButton borrar = new JButton("Borrar");
		borrar.setBounds(200, 350, 190, 35);
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabbedPane.getSelectedIndex() == 0) {
					panelVendedor.borrar();
					txtVentas.setText("");
					txtComision.setText("");
				} else {
					panelPermanente.borrar();
					txtSueldoBase.setText("");
					afiliacion.setSelectedIndex(0);
				}
			}
		});
		return borrar;
	}

	/**
	 * Valida los datos del panel seleccionado
	 * 
	 * @param empleado Panel a validar
	 * @return {@code true} si todos los datos son correctos
	 */
	@SuppressWarnings("unused")
	public boolean datosIngresados(PanelEmpleado empleado) {
		try {
			int dni = Integer.parseInt(empleado.getDni());
			if (tabbedPane.getSelectedIndex() == 0) {
				float comision = Float.parseFloat(txtComision.getText());
				float ventas = Float.parseFloat(txtVentas.getText());
			} else {
				float sueldoBase = Float.parseFloat(txtSueldoBase.getText());
			}
		} catch (NumberFormatException | NullPointerException e) {
			return false;
		}
		return !empleado.getNombres().equals("") && !empleado.getApellidos().equals("");
	}
}
