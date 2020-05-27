package banderas;

public class Carretel{
	int longitud;

	public Carretel(int longitud) {
		this.longitud = longitud;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
	public void cortarRetazo(int longitudRetazo) {
		this.longitud -= longitudRetazo;
	}

	public int calcularLongitudRetazo(int longitudBandera) {
		int longitudRetazo = 0;
		int precalculo = longitudBandera;
		
		char[] cifras = Integer.toString(longitudBandera).toCharArray();
		
		for(char cifra: cifras) {
			
			precalculo += cifra - 48;
		}
		
		if(precalculo <= this.longitud) {
			longitudRetazo = precalculo;
		}
		
		return longitudRetazo;
	}
	
	@Override
	public String toString(){
		return "Longitud de carretel: " + this.longitud;
	}
	
}
