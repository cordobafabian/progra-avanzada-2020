package lectores;

import persona.Pelaje;
import persona.Perro;

public class LectorDeArchivo {
	
	private String algo = "Salsa";
	
	public void hacerLadrar() {
		System.out.println("chota");
	}
	
	public void chillar() {

		Perro perrito = new Perro();
		System.out.println(perrito);
	}
	
	public String getAlgo() {
		return algo;
	}

	public void setAlgo(String algo) {
		this.algo = algo;
	}

	public static void main(String[] args) {
		LectorDeArchivo objeto = new LectorDeArchivo();
		Pelaje pelaje = new Pelaje("azul", 1.3);
		System.out.println(pelaje.getColor());
				
	}
}
