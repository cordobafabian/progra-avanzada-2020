
public class ObtenerDiagonales {

	public static void main(String[] args) {
		int[][] matriz = new int[4][4];
		
		for(int i=0; i<matriz.length; i++)
			for(int j=0; j<matriz[i].length; j++ )
				matriz[i][j] = i*matriz.length + j +1;
		
		
		mostrarMatriz(matriz);
		mostrarMatriz(obtenerDiagonales(matriz));
		

	}
	
	public static int[][] obtenerDiagonales(int[][] mat) {
		int[][] mat2 = new int[2*mat.length - 1][mat.length];
		
		for(int i=0; i<mat.length; i++)
			for(int j=0; j<mat[i].length; j++ )
				mat2[i][j] = 0;
		
				
		return mat2;
	}
	
	static void mostrarMatriz(int[][] mat) {
		int i, j;

		System.out.print("\n");
		for (i = 0; i < mat.length; i++) {
			for (j = 0; j < mat[i].length; j++)
				System.out.print(mat[i][j] + "\t");

			System.out.print("\n");
		}

		System.out.print("\n");
	}
}
