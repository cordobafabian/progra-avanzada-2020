package banderas;

import java.util.ArrayList;
import java.util.List;

public class Ronda {
	
	List<Bandera> banderas;
	
	public Ronda() {
		this.banderas = new ArrayList<Bandera>();
	}
	
	public void addBandera(Bandera bandera) {
		this.banderas.add(bandera);
	}

	public List<Bandera> getBanderas() {
		return banderas;
	}

	public void setBanderas(List<Bandera> banderas) {
		this.banderas = banderas;
	}
	
	@Override
	public String toString() {
		String cadena = "";
		for(Bandera bandera : this.banderas) {
			cadena+= bandera.toString()+"\n";
		}
		
	return cadena.trim();
	}
}
