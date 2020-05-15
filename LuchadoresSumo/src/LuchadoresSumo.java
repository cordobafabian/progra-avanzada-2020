import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class LuchadoresSumo {
	public static void main(String args[]) {
		
		LuchadorSumo[] luchadores = cargaVectorDeLuchadoresDeEntrada("sumo.in");
		if(luchadores != null) {
			grabarVentajas(luchadores, "sumo.out");
		}
					
	}
	
	public static LuchadorSumo[] cargaVectorDeLuchadoresDeEntrada(String archivoIn) {
		
		FileReader fr;
		try {
			fr = new FileReader(archivoIn);
			Scanner inScanner = new Scanner(fr);
			int cantidad = inScanner.nextInt();
			
			LuchadorSumo[] luchadores = new LuchadorSumo[cantidad];
			
			for(int i=0; i<luchadores.length; i++) {
				luchadores[i] = new LuchadorSumo();
				luchadores[i].setPeso(inScanner.nextInt());
				//System.out.print(luchadores[i].getPeso());
				luchadores[i].setAltura(inScanner.nextInt());
				//System.out.println(" "+ luchadores[i].getAltura());
				luchadores[i].setCantidadQueVence(0);
			}
			inScanner.close();
			
			for(int i=0; i<luchadores.length; i++) {
				//System.out.print(luchadores[i].getCantidadQueVence());
				for(int j=0; j<luchadores.length; j++) {
					if(luchadores[i].venceA(luchadores[j])) {
						luchadores[i].aumentarCantidadQueVence();
					}
				}
				//System.out.println(" "+ luchadores[i].getCantidadQueVence());
			}
			return luchadores;
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void grabarVentajas(LuchadorSumo[] luchadores, String archivoOut) {
		try {
			FileWriter fw = new FileWriter(archivoOut);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(int i=0; i<luchadores.length; i++) {
				
				bw.write(String.valueOf(luchadores[i].getCantidadQueVence()));
				bw.newLine();
			}
			
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

