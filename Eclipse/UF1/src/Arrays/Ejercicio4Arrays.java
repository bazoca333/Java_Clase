package Arrays;
import java.util.Scanner;

public class Ejercicio4Arrays {
public static void main(String[]args) {
	Scanner scan = new Scanner(System.in);

	System.out.println("De que tamaño quieres el array?");
	int[] array = new int[scan.nextInt()];
	
	System.out.println("De qué numero quieres poner sus multiplos en el array");
	int numero = scan.nextInt();
	int numero2 = 0;
	
	for (int i = 0; i < array.length; i++) {
		numero2 = numero2 + numero;
		array[i] = numero2 ;
		System.out.println("Posición '" + i + "' del array: " + numero2);
	}
}
}
