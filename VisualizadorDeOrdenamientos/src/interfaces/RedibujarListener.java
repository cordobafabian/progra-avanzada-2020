package interfaces;

public interface RedibujarListener {
	<T> void solicitudRedibujar(T[] arreglo, int[] comparados, int actual, int[] ordenados);
}
