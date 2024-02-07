import java.util.Iterator;
import java.util.Scanner;

public class bucles {
public static void main(String[]args) {
	Scanner scan_n = new Scanner(System.in);
	Scanner scan_s = new Scanner(System.in);
	
	int num = 0;
	//Bucle while
	/**
	while(num <= 1) {
		System.out.println(num);	}
	**/
	
	// Bucle for
	// for(número de vuelta; condición; acción a realizar en cada vuelta)
	
	String palabra = scan_s.nextLine();
	for(int i = 0; i < palabra.length(); i++) {
		
		System.out.println(palabra.charAt(i));
	}
	
}
}
