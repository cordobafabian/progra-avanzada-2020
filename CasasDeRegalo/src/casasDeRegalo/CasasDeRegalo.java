package casasDeRegalo;

import java.util.ArrayList;
import java.util.HashMap;

public class CasasDeRegalo {
	
	public static void main(String[] args) {
		HashMap<Integer, ArrayList<Local>> coloreados = new HashMap<Integer, ArrayList<Local>>();
		CadenaDeLocales locales = new CadenaDeLocales();
		String pathArchivoIn = "regalos.in";
		Lector.cargarGrafo(pathArchivoIn, locales);
		
		System.out.println("Locales sin colores");
		locales.mostrarNodos();
		System.out.println();
		
		System.out.println("Locales con sus cercanos");
		locales.mostrarAdyacentes();
		System.out.println();
		
		Coloreo.colorear(locales, coloreados);
		
		System.out.println("Locales agrupados por color");
		for(Integer color : coloreados.keySet() ) {
			ArrayList<Local> tiendas = coloreados.get(color);
			
			for(Local tienda : tiendas) {
				System.out.println("Local: "+tienda.getIdentificador()+ " color: "+ tienda.getColor());
			}
			System.out.println();
		}
		
		ArrayList<Local> resultados = Coloreo.mayorCantidadDeElementos(coloreados);
		System.out.println("Resultado");
		System.out.println(resultados.size());
		for(Local local : resultados) {
			System.out.print(local.getIdentificador()+" ");
		}
		System.out.println();
	}
}
