package Arrays;
import java.util.Scanner;

public class Ejercicio2Arrays {
public static void main(String[]args) {
	Scanner scan = new Scanner(System.in);
	
	int[] array = new int[5];
	System.out.println("Dame 5 números y los pongo en un array");
	array[0] = scan.nextInt();
	array[1] = scan.nextInt();
	array[2] = scan.nextInt();
	array[3] = scan.nextInt();
	array[4] = scan.nextInt();
	
	for (int i = 0; i < array.length; i++) {
		System.out.println("Número en la posición del array " + i);
		System.out.println(array[i]);
	}
	
}
}
