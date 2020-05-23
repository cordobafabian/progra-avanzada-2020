package pedregal;

import java.io.IOException;

import matrices.Matriz;

public class Pedregal {

	public static void main(String[] args) throws IOException {
		
		String path = "pedregal.in";
		
		Casa casa = new Casa();
		
		int[][] terreno = PedregalMatrices.cargarMatriz(path, casa);
		
		int[][] matrizDinamica = PedregalMatrices.cargarMatrizDinamica(terreno);
		
		Matriz.mostrarMatrizInvertidaVerticalmente(terreno);
		System.out.println();
		System.out.println(casa.toString());
		
		String respuesta = PedregalMatrices.BuscarUbicacionParaCasa(matrizDinamica, casa);
		System.out.println();
		System.out.println(respuesta);

	}

}
