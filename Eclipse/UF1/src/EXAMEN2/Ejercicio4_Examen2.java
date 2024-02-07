package EXAMEN2;

import java.util.Scanner;

public class Ejercicio4_Examen2 {
	public static void main(String[] args) {

		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		// Creo el array de palabras con la longitud que dice el usuario
		System.out.println("Cuantas palabras quieres poner?");
		int palabras = scan1.nextInt();
		String[] array = new String[palabras];

		// defino las variables mas largas y mas cortas
		String masLargo = "";
		String masCorto = "";
		int medialetras = 0;
		for (int i = 0; i < array.length; i++) {
			System.out.println("Palabras obtenidas: " + i + "/" + palabras);
			String palabra = scan2.nextLine();
			array[i] = palabra;
			// hago la media
			medialetras = medialetras + (palabra.length() / 2);

			// Busco constantemente la palabra más larga
			if (masLargo.equals("")) {
				masLargo = palabra;
			} else if (palabra.length() > masLargo.length()) {
				masLargo = palabra;
			}
			// Busco constantemente la palabra más corta
			if (masCorto.equals("")) {
				masCorto = palabra;
			} else if (palabra.length() < masCorto.length()) {
				masCorto = palabra;
			}

		}

		// Imprimo
		System.out.println("La media de las palabras ofrecidas es: " + medialetras);
		System.out.println("La palabra más larga es: " + masLargo);
		System.out.println("La palabra más corta es: " + masCorto);
	}
}
