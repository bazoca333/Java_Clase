package Clases;

import java.util.Scanner;
public class MainJuegos {
public static void main(String[] args) {
	System.out.println("Elige a qué juego quieres jugar");
	System.out.println("1 - Piedra, papel y tijeras");
	System.out.println("2 - Tres en java");
	System.out.println("3 - Números aleatorios");
	
    Scanner scan_n = new Scanner(System.in);
    int eleccion = scan_n.nextInt();
    
    switch (eleccion) {
	case 1:
		Juego_numeros_aleatorios.main(args);
		break;

	case 2:
		Tres_en_Java.main(args);
		break;
	case 3:
		Juego_ppt.main(args);
		break;
		
	default:
		break;
	}

}
}
