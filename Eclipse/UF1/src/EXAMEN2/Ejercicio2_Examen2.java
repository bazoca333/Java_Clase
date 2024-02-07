package EXAMEN2;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio2_Examen2 {
	public static void main(String[] args) {

		// Definir la matriz con el número introducido por el usuario
		Scanner scan = new Scanner(System.in);
		Scanner scan_s = new Scanner(System.in);

		System.out.println("Vamos a crear una matriz con un tamaño de NxN, define el valor de N");
		int matrizsize = scan.nextInt();
		// matriz que se crea con el tamaño del numero que le damos
		int[][] matriz = new int[matrizsize][matrizsize];

		// Hago un loop para que veas los resultados
		boolean fin = false;
		while (fin == false) {

			Random random = new Random();
			// Rellenar la matriz con números aleatorios entre 0 y 50 y mostrar la matriz
			// por pantalla
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int int_random = random.nextInt(50);
					matriz[i][j] = int_random;
				}
			}

			System.out.println("Qué apartado quieres ver, el A, B o C? pon 'fin' para terminar");
			String eleccion = scan_s.nextLine().toUpperCase();
			if (eleccion.equals("A")) {
				// imprime
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						System.out.print(matriz[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
			} else if (eleccion.equals("B")) {
				// Forzar y determinar si todas las posiciones de la matriz donde el índice i
				// (número de
				// fila) es menor al índice j (número de la columna) tienen un valor de 0.

				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						if (i < j) {
							matriz[i][j] = 0;
						}
					}
				}

				// imprime
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						System.out.print(matriz[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
			} else if (eleccion.equals("C")) {
				// Ahora, forzar y determinar si todas las posiciones de la matriz donde el
				// índice i
				// (número de fila) es mayor al índice j (número de la columna) tienen un valor
				// de 0.

				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						if (i > j) {
							matriz[i][j] = 0;
						}
					}
				}
				// imprime
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						System.out.print(matriz[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
			} else if (eleccion.equals("FIN")) {
				fin = true;
			} else {
				System.out.println("Por favor, escriba las letras mostradas en pantalla");
			}

		}

	}
}
