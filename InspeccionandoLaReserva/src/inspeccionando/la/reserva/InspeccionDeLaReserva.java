package inspeccionando.la.reserva;

import grafos.*;

public class InspeccionDeLaReserva {
	
	public static void main(String[] args) {
		int cantidadMiradores = 10;
		//cantidad de tramos = 15 en este caso
		
		Grafo grafo = new Grafo(cantidadMiradores);
		grafo.addConnection(1,2);
		grafo.addConnection(2,7);
		grafo.addConnection(7,6);
		grafo.addConnection(2,3);
		grafo.addConnection(3,4);
		grafo.addConnection(1,9);
		grafo.addConnection(9,3);
		grafo.addConnection(9,10);
		grafo.addConnection(4,6);
		grafo.addConnection(4,5);
		grafo.addConnection(6,5);
		grafo.addConnection(6,8);
		grafo.addConnection(5,8);
		grafo.addConnection(5,10);
		grafo.addConnection(8,10);
	}
}
