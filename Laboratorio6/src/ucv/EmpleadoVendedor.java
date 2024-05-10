package ucv;

public class EmpleadoVendedor extends Empleados {

	private float montoVendido;
	private float tasaComision;

	public EmpleadoVendedor(String dni, String nombres, String apellidos, float montoVendido, float tasaComision) {
		super(dni, nombres, apellidos);
		this.montoVendido = montoVendido;
		this.tasaComision = tasaComision;
	}

	public float getIngresos() {
		return montoVendido * tasaComision;
	}

	public float getBonus() {
		if (montoVendido >= 5000)
			return getIngresos() * 0.1f;
		if (montoVendido >= 1000)
			return getIngresos() * 0.05f;
		return 0;
	}

	public float getDescuentos() {
		if (getIngresos() >= 1000)
			return getIngresos() * 0.15f;
		return getIngresos() * 0.11f;
	}

	public float getSueldoNeto() {
		return getIngresos() + getBonus() - getDescuentos();
	}
}
