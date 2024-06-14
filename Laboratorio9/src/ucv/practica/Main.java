package ucv.practica;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static List<Auto> autos = new ArrayList<Auto>();
	
	public static void main(String[] args) {
		autos.add(new AutoNuevo(true, "ABC123", "Marca1", "Modelo1", 2023, 60000));
		autos.add(new AutoNuevo(true, "ABC321", "Marca2", "Modelo2", 2019, 55000));
		autos.add(new AutoUsado(10, 0, "123ABC", "Marca3", "Modelo3", 2005, 200, 10000));
		autos.add(new AutoUsado(0, 14, "123ABC", "Marca3", "Modelo3", 2005, 200, 10000));
		
		for(Auto auto : autos) {
			mostrarDatos(auto);
		}
		
	}
	
	private static void mostrarDatos(Auto auto) {
		System.out.println("============================================");
		System.out.println("Placa del Auto: " + auto.getPlaca());
		System.out.println("Marca del Auto: " + auto.getMarca());
		System.out.println("Modelo del auto: " + auto.getModelo());
		System.out.println("Año de Fabricacion: " + auto.getFabricacion());
		System.out.println("Kilometraje del Auto: " + auto.getKilometraje() + " km");
		auto.precioVenta();
		auto.precioAlquiler();
		System.out.println("");
	}
}
