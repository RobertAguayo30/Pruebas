package ucv;

public class Empleado {

	private String codigo;
	private String nombres;
	private String areaLaboral;
	private double sueldoBase;
	private int horasExtras;
	private String seguro;

	public Empleado(String codigo, String nombres, String areaLaboral, double sueldo, int horasExtras, String seguro) {
		this.codigo = codigo;
		this.nombres = nombres;
		this.areaLaboral = areaLaboral;
		this.sueldoBase = sueldo;
		this.horasExtras = horasExtras;
		this.seguro = seguro;
	}

	public double montoHExtras() {
		return (sueldoBase * horasExtras) / 240;
	}

	public double montoSeguro() {
		if (seguro.equals("AFP"))
			return sueldoBase * 0.17;
		return sueldoBase * 0.05;
	}

	public double montoEssalud() {
		return sueldoBase * 0.03;
	}

	public double montoDescuentos() {
		return montoSeguro() + montoEssalud();
	}

	public double sueldoBruto() {
		return sueldoBase + montoHExtras();
	}

	public double sueldoNeto() {
		return sueldoBruto() - montoDescuentos();
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public String getAreaLaboral() {
		return areaLaboral;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public int getHorasExtras() {
		return horasExtras;
	}

	public String getSeguro() {
		return seguro;
	}
}
