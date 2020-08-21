package robotito;

public class Este extends Direccion{
	
	
	public Este() {
		super('E');
	}
	
	@Override
	protected void girar(Robotito robotito, Character sentido) {
		
		if(sentido == 'H') {
			robotito.setDireccion(new Sur());
			robotito.aumentarCantidadDeInstrucciones();
			robotito.detenerMovimientos();
		}else {
			robotito.setDireccion(new Norte());
			robotito.aumentarCantidadDeInstrucciones();
		}
		
	}
	
}