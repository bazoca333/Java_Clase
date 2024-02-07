package Matrices;
import java.util.Scanner;

public class Ejercicio6Matrizes {
public static void main(String[]args) {
	Scanner scan = new Scanner(System.in);
	
	int[][] matriz = new int[5][5];
	int numeros_sumados = 0;

	
	for (int i = 0; i < matriz.length; i++) {
		System.out.println("Dame 3 valores para ponerlos en la línea " + i + " de la matriz");
		for (int j = 0; j < matriz[i].length; j++) {
			matriz[i][j] = scan.nextInt();
		}
	}
	
	
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz[i].length; j++) {
			System.out.print(matriz[j][i]);
			numeros_sumados = numeros_sumados + matriz[i][j];
			System.out.print("  ");
		}
		System.out.println("Columna " + i + " tiene como resultado " + numeros_sumados);
		numeros_sumados = 0;

	}
}
}
