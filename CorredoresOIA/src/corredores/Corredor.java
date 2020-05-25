package corredores;

public class Corredor {
	
	private int numero;
	private int edad;
	private String sexo;
	
	public Corredor(int numero, int edad, String sexo) {
		this.numero = numero;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public String toString() {

		return Integer.toString(this.numero);
	}
	
}
