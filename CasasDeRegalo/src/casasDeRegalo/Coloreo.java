package casasDeRegalo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Coloreo {

	public static void colorear(CadenaDeLocales locales, HashMap<Integer, ArrayList<Local>> coloreados) {
		int cantidadDeColores = 0;
		
		for(int i=0; i<locales.cantidadDeLocales(); i++) {
			int color = 1;
			Local local = locales.getNodos().get(i);
			
			while(locales.adyacentesTienenColor(local.getIdentificador(),color)) {
				color++;
			}
			
			if(cantidadDeColores<color) {
				cantidadDeColores = color;
				ArrayList<Local> localesColoreados = new ArrayList<Local>();
				coloreados.put(color, localesColoreados);
			}
			
			local.setColor(color);
			coloreados.get(local.getColor()).add(local);
			
		}
		
	}
	
	public static ArrayList<Local> mayorCantidadDeElementos(HashMap<Integer, ArrayList<Local>> coloreados){
		ArrayList<Local> resultado = new ArrayList<Local>();
		int cantidad = Integer.MIN_VALUE;
		for(Integer key : coloreados.keySet()) {
			if(coloreados.get(key).size()>cantidad) {
				resultado = coloreados.get(key);
				cantidad = resultado.size();
			}
		}
		
		return resultado;
	}

}
