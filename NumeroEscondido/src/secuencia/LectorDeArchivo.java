package secuencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectorDeArchivo {

	public static void leerArchivo(String pathArchivo, SecuenciaDeCifras mayor, SecuenciaDeCifras menor) {
		Scanner lector = null;

		try {
			lector = new Scanner(new FileReader(pathArchivo));
			
			int longitudMayor = lector.nextInt();
			String cadena1 =lector.next().trim();
			mayor.setCifras(stringToArrayList(cadena1));
			
			int longitudMenor = lector.nextInt();
			String cadena2 = lector.next().trim();
			menor.setCifras(stringToArrayList(cadena2));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (lector != null) {
				lector.close();
			}
		}

	}
	
	public static List<Integer> stringToArrayList(String cadena){
		char[] vectorDeChar = cadena.toCharArray();

		List<Integer> cifras = new ArrayList<Integer>(vectorDeChar.length);

		for (char caracter : vectorDeChar) {
			cifras.add(caracter - 48);
		}
		
	return cifras;
	}
}
