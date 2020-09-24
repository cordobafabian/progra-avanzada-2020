package mccabe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CCMcCabe {
	private int cc;
	private int cc2;
	private List<String> lineas;
	private final String[] DECISIONES = { " if(", " if ", " while ", " while(", "}while", "	if(", "	if ", "	while ", "	while(" };
	private final String[] COMPARACIONES = {"==", "<", ">", "!" };
	private final String[] CONTROLES = {" switch(", " switch ", " for(", " for ","	switch(", "	switch ", "	for(", "	for " };
	private final String[] BOOLEANOS = { "&&", "||"};
	

	public CCMcCabe(String stringPathJava) throws IOException {
		//lineas = Files.readAllLines(Paths.get(stringPathJava));
		lineas = new ArrayList<String>();
		cargarLineas(stringPathJava);
		cc = 0;
	}

	private void cargarLineas(String stringPathJava) throws IOException {
		Scanner sc = null;
		
		try {
			sc = new Scanner(new FileReader(new File(stringPathJava)));
			while(sc.hasNext()) {
				lineas.add(sc.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sc != null)
				sc.close();
		}
		
	}

	public int calcularCC() {
		for (String linea : lineas) {
			contarNodoPredicado(linea);
		}

		return ++cc;
	}

	private void contarNodoPredicado(String linea) {
		int resultado = 0, i = 0;
		
		while(resultado==0 && i < CONTROLES.length) {
			if (linea.contains(CONTROLES[i])) {
				cc ++;
				resultado = cc;
				
			}
		i++;
		}
		
		i=0;
		while (resultado == 0 && i < DECISIONES.length) {
			if (linea.contains(DECISIONES[i])) {
				int contadorComparaciones = contarComparaciones(linea);
				if (contadorComparaciones == 0)
					contadorComparaciones = 1;

				cc += contadorComparaciones;
				resultado = cc;
			}else {
				cc += contarComparaciones(linea);
				resultado = cc;
			}
		i++;
		}
		
	}

	private int contarComparaciones(String linea) {
		int contador = 0;

		for (String comparador : COMPARACIONES) {
			while (linea.indexOf(comparador) > -1) {
				linea = linea.substring(linea.indexOf(comparador) + comparador.length(), linea.length());
				contador++;
			}
		}

		return contador;
	}
	
	///////////////////////////////////////////////////////////////7
	public int calcularCC2() {
		for (String linea : lineas) {
			contarNodoPredicado2(linea);
		}

		return ++cc;
	}
	
	private void contarNodoPredicado2(String linea) {
		int resultado = 0;
		int i = 0;
		while(resultado==0 && i < CONTROLES.length) {
			if (linea.contains(CONTROLES[i])) {
				cc ++;
				resultado = cc;
				
			}
		i++;
		}
		
		i=0;
		while (resultado == 0 && i < DECISIONES.length) {
			if (linea.contains(DECISIONES[i])) {
				int contadorOperadoresBooleanos = contarOperadoresBooleanos(linea);
				cc += ++contadorOperadoresBooleanos;
				resultado = cc;
			}
		i++;
		}
		
		
	if(resultado == 0)
		cc += contarPredicadosEnTernaria(linea);
		
	}


	private int contarOperadoresBooleanos(String linea) {
		int contador = 0;

		for (String booleano : BOOLEANOS) {
			while (linea.indexOf(booleano) > -1) {
				linea = linea.substring(linea.indexOf(booleano) + booleano.length(), linea.length());
				contador++;
			}
		}

		return contador;
	}
	
	private int contarPredicadosEnTernaria(String linea) {
		int contadorDeInterrogantes = contarInterrogantes(linea);
		return contadorDeInterrogantes>0 ? contadorDeInterrogantes + contarOperadoresBooleanos(linea):0;
	}

	private int contarInterrogantes(String linea) {
		int contador = 0;
		String operador = "?";

			while (linea.indexOf(operador) > -1) {
				linea = linea.substring(linea.indexOf('?') + operador.length(), linea.length());
				contador++;
			}

		return contador;
	}
}
