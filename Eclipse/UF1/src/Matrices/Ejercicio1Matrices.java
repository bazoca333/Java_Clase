package Matrices;
public class Ejercicio1Matrices {
public static void main(String[]args) {
	
	int[][] matriz = new int[3][3];
	
	matriz[0][0] = 1;
	matriz[0][1] = 1;
	matriz[1][1] = 1;
	matriz[2][2] = 1;
	
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz[i].length; j++) {
			System.out.print(matriz[i][j]);
		}
		System.out.println();
	}
}
}
