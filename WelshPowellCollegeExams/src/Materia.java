
public class Materia {
	int codigo;
	String nombre;
	int color;
	int grado;
	
	public Materia(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.color = 0;
		this.grado = 0;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String toString() {
		return codigo + " " + nombre;
	}
	
}
