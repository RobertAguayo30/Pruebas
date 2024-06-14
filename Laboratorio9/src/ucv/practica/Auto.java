package ucv.practica;

public abstract class Auto {
	private final String placa;
	private final String marca;
	private final String modelo;
	private final int fabricacion;
	private final float kilometraje;
	protected float precio;

	public Auto(String placa, String marca, String modelo, int fabricacion, float kilometraje, float precio) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.fabricacion = fabricacion;
		this.kilometraje = kilometraje;
		this.precio = precio;
	}
	

	public void mostrarDatos(Auto auto) {
		System.out.println("============================================");
		System.out.println("Placa del Auto: " + auto.getPlaca());
		System.out.println("Marca del Auto: " + auto.getMarca());
		System.out.println("Modelo del auto: " + auto.getModelo());
		System.out.println("Año de Fabricacion: " + auto.getFabricacion());
		System.out.println("Kilometraje del Auto: " + auto.getKilometraje() + " km");
	}

	public abstract float precioVenta();

	public abstract int precioAlquiler();

	public String getPlaca() {
		return placa;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getFabricacion() {
		return fabricacion;
	}

	public float getKilometraje() {
		return kilometraje;
	}
}
