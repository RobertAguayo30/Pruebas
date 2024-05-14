package ucv;

public class Main {

	public static void main(String[] args) {
		SeleccionFutbol delBosque = new Entrenador(1, "Vicente", "Del Bosque", 60, 28489);
		SeleccionFutbol iniesta = new Futbolista(2, "Andres", "Iniesta", 29, 6, "Interior Derecho");
		SeleccionFutbol raulMartinez = new Masajista(3, "Raúl", "Martinez", 41, "Licenciado en Fisioterapia", 18);
		
		// Concentracion
		nombrar(delBosque);
		delBosque.concentrarse();
		nombrar(iniesta);
		iniesta.concentrarse();
		nombrar(raulMartinez);
		raulMartinez.concentrarse();

		// Viaje
		nombrar(delBosque);
		delBosque.viajar();
		nombrar(iniesta);
		iniesta.viajar();
		nombrar(raulMartinez);
		raulMartinez.viajar();

		// Entrenamiento
		decir("Entrenamiento de Fútbol: Todos los integrantes tienen su función en un entrenamiento (Especialización): ");
		nombrar(delBosque);
		delBosque.entrenamiento();
		nombrar(iniesta);
		iniesta.entrenamiento();
		nombrar(raulMartinez);
		raulMartinez.entrenamiento();

		// Partido de futbol
		decir("Partido de Fútbol: Todos los integrantes tienen su función en un partido (Especialización): ");
		nombrar(delBosque);
		delBosque.partidoFutbol();
		nombrar(iniesta);
		iniesta.partidoFutbol();
		nombrar(raulMartinez);
		raulMartinez.partidoFutbol();

		// Planificar Entrenamiento
		decir("Planificar Entrenamiento: Solo el entrenador tiene el método para planificar un entrenamiento: ");
		nombrar(delBosque);
		((Entrenador) delBosque).planificarEntrenamiento();

		// Entrevista
		decir("Entrevista: Solo el futbolista tiene el método para dar una entrevista: ");
		nombrar(iniesta);
		((Futbolista) iniesta).entrevista();

		// Masaje
		decir("Masaje: Solo el masajista tiene el metodo para dar un masaje: ");
		nombrar(raulMartinez);
		((Masajista) raulMartinez).darMasaje();
	}
	
	public static void nombrar(SeleccionFutbol seleccionFutbol) {
		System.out.print(seleccionFutbol.getNombre() + " " + seleccionFutbol.getApellidos() + " -> ");
	}
	
	public static void decir(String texto) {
		System.out.println("\n" + texto);
	}
}
