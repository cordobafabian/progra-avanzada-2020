package secuencia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SecuenciaDeCifras {

	private List<Integer> cifras;
	
	public SecuenciaDeCifras() {
		this.cifras = new ArrayList<Integer>();
	}
	
	public SecuenciaDeCifras(List<Integer> lista) {
		this.cifras = lista;
	}
	
	public List<Integer> getCifras() {
		return cifras;
	}

	public void setCifras(List<Integer> lista) {
		this.cifras = lista;
	}

	public boolean tieneMismasCifras(SecuenciaDeCifras other) {
		List<Integer> lista = new LinkedList<Integer>();
		
		for(Integer cifra : other.getCifras()) {
			lista.add(cifra);
		}
		
		for(Integer cifra : this.cifras) {
			if(lista.contains(cifra)) {
				lista.remove(cifra);
			}
		}
		
		return this.size()>0 && other.size()>0 && lista.size()==0;
	}

	public int size() {
		return this.cifras.size();
	}

	public Integer getIndex(int index) {
		return this.cifras.get(index);
	}

	public SecuenciaDeCifras generarSubsecuencia(int indexInicio, int longitud) {

		SecuenciaDeCifras nuevaSecuencia = null;

		if (indexInicio + longitud <= this.size()) {
			List<Integer> array = new ArrayList<Integer>(longitud);

			for (int i = indexInicio; i <= indexInicio + longitud - 1; i++) {
				array.add(this.getIndex(i));
			}

			nuevaSecuencia = new SecuenciaDeCifras(array);
		}

		return nuevaSecuencia;
	}

	public List<Integer> posicionesConSubsecuencia(SecuenciaDeCifras subsecuencia){
		List<Integer> posiciones = new ArrayList<Integer>(this.size());
		int longitudSubsecuencia = subsecuencia.size();
		
		for(int i=0; i <= this.size() - longitudSubsecuencia; i++) {
			
			SecuenciaDeCifras particion = this.generarSubsecuencia( i, longitudSubsecuencia);
			
			if(particion.tieneMismasCifras(subsecuencia)) {
				posiciones.add(i+1);
			}
		}
		
		return posiciones;
	}
	
	public boolean contieneSubsecuencia(SecuenciaDeCifras subsecuencia, List<Integer> posiciones) {
		posiciones = this.posicionesConSubsecuencia(subsecuencia);
		return posiciones.size()!=0;
	}

	public String contieneSubsecuenciaToString(SecuenciaDeCifras subsecuencia) {
		String respuesta = "NO";
		List<Integer> posiciones = this.posicionesConSubsecuencia(subsecuencia);
		if(posiciones.size()!=0){
			respuesta = "SI "+posiciones.size()+"\n";
			
			for(Integer posicion : posiciones) {
				respuesta += posicion.toString() + " ";
			}
		}
		
	return respuesta.trim();
	}


}
