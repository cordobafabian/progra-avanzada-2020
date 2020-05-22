import java.util.ArrayList;
import java.util.Map;

public class Dibujo extends Pintable{
	
	private ArrayList<Pintable> elementos;
	
	public Dibujo() {
		this.elementos = new ArrayList<Pintable>();
	}
	
	public void agregar(Pintable pintable) {
		this.elementos.add(pintable);
	}
	
	@Override
	public Map<String, Double> calcularCantidad() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
