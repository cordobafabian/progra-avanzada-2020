package secuencia;

public class LongitudesNoCoincidentesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "La cantidad de cifras de un numero no coincide con la cantidad informada";
	}
	
	
}
