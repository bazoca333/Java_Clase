package Funciones;

public class Practica_funcion_arrays {
private static int[] arrayenteros = new int[30];
	
public static void main(String[] args) {
	estaVacio(arrayenteros);
}

private static boolean estaVacio(int[] array) {
	for (int i = 0; i < array.length; i++) {
		if (array[i] == 0) {
			continue;
		}else {
			System.out.println("No está vacío");
			return false;
		}
	}
	System.out.println("Está vacío");
	return true;
}

private static boolean estaLleno(int[] array) {
	for (int i = 0; i < array.length; i++) {
		if (array[i] == 0) {
			continue;
		}else {
			System.out.println("No está vacío");
			return true;
		}
	}
	System.out.println("Está vacío");
	return false;
}

//fin
}
