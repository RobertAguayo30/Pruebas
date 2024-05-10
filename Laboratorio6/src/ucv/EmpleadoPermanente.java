package ucv;

public class EmpleadoPermanente extends Empleados {

	private float sueldoBase;
	private boolean afp;

	public EmpleadoPermanente(String dni, String nombres, String apellidos, float sueldoBase, String afiliacion) {
		super(dni, nombres, apellidos);
		this.sueldoBase = sueldoBase;
		this.afp = afiliacion.equals("AFP");
	}

	public float getIngresos() {
		return sueldoBase;
	}

	public float getDescuentos() {
		if (afp)
			return getIngresos() * 0.15f;
		else
			return getIngresos() * 0.11f;
	}

	public float getSueldoNeto() {
		return getIngresos() - getDescuentos();
	}
}
