package monticulo;
import java.util.ArrayList;

public class Monticulo {
	ArrayList<Elemento> elementos;

	public Monticulo() {
		this.elementos = new ArrayList<Elemento>();
		// this.monticulo.add(new Elemento());
		this.elementos.add(null);
	}

	public ArrayList<Elemento> getElementos() {
		return elementos;
	}
	
	public void agregarUnElemento(Elemento elemento) {
		ArrayList<Elemento> array = this.getElementos();
		
		if(array.size() == 1) {
			array.add(elemento);
		}
		else {
			
			array.add(elemento);
			 int indexActual = array.size() - 1;
			 int indexPadre = indexActual / 2;
			 
			 while(indexPadre > 0 && (array.get(indexActual).compareTo(array.get(indexPadre)))<0){
				 
				 array.get(indexActual).intercambiar(array.get(indexPadre));
				 indexActual = indexPadre;
				 indexPadre = indexActual/2;
				 
			 }
			
		}
		
	}
	
	
	public Elemento sacarUnElemento() {
		ArrayList<Elemento> array = this.getElementos();
		Elemento resultado;

		if (array.size() == 1) {
			resultado = null;

		} else {
			if (array.size() == 2) {
				resultado = array.get(1).clone();
				array.remove(1);

			} else {
				resultado = array.get(1).clone();
				
				array.get(1).intercambiar(array.get(array.size()-1));
				//array.set(1, array.get(array.size() - 1));
				array.remove(array.size() - 1);

				int indexActual = 1;
				int indexHI = indexActual * 2 > array.size() - 1 ? -1 : indexActual * 2;
				int indexHD = indexActual * 2 + 1 > array.size() - 1 ? -1 : indexActual * 2 + 1;
				

				while ((indexHI != -1 && array.get(indexActual).compareTo(array.get(indexHI)) > 0)
						|| (indexHD != -1 && array.get(indexActual).compareTo(array.get(indexHD)) > 0)) {
					
					if (indexHD != -1) {
						if (array.get(indexHI).compareTo(array.get(indexHD)) > 0) {
							array.get(indexActual).intercambiar(array.get(indexHD));
							indexActual = indexHD;
						} else {
							array.get(indexActual).intercambiar(array.get(indexHI));
							indexActual = indexHI;

						}
					} else {
						array.get(indexActual).intercambiar(array.get(indexHI));
						indexActual = indexHI;
					}

					indexHI = indexActual * 2 >= array.size() - 1 ? -1 : indexActual * 2;
					indexHD = indexActual * 2 + 1 >= array.size() - 1 ? -1 : indexActual * 2 + 1;

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
