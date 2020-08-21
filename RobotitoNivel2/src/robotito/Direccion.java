package robotito;

public abstract class Direccion {
	
	Character direccion;
	
	public Direccion(Character direccion) {
		this.direccion = direccion;
	}
	
	protected abstract void girar(Robotito robotito, Character sentido);
	
	public Character getDireccion() {
		return direccion;
	}
}
