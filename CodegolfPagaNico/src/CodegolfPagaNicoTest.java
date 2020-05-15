import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CodegolfPagaNicoTest {
	CodegolfPagaNico objeto = new CodegolfPagaNico();

	@Test
	public void test1() {
		Assert.assertEquals(140, objeto.pagaNico(140));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(305, objeto.pagaNico(925));
	}
	
	@Test
	public void test3() {
		//fail("Not yet implemented");
		Assert.assertEquals(167, objeto.pagaNico(250));
	}
	
	@Test
	public void Fatality() {
		//fail("Not yet implemented");
		Assert.assertEquals(225, objeto.pagaNico(837));
	}
	
	@Test
	public void Fatality2() {
		//fail("Not yet implemented");
		Assert.assertEquals(142, objeto.pagaNico(212));
	}
	
	@Test
	public void JoaPagaUnaSolaVezTodo() {
		//No recursivo
		Assert.assertEquals(0, objeto.pagaNico(500));
	}
	
	@Test
	public void JoaAportaUnaUnicaVezYRestoSeDivide() {
		//No Recursivo
		Assert.assertEquals(480, objeto.pagaNico(1100));
	}
	
	@Test
	public void JoaPagaUnaSolaYElRestoPagaNico() {
		//No Recursivo
		Assert.assertEquals(150, objeto.pagaNico(650));
	}
	
	@Test
	public void JoaPagaTodo3Veces() {
		//Recursivo funciona
		Assert.assertEquals(0, objeto.pagaNico(1500));
	}
	
	@Test
	public void JoaPagaDobleYNicoElResto() {
		//Recursivo funciona
		Assert.assertEquals(100, objeto.pagaNico(1600));
	}
	
	@Test
	public void JoaPagaDobleYElRestoSeDivide() {
		//Recursivo funciona
		Assert.assertEquals(305, objeto.pagaNico(1425));
	}
	
	
	
}
