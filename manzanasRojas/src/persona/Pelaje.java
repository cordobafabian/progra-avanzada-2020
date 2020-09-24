package persona;

import lectores.LectorDeArchivo;

public class Pelaje {
	
	private String color;
	private Double largo;
	
	public Pelaje(String color, Double largo) {
		this.color = color;
		this.largo = largo;
	}
	
	private String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public Double getLargo() {
		return largo;
	}



	public void setLargo(Double largo) {
		this.largo = largo;
	}



	public static void main(String[] args) {
		LectorDeArchivo objeto = new LectorDeArchivo();
	}
}
