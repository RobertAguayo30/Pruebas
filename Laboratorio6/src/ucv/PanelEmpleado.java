package ucv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelEmpleado extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField txtDni = createText("DNI", 10, 20, 150, 40);
	private JTextField txtNombres = createText("Nombres", 160, 20, 200, 40);
	private JTextField txtApellidos = createText("Apellidos", 360, 20, 200, 40);

	private JButton salir = createButton("Salir", 390, 170);

	private JTextArea txaSalida = new JTextArea();

	private DecimalFormat df = new DecimalFormat("###0.00");

	/**
	 * Crear panel.
	 */
	public PanelEmpleado(JButton borrar) {
		setLayout(null);

		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		add(txtDni);
		add(txtNombres);
		add(txtApellidos);

		txaSalida.setBounds(10, 110, 550, 230);
		add(txaSalida);

		add(borrar);
		add(salir);
	}

	private JButton createButton(String title, int x, int w) {
		JButton boton = new JButton(title);
		boton.setBounds(x, 350, w, 35);
		return boton;
	}

	private JTextField createText(String titulo, int x, int y, int w, int h) {
		JTextField texto = new JTextField();
		texto.setBorder(new TitledBorder(null, titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		texto.setBounds(x, y, w, h);
		texto.setColumns(10);
		return texto;
	}

	/**
	 * Limpiar datos generales
	 */
	public void borrar() {
		txtDni.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txaSalida.setText("");
		txtDni.requestFocus();
	}

	/**
	 * Actualiza los datos del Area de Texto
	 * @param empleado Objeto del empleado
	 * @param tipo Tipo de empleado
	 */
	public void updateTextArea(Empleados empleado, String tipo) {
		// Limpiar la salida
		txaSalida.setText("");

		txaSalida.append("EMPLEADO " + tipo + ":\n\n");
		txaSalida.append("Nombres\t\t\t: " + empleado.getNombres() + "\n");
		txaSalida.append("Apellidos\t\t\t: " + empleado.getApellidos() + "\n");
		txaSalida.append("D.N.I.\t\t\t: " + empleado.getDni() + "\n");
		txaSalida.append("Ingresos\t\t\t: " + df.format(empleado.getIngresos()) + "\n");
		if (empleado instanceof EmpleadoVendedor)
			txaSalida.append("Bonificaciones\t\t\t: " + df.format(((EmpleadoVendedor) empleado).getBonus()) + "\n");
		txaSalida.append("Descuentos\t\t\t: " + df.format(empleado.getDescuentos()) + "\n");
		txaSalida.append("Sueldo Neto\t\t\t: " + df.format(empleado.getSueldoNeto()) + "\n");
	}

	public String getDni() {
		return txtDni.getText();
	}

	public String getNombres() {
		return txtNombres.getText();
	}

	public String getApellidos() {
		return txtApellidos.getText();
	}
}
