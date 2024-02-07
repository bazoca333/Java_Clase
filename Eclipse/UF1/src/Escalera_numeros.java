import java.util.Iterator;
import java.util.Scanner;

public class Escalera_numeros {
	public static void main(String[]args) {
		
		Scanner scan_n = new Scanner(System.in);
		Scanner scan_s = new Scanner(System.in);

		//MENU
		System.out.println("Hola, escriba un número para elegir qué quiere hacer");		
		System.out.println("-------------------------------");
		System.out.println("1 = Escalera de números normal");
				System.out.println("2 = Escalera de números inversa");
				System.out.println("3 = Ambas");
		System.out.println("-------------------------------");
		int opcion_escoger = scan_n.nextInt();
		
		System.out.println("Ahora diga el número al que quiere llegar");
		int numero_inicial = 1;
		int numero_final = scan_n.nextInt();
		int contador = 1;
		int ant = 0;
		
		if (opcion_escoger == 1) {
			while (contador <= numero_final) {

				while (ant < contador) {
					ant++;
					System.out.print(ant);
				}
				System.out.println();
				contador++;
				ant = 0;
			}
		}
		
		else if (opcion_escoger == 2) {
			//
			numero_inicial = numero_final;
			contador = numero_final;
			ant = 0;
			
			while (contador != 0) {

				while (ant < contador) {
					ant++;
					System.out.print(ant);
				}
				System.out.println();
				contador--;
				ant = 0;
			}
			//
		}
		
		else if (opcion_escoger == 3) {
			boolean end = false;
			boolean cambio = false;
			while (end == false) {
				if (cambio == false) {
					while (contador <= numero_final) {
						while (ant < contador) {
							ant++;
							System.out.print(ant);
						}
						System.out.println();
						contador++;
						ant = 0;
					}
					cambio = true;
				}
				else {
					numero_inicial = numero_final;
					contador = numero_final-1;
					ant = 0;
					
					while (contador != 0) {

						while (ant < contador) {
							ant++;
							System.out.print(ant);
						}
						System.out.println();
						contador--;
						ant = 0;
					}
					end = true;
				}
				
			}
			
			
		}

		System.out.println("FINALIZADO");
		
		
	}	
}
