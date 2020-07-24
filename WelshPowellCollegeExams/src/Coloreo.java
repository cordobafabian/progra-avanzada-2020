import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Coloreo {

	HashMap<Integer, ArrayList<Materia>> grupos;
	ArrayList<Materia> materias;
	HashMap<Integer, Materia > materias2;
	int cantidadDeColores;
	
	public Coloreo() {
		grupos = new HashMap<Integer, ArrayList<Materia>>();
		materias = new ArrayList<Materia>();
		materias2 = new HashMap<Integer, Materia>();
		cantidadDeColores = 0;
	}
	
	public void agruparMateriaPorColor(Materia materia) {
		int color = materia.getColor();
		List<Materia> lista = grupos.get(color);
		lista.add(materia);
	}
	
	public void agregarMateria(Materia materia) {
		materias.add(materia);
	}
	
	public void ordenarDescendentemente() {
		materias.sort(new ComparatorMateriaGradosDescendentes());
	}
	
	public void mostrarMaterias() {
		for(Materia materia : materias) {
			System.out.println(materia);
		}
	}
	
	public void mostrarGruposPorColor() {
		for(int key=1; key<=grupos.size();key++) {
			System.out.println("Color: "+key);
			ArrayList<Materia> subjets = grupos.get(key);
			for(Materia materia : subjets) {
				System.out.println(materia);
			}
			System.out.println();
		}
	}
	
	public void colorear(GrafoListaAdyacencia grafo) {
		
		for(int i=0; i<materias.size();i++) {
			int grado = grafo.grado(i+1);
			materias.get(i).setGrado(grado);
		}
		
		ordenarDescendentemente();
		
		int color = 1;
		
		for(int i=0; i<materias.size();i++) {
			Materia materia = materias.get(i);
			color = 1;
			
			while(materia.getColor() == 0) {
				int nodo = materia.getCodigo();
				if(!nodoTieneAdyacentesDeEseColor(nodo,color,grafo)) {
					if(color>cantidadDeColores) {
						grupos.put(color, new ArrayList<Materia>());
						cantidadDeColores++;
					}
					materia.setColor(color);
					agruparMateriaPorColor(materia);
				}else {
					color++;
				}
			
			}
			
			
		}
		
	}

	private boolean nodoTieneAdyacentesDeEseColor(int nodo, int color, GrafoListaAdyacencia grafo) {
		boolean found = false;
		
		ArrayList<Integer> nodosAdyacentes = grafo.nodosAdyacentes(nodo);
		
		for(Materia materia : materias) {
			materias2.put(materia.getCodigo(), materia);
		}
		
		int i=0;
		while(i<nodosAdyacentes.size() && !found) {
			Materia materia = materias2.get(nodosAdyacentes.get(i));
			
			if(materia.getColor() == color) {
				found = true;
			}
			
		i++;	
		}
		
		
		
	return found;	
	}
}
