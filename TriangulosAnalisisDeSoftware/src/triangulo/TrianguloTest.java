package triangulo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrianguloTest {
	
	int l1, l2, l3;
	Triangulo triangulo;
	String respuestaEsperada;
	String respuestaObtenida = "No es triangulo";

	@Test
	public void esEquilatero() {
		l1 = 200;
		l2 = 200;
		l3 = 200;
		respuestaEsperada = "Equilatero";
		
		//inicio programa
		if(Triangulo.esTriangulo(l1, l2, l3)) {
			triangulo = new Triangulo(l1, l2, l3);
			respuestaObtenida = triangulo.clasificar();
		}
		System.out.println(respuestaObtenida);
		//fin programa
		
		assertEquals(respuestaEsperada, respuestaObtenida);	
	}
	
	@Test
	public void esEscaleno() {
		l1 = 200;
		l2 = 201;
		l3 = 202;
		respuestaEsperada = "Escaleno";
		
		//inicio programa
		if(Triangulo.esTriangulo(l1, l2, l3)) {
			triangulo = new Triangulo(l1, l2, l3);
			respuestaObtenida = triangulo.clasificar();
		}
		System.out.println(respuestaObtenida);
		//fin programa
		
		assertEquals(respuestaEsperada, respuestaObtenida);	
	}
	
	@Test
	public void esIsosceles() {
		l1 = 200;
		l2 = 200;
		l3 = 202;
		respuestaEsperada = "Isosceles";
		
		//inicio programa
		if(Triangulo.esTriangulo(l1, l2, l3)) {
			triangulo = new Triangulo(l1, l2, l3);
			respuestaObtenida = triangulo.clasificar();
		}
		System.out.println(respuestaObtenida);
		//fin programa
		
		assertEquals(respuestaEsperada, respuestaObtenida);	
	}
	
	@Test
	public void noFormaTriangulo() {
		l1 = 500;
		l2 = 200;
		l3 = 200;
		respuestaEsperada = "No es triangulo";
		
		//inicio programa
		if(Triangulo.esTriangulo(l1, l2, l3)) {
			triangulo = new Triangulo(l1, l2, l3);
			respuestaObtenida = triangulo.clasificar();
		}
		System.out.println(respuestaObtenida);
		//fin programa
		
		assertEquals(respuestaEsperada, respuestaObtenida);	
	}
	
	@Test
	public void unLadoNulo() {
		l1 = 0;
		l2 = 200;
		l3 = 202;
		respuestaEsperada = "No es triangulo";
		
		//inicio programa
		if(Triangulo.esTriangulo(l1, l2, l3)) {
			triangulo = new Triangulo(l1, l2, l3);
			respuestaObtenida = triangulo.clasificar();
		}
		System.out.println(respuestaObtenida);
		//fin programa
		
		assertEquals(respuestaEsperada, respuestaObtenida);	
	}
	
	@Test
	public void unLadoNegativo() {
		l1 = -200;
		l2 = 200;
		l3 = 200;
		respuestaEsperada = "No es triangulo";
		
		//inicio programa
		if(Triangulo.esTriangulo(l1, l2, l3)) {
			triangulo = new Triangulo(l1, l2, l3);
			respuestaObtenida = triangulo.clasificar();
		}
		System.out.println(respuestaObtenida);
		//fin programa
		
		assertEquals(respuestaEsperada, respuestaObtenida);	
	}
	

}
