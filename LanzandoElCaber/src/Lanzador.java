import java.util.ArrayList;

public class Lanzador implements Comparable<Lanzador> {
	private int nLanzador;
	private ArrayList<Lanzamiento> lanzamientos;
	
	public Lanzador() {
		this.nLanzador = 0;
		this.lanzamientos = null;
	}
	
	public Lanzador(int numero, ArrayList<Lanzamiento> lanzamientos) {
		setnLanzador(numero);
		setLanzamientos(lanzamientos);
	}
	
	public boolean estaDescalificado() {
		boolean estado = false;
		int i=0;
		
		while(i < this.lanzamientos.size() && estado == false) {
			if( !this.lanzamientos.get(i).esValido() ) {
				estado = true;
			}
			i++;
		}
		return estado;
	}
	

	public int getnLanzador() {
		return nLanzador;
	}

	public void setnLanzador(int nLanzador) {
		this.nLanzador = nLanzador;
	}

	public double getDistanciaTotal() {
		double suma=0;
	
		for(Lanzamiento x: this.lanzamientos) {
			suma += x.getDistanciaCalculada(); 
		}
		
		return suma;
	}
	
	public ArrayList<Lanzamiento> getLanzamientos() {
		return lanzamientos;
	}
	
	public void setLanzamientos(ArrayList<Lanzamiento> lanzamientos) {
		this.lanzamientos = new ArrayList<Lanzamiento>();
		
		for(int i=0; i < lanzamientos.size(); i++) {
			this.lanzamientos.add(i, lanzamientos.get(i));
		}
		
		//this.lanzamientos = lanzamientos;
	}

	@Override
	public int compareTo(Lanzador o) {
		int comparacion = 0;
		
		if(this.getDistanciaTotal() - o.getDistanciaTotal() < 0) {
			comparacion = -1;
		}else if(this.getDistanciaTotal() - o.getDistanciaTotal() > 0 ){
			comparacion = 1;
		}
	return comparacion;	
	}
	
}
