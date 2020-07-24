
public class Monstruo {
	
	private int numero;
	private int poder;
	
	public Monstruo(int numero, int poder) {
		super();
		this.numero = numero;
		this.poder = poder;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getPoder() {
		return poder;
	}
	
	public void setPoder(int poder) {
		this.poder = poder;
	}	

	public boolean vence(Monstruo obj) {
		return this.poder >= obj.getPoder();
	}
	
}
