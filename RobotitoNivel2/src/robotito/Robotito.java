package robotito;

public class Robotito {
	
	Direccion direccion;
	int cantidadDeInstrucciones;
	int estado;
	
	public Robotito() {
		direccion = new Norte();
		cantidadDeInstrucciones = 0;
		estado = -1;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Character verDireccion() {
		return direccion.getDireccion();
	}

	public int getCantidadDeInstrucciones() {
		return cantidadDeInstrucciones;
	}

	public void aumentarCantidadDeInstrucciones() {
		this.cantidadDeInstrucciones++;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void detenerMovimientos() {
		this.setEstado(this.cantidadDeInstrucciones);
	}
	
	public boolean puedeMoverse() {
		return estado == -1;
	}
	
	public void girar(Character sentido) {
		this.direccion.girar(this, sentido);
	}
	
	public void procesarInstrucciones(String instrucciones) {
		if(instrucciones != null) {
			String[] comandos = instrucciones.split("");
			
			int i=0;
			while(this.puedeMoverse() && i < comandos.length) {
				
				this.girar(comandos[i].toCharArray()[0]);
				
			i++;	
			}
		}
	}
	
}
