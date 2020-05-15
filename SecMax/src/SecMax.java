
public class SecMax {
	
	public static int[] secMaxResultados(int[] entrada) {
	int[] resultado = new int[2];
	int contadorMaxSecuenciaValida = 0;
	
	resultado[0] = 0;
	resultado[1] = 0;
	
	int n = entrada.length;
	
	for(int i=0; i<n ; i++) {
		if(entrada[i]%2!=0 && entrada[i]%3!=0 && entrada[i]%5!=0) {
			resultado[0]++;
		}
		
		while(i<n && entrada[i]%2!=0 && entrada[i]%3!=0 && entrada[i]%5!=0) {
			contadorMaxSecuenciaValida++;
			i++;
		}
		
		if(contadorMaxSecuenciaValida > resultado[1]) {
			resultado[1] = contadorMaxSecuenciaValida;
		}
	}
	
	return resultado;
	}

}
