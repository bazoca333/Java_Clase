package Matrices;
public class Ejercicio4Matrizes {
public static void main(String[]args) {

	int[][] matriz = new int[7][7];
	
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz[i].length; j++) {
			matriz[i][i] = 1;
			System.out.print(matriz[i][j]);
			System.out.print("  ");
		}
		System.out.println();
	}

}
}
