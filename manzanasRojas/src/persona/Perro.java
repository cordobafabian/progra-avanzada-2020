package persona;

import lectores.*;

public class Perro {
	
	private Pelaje pelito;
	private String raza;
	
	public Perro(Pelaje pelo, String raza) {
		this.pelito = pelo;
		this.raza = raza;
	}
	
	public Perro() {
		pelito = new Pelaje("Negro", 2.1);
		raza = "Caniche";
	}
	
	@Override
	public String toString() {
		return pelito.toString()+" Raza: "+raza;
	}
	
	
}
