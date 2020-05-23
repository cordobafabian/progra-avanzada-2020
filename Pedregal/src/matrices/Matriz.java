package matrices;

public class Matriz {
	
	public static void mostrarMatrizInvertidaVerticalmente(int[][] matriz) {
		
		for(int fila = matriz.length - 2; fila >= 1; fila--){
			for(int columna = 1; columna < matriz[0].length - 1; columna ++) {
				System.out.print(matriz[fila][columna] + "\t");
			}
			System.out.println();	
		}
		
	}
	
	public static int[][] clonarMatriz(int [][] matriz){
		int[][] clon = new int[matriz.length][matriz[0].length];
		
		for(int fila = 0; fila < matriz.length; fila++) {
			for(int columna = 0; columna < matriz[0].length; columna++) {
				clon[fila][columna] = matriz[fila][columna];
			}
		}
		
		return clon;
	}
	
	
}
