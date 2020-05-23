package pedregal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import matrices.Matriz;

public class PedregalMatrices {

	public static int[][] cargarMatriz(String path, Casa casa) throws IOException {

		int[][] matriz = null;
		Scanner scanIn = null;

		try {
			scanIn = new Scanner(new FileReader(path));

			// esta matriz tendra el sur arriba y el norte abajo

			// generamos una matriz rodeada por unos
			int dx = scanIn.nextInt() + 2;
			int dy = scanIn.nextInt() + 2;

			matriz = new int[dy][dx];

			/*
			 * for(int fila=0; fila < matriz.length; fila++) { matriz[fila][0] = 1;
			 * matriz[fila][matriz[0].length - 1] = 1; }
			 * 
			 * for(int columna=1; columna < matriz[0].length - 1; columna++) {
			 * matriz[0][columna] = 1; matriz[matriz.length - 1][columna] = 1; }
			 */

			// tomamos las dimensiones de la casa
			casa.setLargo(scanIn.nextInt());
			casa.setAncho(scanIn.nextInt());

			// ponemos unos donde se indican las piedras
			int cantidadDePiedras = scanIn.nextInt();
			int fila;
			int columna;

			for (int i = 0; i < cantidadDePiedras; i++) {
				columna = scanIn.nextInt();
				fila = scanIn.nextInt();
				matriz[fila][columna] = 1;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (scanIn != null) {
				scanIn.close();
			}
		}

		return matriz;
	}

	public static int[][] cargarMatrizDinamica(int[][] matriz) {

		int[][] matrizDinamica = Matriz.clonarMatriz(matriz);

		for (int fila = 1; fila < matriz.length - 1; fila++) {
			for (int columna = 1; columna < matriz[0].length - 1; columna++) {
				matrizDinamica[fila][columna] = matrizDinamica[fila][columna] + matrizDinamica[fila - 1][columna]
						+ matrizDinamica[fila][columna - 1] - matrizDinamica[fila - 1][columna - 1];
			}
		}

		return matrizDinamica;
	}

	public static String BuscarUbicacionParaCasa(int[][] matrizDinamica, Casa casa) {
		String respuesta = "NO";
		int largo = 4;// casa.getLargo();
		int ancho =2;// casa.getAncho();

		boolean posicionada = false;
		int i;
		int j;
		int i2;
		int j2;

		i = 1;
		i2 = i + largo - 1;
		while (!posicionada && i < matrizDinamica.length - 1 && i2 < matrizDinamica.length - 1) {

			j = 1;
			j2 = j + ancho - 1;
			while (!posicionada && j < matrizDinamica[0].length - 1 && j2 < matrizDinamica[0].length - 1) {
				int cantidadDePiedras = matrizDinamica[i2][j2] - matrizDinamica[i - 1][j2] - matrizDinamica[i2][j - 1]
						+ matrizDinamica[i - 1][j - 1];

				// Verifica si puede poner puerta

				if (cantidadDePiedras == 0) {
					int i_desde = i;
					int i_hasta = i2;
					int j_desde = j - 1;
					int j_hasta = j - 1;

					if (largo > ancho) {
						
						i_desde = i2 + 1;
						i_hasta = i2 + 1;
						j_desde = j;
						j_hasta = j2;
						
						cantidadDePiedras = matrizDinamica[i_hasta][j_hasta] - matrizDinamica[i_desde - 1][j_hasta]
								- matrizDinamica[i_hasta][j_desde - 1] + matrizDinamica[i_desde - 1][j_desde - 1];

						if (cantidadDePiedras < largo) {
							respuesta = "SI\n" + "\nFila: " + i + " Columna: " + j + "\nVertical" + "\nO";
							posicionada = true;
						} else {
							
							i_desde = i;
							i_hasta = i2;
							j_desde = j2 + 1;
							j_hasta = j2 + 1;
							
							cantidadDePiedras = matrizDinamica[i_hasta][j_hasta] - matrizDinamica[i_desde - 1][j_hasta]
									- matrizDinamica[i_hasta][j_desde - 1] + matrizDinamica[i_desde - 1][j_desde - 1];

							if (cantidadDePiedras < largo) {
								respuesta = "SI\n" + "\nFila: " + i + " Columna: " + j + "\nVertical" + "\nE";
								posicionada = true;
							}
						}
					} else {
						cantidadDePiedras = matrizDinamica[i_hasta][j_hasta] - matrizDinamica[i_desde - 1][j_hasta]
								- matrizDinamica[i_hasta][j_desde - 1] + matrizDinamica[i_desde - 1][j_desde - 1];

						if (cantidadDePiedras < largo) {
							respuesta = "SI\n" + "\nFila: " + i + " Columna: " + j + "\nVertical" + "\nO";
							posicionada = true;
						} else {
							
							i_desde = i;
							i_hasta = i2 + 1;
							j_desde = i2;
							j_hasta = j - 1;
							
							cantidadDePiedras = matrizDinamica[i_hasta][j_hasta] - matrizDinamica[i_desde - 1][j_hasta]
									- matrizDinamica[i_hasta][j_desde - 1] + matrizDinamica[i_desde - 1][j_desde - 1];

							if (cantidadDePiedras < largo) {
								respuesta = "SI\n" + "\nFila: " + i + " Columna: " + j + "\nVertical" + "\nE";
								posicionada = true;
							} else {
								
								i_desde = i - 1;
								i_hasta = i - 1;
								j_desde = j;
								j_hasta = j2;
								
								cantidadDePiedras = matrizDinamica[i_hasta][j_hasta]
										- matrizDinamica[i_desde - 1][j_hasta] - matrizDinamica[i_hasta][j_desde - 1]
										+ matrizDinamica[i_desde - 1][j_desde - 1];

								if (cantidadDePiedras < largo) {
									respuesta = "SI\n" + "\nFila: " + i + " Columna: " + j + "\nVertical" + "\nS";
									posicionada = true;
								} else {
									
									i_desde = i2 + 1;
									i_hasta = i2 + 1;
									j_desde = j;
									j_hasta = j2;
									
									cantidadDePiedras = matrizDinamica[i_hasta][j_hasta]
											- matrizDinamica[i_desde - 1][j_hasta]
											- matrizDinamica[i_hasta][j_desde - 1]
											+ matrizDinamica[i_desde - 1][j_desde - 1];

									if (cantidadDePiedras < largo) {
										respuesta = "SI\n" + "\nFila: " + i + " Columna: " + j + "\nVertical" + "\nN";
										posicionada = true;
									}
								}

							}
						}

					}
				}
				j++;
				j2 = j + ancho - 1;
			}
			i++;
			i2 = i + largo - 1;
		}
/////////////////////////////////segunda vuelta
		if (!posicionada) {
			i = 1;
			i2 = i + ancho - 1;
			while (!posicionada && i < matrizDinamica.length - 1 && i2 < matrizDinamica.length - 1) {

				j = 1;
				j2 = j + largo - 1;
				while (!posicionada && j < matrizDinamica[0].length - 1 && j2 < matrizDinamica[0].length - 1) {
					int cantidadDePiedras = matrizDinamica[i2][j2] - matrizDinamica[i - 1][j2]
							- matrizDinamica[i2][j - 1] + matrizDinamica[i - 1][j - 1];

					if (cantidadDePiedras == 0) {
						int i_desde = i - 1;
						int i_hasta = i - 1;
						int j_desde = j;
						int j_hasta = j2;

						cantidadDePiedras = matrizDinamica[i_hasta][j_hasta] - matrizDinamica[i_desde - 1][j_hasta]
								- matrizDinamica[i_hasta][j_desde - 1] + matrizDinamica[i_desde - 1][j_desde - 1];

						if (cantidadDePiedras < largo) {
							respuesta = "SI\n" + "\nFila: " + i + " Columna: " + j + "\nHorizontal" + "\nS";
							posicionada = true;
						} else {

							i_desde = i2 + 1;
							i_hasta = i2 + 1;
							j_desde = j;
							j_hasta = j2;

							cantidadDePiedras = matrizDinamica[i_hasta][j_hasta] - matrizDinamica[i_desde - 1][j_hasta]
									- matrizDinamica[i_hasta][j_desde - 1] + matrizDinamica[i_desde - 1][j_desde - 1];

							if (cantidadDePiedras < largo) {
								respuesta = "SI\n" + "\nFila: " + i + " Columna: " + j + "\nHorizontal" + "\nN";
								posicionada = true;
							}
						}
					}
					j++;
					j2 = j + largo - 1;
				}
				i++;
				i2 = i + ancho - 1;
			}
		}

		return respuesta;
	}

}
