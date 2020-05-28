package secuencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorDeArchivo {
	
	public static void escribirArchivo(String pathArchivoOut, String resultado) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pathArchivoOut));
		bw.write(resultado);
		bw.close();
	}
}
