
//CORDOBA, FABIAN ARIEL

public class Matriz {
	public static void main(String[] args) {
		

		int[][] matriz = {{6,1,2,3},{4,6,5,6},{7,8,12,9},{10,11,12,24}};
		
		if(matrizCero(matriz))
			System.out.println("\nCUMPLE: Cada elemento en la diagonal es la suma de los elementos anteriores\n");
		else
			System.out.println("\nNO CUMPLE: Cada elemento en la diagonal NO es la suma de los elementos anteriores\\n");
		
	}

	
	static boolean matrizCero(int[][] mat) {
		int sum = mat[0][0], i;
		
		for( i = 1; i < mat.length; i++)
		{
				if(sum == mat[i][i])
					sum += mat[i][i];
				else
					return false;
		}
		
	return true;
	}
	
	
}
