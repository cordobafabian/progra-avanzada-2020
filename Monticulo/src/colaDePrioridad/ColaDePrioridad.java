package colaDePrioridad;

import monticulo.*;

public class ColaDePrioridad {
	
	Monticulo monticulo;
	
	public ColaDePrioridad() {
		this.monticulo = new Monticulo();
	}
	
	public void agregarUnElemento(Elemento elemento) {
		this.monticulo.agregarUnElemento(elemento);
	}
	
	public Elemento sacarUnElemento() {
		return monticulo.sacarUnElemento();
	}
	
	public boolean estaVacia() {
		return this.monticulo.estaVacio();
	}
	
	public Elemento verPrimero() {
		return this.monticulo.verRaiz();
	}
	
}
