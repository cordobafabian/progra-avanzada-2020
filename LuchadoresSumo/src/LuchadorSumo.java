
public class LuchadorSumo {
	private int peso;
	private int altura;
	private int cantidadQueVence;
	
	public LuchadorSumo(){
		this.peso = 0;
		this.altura = 0;
		this.cantidadQueVence = 0;
	}
	
	public LuchadorSumo(int peso, int altura) {
		this.peso = peso;
		this.altura = altura;
		this.cantidadQueVence = 0;
	}
	
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getCantidadQueVence() {
		return cantidadQueVence;
	}
	public void setCantidadQueVence(int cantidadQueVence) {
		this.cantidadQueVence = cantidadQueVence;
	}
	public void aumentarCantidadQueVence() {
		setCantidadQueVence(getCantidadQueVence()+1);
	}
	public boolean venceA(LuchadorSumo luchador2) {
		return(this.peso>luchador2.peso && this.altura==luchador2.altura)
				||(this.peso==luchador2.peso && this.altura>luchador2.altura)
				||(this.peso>luchador2.peso && this.altura>luchador2.altura);
	}
}
