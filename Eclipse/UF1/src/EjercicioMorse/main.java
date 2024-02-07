package EjercicioMorse;
import java.util.Scanner;

public class main {
public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner scan_s = new Scanner(System.in);
		boolean looping = true;
		
		System.out.println("Por favor, escoja una opción para continuar:");
		System.out.println("1. Convertir frase a morse.");
		System.out.println("2. Convertir morse a letras.");
		System.out.println("3. Verificar si un mensaje morse es correcto.");


		while (looping) {
			int eleccion = scan_s.nextInt();
			switch (eleccion) {
			case 1:
				String frase = scan.nextLine();
				
				String fraseConvertida = morse.convertirMorse(frase.toUpperCase());
				System.out.println(fraseConvertida);
				looping = false;
				break;
			case 2:
				String frase2 = scan.nextLine();
				String fraseConvertida2 = morse.convertirLetras(frase2.toUpperCase());
				System.out.println(fraseConvertida2);

				looping = false;
				break;
			case 3:
				String frase3 = scan.nextLine();
				morse.verificarMorse(frase3);
				looping = false;
				break;

			default:
				System.out.println("No le he entendido, vuelva a intentarlo:");
				break;
			}
		}
		
		
}
}
