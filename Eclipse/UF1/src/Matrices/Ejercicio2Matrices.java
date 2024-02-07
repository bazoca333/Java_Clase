package Matrices;
import java.util.Scanner;

public class Ejercicio2Matrices {
public static void main(String[]args) {
	
	Scanner scan = new Scanner(System.in);
	int[][] matriz = new int[3][3];
	
	for (int i = 0; i < matriz.length; i++) {
		System.out.println("Dame 3 valores para ponerlos en la línea " + i + " de la matriz");
		for (int j = 0; j < matriz[i].length; j++) {
			int numero = scan.nextInt();
			matriz[i][j] = numero;
		}
	}
	
	System.out.println("La matriz ha quedado así:");
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz[i].length; j++) {
			System.out.print(matriz[i][j]);
			System.out.print("  ");
		}
		System.out.println();
	}
	
}
}
