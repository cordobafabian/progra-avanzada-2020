import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
1. Escribir un archivo de entre 10 mil y 20 mil números enteros aleatorios,
en el rango de 0 a 12000. (La cantidad de números debe ser aleatoria)
2. Leer dicho archivo, buscando (a) máximo, (b) mínimo, (c) promedio.
3. Escribr un segundo archivo con una tabla de resultados.
*/

public class EntradaSalida07 {

	public static void main(String[] args) {

		// Escribir un archivo de entre 10 mil y 20 mil números enteros aleatorios,
		// en el rango de 0 a 12000. (La cantidad de números debe ser aleatoria)
		FileWriter fw;
		try {
			fw = new FileWriter("Valores.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			/*
			 * si se quiere un numero entero random en el intervalo [N;M] numero = (int)
			 * Math.floor(Math.random()*(M-N+1)+N);
			 */
			int cantMinValores = 10000;
			int cantMaxValores = 20000;
			int minNum = 0;
			int maxNum = 12000;

			int cant = (int) Math.floor(Math.random() * (cantMaxValores - cantMinValores + 1) + cantMinValores);

			for (int i = 1; i <= cant; i++) {
				int num = (int) Math.floor(Math.random() * (maxNum - minNum + 1) + minNum);
				bw.write(String.valueOf(num));
				bw.newLine();
			}
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// LECTURA DE ARCHIVO Y CALCULOS
		try {
			FileReader fr = new FileReader("Valores.txt");
			Scanner lector = new Scanner(fr);

			int contador = 0;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			double sum = 0;

			while (lector.hasNextInt()) {
				int numero = lector.nextInt();

				if (numero < min)
					min = numero;

				if (numero > max)
					max = numero;

				sum += numero;
				contador++;
			}

			lector.close();
			// FIN DE LECTURA

			// COMIENZA ESCRITURA DE ARCHIVO, TAMBIEN SE MUESTRA POR PANTALLA
			// VERIFICO QUE HAYA HABIDO VALORES
			if (contador > 0) {
				// Escribo archivo con formato
				grabaTablaDeResultados(min, max, (int) sum / contador, "Tabla de resultados.txt");

				// Muestra tabla de resultados
				muestraTablaDeResultados(min, max, (int) sum / contador);
			}

			else
				System.out.println("Ningun numero en archivo");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	////////////////////////////////////////////////////////////////
	public static void muestraTablaDeResultados(int min, int max, int prom) {
		String borde = "+----------+-------------+";

		int[] valor = { min, max, prom };
		String[] leyenda = { "Minimo", "Maximo", "Promedio" };
		String patron = "| %-9s|%12d |";

		int j = 0;

		for (int i = 0; i < 7; i++) {
			if (i % 2 == 0)
				System.out.println(borde);
			else {
				System.out.println(String.format(patron, leyenda[j], valor[j]));
				j++;

			}
		}

	}

	////////////////////////////////////////////////////////////
	public static void grabaTablaDeResultados(int min, int max, int prom, String nombreArchivo) {
		try {
			FileWriter fw = new FileWriter(nombreArchivo);
			BufferedWriter bw = new BufferedWriter(fw);

			String borde = "+----------+-------------+";
			int[] valor = { min, max, prom };
			String[] leyenda = { "Minimo", "Maximo", "Promedio" };
			String patron = "| %-9s|%12d |";

			int j = 0; // uso la j para acceder a las posiciones de los vectores

			for (int i = 0; i < 7; i++) {
				if (i % 2 == 0) {
					bw.write(borde);
					bw.newLine();
				} else {
					bw.write(String.format(patron, leyenda[j], valor[j]));
					bw.newLine();
					j++;
				}
			}

			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
