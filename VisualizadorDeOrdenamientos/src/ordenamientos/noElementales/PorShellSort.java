package ordenamientos.noElementales;

import java.util.Arrays;

import ordenamientos.Estrategia;

public class PorShellSort<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(final T[] arregloInmutable) {
		ordenando = true;
		T[] arreglo = Arrays.copyOf(arregloInmutable, arregloInmutable.length);
		int n = arreglo.length;
		ordenados = new int[arregloInmutable.length];
		Arrays.fill(ordenados, -1);
		comparados = new int[1];
		for (int espacio = n / 2; espacio > 0 && estaOrdenando(); espacio /= 2) {
			for (int i = espacio; i < n && estaOrdenando(); i += 1) {
				T temporal = arreglo[i];
				elementoActual = i;
				int j;
				for (j = i; j >= espacio && comparar(arreglo[j - espacio], temporal) > 0
						&& estaOrdenando(); j -= espacio) {
					comparados[0] = j - espacio;
					arreglo[j] = arreglo[j - espacio];
					cantidadDeIntercambios++;
					actualizar(arreglo, comparados, elementoActual, ordenados);
					esperar();
				}
				arreglo[j] = temporal;
				cantidadDeIntercambios++;
				comparados[0] = j;
				actualizar(arreglo, comparados, elementoActual, ordenados);

			}

		}
		for (int j = 0; j < ordenados.length; j++) {
			ordenados[j] = j;
		}
		elementoActual = -1;
		comparados = null;
		actualizar(arreglo, comparados, elementoActual, ordenados);
		return arreglo;
	}
}
