import org.junit.Assert;
import org.junit.Test;

public class ProcesarStringsTest {

	@Test
	public void test1() {
		ProcesarStrings proceso = new ProcesarStrings(" usar el rociador con cerveza de raiz con la de ");

		System.out.println(proceso.getPalabrasClave());

		Assert.assertEquals("usar", proceso.getPalabrasClave().get(0));

	}

	@Test
	public void test2() {
		ProcesarStrings proceso = new ProcesarStrings("usar jugo");

		System.out.println(proceso.getPalabrasClave());

		Assert.assertEquals("jugo", proceso.getPalabrasClave().get(1));

	}

}
