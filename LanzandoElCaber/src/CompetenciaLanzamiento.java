import java.util.ArrayList;

public class CompetenciaLanzamiento {

	private ArrayList<Lanzador> lanzadores;

	public CompetenciaLanzamiento() {
		this.lanzadores = null;
		/*System.out.println(
				"No se ha ingresado ninguna ruta\n" + "a algun archivo con los competidores\n" + "y sus lanzamientos");
        */	
	}

	public CompetenciaLanzamiento(ArrayList<Lanzador> lanzadores) {
		setLanzadores(lanzadores);
	}
	
	public String getPodios(){
		String podios = "";
		
		for(Integer x: getPodioConstancia()) {
			podios += Integer.toString(x) + " ";
		}
		podios = podios.substring(0,podios.length() - 1);
		podios+="\n";
		
		for(Integer x: getPodioDistancia()) {
			podios += Integer.toString(x) + " ";
		}
		podios = podios.substring(0,podios.length() - 1);
		
	return podios;
	}
	
	private ArrayList<Integer> getPodioDistancia(){
		ArrayList<Integer> podioDistancia = new ArrayList<Integer>();
		
		
		
		return podioDistancia;
	}
	
	private ArrayList<Integer> getPodioConstancia(){
		ArrayList<Integer> podioConstancia = new ArrayList<Integer>();
		
		
		return podioConstancia;
	}
	
	
	public ArrayList<Lanzador> getLanzadores() {
		return lanzadores;
	}

	public void setLanzadores(ArrayList<Lanzador> lanzadores) {
		this.lanzadores = lanzadores;
	}

}