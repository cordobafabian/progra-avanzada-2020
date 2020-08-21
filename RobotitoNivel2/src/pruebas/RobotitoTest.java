package pruebas;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import robotito.Lector;
import robotito.Robotito;

public class RobotitoTest {
	
	String path;
	String instrucciones;
	Robotito robotito;

	@Test
	public void casoEnunciado1() throws IOException {
		//llega con movimientos mixtos y sigue dando instrucciones
		path = "ArchivosIn/casoEnunciado1.in";
		instrucciones = Lector.leerInstuccionesDeArchivo(path);	
		
		robotito = new Robotito();
		robotito.procesarInstrucciones(instrucciones);
		
		assertEquals(8, robotito.getEstado());	
	}
	
	@Test
	public void casoEnunciado2() throws IOException {
		//no llega
		path = "ArchivosIn/casoEnunciado2.in";
		instrucciones = Lector.leerInstuccionesDeArchivo(path);	
		
		robotito = new Robotito();
		robotito.procesarInstrucciones(instrucciones);
		
		assertEquals(-1, robotito.getEstado());	
	}
	
	@Test
	public void caso3() throws IOException {
		//realiza dos movimienots horarios, llega y termina
		path = "ArchivosIn/caso3.in";
		instrucciones = Lector.leerInstuccionesDeArchivo(path);	
		
		robotito = new Robotito();
		robotito.procesarInstrucciones(instrucciones);
		
		assertEquals(2, robotito.getEstado());	
	}
	
	@Test
	public void caso4() throws IOException {
		//llega en dos movimientos horarios y sigue dando instrucciones
		path = "ArchivosIn/caso4.in";
		instrucciones = Lector.leerInstuccionesDeArchivo(path);	
		
		robotito = new Robotito();
		robotito.procesarInstrucciones(instrucciones);
		
		assertEquals(2, robotito.getEstado());	
	}
	
	@Test
	public void caso5() throws IOException {
		//sin movimientos
		path = "ArchivosIn/caso5.in";
		instrucciones = Lector.leerInstuccionesDeArchivo(path);	
		
		robotito = new Robotito();
		robotito.procesarInstrucciones(instrucciones);
		
		assertEquals(-1, robotito.getEstado());	
	}
	
	@Test
	public void caso6() throws IOException {
		//llega en exactamente dos movimientos antihorarios y no da mas instrucciones
		path = "ArchivosIn/caso6.in";
		instrucciones = Lector.leerInstuccionesDeArchivo(path);	
		
		robotito = new Robotito();
		robotito.procesarInstrucciones(instrucciones);
		
		assertEquals(2, robotito.getEstado());	
	}
	
	@Test
	public void caso7() throws IOException {
		//llega dos movimientos antihorarios y da mas instrucciones
		path = "ArchivosIn/caso7.in";
		instrucciones = Lector.leerInstuccionesDeArchivo(path);	
		
		robotito = new Robotito();
		robotito.procesarInstrucciones(instrucciones);
		
		assertEquals(2, robotito.getEstado());	
	}

}
