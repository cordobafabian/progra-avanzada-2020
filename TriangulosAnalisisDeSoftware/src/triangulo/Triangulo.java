package triangulo;

import java.util.Scanner;

public class Triangulo {
	private int l1;
	private int l2;
	private int l3;

	public Triangulo(int l1, int l2, int l3) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
	}

	public String clasificar() {

		if (l1 == l2 && l2 == l3) {
			return "Equilatero";
		}
		if (l1 != l2 && l1 != l3 && l2 != l3) {
			return "Escaleno";
		}
		return "Isosceles";

	}
	
	public static String clasificar(int l1, int l2, int l3) {

		if (l1 == l2 && l2 == l3) {
			return "Equilatero";
		}
		if (l1 != l2 && l1 != l3 && l2 != l3) {
			return "Escaleno";
		}
		return "Isosceles";

	}
	
	
	public static boolean esTriangulo(int l1, int l2, int l3) {
		return l1 > 0 && l2 > 0 && l3 > 0 && l1 + l2 > l3 && l1 + l3 > l2 && l2 + l3 > l1;
	}
	
	public static void main(String[] args) {
		int l1, l2, l3;
		Scanner reader = new Scanner(System.in);
		Triangulo triangulo;
		String respuestaObtenida = "No es triangulo";
		
		System.out.println("Ingrese los lados de un triangulo");
		
		l1 = reader.nextInt();
		l2 = reader.nextInt();
		l3 = reader.nextInt();

		if(Triangulo.esTriangulo(l1, l2, l3)) {
			triangulo = new Triangulo(l1, l2, l3);
			respuestaObtenida = triangulo.clasificar();
		}
		
		System.out.println(respuestaObtenida);
	}

}
