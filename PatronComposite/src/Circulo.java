
public class Circulo extends Figura{

	public Circulo(String color, Double radio){
		this.setColor(color);
		this.setAreaCm2(Figura.PI * radio);
	}
}