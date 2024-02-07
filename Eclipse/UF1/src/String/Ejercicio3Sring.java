package String;
import java.util.Scanner;

public class Ejercicio3Sring {
public static void main(String[]args) {
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Escriba una frase y yo le diré cuantas palabras contiene");
	String lista = scan.nextLine();
	int espacios = 1;
	
	
	for (int i = 0; i < lista.length() ; i++) {
		char car = lista.charAt(i);
		
		if (car == ' ') {
			espacios++;
		}
	}
	System.out.println("La frase tiene " + espacios + " palabras");
}
}
