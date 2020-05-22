import java.util.HashMap;
import java.util.Map;

public abstract class Figura extends Pintable{
	
	public static final Double PI = 3.14;
	
	private String color;
	private Double areaCm2;
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Double getAreaCm2() {
		return areaCm2;
	}

	public void setAreaCm2(Double areaCm2) {
		this.areaCm2 = areaCm2;
	}
	
	@Override
	public Map<String, Double> calcularCantidad(){
		Map<String, Double> mapa = new HashMap<String, Double>();
		
		mapa.put(this.getColor(), this.getAreaCm2());
		
		return mapa;
	}
	
}
