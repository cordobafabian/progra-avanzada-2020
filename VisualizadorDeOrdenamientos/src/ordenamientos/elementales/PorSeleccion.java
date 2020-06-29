package ordenamientos.elementales;

import java.util.Arrays;

import ordenamientos.Estrategia;

public class PorSeleccion<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(final T[] arregloInmutable) {
		ordenando = true;
		T[] arreglo = Arrays.copyOf(arregloInmutable, arregloInmutable.length);
		comparados = new int[1];
		ordenados = new int[arregloInmutable.length];
		Arrays.fill(ordenados, -1);
		T menor;
		int i, j, posicionDelMenor;
		for (i = 0; i < arreglo.length - 1 && estaOrdenando(); i++) {
			elementoActual = i;
			menor = arreglo[i];
			posicionDelMenor = i;
			for (j = i + 1; j < arreglo.length && estaOrdenando(); j++) {

				if (comparar(arreglo[j], menor) < 0) {
					menor = arreglo[j];
					posicionDelMenor = j;
				}
				comparados[0] = j;
				actualizar(arreglo, comparados, elementoActual, ordenados);
				esperar();
			}
			if (posicionDelMenor != i) {
				intercambiar(arreglo, i, posicionDelMenor);
			}
			ordenados[i] = i;
		}
		comparados = null;
		elementoActual = -1;
		ordenados[i] = i;
		actualizar(arreglo, comparados, elementoActual, ordenados);
		return arreglo;
	}

}
