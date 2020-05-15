
public class Lanzamiento {
	private double distanciaRecorrida;
	private double angulo;
	private double distanciaCalculada;

	public Lanzamiento() {
		this.distanciaRecorrida = 0;
		this.angulo = 0;
		this.distanciaCalculada = 0;
	}

	public Lanzamiento(double distanciaRecorrida, double angulo) {
		setDistanciaRecorrida(distanciaRecorrida);
		setAngulo(angulo);
		setDistanciaCalculada();
	}

	public double getDistanciaCalculada() {
		return distanciaCalculada;
	}

	private void setDistanciaCalculada() {
		this.distanciaCalculada = getDistanciaEfectiva(this.distanciaRecorrida, this.angulo);
	}

	private double getDistanciaEfectiva(double distanciaRecorrida, double angulo) {
		double resultado;

		if ((angulo >= -30 && angulo <= 30) || (angulo >= 330 && angulo <= 360) || (angulo >= -360 && angulo <= -330)) {
			resultado = distanciaRecorrida;
		} else {
			if ((angulo > 30 && angulo <= 90) || (angulo >= 270 && angulo < 330) || (angulo >= -90 && angulo < -30)
					|| (angulo >= -330 && angulo < -270)) {
				resultado = distanciaRecorrida * 80 / 100;
			} else {
				resultado = 0;
			}
		}
		return resultado;
	}

	public boolean esValido() {
		return ((angulo >= -90 && angulo <= 90) || (angulo >= 270 && angulo <= 360))? true : false;
	}

	public double getDistanciaRecorrida() {
		return distanciaRecorrida;
	}

	public void setDistanciaRecorrida(double distanciaRecorrida) {
		this.distanciaRecorrida = distanciaRecorrida;
	}

	public double getAngulo() {
		return angulo;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

}
