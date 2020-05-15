
public class Punto3D extends Punto2D {
	protected int z;
	
	public Punto3D(int x, int y, int z) {
		super(x,y);
		this.z = z;
	}
	
	public boolean equals(Object other) {
		if (other == null) return false;
		
		if (getClass() != other.getClass()) return false;
		
		final Punto3D otro = (Punto3D) other; // CONST
		
		if (otro.x != this.x || otro.y != this.y || otro.z != this.z) return false;
		
		return true;
	}
	
	public String toString() {
		return '(' + Integer.toString(this.x) + ',' + Integer.toString(this.y) + ','
				+ Integer.toString(this.z) + ')';
	}
}
