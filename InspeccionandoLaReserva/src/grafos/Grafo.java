package grafos;

import java.util.Stack;

public class Grafo {
		int[][] matrizAdyacencia;
		
		public Grafo(int[][] matrizAdyacencia){
			this.matrizAdyacencia = matrizAdyacencia;
		}
		
		public Grafo(int cantidadDeNodos) {
			this.matrizAdyacencia = new int[cantidadDeNodos][cantidadDeNodos];
		}
		
		public void addConnection(int tail, int head) {
			this.matrizAdyacencia[tail-1][head-1] = 1;
		}
		
		public long contarCaminos(int origin, int end) {
			long cont = 0;
			boolean[] elementos = new int[matrizAdyacencia.length];
			Stack<Integer> pila = new Stack<Integer>();
			
			
			
			
		return cont;
		}
}
