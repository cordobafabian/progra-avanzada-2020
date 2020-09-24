package monticulo;
import java.util.ArrayList;

public class Monticulo {
	private ArrayList<Elemento> elementos;

	public Monticulo() {
		this.elementos = new ArrayList<Elemento>();
		// this.monticulo.add(new Elemento());
		this.elementos.add(null);
	}

	public ArrayList<Elemento> getElementos() {
		return elementos;
	}
	
	public void agregarUnElemento(Elemento elemento) {
		
		if(elementos.size() == 1) {
			elementos.add(elemento);
		}
		else {
			
			elementos.add(elemento);
			 int indexActual = elementos.size() - 1;
			 int indexPadre = indexActual / 2;
			 
			 while(indexPadre > 0 && (elementos.get(indexActual).compareTo(elementos.get(indexPadre)))<0){
				 
				 elementos.get(indexActual).intercambiar(elementos.get(indexPadre));
				 indexActual = indexPadre;
				 indexPadre = indexActual/2;
				 
			 }
			
		}
		
	}
	
	
	public Elemento sacarUnElemento() {
		Elemento resultado;

		if (elementos.size() == 1) {
			resultado = null;

		} else {
			if (elementos.size() == 2) {
				resultado = elementos.get(1).clone();
				elementos.remove(1);

			} else {
				resultado = elementos.get(1).clone();
				
				elementos.get(1).intercambiar(elementos.get(elementos.size()-1));
				//array.set(1, array.get(array.size() - 1));
				elementos.remove(elementos.size() - 1);

				int indexActual = 1;
				int indexHI = indexActual * 2 >= elementos.size() - 1 ? -1 : indexActual * 2;
				int indexHD = indexActual * 2 + 1 >= elementos.size() - 1 ? -1 : indexActual * 2 + 1;
				

				while ((indexHI != -1 && elementos.get(indexActual).compareTo(elementos.get(indexHI)) > 0)
						|| (indexHD != -1 && elementos.get(indexActual).compareTo(elementos.get(indexHD)) > 0)) {
					
					if (indexHD != -1) {
						if (elementos.get(indexHI).compareTo(elementos.get(indexHD)) > 0) {
							elementos.get(indexActual).intercambiar(elementos.get(indexHD));
							indexActual = indexHD;
						} else {
							elementos.get(indexActual).intercambiar(elementos.get(indexHI));
							indexActual = indexHI;

						}
					} else {
						elementos.get(indexActual).intercambiar(elementos.get(indexHI));
						indexActual = indexHI;
					}

					indexHI = indexActual * 2 >= elementos.size() - 1 ? -1 : indexActual * 2;
					indexHD = indexActual * 2 + 1 >= elementos.size() - 1 ? -1 : indexActual * 2 + 1;

				} // FIN WHILE
			} // FIN DE ELSE INTERNO
		} // FIN ELSE MAYOR
		return resultado;
	}

	
	public boolean estaVacio() {
		return this.getElementos().size() == 1;
	}
	
	public Elemento verRaiz() {
		return !estaVacio() ? this.getElementos().get(1): null;
	}


}
