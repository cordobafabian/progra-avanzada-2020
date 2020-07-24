import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LectorMaterias {
	
	public static void lecturaArchivo(String pathIn, Coloreo coloreo, GrafoListaAdyacencia grafo) {
		Scanner lector = null;
		
		try {
			lector = new Scanner(new FileReader(pathIn));
			int cantidadNodos = lector.nextInt();
			
			for(int i=0; i<cantidadNodos; i++) {
				Materia materia = new Materia(i+1, lector.next());
				coloreo.agregarMateria(materia);
				grafo.nuevoNodo();
			}
			
			for(int i=0; i<cantidadNodos; i++) {
				int nodo = lector.nextInt();
				int adyacente = lector.nextInt();
				while(adyacente!=-1) {
					grafo.agregarAdyacencia(nodo, adyacente);
					grafo.agregarAdyacencia(adyacente, nodo);
					adyacente = lector.nextInt();
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(lector!=null) {
				lector.close();
			}
		}
	}
}
