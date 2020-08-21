package robotito;

public class Norte extends Direccion{
	
	public Norte() {
		super('N');
	}
	
	@Override
	protected void girar(Robotito robotito, Character sentido) {
		
		if(sentido == 'H') {
			robotito.setDireccion(new Este());
		}else {
			robotito.setDireccion(new Oeste());
			
		}
		
		robotito.aumentarCantidadDeInstrucciones();
		
	}
	
}
