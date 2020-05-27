package numeroescondidotest;

import secuencia.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class NumeroEscondidoTest {

	SecuenciaDeCifras mayor;
	SecuenciaDeCifras menor;
	String pathArchivoIn;
	String pathArchivoOut;
	String expected;
	String actual;

	@Test
	public void provistoPorCatedra() {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\catedra.in";
		expected = "SI 6\n1 5 9 13 17 21";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaToString(menor);
		assertEquals(expected, actual);
	}

	@Test
	public void casoDeEnunciado() {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\entrada.in";
		expected = "SI 2\n2 3";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaToString(menor);
		assertEquals(expected, actual);
	}

	@Test
	public void casoDeEnunciado2() {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\entrada2.in";
		expected = "NO";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaToString(menor);
		assertEquals(expected, actual);
	}

	@Test
	public void casoDeEnunciado3() {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\entrada3.in";
		expected = "SI 1\n5";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaToString(menor);
		assertEquals(expected, actual);
	}
	
	@Test
	public void casoDeEnunciado4() {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\entrada4.in";
		expected = "SI 2\n5 9";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaToString(menor);
		assertEquals(expected, actual);
	}

}
