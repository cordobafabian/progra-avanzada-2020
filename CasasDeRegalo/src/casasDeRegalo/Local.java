package casasDeRegalo;

public class Local {
	private int identificador;
	private int color;

	public Local() {

	}
	
	public Local(int identificador) {
		super();
		this.identificador = identificador;
		this.color = 0;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Local: "+identificador+", Color: "+color;
	}

}
