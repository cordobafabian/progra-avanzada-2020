
import org.junit.Assert;
import org.junit.Test;

public class PonyExpressTest {

	@Test
	public void unJinete() {

		Assert.assertEquals(1, PonyExpress.jinetes(new int[] { 18, 15 }));
	}

	@Test
	public void sgundoJinete() {
		Assert.assertEquals(2, PonyExpress.jinetes(new int[] { 43, 23, 40, 13 }));

	}

	@Test
	public void variosJinetes() {
		Assert.assertEquals(3, PonyExpress.jinetes(new int[] { 33, 8, 16, 47, 30, 30, 46 }));
	}

	@Test
	public void pocasEstacionesALargasDistancias() {
		Assert.assertEquals(3, PonyExpress.jinetes(new int[] { 51, 51, 51 }));

	}

	@Test
	public void muchasEstacionesACortasDistancias() {
		Assert.assertEquals(4, PonyExpress.jinetes(new int[] { 6, 24, 6, 8, 28, 8, 23, 47, 17, 29, 37, 18, 40, 49 }));

	}

}
