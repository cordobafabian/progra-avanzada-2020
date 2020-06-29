package ordenamientos;

import java.util.ArrayList;
import java.util.List;

import interfaces.RedibujarListener;

public abstract class Estrategia<T extends Comparable<T>> {
	protected List<RedibujarListener> listeners = new ArrayList<RedibujarListener>();
	protected int cantidadDeIntercambios;
	protected int cantidadDeComparaciones;
	protected int elementoActual = -1;
	protected boolean ordenando;
	protected int comparados[];
	protected int retardo = 15;
	protected int ordenados[];

	protected Estrategia() {
		cantidadDeComparaciones = 0;
		cantidadDeIntercambios = 0;
	}

	public abstract T[] ordenar(final T[] arreglo);

	protected void intercambiar(T[] arreglo, int i, int j) {
		T temporal = arreglo[i];
		arreglo[i] = arreglo[j];
		arreglo[j] = temporal;
		cantidadDeIntercambios = getCantidadDeIntercambios() + 1;
	}

	protected int comparar(T elemento1, T elemento2) {
		cantidadDeComparaciones++;
		return elemento1.compareTo(elemento2);
	}

	protected void actualizar(T[] arreglo, int[] check, int current, int[] ordenados) {
		for (RedibujarListener listener : listeners) {
			listener.solicitudRedibujar(arreglo, check, current, ordenados);
		}
	}

	protected void esperar() {
		try {
			Thread.sleep(retardo);
		} catch (Exception e) {

		}
	}

	public void addListener(RedibujarListener listener) {
		listeners.add(listener);
	}

	public void stop() {
		ordenando = false;
	}

	public boolean estaOrdenando() {
		return ordenando;
	}

	public void setCantidadDeComparaciones(int cantidadDeComparaciones) {
		this.cantidadDeComparaciones = cantidadDeComparaciones;
	}

	public int getRetardo() {
		return retardo;
	}

	public void setRetardo(int retardo) {
		this.retardo = retardo;
	}

	public int getCantidadDeComparaciones() {
		return cantidadDeComparaciones;
	}

	public int getActual() {
		return elementoActual;
	}

	public int[] getComparados() {
		return comparados;
	}

	public void setComparados(int[] comparados) {
		this.comparados = comparados;
	}

	public int getCantidadDeIntercambios() {
		return cantidadDeIntercambios;
	}
}
