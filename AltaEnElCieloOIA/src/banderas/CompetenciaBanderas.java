package banderas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompetenciaBanderas {
	
	int cantidadEscuelas;
	private Carretel carretel;
	private List<Ronda> rondas;
	
	public CompetenciaBanderas() {
		this.rondas = new ArrayList<Ronda>();
	}
	
	public void leerArchivo(String pathArchivo) {
		Scanner lector = null;
		try {
			lector = new Scanner(new FileReader(pathArchivo));
			
			this.setCarretel(new Carretel(lector.nextInt()));
			
			this.cantidadEscuelas = lector.nextInt();
			Ronda rondaInicial = new Ronda();
			for(int i=1; i<=this.cantidadEscuelas; i++) {
				int longitudRetazoInicial = lector.nextInt();
				rondaInicial.addBandera(new Bandera( i, longitudRetazoInicial));
				this.carretel.cortarRetazo(longitudRetazoInicial);
			}
			this.addRonda(rondaInicial);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(lector!=null) {
				lector.close();
			}
		}
		
	}
	
	
	public void addRonda(Ronda ronda) {
		this.rondas.add(ronda);
	}
	
	public List<Ronda> getRondas() {
		return rondas;
	}

	public void setRondas(List<Ronda> rondas) {
		this.rondas = rondas;
	}

	public Carretel getCarretel() {
		return carretel;
	}

	public void setCarretel(Carretel carretel) {
		this.carretel = carretel;
	}
	
	public int carretelRestante() {
		return this.carretel.getLongitud();
	}
	
	@Override
	public String toString() {
		String cadena = this.carretel.toString() + "\n\n";
		
		for(Ronda ronda: this.rondas) {
			cadena += ronda.toString() + "\n";
		}
		cadena+="\n";
		
		return cadena.trim();
	}

	public void iniciarCompetencia() {
		int longitudCarretelAnterior = this.carretelRestante();
		
		
				
	return;
	}
	
}
