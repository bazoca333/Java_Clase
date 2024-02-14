package Ejercicio1;
import java.util.Random;

public class Ejercicio1 {
	private static Random random = new Random();
public static void main(String[] args) {
	float media;
	
	int[] array = new int[10];
	rellenarArray(array);
	mostrarPares(array);
	
	media = calcularMedia(array);
	System.out.println("La media del array es de: " + media);

}

private static void rellenarArray(int[] array) {
	for (int i = 0; i < array.length; i++) {
		int int_random = random.nextInt(0, 50);
		array[i] = int_random;
	}

}

private static void mostrarPares(int[] array) {
	
	for (int i = 0; i < array.length; i++) {
		if (array[i] % 2 == 0) {
			System.out.println(array[i] + ": Posición " + i);
		}
	}
}

public static float calcularMedia(int[] array) {
	int media = 0;
	for (int i = 0; i < array.length; i++) {
		media += array[i];
	}
	
	media = media/2;
	return media;
}
}//FIN SCRIPT
