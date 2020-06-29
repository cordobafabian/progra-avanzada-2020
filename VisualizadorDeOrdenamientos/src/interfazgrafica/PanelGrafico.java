package interfazgrafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class PanelGrafico extends JPanel {

	private static final long serialVersionUID = 1L;
	private Integer[] arreglo;
	private int actual;
	private int[] comparados;
	private int[] ordenados;

	public void actualizar(Integer[] arreglo, int actual, int ancho, int[] comparados, int[] ordenados) {

		this.arreglo = arreglo;
		this.actual = actual;
		this.comparados = comparados;
		this.ordenados = ordenados;
	}

	public PanelGrafico() {
		setBackground(Color.black);
	}

	public void paintComponent(Graphics g) {
		try {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			for (int i = 0; i < arreglo.length; i++) {
				double HEIGHT = arreglo[i] * ((double) this.getHeight() / arreglo.length); // SETEA LA ALTURA DE LAS
																							// BARRAS EN EL GRAFICO
				g2.setColor(Color.white); // COLOR POR DEFECTO

				if (ordenados != null) {
					for (int j : ordenados) {
						if (i == j) {
							g2.setColor(Color.magenta); // COLOR DE LOS ELEMENTOS ORDENADOS
						}
					}
				}
				if (comparados != null) {
					for (int j : comparados) {
						if (i == j) {
							g2.setColor(Color.red); // COLOR DE LOS ELEMENTOS QUE ESTA COMPARANDO
						}
					}
				}

				if (actual > -1 && i == actual) {
					g2.setColor(Color.green); // COLOR DEL ACTUAL
				}

				// DIBUJA LAS BARRAS Y SU CONTORNO
				double x = i * ((double) this.getWidth() / arreglo.length);
				double y = this.getHeight() - HEIGHT;
				double w = (double) this.getWidth() / arreglo.length;
				double h = HEIGHT;
				Rectangle2D rectangulo = new Rectangle2D.Double(x, y, w, h);

				g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
				g2.fill(rectangulo);
				g2.setColor(Color.black);
				g2.draw(rectangulo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
