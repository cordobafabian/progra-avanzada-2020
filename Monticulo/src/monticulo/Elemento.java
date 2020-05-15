package monticulo;

public class Elemento{
	private String nombre;
	private int prioridad;
	
	public Elemento() {
		this.nombre = "";
		this.prioridad = 0;
	}
	
	public Elemento(String nombre, int numero) {
		this.nombre = nombre;
		this.prioridad = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int numero) {
		this.prioridad = numero;
	}
	
	public Elemento clone() {
	
		return new Elemento(this.getNombre(), this.getPrioridad());	
	}
	
	public int compareTo(Elemento o) {
		return this.getPrioridad() - o.getPrioridad();
	}
	
	public void intercambiar(Elemento o) {
		Elemento aux = this.clone();
		
		this.setNombre(o.getNombre());
		this.setPrioridad(o.getPrioridad());
		
		o.setNombre(aux.getNombre());
		o.setPrioridad(aux.getPrioridad());
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.prioridad) +" "+ this.nombre;  
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + prioridad;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elemento other = (Elemento) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (prioridad != other.prioridad)
			return false;
		return true;
	}
	

}