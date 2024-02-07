package Matrices;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio3Matrizes {
public static void main(String[]args) {
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	
	System.out.println("Dime cuantos números quieres que sea de larga la matriz?");
	int numero = scan.nextInt();
	int[][] matriz = new int[5][numero];
	
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz[i].length; j++) {
			int int_random = rand.nextInt(10);
			matriz[i][j] = int_random;
			System.out.print(matriz[i][j]);
			System.out.print("  ");
		}
		System.out.println();
	}
}
}
