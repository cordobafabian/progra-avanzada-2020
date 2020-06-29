package interfazgrafica;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingWorker;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import enums.Orden;
import enums.Ordenamiento;
import helpers.Arreglos;
import interfaces.RedibujarListener;
import ordenamientos.Estrategia;
import ordenamientos.Salida;
import ordenamientos.elementales.PorBurbujeo;
import ordenamientos.elementales.PorInsercion;
import ordenamientos.elementales.PorSeleccion;
import ordenamientos.noElementales.PorMergeSort;
import ordenamientos.noElementales.PorQuickSort;
import ordenamientos.noElementales.PorShellSort;

public class Visualizador extends JFrame implements RedibujarListener {

	private static final long serialVersionUID = 1L;
	private Integer[] elementos;
	private int velocidad;
	private int tamanio;
	private Orden casoSeleccionado;
	private Ordenamiento algoritmoSeleccionado;
	Estrategia<Integer> algoritmo;
	private final int tamanioDelGrafico;
	private int ancho;
	JPanel configJPanel;
	PanelGrafico panelGrafico;
	JLabel retardoJLabel;
	JLabel tiempoDeRetardoJLabel;
	JLabel tamanioJLabel;
	JLabel cantidadDeElementosJLabel;
	JLabel comparacionesJLabel;
	JLabel intercambiosJLabel;
	JLabel tiempoDeEjecucionJLabel;
	JLabel algoritmoJLabel;
	JComboBox<Ordenamiento> algoritmoJComboBox;
	JLabel ordenJLabel;
	JComboBox<Orden> ordenJComboBox;
	JButton ordenarJButton;
	JButton mezclarJButton;
	JButton stopJButton;
	JSlider tamanioJSlider;
	JSlider retardoJSlider;
	Border bordeDelPanelDeHerramientas;
	OrdenamientoWorker ordenamiento;
	Thread temporizador;
	Thread salidaHilo;
	private double tiempoInicial;
	private double tiempoTranscurrido;
	Salida salida;
	private JPanel infoJPanel;
	private JPanel botonesJPanel;
	Arreglos arreglos = new Arreglos();

	public Visualizador() {
		salida = new Salida("archivo.csv", ";");
		algoritmo = new PorBurbujeo<Integer>();
		velocidad = 15;
		tamanio = 50;
		casoSeleccionado = Orden.ALEATORIO;
		algoritmoSeleccionado = Ordenamiento.BURBUJEO;
		tamanioDelGrafico = 600;
		ancho = tamanioDelGrafico / tamanio;
		configJPanel = new JPanel();
		infoJPanel = new JPanel();
		botonesJPanel = new JPanel();
		retardoJLabel = new JLabel("Retardo :");
		tiempoDeRetardoJLabel = new JLabel(velocidad + " ms");
		tamanioJLabel = new JLabel("Tamaño :");
		cantidadDeElementosJLabel = new JLabel(tamanio + "");
		comparacionesJLabel = new JLabel("Comparaciones : " + 0);
		intercambiosJLabel = new JLabel("Intercambios : " + 0);
		tiempoDeEjecucionJLabel = new JLabel("Tiempo transcurrido: " + 0 + " ms");
		algoritmoJLabel = new JLabel("Algoritmos");
		algoritmoJComboBox = new JComboBox<Ordenamiento>(Ordenamiento.values());
		ordenJLabel = new JLabel("Orden");
		ordenJComboBox = new JComboBox<Orden>(Orden.values());
		ordenarJButton = new JButton("Ordenar");
		mezclarJButton = new JButton("Mezclar");
		tamanioJSlider = new JSlider(JSlider.HORIZONTAL, 5, 1000, tamanio);
		retardoJSlider = new JSlider(JSlider.HORIZONTAL, 0, 1000, velocidad);
		bordeDelPanelDeHerramientas = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		mezclarLista();
		inicializar();
	}

	public void mezclarLista() {
		if (ordenamiento != null) {
			ordenamiento.cancel();
		}
		elementos = arreglos.generarArray(casoSeleccionado, tamanio);
	}

	public void inicializar() {
		setSize(800, 600);
		setTitle("Visualizador de Ordenamientos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		infoJPanel.setLayout(null);
		infoJPanel.setBounds(10, 310, 200, 300);
		infoJPanel.setBorder(BorderFactory.createTitledBorder(bordeDelPanelDeHerramientas, "Información"));

		configJPanel.setLayout(null);
		configJPanel.setBounds(10, 15, 200, 300);
		configJPanel.setBorder(BorderFactory.createTitledBorder(bordeDelPanelDeHerramientas, "Configuración"));

		botonesJPanel.setLayout(null);
		botonesJPanel.setBounds(10, 15, 200, 100);

		algoritmoJLabel.setHorizontalAlignment(JLabel.CENTER);
		algoritmoJLabel.setBounds(75, 20, 100, 25);
		configJPanel.add(algoritmoJLabel);

		DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
		listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

		algoritmoJComboBox.setRenderer(listRenderer);
		algoritmoJComboBox.setBounds(30, 45, 190, 25);
		configJPanel.add(algoritmoJComboBox);

		ordenJLabel.setHorizontalAlignment(JLabel.CENTER);
		ordenJLabel.setBounds(75, 75, 100, 25);
		configJPanel.add(ordenJLabel);

		ordenJComboBox.setRenderer(listRenderer);
		ordenJComboBox.setBounds(30, 100, 190, 25);
		configJPanel.add(ordenJComboBox);

		ordenarJButton.setBounds(10, 10, 100, 25);
		botonesJPanel.add(ordenarJButton);

		mezclarJButton.setBounds(140, 10, 100, 25);
		botonesJPanel.add(mezclarJButton);

		retardoJLabel.setHorizontalAlignment(JLabel.LEFT);
		retardoJLabel.setBounds(10, 155, 60, 25);
		configJPanel.add(retardoJLabel);

		tiempoDeRetardoJLabel.setHorizontalAlignment(JLabel.LEFT);
		tiempoDeRetardoJLabel.setBounds(190, 155, 75, 25);
		configJPanel.add(tiempoDeRetardoJLabel);

		retardoJSlider.setMajorTickSpacing(5);
		retardoJSlider.setBounds(65, 155, 120, 25);
		retardoJSlider.setPaintTicks(false);
		configJPanel.add(retardoJSlider);

		tamanioJLabel.setHorizontalAlignment(JLabel.LEFT);
		tamanioJLabel.setBounds(10, 190, 60, 25);
		configJPanel.add(tamanioJLabel);

		cantidadDeElementosJLabel.setHorizontalAlignment(JLabel.LEFT);
		cantidadDeElementosJLabel.setBounds(190, 190, 50, 25);
		configJPanel.add(cantidadDeElementosJLabel);

		tamanioJSlider.setMajorTickSpacing(50);
		tamanioJSlider.setBounds(65, 190, 120, 25);
		tamanioJSlider.setPaintTicks(false);
		configJPanel.add(tamanioJSlider);

		comparacionesJLabel.setHorizontalAlignment(JLabel.LEFT);
		comparacionesJLabel.setBounds(10, 25, 200, 25);
		infoJPanel.add(comparacionesJLabel);

		intercambiosJLabel.setHorizontalAlignment(JLabel.LEFT);
		intercambiosJLabel.setBounds(10, 60, 200, 25);
		infoJPanel.add(intercambiosJLabel);

		tiempoDeEjecucionJLabel.setHorizontalAlignment(JLabel.LEFT);
		tiempoDeEjecucionJLabel.setBounds(10, 95, 230, 25);
		infoJPanel.add(tiempoDeEjecucionJLabel);

		panelGrafico = new PanelGrafico();
		panelGrafico.setBounds(190, 0, tamanioDelGrafico, tamanioDelGrafico);
		panelGrafico.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints configPanelConstraints = new GridBagConstraints();
		configPanelConstraints.ipadx = 250;
		configPanelConstraints.gridheight = 1;
		configPanelConstraints.ipady = 240;
		configPanelConstraints.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(configJPanel, configPanelConstraints);

		GridBagConstraints infoPanelConstraints = new GridBagConstraints();
		infoPanelConstraints.gridy = 2;
		infoPanelConstraints.ipadx = 250;
		infoPanelConstraints.gridheight = 1;
		infoPanelConstraints.ipady = 130;
		infoPanelConstraints.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(infoJPanel, infoPanelConstraints);

		GridBagConstraints graficoPanelConstraints = new GridBagConstraints();
		graficoPanelConstraints.weightx = 1;
		graficoPanelConstraints.weighty = 1;
		graficoPanelConstraints.fill = GridBagConstraints.BOTH;
		graficoPanelConstraints.gridx = 1;
		graficoPanelConstraints.gridheight = 3;
		getContentPane().add(panelGrafico, graficoPanelConstraints);

		GridBagConstraints botonesPanelConstraints = new GridBagConstraints();
		botonesPanelConstraints.gridy = 1;
		botonesPanelConstraints.ipadx = 250;
		botonesPanelConstraints.gridheight = 1;
		botonesPanelConstraints.gridx = 0;
		botonesPanelConstraints.ipady = 65;
		botonesPanelConstraints.anchor = GridBagConstraints.NORTHWEST;
		getContentPane().add(botonesJPanel, botonesPanelConstraints);

		algoritmo.addListener(this);
		algoritmoJComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				algoritmoSeleccionado = (Ordenamiento) algoritmoJComboBox.getSelectedItem();
			}

		});
		ordenJComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				casoSeleccionado = (Orden) ordenJComboBox.getSelectedItem();
				mezclarLista();
				reiniciar();
			}

		});

		ordenarJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (ordenamiento == null || ordenamiento.isDone()) {
					ordenarJButton.setText("Detener");
					mezclarJButton.setEnabled(false);
					ordenJComboBox.setEnabled(false);
					algoritmoJComboBox.setEnabled(false);
					tamanioJSlider.setEnabled(false);
					ordenar();
				} else {
					reiniciar();
				}
			}
		});

		mezclarJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mezclarLista();
				reiniciar();
			}
		});
		retardoJSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				velocidad = (int) retardoJSlider.getValue();
				if (algoritmo != null) {
					algoritmo.setRetardo(velocidad);
				}
				tiempoDeRetardoJLabel.setText(algoritmo.getRetardo() + " ms");
			}
		});
		tamanioJSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				int val = tamanioJSlider.getValue();
				tamanio = val;
				cantidadDeElementosJLabel.setText(Integer.toString(tamanio));
				if (elementos.length != tamanio)
					mezclarLista();
				reiniciar();
			}

		});
		reiniciar();
	}

	public void ordenar() {

		try {
			switch (algoritmoSeleccionado) {

			case BURBUJEO:
				algoritmo = new PorBurbujeo<Integer>();
				break;
			case SELECCION:
				algoritmo = new PorSeleccion<Integer>();
				break;
			case INSERCION:
				algoritmo = new PorInsercion<Integer>();
				break;
			case MERGE_SORT:
				algoritmo = new PorMergeSort<Integer>();
				break;
			case QUICK_SORT:
				algoritmo = new PorQuickSort<Integer>();
				break;
			case SHELL_SORT:
				algoritmo = new PorShellSort<Integer>();
				break;
			}

			algoritmo.addListener(this);
			ordenamiento = new OrdenamientoWorker();
			tiempoInicial = System.nanoTime();
			ordenamiento.execute();
			;
		} catch (IndexOutOfBoundsException e) {
		}
	}

	public void reiniciar() {
		if (ordenamiento != null) {
			ordenamiento.cancel();
		}
		tiempoInicial = 0;
		actualizar(elementos, null, -1, null);
	}

	public void actualizar(Integer[] arreglo, int[] check, int current, int[] ordenados) {

		double tiempoFinal = System.nanoTime();

		ancho = tamanioDelGrafico / arreglo.length;
		elementos = arreglo;
		panelGrafico.actualizar(arreglo, current, ancho, check, ordenados);
		panelGrafico.repaint();
		comparacionesJLabel.setText("Comparaciones : " + algoritmo.getCantidadDeComparaciones());
		intercambiosJLabel.setText("Intercambios: " + algoritmo.getCantidadDeIntercambios());
		tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000000;
		if (tiempoInicial > 0) {
			tiempoDeEjecucionJLabel.setText(String.format("Tiempo transcurrido: %.2f ms", tiempoTranscurrido));
		}
	}

	@Override
	public <T> void solicitudRedibujar(T[] arreglo, int[] check, int current, int[] ordenados) {
		actualizar((Integer[]) arreglo, check, current, ordenados);
	}

	class OrdenamientoWorker extends SwingWorker<Void, Void> {
		String estado;

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public void cancel() {
			try {
				algoritmo.stop();
				if (!isCancelled()) {
					cancel(true);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

		}

		@Override
		protected Void doInBackground() throws Exception {
			algoritmo.setRetardo(velocidad);
			try {
				elementos = algoritmo.ordenar(elementos);
			} catch (Exception e) {
				estado = "Error";
				System.err.println(e.getMessage());
			}
			return null;
		}

		@Override
		public void done() {
			try {
				if (!isCancelled()) {
					estado = "Ordenado";
				} else {
					estado = "Cancelado";
				}
			} catch (Exception e) {
				estado = "Error";
				System.err.println(e.getMessage());
			}
			ordenarJButton.setText("Ordenar");
			mezclarJButton.setEnabled(true);
			ordenJComboBox.setEnabled(true);
			algoritmoJComboBox.setEnabled(true);
			tamanioJSlider.setEnabled(true);
			salida.escribirCSV(algoritmoSeleccionado.toString(), casoSeleccionado.toString(), Integer.toString(tamanio),
					String.format(Locale.ROOT, "%.4f", tiempoTranscurrido / 1000), estado);
		}
	}
}
