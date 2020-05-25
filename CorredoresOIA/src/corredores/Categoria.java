package corredores;

import java.util.ArrayList;

public class Categoria {
	
	private int numero;
	private String sexo;
	private int menorEdad;
	private int mayorEdad;
	private ArrayList<Corredor> corredores;
	
	public Categoria(int numero, String sexo, int menorEdad, int mayorEdad) {
		this.numero = numero;
		this.sexo = sexo;
		this.menorEdad = menorEdad;
		this.mayorEdad = mayorEdad;
		this.corredores = new ArrayList<Corredor>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getMenorEdad() {
		return menorEdad;
	}

	public void setMenorEdad(int menorEdad) {
		this.menorEdad = menorEdad;
	}

	public int getMayorEdad() {
		return mayorEdad;
	}

	public void setMayorEdad(int mayorEdad) {
		this.mayorEdad = mayorEdad;
	}

	public ArrayList<Corredor> getCorredores() {
		return corredores;
	}

	public void setCorredores(ArrayList<Corredor> corredores) {
		this.corredores = corredores;
	}
	
	public void add(Corredor obj) {
		this.corredores.add(obj);
	}
	
	public boolean pertenece(Corredor obj) {
		return this.menorEdad <= obj.getEdad() && obj.getEdad()<= this.mayorEdad;
	}

	@Override
	public String toString() {
		String cadena = Integer.toString(this.getNumero())+" ";
		
		int i=0;
		while(i<3 && i<this.corredores.size()) {
			cadena += this.corredores.get(i).toString() + " ";
			i++;
		}
		
		int j = 3 - i;
		while( j>0 ) {
			cadena += "0 ";
			j--;
		}
		
		return cadena.trim();
	}
	
	
	
}
