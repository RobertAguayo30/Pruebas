package ucv.practica;

public class AutoNuevo extends Auto {

	private final boolean feria;

	public AutoNuevo(boolean feria, String placa, String marca, String modelo, int fabricacion, float precio) {
		super(placa, marca, modelo, fabricacion, 0, precio);
		this.feria = feria;
	}

	@Override
	public float precioVenta() {
		if (feria) {
			float desc = precio * 0.1f;
			System.out.println("El descuento aplicado es de S/" + desc + ", por lo que el monto a pagar es de S/"
					+ (precio - desc));
			return precio - desc;
		}
		return precio;
	}

	@Override
	public int precioAlquiler() {
		System.out.println("Los autos nuevos no se alquilan");
		return 0;
	}

	public void estaFeriaVenta() {
		if (feria) {
			System.out.println("El auto nuevo esta en la feria de venta");
		}
		System.out.println("El auto nuevo NO esta en la feria de venta");
	}
}
