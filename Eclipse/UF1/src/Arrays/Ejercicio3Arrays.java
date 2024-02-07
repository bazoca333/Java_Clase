package Arrays;
import java.util.Scanner;

public class Ejercicio3Arrays {
public static void main(String[]args) {
	Scanner scan = new Scanner(System.in);

	int[] array = new int[10];
	
	System.out.println("Dame 10 números y los pongo en un array");
	
	int suma = 0;
	for (int i = 0; i < array.length; i++) {
		array[i] = scan.nextInt();
		suma = suma + array[i];
	}
	
	System.out.println("La media es: " + suma/array.length);
}
}
