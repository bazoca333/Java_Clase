package Clases;
import java.util.Scanner;

public class Tres_en_Java {
	public static void main(String[] args) {

		// Defino los jugadores
		String p1 = "[x]";
		String p2 = "[o]";

		int fila = 0;
		int columna = 0;

		int turno = 1;
		int ganador = 0;

		// Creo la matriz
		String matriz[][] = { { "[1]", "[2]", "[3]" }, { "[4]", "[5]", "[6]" }, { "[7]", "[8]", "[9]" } };

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

		// Hacer bucle
		boolean fin = false;
		while (fin == false) {

			// Ver si el tablero está lleno
			int fichastablero = 0;
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					if (!matriz[i][j].equals(p1) && !matriz[i][j].equals(p2)) {
						i = 2;
						j = 2;
					} else {
						fichastablero++;
						if (fichastablero >= 9) {
							fin = true;
						}
					}

				}
			}
			if (fin == false) {
				// Pido al usuario los datos
				Scanner scan = new Scanner(System.in);
				int eleccion = 0;
				boolean cVacia = false;
				while (cVacia == false) {

					System.out.println("Jugador " + turno + " elija dónde quiere poner su ficha");
					boolean finEleccion = false;
					while (finEleccion == false) {
						eleccion = scan.nextInt();
						if (eleccion == 1) {
							fila = 0;
							columna = 0;
							finEleccion = true;
						} else if (eleccion == 2) {
							fila = 1;
							columna = 0;
							finEleccion = true;
						} else if (eleccion == 3) {
							fila = 2;
							columna = 0;
							finEleccion = true;
						} else if (eleccion == 4) {
							fila = 0;
							columna = 1;
							finEleccion = true;
						} else if (eleccion == 5) {
							fila = 1;
							columna = 1;
							finEleccion = true;
						} else if (eleccion == 6) {
							fila = 2;
							columna = 1;
							finEleccion = true;
						} else if (eleccion == 7) {
							fila = 0;
							columna = 2;
							finEleccion = true;
						} else if (eleccion == 8) {
							fila = 1;
							columna = 2;
							finEleccion = true;
						} else if (eleccion == 9) {
							fila = 2;
							columna = 2;
							finEleccion = true;
						} else {
							System.out.println("Casilla no válida");
						}

					}

					if (matriz[columna][fila].equals(p1) || matriz[columna][fila].equals(p2)) {
						System.out.println("La casilla está ocupada!!!");
					} else {
						cVacia = true;
					}
				}

				// Hago que se rellene la matriz
				String simbolo = "";
				if (turno == 1) {
					simbolo = p1;
				} else {
					simbolo = p2;
				}

				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						matriz[columna][fila] = simbolo;
					}
				}

				// Checkear algoritmo ganador
				int check = 0;
				// Horizontal
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {

						if (matriz[i][j].equals(simbolo)) {
							check++;
						}
					}
					if (check == 3) {
						fin = true;
						if (matriz[i][0].equals(p1)) {
							ganador = 1;
						} else {
							ganador = 2;
						}
					}
					check = 0;
				}

				// Vertical
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz.length; j++) {

						if (matriz[j][i].equals(simbolo)) {
							check++;
						}
					}
					if (check == 3) {
						fin = true;
						if (matriz[0][i].equals(p1)) {
							ganador = 1;
						} else {
							ganador = 2;
						}
					}
					check = 0;
				}
				// Diagonal 1
				for (int i = 0; i < matriz.length; i++) {
					if (matriz[i][i].equals(simbolo)) {
						check++;
					}
				}
				if (check == 3) {
					fin = true;
					if (simbolo.equals(p1)) {
						ganador = 1;
					} else {
						ganador = 2;
					}
				}

				check = 0;

				// Diagonal 2
				for (int i = 0; i < matriz.length; i++) {
					if (matriz[i][matriz.length - 1 - i].equals(simbolo)) {
						check++;
					}
				}
				if (check == matriz.length) {
					fin = true;
					if (simbolo.equals(p1)) {
						ganador = 1;
					} else {
						ganador = 2;
					}
				}
				check = 0;

				// Imprimir

				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						System.out.print(matriz[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}

				// Resetear valores
				if (turno == 1) {
					turno = 2;
				} else {
					turno = 1;
				}

				fila = 0;
				columna = 0;

			}
		}

		if (ganador == 0) {
			System.out.println("Empate!");

		} else {
			System.out.println("El ganador es: Jugador " + ganador);

		}

	}
}