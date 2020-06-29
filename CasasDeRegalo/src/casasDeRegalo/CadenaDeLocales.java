package casasDeRegalo;

import java.util.ArrayList;

public class CadenaDeLocales {
	ArrayList<ArrayList<Integer>> adyacentes;
	ArrayList<Local> nodos;
	
	public CadenaDeLocales() {
		adyacentes = new ArrayList<ArrayList<Integer>>();
		nodos = new ArrayList<Local>();
		
	}
	
	public void agregarAdyacentes(int nodo, int adyacente) {
		adyacentes.get(nodo).add(adyacente);
	}
	
	public void agregarLocal(Local nodo) {
		nodos.add(nodo);
	}
	
	public int cantidadDeLocales() {
		return nodos.size();
	}
	
	public boolean adyacentesTienenColor(int nodo, int color) {
		boolean tienen = false;
		ArrayList<Integer> adyacentes = this.adyacentes.get(nodo - 1);
		int i = 0;
		while(i<adyacentes.size() && !tienen) {
			if( nodos.get(adyacentes.get(i)-1).getColor() == color ) {
				tienen = true;
			}
		
			i++;
		}
		return tienen;
	}

	public ArrayList<ArrayList<Integer>> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(ArrayList<ArrayList<Integer>> adyacentes) {
		this.adyacentes = adyacentes;
	}

	public ArrayList<Local> getNodos() {
		return nodos;
	}

	public void setNodos(ArrayList<Local> nodos) {
		this.nodos = nodos;
	}

	public void mostrarNodos() {
		for(Local local : nodos) {
			System.out.println(local.toString());
		}
		
	}

	public void mostrarAdyacentes() {
		for(ArrayList<Integer> local : adyacentes) {
			int pos = adyacentes.indexOf(local)+1;
			System.out.println("Local: "+ pos);
			for(Integer adyacente : local) {
				System.out.print(adyacente+" ");
			}
			System.out.println();
		}
		
	}
	
}
