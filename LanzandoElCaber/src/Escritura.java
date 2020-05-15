import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura {

	public static void grabarArchivoResultados(String resultados, String pathArchivoOut) throws IOException {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(pathArchivoOut));
			bw.write(resultados);
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(bw!= null) {
				bw.close();
			}
		}
	}
	
}
