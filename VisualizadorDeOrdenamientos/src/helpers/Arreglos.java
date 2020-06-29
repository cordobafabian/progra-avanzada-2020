package helpers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import enums.Orden;

public class Arreglos {

	public Arreglos() {

	}

	public Integer[] generarArray(Orden caso, int cantElementos) {
		Integer[] elementos;

		switch (caso) {
		case ALEATORIO:
			elementos = generarListaOrdenada(cantElementos);
			aleatorizar(elementos);
			break;
		case CASI_ORDENADO:
			elementos = generarListaOrdenada(cantElementos);
			desordenar(elementos, 3);
			break;
		case INVERTIDO:
			elementos = generarListaInvertida(cantElementos);
			break;
		case CASI_INVERTIDO:
			elementos = generarListaInvertida(cantElementos);
			desordenar(elementos, 3);
			break;
		case ORDENADO:
			elementos = generarListaOrdenada(cantElementos);
			break;
		default:
			elementos = new Integer[cantElementos];
			break;
		}
		return elementos;
	}

	private Integer[] aleatorizar(Integer[] arreglo) {
		List<Integer> intList = Arrays.asList(arreglo);
		Collections.shuffle(intList);
		intList.toArray(arreglo);
		return arreglo;
	}

	private Integer[] generarListaOrdenada(int tamanio) {
		Integer[] lista = new Integer[tamanio];
		for (int i = 0; i < tamanio; i++) {
			lista[i] = i + 1;
		}
		return lista;
	}

	private Integer[] desordenar(Integer[] arreglo, int n) {
		Random r = new Random();
		for (int i = 0; i < arreglo.length; i += n) {
			if (i + n >= arreglo.length) {
				n = arreglo.length - i;
			}

			if (i % n == 0) {
				for (int j = i; j < i + n; j++) {
					int k = r.ints(1, i, i + n).findFirst().getAsInt();

					Integer tmp = arreglo[k];
					arreglo[k] = arreglo[j];
					arreglo[j] = tmp;
				}
			}
		}

		return arreglo;
	}

	private Integer[] generarListaInvertida(int tamanio) {
		Integer[] lista = new Integer[tamanio];
		for (int i = 0; i < tamanio; i++) {
			lista[i] = tamanio - i;
		}
		return lista;
	}
}
