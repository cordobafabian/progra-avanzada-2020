
public class Punto2D {
	protected int x;
	protected int y;
	
	Punto2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object other) {
		if (other == null) return false;
		
		if (getClass() != other.getClass()) return false;
		
		final Punto2D otro = (Punto2D) other; // CONST
		
		if (otro.x != this.x || otro.y != this.y) return false;
		
		return true;
	}
	
	public String toString() {
		return '(' + Integer.toString(this.x) + ',' + Integer.toString(this.y) + ')' ;
	}
	
	public int compareTo(Punto2D other) {
		//TODO: if bigger return 1; if smaller return -1
		return 0;
	}
}
