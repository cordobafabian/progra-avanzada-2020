import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Lectura {
	
	public static final int TIROS_POR_LANZADOR = 3;
	public static final int MAXIMO_LANZADORES = 1000000;
	
	public static ArrayList<Lanzador> leerArchivoLanzadores(String pathArchivoIn) {
		
		ArrayList<Lanzador> competidores = null;
		Scanner inScanner = null;
			try {
				inScanner = new Scanner(new FileReader(pathArchivoIn));

				competidores = new ArrayList<Lanzador>();

				int cantidad = inScanner.nextInt();

				for (int i = 0; i < cantidad && i < MAXIMO_LANZADORES; i++) {
					ArrayList<Lanzamiento> tiros = new ArrayList<Lanzamiento>();

					for (int j = 0; j < TIROS_POR_LANZADOR; j++) {
						Lanzamiento tiroJ = new Lanzamiento(inScanner.nextDouble(), inScanner.nextDouble());
						tiros.add(tiroJ);

					}

					Lanzador competidorI = new Lanzador(i+1,tiros);
					competidores.add(competidorI);

				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (inScanner != null) {
					inScanner.close();
				}
			}
		return competidores;
		}
	
	}
