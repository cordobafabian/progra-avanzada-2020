
public class main{
	public static void main(String[] args) {
		

		int[][] matriz = {{6,1,2,3},{4,6,5,6},{0,8,12,3},{10,11,12,24}};
		
		if(matrizMultiplicacionNula(matriz))
			System.out.println("\nCUMPLE: Multiplicación nula.\n");
		else
			System.out.println("\nNO CUMPLE: La multiplicación no es nula.\n");
		
	}

	
	static boolean matrizMultiplicacionNula(int[][] mat) {
		int i,j;
		
		for( i = 0; i < mat.length; i++)
			for( j = 0; j < mat[i].length; j++)
				{	
					if(mat[i][j] == 0)
						return true;

				}
	return false;
	}
	
	
}
