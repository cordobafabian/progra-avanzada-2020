/**
 * 
 * Dadas n casas, ordenadas por numeracion de 1 hasta n, hallar el numero de
 * casa en el que la suma de las casas a izquierda es igual a la suma de los
 * numeros a derecha. la suma no incluye la posicion de la casa resultado
 * 
 * Se brinda n como parametro.
 *
 * si no se halla, devolver negativo
 *
 * n da 8 6 49 35 1681 1189
 */
public class SumaDirecciones {

	public static void main(String[] args) {
		System.out.println(IgualdadDeSumasLaterales(8));
	}

	/*
	 * Devuelve -1 si no lo encuentra
	 */
	public static int IgualdadDeSumasLaterales(int n) {
		int resp = -1;
		int j = 1;

		while (resp == -1 && j < n) {

			int sum = 0;

			for (int i = 1; i < j; i++) {

				sum += i;
			}

			for (int i = n; i > j; i--) {
				sum -= i;
			}

			if (sum == 0) {
				resp = j;
			}

			j++;

		}
		return resp;
	}

	public static int IgualdadDeSumasLaterales2(int n) {

		return 1;

	}

	public static int metodo3(int n) {
		if (n < 3)
			return -1;

		double i = Math.sqrt((Math.pow(n, 2) + n) / 2);
		int entera = (int) i;
		if ((i - entera) == 0)
			return (int) i;

		return -1;

	}

}
