package ordenamientos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Salida {
	private String archivoDeSalida;
	private String separador;

	public Salida(String archivoDeSalida, String separador) {
		this.archivoDeSalida = archivoDeSalida;
		this.separador = separador;
		BufferedWriter writer = null;
		try {

			File archivo = new File(archivoDeSalida);
			if (!archivo.exists()) {
				writer = new BufferedWriter(new FileWriter(archivoDeSalida));
				writer.write("Algoritmo");
				writer.write(separador);
				writer.write("Orden");
				writer.write(separador);
				writer.write("Tamaño");
				writer.write(separador);
				writer.write("Tiempo");
				writer.write(separador);
				writer.write("Estado");
				writer.newLine();
			}

		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}

	public void escribirCSV(String algoritmoSeleccionado, String ordenSeleccionado, String tamanio,
			String tiempoTranscurrido, String estado) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(archivoDeSalida, true));
			writer.write(algoritmoSeleccionado);
			writer.write(separador);
			writer.write(ordenSeleccionado);
			writer.write(separador);
			writer.write(tamanio);
			writer.write(separador);
			writer.write(tiempoTranscurrido);
			writer.write(separador);
			writer.write(estado);
			writer.newLine();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}
}
