package Arrays;
import java.util.Scanner;

public class Ejercicio6Arrays {
public static void main(String[]args) {
	
	int[] array = {1,2,3,4,5};
	int mayor = array[0];;
	for (int i = 0; i < array.length; i++) {
		if (array[i] > mayor) {
			mayor = array[i];
		}
	}
	
	System.out.println(mayor);
}
}
