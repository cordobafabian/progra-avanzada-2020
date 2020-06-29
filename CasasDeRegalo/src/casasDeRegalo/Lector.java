package casasDeRegalo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Lector {

	public static void cargarGrafo(String pathArchivoIn, CadenaDeLocales locales) {

		Scanner lector = null;

		try {
			lector = new Scanner(new FileReader(pathArchivoIn));
			int cantidad = lector.nextInt();
			
			for(int i=0; i<cantidad;i++) {
				locales.agregarLocal(new Local(i+1));
				locales.adyacentes.add(new ArrayList<Integer>());
			}
			

			for (int i = 0; i < cantidad; i++) {
				int pos = lector.nextInt() - 1;
				int adyacente = lector.nextInt();
				
				while (adyacente != -1) {
					locales.agregarAdyacentes(pos, adyacente);
					locales.agregarAdyacentes(adyacente - 1, pos + 1);
					adyacente = lector.nextInt();
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (lector != null) {
				lector.close();
			}
		}

	}
}
