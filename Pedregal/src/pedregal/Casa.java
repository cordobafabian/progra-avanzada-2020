package pedregal;

public class Casa {
	int ancho;
	int largo;
	
	public Casa() {
		this.ancho = 0;
		this.largo = 0; 
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}
	
	public String toString() {
		return this.getLargo()+" "+this.getAncho();
	}
	
	
	
	
}
