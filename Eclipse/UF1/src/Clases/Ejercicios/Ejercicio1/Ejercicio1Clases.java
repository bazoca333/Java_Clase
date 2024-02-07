package Clases.Ejercicios.Ejercicio1;
import java.util.Scanner;

public class Ejercicio1Clases {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Dime una frase y yo giraré las palabras");
		String fraseGirada = scan.nextLine();
		for (int j = 0; j < fraseGirada.length(); j++) {
			System.out.print(fraseGirada.charAt((fraseGirada.length()-1)-j));

		}
	}
	
	public static String NuevaFrase() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Dime una frase y yo giraré las palabras");
		String fraseNormal = scan.nextLine();
		String fraseModificada = "";
		
		int espacioAnterior = 0;
		for (int i = 0; i < fraseNormal.length(); i++) {
			String NewWord = "";
			
			if (fraseNormal.charAt(i+espacioAnterior) != ' ') {
				NewWord += fraseNormal.charAt(i);
			}else {
				espacioAnterior = i;
			}
			
			fraseModificada += invertirPalabra(NewWord);
		}
		
		return fraseModificada;
	}
	
	public static String invertirPalabra(String palabra) {
		String palabraInvertida = "";
		
		for (int i = palabra.length(); i > 0; i--) {
		 	palabraInvertida += palabra.charAt(i);
		}
		palabraInvertida += " ";
		return palabraInvertida;
	}

}

