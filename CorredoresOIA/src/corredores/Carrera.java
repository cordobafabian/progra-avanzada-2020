package corredores;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carrera {

	private ArrayList<Categoria> mujeres;
	private ArrayList<Categoria> hombres;
	private List<Corredor> corredores;

	public Carrera() {
		this.mujeres = new ArrayList<Categoria>();
		this.hombres = new ArrayList<Categoria>();
		this.corredores = new ArrayList<Corredor>();
	}

	public void cargarCategorias(String pathArchivo) {

		Scanner lector = null;

		try {
			lector = new Scanner(new FileReader(pathArchivo));

			int cantidadCompetidores = lector.nextInt();
			int cantidadCategoriasMujeres = lector.nextInt();
			int cantidadCategoriasHombres = lector.nextInt();
			int cantidadQueLlegoAMeta = lector.nextInt();

			for (int i = 1; i <= cantidadCategoriasMujeres; i++) {
				this.mujeres.add(new Categoria(i, "F", lector.nextInt(), lector.nextInt()));
			}

			for (int i = 1; i <= cantidadCategoriasHombres; i++) {
				this.hombres.add(new Categoria(i, "M", lector.nextInt(), lector.nextInt()));
			}

			for (int i = 1; i <= cantidadCompetidores; i++) {
				Corredor corredor = new Corredor(i, lector.nextInt(), lector.nextLine().trim());
				corredores.add(corredor);
			}
			
			for(int i=1; i <= cantidadQueLlegoAMeta; i++ ) {
				this.categorizarCorredor(corredores.get(lector.nextInt()-1));	
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			if (lector != null) {
				lector.close();
			}
		}
	}

	public void categorizarCorredor(Corredor corredor) {
		if (corredor.getSexo().equals("F")) {
			int j = 0;
			while (j < mujeres.size()) {

				if (mujeres.get(j).pertenece(corredor)) {
					mujeres.get(j).add(corredor);
				}
				j++;

			}
		}

		if (corredor.getSexo().equals("M")) {
			int j = 0;
			while (j < hombres.size()) {

				if (hombres.get(j).pertenece(corredor)) {
					hombres.get(j).add(corredor);
				}
				j++;

			}
		}
	}

	public ArrayList<Categoria> getMujeres() {
		return mujeres;
	}

	public void setMujeres(ArrayList<Categoria> mujeres) {
		this.mujeres = mujeres;
	}

	public ArrayList<Categoria> getHombres() {
		return hombres;
	}

	public void setHombres(ArrayList<Categoria> hombres) {
		this.hombres = hombres;
	}

	public List<Corredor> getCorredores() {
		return corredores;
	}

	public void setCorredores(ArrayList<Corredor> corredores) {
		this.corredores = corredores;
	}
	
	@Override
	public String toString() {
		String retorno = "";
		
		for(Categoria categoria : this.mujeres) {
			retorno += categoria.toString()+"\n";
		}
		
		for(Categoria categoria : this.hombres) {
			retorno += categoria.toString()+"\n";
		}
		
		return retorno;
	}
	
	public void escribirArchivo(String pathArchivo) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(pathArchivo));
			bw.write(this.toString());
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
