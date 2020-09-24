package pruebas;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import mccabe.CCMcCabe;

public class pruebaConBooleanos {
	String pathJava;
	CCMcCabe mccabe;
	
	@Test
	public void test() throws IOException {
		pathJava = "codigo.in";
		mccabe = new CCMcCabe(pathJava);
		
		assertEquals(6, mccabe.calcularCC2());
	}
	
	@Test
	public void ifSimple() throws IOException {
		pathJava = "if simple.in";
		mccabe = new CCMcCabe(pathJava);
		
		assertEquals(2, mccabe.calcularCC2());
	}
	
	@Test
	public void whileSimple() throws IOException {
		pathJava = "while simple.in";
		mccabe = new CCMcCabe(pathJava);
		
		assertEquals(2, mccabe.calcularCC2());
	}
	
	@Test
	public void forSimple() throws IOException {
		pathJava = "for simple.in";
		mccabe = new CCMcCabe(pathJava);
		
		assertEquals(2, mccabe.calcularCC2());
	}
	
	@Test
	public void switchSimple() throws IOException {
		pathJava = "switch simple.in";
		mccabe = new CCMcCabe(pathJava);
		
		assertEquals(2, mccabe.calcularCC2());
	}
	
	@Test
	public void sinDecisiones() throws IOException {
		pathJava = "sin decisiones.in";
		mccabe = new CCMcCabe(pathJava);
		
		assertEquals(1, mccabe.calcularCC2());
	}
	
	@Test
	public void ternariaSimple() throws IOException {
		pathJava = "ternaria simple.in";
		mccabe = new CCMcCabe(pathJava);
		
		assertEquals(2, mccabe.calcularCC2());
	}
	
	@Test
	public void ternariaDosCondiciones() throws IOException {
		pathJava = "ternaria dos condiciones.in";
		mccabe = new CCMcCabe(pathJava);
		
		assertEquals(3, mccabe.calcularCC2());
	}
	
	@Test
	public void ternariaMultiple() throws IOException {
		pathJava = "ternaria multiple.in";
		mccabe = new CCMcCabe(pathJava);
		
		assertEquals(7, mccabe.calcularCC2());
	}
	

}

