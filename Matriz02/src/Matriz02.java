
public class Matriz02 {
	public static void main(String[] args) {

		int[][] matriz = { { 8, 2, -3, 4 }, { 5, -6, -6, 20 }, { 21, 1, -5, 0 } };

		mostrarMatriz(matriz);

		mostrarMatriz(sumaAdyacentes(matriz));

	}

	static int[][] sumaAdyacentes(int[][] mat) {
		int i = 0, j, sum = 0;
		int[][] nueva = new int[mat.length][mat[i].length];

		for (i = 0; i < mat.length; i++) {
			for (j = 0; j < mat[i].length; j++) {
				sum = mat[i][j];

				if (i >= 1)
					sum += mat[i - 1][j];
				if (j >= 1)
					sum += mat[i][j - 1];
				if (i < (mat.length - 1))
					sum += mat[i + 1][j];
				if (j < (mat[i].length - 1))
					sum += mat[i][j + 1];

				nueva[i][j] = sum;
			}
		}
		return nueva;
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