
public class WelshPowellCollegeExams {
	
	public static void main(String[] args) {
		Coloreo coloreo = new Coloreo();
		GrafoListaAdyacencia grafo = new GrafoListaAdyacencia();
		String pathIn = "examenes.in";
		
		LectorMaterias.lecturaArchivo(pathIn, coloreo, grafo);
		
		coloreo.mostrarMaterias();
		System.out.println();
		grafo.mostrarAdyacentes();
		System.out.println();
		
		coloreo.colorear(grafo);
		
		coloreo.mostrarMaterias();
		System.out.println();
		grafo.mostrarAdyacentes();
		System.out.println();
		
		coloreo.mostrarMaterias();
		System.out.println();
		coloreo.mostrarGruposPorColor();
		
	}
}
