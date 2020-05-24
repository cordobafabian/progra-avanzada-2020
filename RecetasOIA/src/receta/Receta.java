package receta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;

public class Receta {
	
	public static void leerArchivo(String archivoIn, Set<String> ingredientes, Set<String> heladera) {
		
		Scanner scanIn = null;
		
		try {
			scanIn = new Scanner(new FileReader(archivoIn));
			int cantidadEnHeladera = scanIn.nextInt();
			int cantidadEnReceta = scanIn.nextInt();
			
			scanIn.nextLine();
			
			if(cantidadEnHeladera>0) {
				String cadenaHeladera = scanIn.nextLine();
				String[] array = cadenaHeladera.split(" ");
				
				int i=0;
				while( i<array.length && cantidadEnHeladera>0 ) {
					heladera.add(array[i].trim());
					i++;
					cantidadEnHeladera--;
				}
				
			}
			
			
			String cadenaReceta = scanIn.nextLine();
			String[] array2 = cadenaReceta.split(" ");
			
			int i=0;
			while( i<array2.length && cantidadEnReceta>0 ) {
				ingredientes.add(array2[i].trim());
				i++;
				cantidadEnReceta--;
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(scanIn!=null) {
				scanIn.close();
			}
		}
		
		
	}
	
	public static int receta(Set<String> ingredientes, Set<String> heladera, Set<String> faltantes) {
		
		for(String ingrediente : ingredientes) {
			
			if(!heladera.contains(ingrediente)) {
				faltantes.add(ingrediente);
			}	
		}

	return faltantes.size();
	}

}
