import java.util.ArrayList;
import java.util.TreeMap;

public class CompetenciaBatamon {

	public static void main(String[] args) {
		Contrincante hechicera = new Contrincante();
		Contrincante rival = new Contrincante();
		TreeMap<Integer, Integer> enfrentamientos = new TreeMap<Integer, Integer>();
		String path = "batalla.in";

		LectorDeArchivo.leerArchivo(path, hechicera, rival);
		batamon(hechicera, rival, enfrentamientos);

		System.out.println(hechicera.getVictorias());
		System.out.println();
		for (Integer numeroMonstruoRival : enfrentamientos.keySet()) {
			System.out.println(numeroMonstruoRival + " " + enfrentamientos.get(numeroMonstruoRival));
		}
	}

	private static void batamon(Contrincante hechicera, Contrincante rival, TreeMap<Integer, Integer> enfrentamientos) {
		hechicera.ordenarPorPoderDescendente();
		rival.ordenarPorPoderDescendente();

		int inicial = 0;
		int ultimo = hechicera.cantidadDeMonstruos() - 1;

		for (Monstruo monstruoRival : rival.getMonstruos()) {
			Monstruo monster = hechicera.getMonstruoNumero(inicial);

			if (monster.vence(monstruoRival)) {
				enfrentamientos.put(monstruoRival.getNumero(), monster.getNumero());
				hechicera.agregarNuevaVictoria();
				inicial++;
			} else {
				monster = hechicera.getMonstruoNumero(ultimo);
				enfrentamientos.put(monstruoRival.getNumero(), monster.getNumero());
				ultimo--;
			}
		}

	}
}
