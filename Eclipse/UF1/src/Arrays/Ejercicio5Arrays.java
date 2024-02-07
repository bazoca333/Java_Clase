package Arrays;
import java.util.Scanner;

public class Ejercicio5Arrays {
public static void main(String[]args) {
	Scanner scan = new Scanner(System.in);

	int[] array = new int[5];
	array[0] = 8;
	array[1] = 2;
	array[2] = 23;
	array[3] = 75;
	array[4] = 5;

	
	System.out.println("Qué número quieres buscar? (23, 2, 8, 75, 5)");
	int numero = scan.nextInt();
	int numero2 = 0;
	
	for (int i = 0; i < array.length; i++) {
		if (numero == array[i]) {
			numero2 = i;
		}
	}
	
	System.out.println("El número está en la posición: " + numero2);
}
}