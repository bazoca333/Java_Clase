import java.util.Random;
import java.util.Scanner;

public class Ejercicio3_Examen2 {
public static void main(String[] args) {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);

	//Defino una matriz de 7x7 
	int matriz[][] =new int[7][7];
	
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz[i].length; j++) {
			int int_random = random.nextInt(50);
			matriz[i][j] = int_random;
		}
	}
	
	//imprimo la matriz
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz[i].length; j++) {
			System.out.print("[" + matriz[i][j] + "]");
			System.out.print(" ");
		}
		System.out.println();
	}
	
	System.out.println("Ordenando...");
	
	//creo una array para poner los datos de la matriz dentro
	int[] array = new int[7*7];
	
	//Pongo los valores de la matriz en el array
	int contador = 0;
	for (int i = 0; i < matriz.length; i++) {
		for (int j = 0; j < matriz[i].length; j++) {
			array[contador] = matriz[i][j]; 
			contador++;
		}
	}
	
	//bucle para poder elegir infinitamente hasta que queramos parar
	boolean fin = true;
	int cosa = 0;
	while (fin == true) {
		System.out.println("¿Los ordeno de menor a mayor (primera)?¿O de mayor a menor(segunda)?");
		String eleccion = scan.nextLine();
		if (eleccion.equals("primera")) {
			cosa = 1;
			fin = false;
		}else if (eleccion.equals("segunda")) {
			cosa = 2;
			fin = false;
		}else {
			System.out.println("Lo siento, escribe mejor");
		}
	}
	
	if (cosa == 1) {
		//Ordeno los valores en una nueva array
		int[] array2 = new int[7*7];
		//51 porque el numero maximo de random es 50
		int numeromenor = 51;
		
		//hago una array de booleans para excluir los numeros ya puestos en la array 2
		int excluir = 0;
		boolean excluidos[] = new boolean[7*7];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j] < numeromenor && !excluidos[j]) {
					numeromenor = array[j];
		            excluir = j;
				}
			}
			array2[i] = numeromenor;
			excluidos[excluir] = true;
			numeromenor = 51;
			
			
		}
		//imprimo la array
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i]);
			System.out.print(" ");
		}
		
		//Aquí hago lo mismo que en la anterior pero a la inversa
	}else if (cosa == 2) {
		//Ordeno los valores en una nueva array
		int[] array2 = new int[7*7];
		int numeromenor = -1;
		int excluir = 0;
		boolean excluidos[] = new boolean[7*7];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j] > numeromenor && !excluidos[j]) {
					numeromenor = array[j];
		            excluir = j;
				}
			}
			array2[i] = numeromenor;
			excluidos[excluir] = true;
			numeromenor = 0;
			
			
		}
		//imprimo la array
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i]);
			System.out.print(" ");
		}
	}else {
		System.out.println("ERROR");
	}
}
}
