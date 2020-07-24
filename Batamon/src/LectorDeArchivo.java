import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LectorDeArchivo {
	
	public static void leerArchivo(String path, Contrincante hechicera, Contrincante rival) {
		Scanner lector = null;
		
		try {
			lector = new Scanner(new FileReader(path));
			int cantidadDeMonstruos = lector.nextInt();
			
			for(int i = 1; i <= cantidadDeMonstruos; i++) {
				Monstruo monster = new Monstruo(i, lector.nextInt());
				hechicera.agregarMonstruo(monster);
			}
			
			for(int i = 1; i <= cantidadDeMonstruos; i++) {
				Monstruo monster = new Monstruo(i, lector.nextInt());
				rival.agregarMonstruo(monster);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(lector != null) {
				lector.close();
			}
		}
		
	}
}
