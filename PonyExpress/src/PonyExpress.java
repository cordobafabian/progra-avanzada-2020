
public class PonyExpress {
	/**
	 * Cada jinete viaja tan lejos como puede, pero nunca lo hace más de 100 millas
	 * seguidas
	 */
	public static int MAX_DISTANCIA = 100;

	/**
	 * @param estaciones es la distancia en millas de una estación hasta la otra
	 * @returns la cantidad de jinetes necesarios para enviar el correo desde un
	 *          extremo hasta el otro del recorrido
	 */
	public static int jinetes(int[] estaciones) {
		int i = 0, recorrido = 0, cantidadJinetes = 1;

		while (i < estaciones.length) {

			while (recorrido < MAX_DISTANCIA && i < estaciones.length) {
				recorrido += estaciones[i];
				i++;
			}

			if (recorrido >= MAX_DISTANCIA && i <= estaciones.length) {
				cantidadJinetes++;
				recorrido = 0;
				i--;
			}
		}

		return cantidadJinetes;
	}

}
