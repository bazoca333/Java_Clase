package String;
import java.util.Scanner;

public class Ejercicio2String {
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	
	String lista_palabra = "";
	
	for (int i = 0; i < 10; i++) {
		System.out.println("Escriba una palabra:");
		String palabra = scan.nextLine();
		palabra = palabra + " ";
		lista_palabra = lista_palabra + palabra;
		
	}
	
	System.out.println(lista_palabra);
	
}
}
