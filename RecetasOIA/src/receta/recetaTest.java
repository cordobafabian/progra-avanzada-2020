package receta;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class recetaTest {
	
	Set<String> ingredientes;
	Set<String> heladera;
	Set<String> faltantes;
	Set<String> faltantesEsperados;
	
	String archivoIn;
	
	int cantidadFaltantesEsperada;
	int cantidadFaltantes;
	
	@Test
	public void verificaCantidadDeFaltantes() {
		
		archivoIn = "receta.in";
		cantidadFaltantesEsperada = 4;
		
		ingredientes = new HashSet<String>();
		heladera = new HashSet<String>();
		faltantes = new HashSet<String>();
		
		Receta.leerArchivo(archivoIn, ingredientes, heladera);
		cantidadFaltantes = Receta.receta(ingredientes, heladera, faltantes);
		
		assertEquals(cantidadFaltantesEsperada, cantidadFaltantes);	
	}
	
	
	@Test
	public void verificaIgredientesFaltantes() {
		
		archivoIn = "receta.in";
		
		faltantesEsperados = new HashSet<String>();
		faltantesEsperados.add("palometa");
		faltantesEsperados.add("papa");
		faltantesEsperados.add("choclo");
		faltantesEsperados.add("cordero");
		
		ingredientes = new HashSet<String>();
		heladera = new HashSet<String>();
		faltantes = new HashSet<String>();
		
		Receta.leerArchivo(archivoIn, ingredientes, heladera);
		cantidadFaltantes = Receta.receta(ingredientes, heladera, faltantes);
		
		assertEquals(true, faltantesEsperados.equals(faltantes));
	}
	
	@Test
	public void verificaCantidadDeFaltantesHeladeraVacia() {
		
		archivoIn = "receta 1.in";
		cantidadFaltantesEsperada = 6;
		
		ingredientes = new HashSet<String>();
		heladera = new HashSet<String>();
		faltantes = new HashSet<String>();
		
		Receta.leerArchivo(archivoIn, ingredientes, heladera);
		cantidadFaltantes = Receta.receta(ingredientes, heladera, faltantes);
		
		assertEquals(cantidadFaltantesEsperada, cantidadFaltantes);	
	}
	
	
	@Test
	public void verificaIgredientesFaltantesHeladeraVacia() {
		
		archivoIn = "receta 1.in";
		
		faltantesEsperados = new HashSet<String>();
		faltantesEsperados.add("palometa");
		faltantesEsperados.add("papa");
		faltantesEsperados.add("choclo");
		faltantesEsperados.add("cordero");
		faltantesEsperados.add("limon");
		faltantesEsperados.add("pan");
		
		ingredientes = new HashSet<String>();
		heladera = new HashSet<String>();
		faltantes = new HashSet<String>();
		
		Receta.leerArchivo(archivoIn, ingredientes, heladera);
		cantidadFaltantes = Receta.receta(ingredientes, heladera, faltantes);
		
		assertEquals(true, faltantesEsperados.equals(faltantes));
	}
	
	
	
	/*
	@Test
	public void proximaPrueba() {
		
		archivoIn = "receta.in";
		
		faltantesEsperados = new HashSet<String>();
		faltantesEsperados.add("palometa");
		faltantesEsperados.add("papa");
		faltantesEsperados.add("choclo");
		faltantesEsperados.add("cordero");
		
		ingredientes = new HashSet<String>();
		heladera = new HashSet<String>();
		faltantes = new HashSet<String>();
		
		Receta.leerArchivo(archivoIn, ingredientes, heladera);
		cantidadFaltantes = Receta.receta(ingredientes, heladera, faltantes);
		
		for(String x : heladera) {
			System.out.println(x);
		}
		System.out.println();
		
		for(String x : ingredientes) {
			System.out.println(x);
		}
		System.out.println();
		
		for(String x : faltantes) {
			System.out.println(x);
		}
		
		
		assertEquals(true, faltantesEsperados.equals(faltantes));
	}
	*/

}
