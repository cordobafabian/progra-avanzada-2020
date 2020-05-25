package corredores;

import static org.junit.Assert.*;

import org.junit.Test;

public class CorredoresOIATest {

	@Test
	public void test() {
		
		String expected = "1 3 1 0\n" + 
				"2 0 0 0\n" + 
				"3 4 10 0\n" + 
				"1 8 5 9\n";
		
		Carrera carrera = new Carrera();
		carrera.cargarCategorias("carrera.in");
		assertEquals(expected, carrera.toString());
	}
	
	@Test
	public void verificamosCantidadDeCategoriasFemeninas() {
		
		Carrera carrera = new Carrera();
		carrera.cargarCategorias("carrera.in");
		assertEquals(3, carrera.getMujeres().size());
	}

}
