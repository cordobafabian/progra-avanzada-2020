package banderas;

import static org.junit.Assert.*;

import org.junit.Test;

public class AltaEnElCieloOIATest {

	@Test
	public void cargaDeArchivo() {
		CompetenciaBanderas competencia = new CompetenciaBanderas();
		competencia.leerArchivo("banderas.in");
		System.out.println(competencia.toString());
	}
	
	@Test
	public void test() {
		CompetenciaBanderas competencia = new CompetenciaBanderas();
		competencia.leerArchivo("banderas.in");
		//competencia.iniciarCompetencia();
		System.out.println(competencia.toString());
	}

}
