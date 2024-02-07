package Matrices;

public class Ejercicio7Matrices {
public static void main(String[]args) {
	
	int[][] matriz = new int[5][5];
	
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz[i].length; j++) {
			matriz[i][j] = i+j;
			System.out.print(matriz[i][j]);
			System.out.print("  ");
		}
		System.out.println();
	}
}
}
