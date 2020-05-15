
public class Punto {
	private double x, y;
	
	public Punto() {
		setX(0);
		setY(0);
	}
	
	public Punto(double x, double y) {
		setX(x);
		setY(y);
	}
	
	public double distanciaCon(Punto p2) {
		return Math.sqrt(Math.pow(this.getX() - p2.getX(), 2) + Math.pow(this.getY() - p2.getY(), 2));
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
}
