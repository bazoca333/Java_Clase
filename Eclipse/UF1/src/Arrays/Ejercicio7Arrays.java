package Arrays;
public class Ejercicio7Arrays {
public static void main(String[]args) {
	
	int[] array = {1,2,3,4,5};
	int menor = array[0];;
	for (int i = 0; i < array.length; i++) {
		if (array[i] < menor) {
			menor = array[i];
		}
	}
	
	System.out.println(menor);
}
}
