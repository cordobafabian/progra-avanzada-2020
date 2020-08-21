package robotito;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lector {
	
	public static String leerInstuccionesDeArchivo(String path) throws IOException {
		String retorno = null;
		BufferedReader lector = null;
		
		try {
			lector = new BufferedReader(new FileReader(path));
			retorno = lector.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(lector != null) {
				lector.close();
			}
		}
	
		return retorno;
	}
}
