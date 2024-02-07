package Funciones;
import java.util.Random;
import java.util.Scanner;

public class Juego_numeros_aleatorios {
    public static void main(String[] args) {
        Scanner scan_n = new Scanner(System.in);
        Scanner scan_s = new Scanner(System.in);
        Random rand = new Random();
        boolean nxtTry = true;

        
        int modo = 0;
        System.out.println("Qué modo quieres jugar?");
        System.out.println("1. Con intentos");
        System.out.println("2. Intentos infinitos");
        int quemodo = scan_n.nextInt();
        
        if (quemodo == 1) {
            while (nxtTry) {
            	
            	if (nxtTry) {
            		int maxintento = intentos();
                	boolean a = normal(rand, scan_n, scan_s, maxintento, nxtTry);
                	if (nxtTry == a) {
        				continue;
        			}else {
        				nxtTry = false;
        			}
    			}
            }
		}else if(quemodo == 2) {
            while (nxtTry) {
            	
            	if (nxtTry) {
                	boolean b = infinito(rand, scan_n, scan_s, nxtTry);
                	System.out.println("Debe imprimir");
                	if (b == true) {
						System.out.println("True");
					}else {
						System.out.println("False");
					}
                	if (b == false) {
        				nxtTry = false;
        			}
    			}
            }

		}

    }
    
    private static int intentos() {
    	Scanner scan_n = new Scanner(System.in);
        int maxintentos = 0;
        
        System.out.println("==== Menú de Niveles ====");
         System.out.println("1. Nivel 1");
         System.out.println("2. Nivel 2");
         System.out.println("3. Nivel 3");
         System.out.println("0. Salir");
         System.out.print("Seleccione un nivel (1/2/3/0): ");
         int nivel = scan_n.nextInt();

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
                 
         }

    	return maxintentos;
    }
    
    private static boolean normal(Random rand, Scanner scan_n, Scanner scan_s, int maxintentos, boolean nxtTry) {
        int intentos = maxintentos;
        int int_random = 0;
        int nivel = 0;
        
        if (maxintentos ==5) {
			nivel = 1;
		}else if (maxintentos ==4) {
			nivel = 2;
		}else if (maxintentos ==3) {
			nivel = 3;
		}
       
        int_random = rand.nextInt(0,25); // Generar un número aleatorio entre 0 y 25

        System.out.println("Estás en el nivel " + nivel + ", dispones con " + maxintentos + " intentos");
        
        boolean fin = false;

        while (!fin && intentos > 0) {
            System.out.println("¿Qué número es?");
            int input = scan_n.nextInt();
            
            //Valida el numero
            Checkear(input, int_random, intentos-1, fin);
            intentos--;
            
            
        // Notificar si quiere volver a jugar
            if (intentos <= 0) {
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
		return nxtTry;
    }
   
    private static boolean infinito(Random rand, Scanner scan_n, Scanner scan_s, boolean nxtTry) {
        int int_random = 0;
      boolean a = false;
        int_random = rand.nextInt(0,25); // Generar un número aleatorio entre 0 y 25
        
        boolean fin = false;

        while (!fin) {
            System.out.println("¿Qué número es? ('100' para cerrar)");
            int input = scan_n.nextInt();
            
            //Valida el numero
            boolean acabar = Checkear2(input, int_random);
            if (acabar == true) {
				a = false;
			}
    }
		return a;
}
   

    private static void Checkear(int input, int int_random, int intentos, boolean fin) {
    	
        if (input > int_random) {
            intentos--;
            if (intentos > 0) {
                System.out.println("El número es menor, prueba otra vez | Te quedan " + intentos + " intentos");
            }
        } else if (input < int_random) {
            if (intentos > 0) {
                System.out.println("El número es mayor, prueba otra vez | Te quedan " + intentos + " intentos");
            }
        } else if (input == int_random) {
            System.out.println("Acertaste :)");
            fin = true;
        }
    }
    private static boolean Checkear2(int input, int int_random) {
    	boolean b = false;
        if (input > int_random) {
                System.out.println("El número es menor, prueba otra vez ");
        } else if (input < int_random) {
                System.out.println("El número es mayor, prueba otra vez");
        } else if (input == int_random) {
            System.out.println("Acertaste :)");
            b = true;
        }else if (input == 100) {
			b = true;
		}
		return b;
    }

    
}
