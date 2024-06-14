package ucv.practica;

public class AutoUsado extends Auto {

	private final float descuento;
	private final int diasAlquiler;

	public AutoUsado(float descuento, int diasAlquiler, String placa, String marca, String modelo, int fabricacion,
			float kilometraje, float precio) {
		super(placa, marca, modelo, fabricacion, kilometraje, precio);
		this.descuento = descuento;
		this.diasAlquiler = diasAlquiler;
	}
	
	@Override
	public float precioVenta() {
		if (descuento > 0) {
			float desc = precio * (descuento / 100);
			System.out.println("El descuento aplicado es del " + descuento + "%, por lo que el monto a pagar es de S/"
					+ (precio - desc));
			return precio - desc;
		}
		System.out.println("Este auto no se esta vendiendo");
		return precio;
	}

	@Override
	public int precioAlquiler() {
		if (diasAlquiler > 0) {
			int precioAlquiler = diasAlquiler * 120;
			System.out.println("El precio por " + diasAlquiler + " de alquiler es de S/" + precioAlquiler);
			return precioAlquiler;
		}
		System.out.println("Este auto no se esta alquilando");
		return 0;
	}

}
