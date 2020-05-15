import java.util.ArrayList;

public class ProcesarStrings {
	
	private String cadenaTipeada;
	private ArrayList<String> palabrasClave = null;
	private final String[] PALABRAS_A_OMITIR = {"en","hacia","hasta","para","por", "a", "de", "del", "con", "la", "el", "lo", "los", "las", "contra", "quiero"};
	
	
	public ProcesarStrings(String cadenaTipeada) {
		this.cadenaTipeada = cadenaTipeada.trim();
		this.palabrasClave = this.dividirCadena();
		//this.palabrasClave = this.descartarPalabras();
	}
	
	public String getCadenaTipeada() {
		return cadenaTipeada;
	}
	public void setCadenaTipeada(String cadenaTipeada) {
		this.cadenaTipeada = cadenaTipeada.trim();
	}
	public ArrayList<String> getPalabrasClave() {
		return palabrasClave;
	}
	public void setPalabrasClave(ArrayList<String> palabrasClave) {
		this.palabrasClave = palabrasClave;
	}
	
	private ArrayList<String> dividirCadena(){
		ArrayList<String> palabrasClave = new ArrayList<String>();
		
		//String[] vecAux = this.getCadenaTipeada().split("\\s");
		//String[] vecAux = this.getCadenaTipeada().split("\\s", 2);
		String[] vecAux = this.getCadenaTipeada().split(" ");
		//String[] vecAux = this.getCadenaTipeada().split(" ", 2);
		
		for(int i=0; i<vecAux.length; i++) {
			if(!ignorarPalabra(vecAux[i].trim())) {
				palabrasClave.add(vecAux[i].trim());
			}
				
		}
		return palabrasClave;		
	}
	
	/**
	private ArrayList<String> descartarPalabras(){
		
		ArrayList<String> palabras = this.getPalabrasClave();
		
		for(int i=0; i < palabras.size(); i++) {
			if(ignorarPalabra( palabras.get(i) )) {
				palabras.remove(i);
			}
			
		}
	return palabras; 	
	}
	
	**/
	
	private boolean ignorarPalabra(String palabra) {
		boolean ignorar = false;
		int i=0;
		
		while(i < PALABRAS_A_OMITIR.length && ignorar == false) {
			ignorar = palabra.equals(PALABRAS_A_OMITIR[i]);
			i++;
		}
		
		return ignorar;
	}
	

}
