package banderas;

public class Bandera {
	private int numeroEscuela;
	private int longitud;
	private int costuras;

	public Bandera(int numeroEscuela, int longitud) {
		this.numeroEscuela = numeroEscuela;
		this.longitud = longitud;
		this.costuras = 0;
	}

	public int agregarRetazo(Carretel carretel) {
		int longitudRetazo = carretel.calcularLongitudRetazo(this.longitud);

		if (longitudRetazo > 0) {
			this.longitud += longitudRetazo;
			this.costuras++;
		}

		return longitudRetazo;
	}
	
	
	
	public int getNumeroEscuela() {
		return numeroEscuela;
	}

	public void setNumeroEscuela(int numeroEscuela) {
		this.numeroEscuela = numeroEscuela;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public int getCosturas() {
		return costuras;
	}

	public void setCosturas(int costuras) {
		this.costuras = costuras;
	}
	
	@Override
	public String toString() {
		return "Escuela " + this.numeroEscuela + " Bandera de " + this.longitud +"cm con "+this.costuras+" costuras.";
	}

}
