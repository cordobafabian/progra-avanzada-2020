package ordenamientos.noElementales;

import java.lang.reflect.Array;
import java.util.Arrays;

import ordenamientos.Estrategia;

public class PorMergeSort<T extends Comparable<T>> extends Estrategia<T> {

	public T[] ordenar(final T[] arregloInmutable) {
		ordenando = true;
		comparados = new int[1];
		ordenados = new int[arregloInmutable.length];
		Arrays.fill(ordenados, -1);
		T[] arreglo = Arrays.copyOf(arregloInmutable, arregloInmutable.length);
		ordenar(arreglo, 0, arreglo.length - 1);
		for (int l = 0; l < arreglo.length; l++) {
			ordenados[l] = l;
		}
		elementoActual = -1;
		comparados = null;
		actualizar(arreglo, comparados, elementoActual, ordenados);
		return arreglo;
	}

	private void ordenar(T[] arreglo, int limiteIzquierdo, int limiteDerecho) {
		if (limiteIzquierdo < limiteDerecho) {
			int puntoMedio = (limiteIzquierdo + limiteDerecho) / 2;
			elementoActual = limiteDerecho;
			ordenar(arreglo, limiteIzquierdo, puntoMedio);
			ordenar(arreglo, puntoMedio + 1, limiteDerecho);

			merge(arreglo, limiteIzquierdo, puntoMedio, limiteDerecho);

		}
	}

	@SuppressWarnings("unchecked")
	private void merge(T arreglo[], int limiteIzquierdo, int puntoMedio, int limiteDerecho) {
		int n1 = puntoMedio - limiteIzquierdo + 1;
		int n2 = limiteDerecho - puntoMedio;

		T[] arregloTemporalIzquierdo = (T[]) Array.newInstance(arreglo[0].getClass(), n1);
		T[] arregloTemporalDerecho = (T[]) Array.newInstance(arreglo[0].getClass(), n2);

		for (int i = 0; i < n1; ++i)
			arregloTemporalIzquierdo[i] = arreglo[limiteIzquierdo + i];
		for (int j = 0; j < n2; ++j)
			arregloTemporalDerecho[j] = arreglo[puntoMedio + 1 + j];

		int i = 0, j = 0;

		int k = limiteIzquierdo;
		while (i < n1 && j < n2 && estaOrdenando()) {
			comparados[0] = k;
			if (comparar(arregloTemporalIzquierdo[i], arregloTemporalDerecho[j]) < 0) {
				arreglo[k] = arregloTemporalIzquierdo[i];
				cantidadDeIntercambios++;
				i++;
			} else {
				arreglo[k] = arregloTemporalDerecho[j];
				cantidadDeIntercambios++;
				j++;
			}
			actualizar(arreglo, comparados, elementoActual, ordenados);
			esperar();
			k++;
		}

		while (i < n1 && estaOrdenando()) {
			arreglo[k] = arregloTemporalIzquierdo[i];
			cantidadDeIntercambios++;
			i++;
			k++;
			actualizar(arreglo, comparados, elementoActual, ordenados);
			esperar();
		}

		while (j < n2 && estaOrdenando()) {
			arreglo[k] = arregloTemporalDerecho[j];
			cantidadDeIntercambios++;
			j++;
			k++;
			actualizar(arreglo, comparados, elementoActual, ordenados);
			esperar();
		}
	}
}
