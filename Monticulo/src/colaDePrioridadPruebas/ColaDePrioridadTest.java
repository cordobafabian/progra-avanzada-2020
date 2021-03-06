package colaDePrioridadPruebas;

import monticulo.*;
import colaDePrioridad.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColaDePrioridadTest {

	@Test
	public void ObtenerUltimoDesencolando() {
		
		ColaDePrioridad cola = new ColaDePrioridad();
		cola.agregarUnElemento(new Elemento("a",5));
		cola.agregarUnElemento(new Elemento("b",7));
		cola.agregarUnElemento(new Elemento("c",15));
		cola.agregarUnElemento(new Elemento("d",14));
		cola.agregarUnElemento(new Elemento("e",9));
		cola.agregarUnElemento(new Elemento("f",18));
		cola.agregarUnElemento(new Elemento("g",20));
		
		Elemento masGrandeEsperado = new Elemento("g",20);
		Elemento masGrandeEnCola = new Elemento();
		
		while(!cola.estaVacia()) {
			masGrandeEnCola = cola.sacarUnElemento();
		}
		
		assertEquals(masGrandeEsperado,masGrandeEnCola);
	}
	
	
	@Test
	public void verPrimeroLuegoDeQuitarDos() {
		
		ColaDePrioridad cola = new ColaDePrioridad();
		cola.agregarUnElemento(new Elemento("a",5));
		cola.agregarUnElemento(new Elemento("b",7));
		cola.agregarUnElemento(new Elemento("c",15));
		cola.agregarUnElemento(new Elemento("d",14));
		cola.agregarUnElemento(new Elemento("e",9));
		cola.agregarUnElemento(new Elemento("f",18));
		cola.agregarUnElemento(new Elemento("g",20));
		
		cola.sacarUnElemento();
		cola.sacarUnElemento();
		
		Elemento Esperado = new Elemento("e",9);
		Elemento Obtenido = cola.verPrimero();
		
		assertEquals(Esperado,Obtenido);
	}

}
