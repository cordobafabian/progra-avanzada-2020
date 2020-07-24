import java.lang.reflect.Array;
import java.util.ArrayList;

public class GrafoListaAdyacencia {
	ArrayList<ArrayList<Integer>> adyacentes;
	
	public GrafoListaAdyacencia() {
		adyacentes = new ArrayList<ArrayList<Integer>>();
	}

	public ArrayList<ArrayList<Integer>> getAdyacentes() {
		return adyacentes;
	}

	public void setAdycentes(ArrayList<ArrayList<Integer>> adycentes) {
		this.adyacentes = adyacentes;
	}
	
	public void nuevoNodo() {
		ArrayList<Integer> nodo = new ArrayList<Integer>();
		adyacentes.add(nodo);
	}
	
	public void agregarAdyacencia(int pos, int adyacente) {
		adyacentes.get(pos - 1).add(adyacente);
	}
	
	public ArrayList<Integer> nodosAdyacentes(int nodo){
		return adyacentes.get(nodo - 1);
	}
	
	public int grado(int nodo) {
		return adyacentes.get(nodo - 1).size();
	}
	
	public void mostrarAdyacentes() {
		for(int i=0; i<adyacentes.size(); i++) {
			System.out.print("Nodo: "+(i+1)+". Adyacentes: ");
			for(Integer adyacente : adyacentes.get(i)) {
				System.out.print(adyacente+" ");
			}
			System.out.println();
		}
	}
}
