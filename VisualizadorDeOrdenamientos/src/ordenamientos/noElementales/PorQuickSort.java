package ordenamientos.noElementales;

import java.util.Arrays;

import ordenamientos.Estrategia;

public class PorQuickSort<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(final T[] arregloInmutable) {
		ordenando = true;
		comparados = new int[2];
		ordenados = new int[arregloInmutable.length];
		Arrays.fill(ordenados, -1);
		T[] arreglo = Arrays.copyOf(arregloInmutable, arregloInmutable.length);
		ordenar(arreglo, 0, arreglo.length - 1);
		for (int j = 0; j < ordenados.length; j++) {
			ordenados[j] = j;
		}
		elementoActual = -1;
		comparados = null;
		actualizar(arreglo, comparados, elementoActual, ordenados);
		return arreglo;
	}

	private void ordenar(T arreglo[], int inferior, int superior) {
		if (!estaOrdenando()) {
			return;
		}
		elementoActual = superior;
		if (inferior < superior) {
			int pivot = partition(arreglo, inferior, superior);

			ordenar(arreglo, inferior, pivot - 1);
			ordenar(arreglo, pivot + 1, superior);

		}
	}

	private int partition(T arreglo[], int inferior, int superior) {
		T pivot = arreglo[superior];
		int i = (inferior - 1);
		comparados[1] = inferior;
		for (int j = inferior; j < superior && estaOrdenando(); j++) {
			comparados[0] = j;
			if (comparar(arreglo[j], pivot) < 0) {
				i++;
				comparados[1] = i;
				intercambiar(arreglo, i, j);
			}
			actualizar(arreglo, comparados, elementoActual, ordenados);
			esperar();
		}
		intercambiar(arreglo, i + 1, superior);
		comparados[0] = superior;
		comparados[1] = i + 1;
		actualizar(arreglo, comparados, elementoActual, ordenados);
		esperar();
		return i + 1;
	}
}
