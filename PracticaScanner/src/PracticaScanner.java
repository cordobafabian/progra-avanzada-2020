import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/*
 * Ejemplo de input:



6

1.6

3.8

3.7

1

3.6

-4.67

 
Se pide:
1) mínimo
2) máximo
3) promedio
4) array ordenado ascendente (en 1 sola línea separado por espacios)
5) formatear decimales con 3 digitos
*/

public class PracticaScanner {
	public static void main(String args[]) {
		FileReader fr;
		//setea punto en double... importar locale
		Locale.setDefault(Locale.ENGLISH);
		
		try {
			fr = new FileReader("Ejemplo de input.txt");
			Scanner lectura = new Scanner(fr);

			if (lectura.hasNextInt()) {
				int cant = lectura.nextInt();
				double[] vec = new double[cant];

				for (int i = 0; i < cant; i++) {
					vec[i] = lectura.nextDouble();
				}

				double min = vec[0], max = vec[0], sum = vec[0];
				for (int i = 1; i < cant; i++) {
					if (vec[i] < min)
						min = vec[i];

					if (vec[i] > max)
						max = vec[i];

					sum += vec[i];
				}
				
				//Ordeno vector de forma ascendente
				ordenarVectorDoubleAsc(vec);
				
				//Escribo archivo
				FileWriter fw = new FileWriter("Salida.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write("Minimo:" + Double.toString(min));
				bw.newLine();
				bw.write("Maximo:" + Double.toString(max));
				bw.newLine();
				bw.write("Promedio:" + Double.toString(sum/cant));
				bw.newLine();
				bw.newLine();
				bw.write("Vector ordenado:");
				bw.newLine();
				
				for(int i=0; i<cant; i++) {
					bw.write(Double.toString(vec[i])+" ");
				}
				
				//cierro archivo de escritura
				bw.close();
				
				
				//Muestro por pantalla
				System.out.println("Minimo:" + min);
				System.out.println("Maximo:" + max);
				System.out.println("Promedio:" + sum / cant);
				System.out.println("Vector ordenado:");
				for(int i=0; i<cant; i++){
					System.out.print(vec[i]+" ");
				}
				System.out.print("\n");

			} else {
				System.out.println("No puede abrirse el archivo");
			}
			fr.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void ordenarVectorDoubleAsc(double[] vec) {
		
		  int tam = vec.length;
				
				for(int i=0; i<tam; i++) {
					for(int j=i; j<tam; j++) {
						if(vec[j]<vec[i]) {
							double aux = vec[j];
							vec[j]=vec[i];
							vec[i]=aux;
						}
					}
				}	
				
				
			
			}


}
