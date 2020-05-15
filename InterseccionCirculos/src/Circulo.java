
public class Circulo {
	private Punto p;
	private double radio;

	public Circulo() {
		setP(new Punto(0, 0));
		setRadio(1.0);
	}

	public Circulo(Punto p, double radio) {
		setP(p);
		setRadio(radio);
	}
	
	public boolean intersectaCon(Circulo c2) {
		if( this.getP().distanciaCon(c2.getP()) - this.getRadio() - c2.getRadio() > 0 )
			return false; //"Los circulos no se intersectan";
		else
			return true; //"Los circulos se intersectan";	
	}

	public Punto getP() {
		return p;
	}

	public void setP(Punto p) {
		this.p = p;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

}
