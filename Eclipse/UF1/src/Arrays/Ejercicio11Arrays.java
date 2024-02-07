package Arrays;

public class Ejercicio11Arrays {
public static void main(String[] args) {
	int[] array = {10, 30, 15, 28, 40, 20, 5, 50};
    int[] array2 = new int[array.length];
    int contador = 0;
    
    for (int i = 0; i < array.length; i++) {
        if (array[i] % 2 == 0 && array[i] > 25) {
            array2[contador] = array[i];
            contador++;
        }
    }
    
    for (int i = 0; i < array2.length; i++) {
    	if (array2[i] % 2 == 0 && array2[i] > 25) {
        	System.out.println(array2[i]);
    	}
	}
	        
}
}
