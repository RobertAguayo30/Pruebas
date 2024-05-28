package ucv;

public class Main {

	public static void main(String[] args) {
		SeleccionFutbol delBosque = new Entrenador(1, "Vicente", "Del Bosque", 60, 28489);
		SeleccionFutbol iniesta = new Futbolista(2, "Andres", "Iniesta", 29, 6, "Interior Derecho");
		SeleccionFutbol raulMartinez = new Masajista(3, "Raúl", "Martinez", 41, "Licenciado en Fisioterapia", 18);

		// Concentracion
		System.out.print(delBosque.getNombre() + " " + delBosque.getApellidos() + " -> ");
		delBosque.concentrarse();
		System.out.print(iniesta.getNombre() + " " + iniesta.getApellidos() + " -> ");
		iniesta.concentrarse();
		System.out.print(raulMartinez.getNombre() + " " + raulMartinez.getApellidos() + " -> ");
		raulMartinez.concentrarse();

		// Viaje
		System.out.print(delBosque.getNombre() + " " + delBosque.getApellidos() + " -> ");
		delBosque.viajar();
		System.out.print(iniesta.getNombre() + " " + iniesta.getApellidos() + " -> ");
		iniesta.viajar();
		System.out.print(raulMartinez.getNombre() + " " + raulMartinez.getApellidos() + " -> ");
		raulMartinez.viajar();

		// Entrenamiento
		System.out.println(
				"\nEntrenamiento de Fútbol: Todos los integrantes tienen su función en un entrenamiento (Especialización): ");
		System.out.print(delBosque.getNombre() + " " + delBosque.getApellidos() + " -> ");
		delBosque.entrenar();
		System.out.print(iniesta.getNombre() + " " + iniesta.getApellidos() + " -> ");
		iniesta.entrenar();
		System.out.print(raulMartinez.getNombre() + " " + raulMartinez.getApellidos() + " -> ");
		raulMartinez.entrenar();

		// Partido de futbol
		System.out.println(
				"\nPartido de Fútbol: Todos los integrantes tienen su función en un partido (Especialización): ");
		System.out.print(delBosque.getNombre() + " " + delBosque.getApellidos() + " -> ");
		delBosque.jugarPartido();
		System.out.print(iniesta.getNombre() + " " + iniesta.getApellidos() + " -> ");
		iniesta.jugarPartido();
		System.out.print(raulMartinez.getNombre() + " " + raulMartinez.getApellidos() + " -> ");
		raulMartinez.jugarPartido();

		
		// Planificar Entrenamiento
		System.out.println(
				"\nPlanificar Entrenamiento: Solo el entrenador tiene el método para planificar un entrenamiento: ");
		System.out.print(delBosque.getNombre() + " " + delBosque.getApellidos() + " -> ");
		((Entrenador) delBosque).planificarEntrenamiento();

		// Entrevista
		System.out.println("\nEntrevista: Solo el futbolista tiene el método para dar una entrevista: ");
		System.out.print(iniesta.getNombre() + " " + iniesta.getApellidos() + " -> ");
		((Futbolista) iniesta).entrevista();

		// Masaje
		System.out.println("\nMasaje: Solo el masajista tiene el metodo para dar un masaje: ");
		System.out.print(raulMartinez.getNombre() + " " + raulMartinez.getApellidos() + " -> ");
		((Masajista) raulMartinez).darMasaje();
	}

}
