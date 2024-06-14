package ucv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class EmpleadosGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Texto
	private JTextField txtCodigo = Utils.createText("C\u00F3digo", 10, 10, 120, 40);
	private JTextField txtNombre = Utils.createText("Nombre", 140, 10, 240, 40);
	private JTextField txtSueldo = Utils.createText("Sueldo Base", 10, 60, 120, 40);
	private JTextField txtHorasExtras = Utils.createText("Horas Extras", 140, 60, 130, 40);

	// ComboBox
	private JComboBox<String> areaCombo = Utils.createCombo("Area", 280, 60, 250, 40,
			new String[] { "-----SELECCIONE-----", "Sistemas", "Administración", "Marketing" });
	private JComboBox<String> seguroCombo = Utils.createCombo("Tipo de Seguro", 390, 10, 140, 40,
			new String[] { "---SELECCIONE---", "AFP", "SNP" });

	// Botones
	private JButton btnGrabar = Utils.createButton("GRABAR", 540, 10, 240, 45);
	private JButton btnLimpiar = Utils.createButton("LIMPIAR", 780, 10, 200, 45);
	private JButton btnSalir = Utils.createButton("SALIR", 780, 55, 200, 45);
	private JButton btnMostrarResumen = Utils.createButton("MOSTRAR RESUMEN", 540, 55, 240, 45);

	// Crear la tabla
	private String[][] data;
	private String[] cabecera = { "N°", "Codigo", "Nombres", "Area", "Tipo Seg", "Horas Extras", "Sueldo",
			"Monto H. E.", "Monto Seguro", "Monto Essalud", "Sueldo Neto" };
	private DefaultTableModel tableModel = new DefaultTableModel(data, cabecera);
	private JTable table;

	// Datos de empleados
	private Empleado[] arrayEmp = new Empleado[100];
	private int numEmp;

	// Resultado
	private Resultado resultado = new Resultado();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpleadosGUI frame = new EmpleadosGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EmpleadosGUI() {
		setTitle("Arreglo de Objetos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(txtCodigo);
		contentPane.add(txtNombre);
		contentPane.add(txtSueldo);
		contentPane.add(txtHorasExtras);

		contentPane.add(areaCombo);
		contentPane.add(seguroCombo);

		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cod = txtCodigo.getText();
				String nom = txtNombre.getText();
				String seguro = seguroCombo.getSelectedItem().toString();
				double sueldo = Double.parseDouble(txtSueldo.getText());
				int h_extras = Integer.parseInt(txtHorasExtras.getText());
				String area = areaCombo.getSelectedItem().toString();

				Empleado emp = new Empleado(cod, nom, area, sueldo, h_extras, seguro);

				arrayEmp[numEmp] = emp;
				insertarFila(emp);
				numEmp++;

				limpiarEntradas();
			}
		});
		contentPane.add(btnGrabar);

		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarEntradas();
			}
		});
		contentPane.add(btnLimpiar);

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalir);

		btnMostrarResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultado.mostrarDatos(arrayEmp);
			}
		});
		contentPane.add(btnMostrarResumen);

		table = new JTable();
		table.setBounds(10, 110, 970, 288);

		arrayEmp = new Empleado[100];
		tableModel = new DefaultTableModel(data, cabecera);
		table.setModel(tableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 110, 970, 360);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(table);

		resultado.setBounds(10, 470, 970, 126);
		contentPane.add(resultado);
	}

	private void insertarFila(Empleado empleado) {
		DecimalFormat df = new DecimalFormat("####.00");
		String horasExtras = df.format(empleado.montoHExtras());
		String montoSeguro = df.format(empleado.montoSeguro());
		String montoEssalud = df.format(empleado.montoEssalud());
		String sueldoNeto = df.format(empleado.sueldoNeto());

		Object[] fila = { numEmp + 1, empleado.getCodigo(), empleado.getNombres(), empleado.getAreaLaboral(),
				empleado.getSeguro(), empleado.getHorasExtras(), empleado.getSueldoBase(), horasExtras, montoSeguro,
				montoEssalud, sueldoNeto };

		tableModel.addRow(fila);
	}

	private void limpiarEntradas() {
		txtCodigo.setText("");
		txtNombre.setText("");
		areaCombo.setSelectedIndex(0);
		txtSueldo.setText("");
		txtHorasExtras.setText("");
		seguroCombo.setSelectedIndex(0);
		txtCodigo.requestFocus();
	}
}
