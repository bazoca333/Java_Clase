package String;
import java.util.Scanner;

public class Ejercicio4String {
public static void main (String[]args) {
	
	Scanner scan_s = new Scanner(System.in);
	String frase_pricipal = "";
	String frase_cambiada = "";
	frase_pricipal = scan_s.nextLine();
	
	frase_cambiada = frase_pricipal.replace("a", "e");
	
	System.out.println(frase_cambiada);
}
}
