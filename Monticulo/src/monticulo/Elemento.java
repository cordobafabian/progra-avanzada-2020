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
	
	public int obtenerPosPico(int[] arreglo){
		int i = 0;
		int posPico = -1;
		
		while(i+1 < arreglo.length && posPico==-1){
			if(arreglo[i+1] < arreglo[i]) {
				posPico = i;
			}
		i++;
		}
		
	return posPico;
	}
	
	public int obtenerPosPicoB(int[] arreglo) {
		return obtenerPosPicoB(arreglo, 0, (arreglo.length -1)/2, arreglo.length - 1);
	}
	
	public int obtenerPosPicoB(int[] arreglo, int inferior,int medio, int superior){
	int posPico = -1;
	
	if(arreglo[medio] > arreglo[medio + 1]) {
		posPico = medio;
	
	}else {
		if(arreglo[medio-1] < arreglo[medio + 1]) {
			posPico = obtenerPosPicoB(arreglo, medio +1, (medio+1+superior)/2, superior);
		}
		else {
			posPico = obtenerPosPicoB(arreglo, inferior, (inferior + medio)/2, medio);
		}
	}
	
	return posPico;
	
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
	
	public static void main(String[] args) {
		int[] arreglo = {1,2,3,4,5,7,6,5,4,3,2,1,0,-1,-3,-5,-7};
		Elemento ele = new Elemento();
		int pico = ele.obtenerPosPico(arreglo);

		System.out.println(pico);
	}

}
