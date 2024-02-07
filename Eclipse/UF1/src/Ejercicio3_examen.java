import java.util.Scanner;

public class Ejercicio3_examen {
public static void main(String[] args) {

	Scanner scan_s = new Scanner(System.in);
	 
	System.out.println("Dime una palabra:");
	String palabra = scan_s.nextLine().toLowerCase();

	//Cojo la primera letra de la palabra
    char primerCaracter = palabra.charAt(0); 

    // Comprueba si el primer carácter es una vocal comparando chars
    if (primerCaracter == 'a' || primerCaracter == 'e' || primerCaracter == 'i' || primerCaracter == 'o' || primerCaracter == 'u') {
        System.out.println("La palabra comienza con una vocal.");
        //Veo si es mayor que 10 la longitud de la palabra y si lo es, la imprimo en mayuscula
        if (palabra.length() > 10) {
			System.out.println(palabra.toUpperCase());
		}
        
    } else {
    	//imprimo la longitud de la palabra con lenght
        System.out.println("La palabra tiene "+ palabra.length() + " letras");
    }

}
}
