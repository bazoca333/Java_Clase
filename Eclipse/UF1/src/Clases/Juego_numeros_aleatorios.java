package Clases;
import java.util.Random;
import java.util.Scanner;

public class Juego_numeros_aleatorios {
    public static void main(String[] args) {
        Scanner scan_n = new Scanner(System.in);
        Scanner scan_s = new Scanner(System.in);
        Random rand = new Random();

        boolean nxtTry = true;

        while (nxtTry) {
            int maxintentos = 5;
            int intentos = maxintentos;
            int int_random = 0;
            int nivel = 0;

            System.out.println("==== Menú de Niveles ====");
            System.out.println("1. Nivel 1");
            System.out.println("2. Nivel 2");
            System.out.println("3. Nivel 3");
            System.out.println("0. Salir");
            System.out.print("Seleccione un nivel (1/2/3/0): ");
            nivel = scan_n.nextInt();

            switch (nivel) {
                case 1:
                    maxintentos = 5;
                    break;
                case 2:
                    maxintentos = 4;
                    break;
                case 3:
                    maxintentos = 3;
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    continue;
            }

            int_random = rand.nextInt(26); // Generar un número aleatorio entre 0 y 25

            System.out.println("Estás en el nivel " + nivel + ", dispones con " + maxintentos + " intentos");
            
            boolean fin = false;

            while (!fin && intentos > 0) {
                System.out.println("¿Qué número es?");
                int input = scan_n.nextInt();

                if (input > int_random) {
                    intentos--;
                    if (intentos > 0) {
                        System.out.println("El número es menor, prueba otra vez | Te quedan " + intentos + " intentos");
                    }
                } else if (input < int_random) {
                    intentos--;
                    if (intentos > 0) {
                        System.out.println("El número es mayor, prueba otra vez | Te quedan " + intentos + " intentos");
                    }
                } else if (input == int_random) {
                    System.out.println("Acertaste :)");
                    fin = true;
                }
            }

            // Notificar si quiere volver a jugar
            System.out.println("¿Quieres volver a Jugar? S/N");
            String nxtTryString = scan_s.nextLine();
            nxtTryString = nxtTryString.toUpperCase();

            if (nxtTryString.equals("N")) {
                System.out.println("Gracias por jugar");
                nxtTry = false;
            } else if (!nxtTryString.equals("S")) {
                System.out.println("Lo siento, no lo he entendido");
            }
        }
    }
}
