package Arrays;

public class Ejercicio9Arrays {
public static void main(String[]args) {

	boolean fin = false;
	int[] array = {-1,-2,-3,-4,-5,-6, 7};
	int i = 0;

	while (fin == false) {
		if (array[i] > 0) {
			fin = true;
			System.out.println(array[i]);
		}else {
			i++;
		}
	}
}
}
