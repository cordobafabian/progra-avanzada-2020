package metodosDeOrdenamiento;

import java.util.ArrayList;

public class MetodosDeOrdenamiento {
	
	/////CONVIERTE ARRAYLIST<INTEGER> EN INT[]
	public static int[] convertIntegers(ArrayList<Integer> integers)
	{
	    int[] retorno = new int[integers.size()];
	    
	    for (int i=0; i < retorno.length; i++)
	    {
	        retorno[i] = integers.get(i).intValue();
	    }
	    return retorno;
	}
	
	/////BURBUJA - ASCENDENTE
	public static void burbuja_Sort(ArrayList<Integer> array) {
		boolean changed = false;
		
		do {
			changed = false;
			for(int i=0; i < array.size() - 1; i++) {
				if(array.get(i).compareTo(array.get(i+1))>0) {
					Integer aux = array.get(i);
					array.set(i, array.get(i+1));
					array.set(i+1, aux);
					
					changed = true;
				}
			}	
		}while(changed);	
	}
	
	/////INSERSION - ASCENDENTE
	public static void insersion_Sort(ArrayList<Integer> array) {
		
		for(int i=1; i<array.size(); i++) {
			Integer valor = array.get(i);
			int j = i-1;
			
			while(j>=0 && array.get(j).compareTo(valor)>0) {
				
				array.set(j+1, array.get(j));
				j--;
			}
			
			array.set(j+1, valor);
		}
	}
	
	
	//////SELECCION - ASCENDENTE
	public static void seleccion_Sort(ArrayList<Integer> array) {
		
		
	}
	
}
