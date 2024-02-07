package EXAMEN2;

import java.util.Scanner;

public class pentavocalicas {
	public static void main(String[] args) {

		// Poner las variables necesarias, como el input y las palabras
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Cuantas palabras quieres poner?");
		int palabras = scan1.nextInt();
		String[] array = new String[palabras];

		int contador = 0;
		int numeroPalabras = palabras;
		while (contador != palabras) {
			System.out.println("Palabras restantes: " + numeroPalabras);
			String palabra = scan2.nextLine();
			palabra.toLowerCase();

			// Analizar las palabras y ver si contienen las 5 vocales
			if (palabra.contains("ñ") || palabra.length() > 30) {
				System.out.println(
						"La palabra no es válida, recuerda que no tiene que ser mayor de 30 letras ni debe contener Ñ");
			} else {
				array[contador] = palabra;
				contador++;
				numeroPalabras--;
			}
		}

		// Crear e imprimir SI/NO
		String[] arraySINO = new String[palabras];
		for (int i = 0; i < arraySINO.length; i++) {
			if (array[i].contains("a") && array[i].contains("e") && array[i].contains("i") && array[i].contains("o")
					&& array[i].contains("u")) {
				arraySINO[i] = "SI";
			} else {
				arraySINO[i] = "NO";
			}
		}

		for (int i = 0; i < arraySINO.length; i++) {
			System.out.println(arraySINO[i]);
		}
	}
}
