package Arrays;

public class Ejercicio10Arrays {
public static void main(String[]args) {

	int[] array = {1,2,3,4,5};
	int[] array2 = new int[array.length];
	
	int contadorarray2 = 0;
	for (int i = array.length - 1; i >= 0; i--) {
		array2[contadorarray2] = array[i];
		contadorarray2++;		
	}
	
	for (int i = 0; i < array2.length; i++) {
		System.out.println(array2[i]);
	}
	
}
}
