package ucv;

public abstract class Empleados {

	// String ya que no se realizara operaciones numericas con el DNI
	private String dni;
	private String nombres;
	private String apellidos;

	public Empleados(String dni, String nombres, String apellidos) {
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public abstract float getIngresos();

	public abstract float getDescuentos();

	public abstract float getSueldoNeto();
}
