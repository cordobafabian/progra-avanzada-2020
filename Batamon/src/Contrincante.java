import java.util.ArrayList;
import java.util.Iterator;

public class Contrincante{
	
	private ArrayList<Monstruo> monstruos;
	private int victorias;
	
	public Contrincante() {
		this.monstruos = new ArrayList<Monstruo>();
		this.victorias = 0;
	}

	public ArrayList<Monstruo> getMonstruos() {
		return monstruos;
	}

	public void setMonstruos(ArrayList<Monstruo> monstruos) {
		this.monstruos = monstruos;
	}
	
	public void agregarMonstruo(Monstruo obj) {
		monstruos.add(obj);
	}
	
	public void ordenarPorPoderDescendente() {
		this.monstruos.sort(new ComparatorPoderDescendente());
	}
	
	public int getVictorias() {
		return victorias;
	}

	public void agregarNuevaVictoria() {
		this.victorias++;
	}

	public int cantidadDeMonstruos() {
		return this.monstruos.size();
	}
	
	public Monstruo getMonstruoNumero(int numero) {
		return monstruos.get(numero);
	}
	
}
