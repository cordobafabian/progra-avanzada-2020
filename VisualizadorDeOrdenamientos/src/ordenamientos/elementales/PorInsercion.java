package ordenamientos.elementales;

import java.util.Arrays;

import ordenamientos.Estrategia;

public class PorInsercion<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(final T[] arregloInmutable) {
		ordenando = true;
		T[] arreglo = Arrays.copyOf(arregloInmutable, arregloInmutable.length);
		comparados = new int[1];
		ordenados = new int[arregloInmutable.length];
		Arrays.fill(ordenados, -1);
		for (int i = 1; i < arreglo.length && estaOrdenando(); i++) {
			elementoActual = i;
			T valorActual = arreglo[i];
			int j = i - 1;
			while (j >= 0 && comparar(arreglo[j], valorActual) > 0 && estaOrdenando()) {
				comparados[0] = j;
				arreglo[j + 1] = arreglo[j];
				ordenados[j] = j;
				j = j - 1;
				cantidadDeIntercambios = getCantidadDeIntercambios() + 1;
				actualizar(arreglo, comparados, elementoActual, ordenados);
				esperar();

			}

			arreglo[j + 1] = valorActual;

		}
		for (int j = cantidadDeIntercambios == 0 ? 0 : arreglo.length - 1; j < ordenados.length; j++) {
			ordenados[j] = j;
		}

		elementoActual = -1;
		comparados = null;
		actualizar(arreglo, comparados, elementoActual, ordenados);
		return arreglo;
	}

}
