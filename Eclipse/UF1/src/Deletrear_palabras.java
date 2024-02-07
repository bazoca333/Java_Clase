import java.util.Iterator;
import java.util.Scanner;

public class Deletrear_palabras {
public static void main(String[]args) {
	
	Scanner scan = new Scanner(System.in);
	System.out.println("Qué palabra quieres que deletree?");
	String palabra = scan.nextLine();
	int lPalabra = palabra.length();
	
	for (int i = 0; i < lPalabra; i++) {
		System.out.println(palabra.charAt(i));
		
	}
	
}
}
