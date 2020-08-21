package robotito;

public class Oeste extends Direccion{
	
	public Oeste() {
		super('O');
	}
	
	@Override
	protected void girar(Robotito robotito, Character sentido) {
		
		if(sentido == 'H') {
			robotito.setDireccion(new Norte());
			robotito.aumentarCantidadDeInstrucciones();
		}else {
			robotito.setDireccion(new Sur());
			robotito.aumentarCantidadDeInstrucciones();
			robotito.detenerMovimientos();
		}
		
	}
	
}