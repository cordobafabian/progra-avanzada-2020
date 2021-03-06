package monticuloPruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import monticulo.*;

public class monticuloTest {
	
	@Test
	public void testAgregarYSacarDeMonticulo() {
		
		Monticulo monti = new Monticulo();
		monti.agregarUnElemento(new Elemento("a",5));
		monti.agregarUnElemento(new Elemento("b",7));
		monti.agregarUnElemento(new Elemento("c",15));
		monti.agregarUnElemento(new Elemento("d",14));
		monti.agregarUnElemento(new Elemento("e",9));
		monti.agregarUnElemento(new Elemento("f",18));
		monti.agregarUnElemento(new Elemento("g",20));
		
		for(Elemento x: monti.getElementos() ) {
			System.out.println(x);
		}
		System.out.println();
		
		
		System.out.println("Eliminado: " + monti.sacarUnElemento());
		System.out.println();
		
		for(Elemento x: monti.getElementos() ) {
			System.out.println(x);
		}
		System.out.println();
		
		assertEquals(7, monti.getElementos().size());
	}


}
