package ordenamientos.elementales;

import java.util.Arrays;

import ordenamientos.Estrategia;

public class PorBurbujeo<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(final T[] arregloInmutable) {
		ordenando = true;
		comparados = new int[1];
		ordenados = new int[arregloInmutable.length];
		Arrays.fill(ordenados, -1);
		int j = 1;
		T[] arreglo = Arrays.copyOf(arregloInmutable, arregloInmutable.length);
		boolean huboCambio = false;
		do {
			huboCambio = false;
			for (int i = 0; i < arreglo.length - j && estaOrdenando(); i++) {
				if (comparar(arreglo[i], arreglo[i + 1]) > 0) {
					intercambiar(arreglo, i, i + 1);
					huboCambio = true;
				}
				comparados[0] = i + 1;
				elementoActual = i;
				actualizar(arreglo, comparados, elementoActual, ordenados);
				esperar();
			}
			ordenados[j - 1] = arreglo.length - j;
			j++;
		} while (huboCambio && estaOrdenando());
		elementoActual = -1;
		comparados = null;
		for (; j <= ordenados.length; j++) {
			ordenados[j - 1] = arreglo.length - j;

		}
		actualizar(arreglo, comparados, elementoActual, ordenados);
		return arreglo;
	}
}
