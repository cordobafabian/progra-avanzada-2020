package metodosDeOrdenamiento;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MetodosDeOrdenamientoTest {
	
	ArrayList<Integer> valores;
	ArrayList<Integer> esperados;
	
	@Before
	public void inicializar() {
		valores = new ArrayList<Integer>();
		valores.add(8);
		valores.add(2);
		valores.add(7);
		valores.add(3);
		valores.add(4);
		valores.add(1);
		valores.add(8);
		valores.add(2);
		valores.add(0);
		
		esperados = new ArrayList<Integer>();
		esperados.add(8);
		esperados.add(2);
		esperados.add(7);
		esperados.add(3);
		esperados.add(4);
		esperados.add(1);
		esperados.add(8);
		esperados.add(2);
		esperados.add(0);
		
		esperados.sort(null);
	}
	
	
	@Test
	public void burbuja() {
		MetodosDeOrdenamiento.burbuja_Sort(valores);
		
		int[] actuals = MetodosDeOrdenamiento.convertIntegers(valores);
		int[] expecteds = MetodosDeOrdenamiento.convertIntegers(esperados);
		
		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void insersion() {
		MetodosDeOrdenamiento.insersion_Sort(valores);
		
		int[] actuals = MetodosDeOrdenamiento.convertIntegers(valores);
		int[] expecteds = MetodosDeOrdenamiento.convertIntegers(esperados);
		
		assertArrayEquals(expecteds, actuals);
	}

}
