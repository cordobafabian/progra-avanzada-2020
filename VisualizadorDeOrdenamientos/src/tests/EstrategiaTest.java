package tests;

import java.util.Locale;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import enums.Orden;
import enums.Ordenamiento;
import helpers.Arreglos;
import ordenamientos.Estrategia;
import ordenamientos.Salida;
import ordenamientos.elementales.PorBurbujeo;
import ordenamientos.elementales.PorInsercion;
import ordenamientos.elementales.PorSeleccion;
import ordenamientos.noElementales.PorMergeSort;
import ordenamientos.noElementales.PorQuickSort;
import ordenamientos.noElementales.PorShellSort;

class EstrategiaTest {
	
	@Test
	void testPorBurbujeoConCsv() {
		Arreglos arreglos = new Arreglos();
		Integer[] array = arreglos.generarArray(Orden.INVERTIDO, 20);
		Estrategia<Integer> estrategia = new PorBurbujeo<Integer>();
		estrategia.setRetardo(15);
		
		double tiempoInicial = System.currentTimeMillis();
		
		Integer[] ordenado = estrategia.ordenar(array);
		
		double tiempoFinal = System.currentTimeMillis();
		Salida salida = new Salida("archivo.csv",";");
		
		double tiempoTranscurrido = (tiempoFinal - tiempoInicial);
		
		salida.escribirCSV(Ordenamiento.BURBUJEO.toString(), Orden.INVERTIDO.toString(), "20", 
				String.format(Locale.ROOT, "%.4f", tiempoTranscurrido/1000),"OK");
		
		Assert.assertArrayEquals(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, ordenado);
	}
	
	@Test
	void testPorInsercion() {
		Arreglos arreglos = new Arreglos();
		Integer[] array = arreglos.generarArray(Orden.ALEATORIO, 20);
		Estrategia<Integer> estrategia = new PorInsercion<Integer>();
		estrategia.setRetardo(15);
		Integer[] ordenado = estrategia.ordenar(array);
		Assert.assertArrayEquals(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, ordenado);
	}
	
	@Test
	void testPorSeleccion() {
		Arreglos arreglos = new Arreglos();
		Integer[] array = arreglos.generarArray(Orden.CASI_ORDENADO, 20);
		Estrategia<Integer> estrategia = new PorSeleccion<Integer>();
		estrategia.setRetardo(15);
		Integer[] ordenado = estrategia.ordenar(array);
		Assert.assertArrayEquals(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, ordenado);
	}
	
	@Test
	void testPorMergeSort() {
		Arreglos arreglos = new Arreglos();
		Integer[] array = arreglos.generarArray(Orden.CASI_INVERTIDO, 20);
		Estrategia<Integer> estrategia = new PorMergeSort<Integer>();
		estrategia.setRetardo(15);
		Integer[] ordenado = estrategia.ordenar(array);
		Assert.assertArrayEquals(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, ordenado);
	}
	
	@Test
	void testPorQuickSort() {
		Arreglos arreglos = new Arreglos();
		Integer[] array = arreglos.generarArray(Orden.ORDENADO, 20);
		Estrategia<Integer> estrategia = new PorQuickSort<Integer>();
		estrategia.setRetardo(15);
		Integer[] ordenado = estrategia.ordenar(array);
		Assert.assertArrayEquals(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, ordenado);
	}
	
	@Test
	void testPorShellSort() {
		Arreglos arreglos = new Arreglos();
		Integer[] array = arreglos.generarArray(Orden.INVERTIDO, 20);
		Estrategia<Integer> estrategia = new PorShellSort<Integer>();
		estrategia.setRetardo(15);
		Integer[] ordenado = estrategia.ordenar(array);
		Assert.assertArrayEquals(new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, ordenado);
	}
}
