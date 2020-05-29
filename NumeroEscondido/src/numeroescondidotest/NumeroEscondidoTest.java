package numeroescondidotest;

import secuencia.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class NumeroEscondidoTest {

	SecuenciaDeCifras mayor;
	SecuenciaDeCifras menor;
	String pathArchivoIn;
	String pathArchivoOut;
	String expected;
	String actual;

	@Test
	public void provistoPorCatedra() throws IOException {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\catedra.in";
		expected = "SI 6\n1 5 9 13 17 21";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaInfoString(menor);
		
		pathArchivoOut = "..\\Pruebas NumeroEscondido\\Salidas\\catedra.out";
		EscritorDeArchivo.escribirArchivo(pathArchivoOut, actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void cifrasBuscadasEnDiferentesOrdenes() throws IOException {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\cifrasBuscadasEnDiferentesOrdenes.in";
		expected = "SI 3\n1 4 7";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaInfoString(menor);
		
		pathArchivoOut = "..\\Pruebas NumeroEscondido\\Salidas\\cifrasBuscadasEnDiferentesOrdenes.out";
		EscritorDeArchivo.escribirArchivo(pathArchivoOut, actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void mismasCifras() throws IOException {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\mismasCifras.in";
		expected = "SI 1\n1";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		
		actual = mayor.contieneSubsecuenciaInfoString(menor);
		
		pathArchivoOut = "..\\Pruebas NumeroEscondido\\Salidas\\mismasCifras.out";
		EscritorDeArchivo.escribirArchivo(pathArchivoOut, actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void posicionesCompartidas() throws IOException {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\posicionesCompartidas.in";
		expected = "SI 4\n1 2 3 4";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaInfoString(menor);
		
		pathArchivoOut = "..\\Pruebas NumeroEscondido\\Salidas\\posicionesCompartidas.out";
		EscritorDeArchivo.escribirArchivo(pathArchivoOut, actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void todasLasPosiciones() throws IOException {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\todasLasPosiciones.in";
		expected = "SI 10\n1 2 3 4 5 6 7 8 9 10";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaInfoString(menor);
		
		pathArchivoOut = "..\\Pruebas NumeroEscondido\\Salidas\\todasLasPosiciones.out";
		EscritorDeArchivo.escribirArchivo(pathArchivoOut, actual);
		
		assertEquals(expected, actual);
	}

	@Test
	public void casoDeEnunciado() throws IOException {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\entrada.in";
		expected = "SI 2\n2 3";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaInfoString(menor);
		
		pathArchivoOut = "..\\Pruebas NumeroEscondido\\Salidas\\salida.out";
		EscritorDeArchivo.escribirArchivo(pathArchivoOut, actual);
		
		assertEquals(expected, actual);
	}

	@Test
	public void casoDeEnunciado2() throws IOException {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\entrada2.in";
		expected = "NO";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaInfoString(menor);
		
		pathArchivoOut = "..\\Pruebas NumeroEscondido\\Salidas\\salida2.out";
		EscritorDeArchivo.escribirArchivo(pathArchivoOut, actual);
		
		assertEquals(expected, actual);
	}

	@Test
	public void casoDeEnunciado3() throws IOException {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\entrada3.in";
		expected = "SI 1\n5";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaInfoString(menor);
		
		pathArchivoOut = "..\\Pruebas NumeroEscondido\\Salidas\\salida3.out";
		EscritorDeArchivo.escribirArchivo(pathArchivoOut, actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void casoDeEnunciado4() throws IOException {
		pathArchivoIn = "..\\Pruebas NumeroEscondido\\Entradas\\entrada4.in";
		expected = "SI 2\n5 9";
		mayor = new SecuenciaDeCifras();
		menor = new SecuenciaDeCifras();
		LectorDeArchivo.leerArchivo(pathArchivoIn, mayor, menor);
		actual = mayor.contieneSubsecuenciaInfoString(menor);
		
		//Falla, arroja una LongitudesNocoincidentesException
		//Creamos este tipo de Exception para cuando
		//alguna de las longitudes 
		//informadas no oincidan con las longitudes de las secuencias de cifras
		
		assertEquals(expected, actual);
	}

}
