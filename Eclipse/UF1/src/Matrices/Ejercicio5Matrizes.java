package Matrices;
import java.util.Random;

public class Ejercicio5Matrizes {
public static void main(String[]args) {
	
	Random rand = new Random();	
	int[][] matriz = new int[5][5];
	int numeros_sumados = 0;
	
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz[i].length; j++) {
			int int_random = rand.nextInt(10);
			matriz[i][j] = int_random;
			System.out.print(matriz[i][j]);
			numeros_sumados = numeros_sumados + matriz[i][j];
			System.out.print("  ");
		}
		System.out.print("=  " + numeros_sumados);
		System.out.println();
		numeros_sumados = 0;

	}
}
}
