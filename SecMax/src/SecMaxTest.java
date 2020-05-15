import org.junit.Assert;

import org.junit.Test;

public class SecMaxTest {

	@Test
	public void test() {
		 int[] entrada = {9,7,11,6,14,19,5,11,17,18};
		 int[] salidaEsperada = {5,2};
		Assert.assertArrayEquals(salidaEsperada,SecMax.secMaxResultados(entrada));
	}

}
