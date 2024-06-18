package ucv;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

public class Resultado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField mayorSueldo = Utils.createText("Empleado con mayor sueldo neto", 20, 20, 310, 48, false);
	private JTextField montoHExtraSistemas = Utils
			.createText("N\u00B0 de Emp. de sistemas con MontoHE entre 500 y 800 soles", 20, 68, 310, 48, false);
	private JTextField sueldoPromMarketing = Utils.createText("Promedio de sueldos del area de Marketing", 330, 20, 310,
			48, false);
	private JTextField snpMenorDescuento = Utils.createText("Empleado del SNP con el menor monto de Descuento", 330, 68,
			310, 48, false);
	private JTextField seguroMayor100 = Utils.createText("N\u00B0 de Emp. cuyo monto de Seguro > 100 soles", 640, 20,
			310, 48, false);

	private JTextField totalPagar = Utils.createText("Total que gasta la empresa en pagar a todos sus empleados", 640,
			68, 310, 48, false);

	public Resultado() {
		setBorder(new TitledBorder(null, "RESUMEN DE DATOS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);

		add(mayorSueldo);
		add(montoHExtraSistemas);
		add(sueldoPromMarketing);
		add(snpMenorDescuento);
		add(seguroMayor100);
		add(totalPagar);
	}

	public void mostrarDatos(Empleado[] empleados) {
		double tempMayorSueldo = -1, tempMenorDescuento = 999999, sueldoMarketing = 0, cont = 0, b = 0, f = 0;
		int c = 0, d = 0;
		String a = "", e = "";
		for (Empleado empleado : empleados) {
			if (empleado == null) {
				continue;
			}

			// a) Nombre mayor sueldo
			if (empleado.sueldoNeto() > tempMayorSueldo) {
				tempMayorSueldo = empleado.sueldoNeto();
				a = empleado.getNombres();
			}

			// b) Promedio sueldo Marketing
			if (empleado.getAreaLaboral().equals("Marketing")) {
				sueldoMarketing += empleado.sueldoNeto();
				cont++;
				b = sueldoMarketing / cont;
			}

			// c) Personas con mas de 100 soles de seguro
			if (empleado.montoSeguro() > 100) {
				c++;
			}

			// d) Sistemas con pago por horas extras entre 500 y 800
			if (empleado.getAreaLaboral().equals("Sistemas") && empleado.montoHExtras() >= 500
					&& empleado.montoHExtras() <= 800) {
				d++;
			}

			// e) SNP con menor descuento
			if (empleado.getSeguro().equals("SNP") && empleado.montoDescuentos() < tempMenorDescuento) {
				tempMenorDescuento = empleado.montoDescuentos();
				e = empleado.getNombres();
			}

			// f) Pago total
			f += empleado.montoSeguro() + empleado.montoEssalud() + empleado.sueldoNeto();
		}

		mayorSueldo.setText(a);
		sueldoPromMarketing.setText(String.valueOf(b));
		seguroMayor100.setText(String.valueOf(c));
		montoHExtraSistemas.setText(String.valueOf(d));
		snpMenorDescuento.setText(e);
		totalPagar.setText(String.valueOf(f));
	}
}
