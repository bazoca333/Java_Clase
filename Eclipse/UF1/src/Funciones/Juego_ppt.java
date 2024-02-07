package Funciones;

import java.util.Random;
import java.util.Scanner;

public class Juego_ppt{
	 public static void main(String[] args)
	 {
		 Scanner scan = new Scanner(System.in);
		 String nombre1 = "";
		 String nombre2 = "";
		 String eleccion1 = "";
		 String eleccion2 = "";
		 String ganador = "";
		 
		 boolean condition = false;
		 while (condition == false) {
			 System.out.println("Elija un modo:");
			 System.out.println("-IA");
			 System.out.println("-NORMAL");
			 String eleccionmodo = scan.nextLine();
			 if (eleccionmodo.equals("IA")) {
				 ia(eleccion1, nombre1, nombre2, eleccion2, ganador);
				 condition = true;
			}else if (eleccionmodo.equals("NORMAL")) {
				 bothplayers(eleccion1, nombre1, nombre2, eleccion2, ganador);
				 condition = true;
			}else {
				System.out.println("Vuelve a introducir el modo:");
			}

		}
	 	     
	     	      

	     
	 }
	 
 private static void bothplayers(String eleccion1f, String nombre1f, String nombre2f, String eleccion2f, String ganadorf) {
		 Scanner scan_n = new Scanner(System.in);
	     Scanner scan_s = new Scanner(System.in);
	        
	     System.out.println("Nombre del jugador 1:");
	     nombre1f = scan_s.nextLine();
	     
	     System.out.println("Nombre del jugador 2:");
	     nombre2f = scan_s.nextLine();
	     
	     System.out.println("Elección del jugador 1:");
	     
	     boolean acabado = false;
	     
	     while (acabado == false) {
		     eleccion1f = scan_s.nextLine().toUpperCase();
	    	 if (eleccion1f.equals("PIEDRA")||eleccion1f.equals("PAPEL")||eleccion1f.equals("TIJERAS")) {
	 			acabado = true;
	 		}else {
				System.out.println("No te he entendido");
			}

		}
	     acabado = false;
	     	     
	     System.out.println("Elección del jugador 2:");
	     while (acabado == false) {
		     eleccion2f = scan_s.nextLine().toUpperCase();
	    	 if (eleccion2f.equals("PIEDRA")||eleccion2f.equals("PAPEL")||eleccion2f.equals("TIJERAS")) {
	 			acabado  = true;
	 		}else {
				System.out.println("No te he entendido");
			}

		}
	     
	     ganadorf = checkear(eleccion1f, nombre1f, nombre2f, eleccion2f, ganadorf);
	     if (ganadorf.equals(nombre2f) || ganadorf.equals(nombre1f)) {
	         System.out.println(nombre1f + " ha elegido " + eleccion1f + " y " + nombre2f + " " + eleccion2f + ". " + ganadorf + " es el/la ganador/a" );
		}else {
			return;
		}

	 }
 private static void ia(String eleccion1, String nombre1, String nombre2, String eleccion2, String ganador) {
	 //IA
     Scanner scan_s = new Scanner(System.in);

	 Random rand = new Random();
	 int int_random = rand.nextInt(2);
     eleccion2 = "";
     nombre2 = "IA";
	 if (int_random == 0) {
		eleccion2 = "PIEDRA";
	}else if (int_random == 1) {
		eleccion2 = "PAPEL";
	}else if (int_random == 2) {
		eleccion2 = "TIJERAS";
	}
	 
	 //Variables
	 boolean empate = false;
	 boolean fin = false;
	 eleccion1 = "";
	 nombre1 = "";
	 ganador = "";
	 
	 System.out.println("Nombre del jugador 1:");
      nombre1 = scan_s.nextLine();
	 
      //Bucle elección
		 System.out.println("Elección del jugador 1:");
	      eleccion1 = scan_s.nextLine().toUpperCase();
	     if (eleccion1.equals("TIJERA")) {
			eleccion1 = "TIJERAS";
		}
     
     ganador = checkear(eleccion1, nombre1, nombre2, eleccion2, ganador);
     if (ganador.equals(nombre2) || ganador.equals(nombre1)) {
         System.out.println(nombre1 + " ha elegido " + eleccion1 + " y " + nombre2 + " " + eleccion2 + ". " + ganador + " es el/la ganador/a" );
	}else {
		return;
	}
	 

 }

 private static String checkear(String eleccion1, String nombre1, String nombre2, String eleccion2, String ganador) {
     if (eleccion1.equals("PIEDRA")) {
 	    if (eleccion2.equals("PAPEL")) {
 	        ganador = nombre2;
 	    } else if (eleccion2.equals("TIJERAS")) {
 	        ganador = nombre1;
 	    }else if (eleccion1.equals(eleccion2)) {
				System.out.println(nombre1 + " ha elegido " + eleccion1 + " e " + nombre2 + " " + eleccion2 + ". El resultado es un empate" );
			}
 	    
 	} else if (eleccion1.equals("PAPEL")) {
 	    if (eleccion2.equals("PIEDRA")) {
 	        ganador = nombre1;
 	    } else if (eleccion2.equals("TIJERAS")) {
 	        ganador = nombre2;
 	    }else if (eleccion1.equals(eleccion2)) {
				System.out.println(nombre1 + " ha elegido " + eleccion1 + " e " + nombre2 + " " + eleccion2 + ". El resultado es un empate" );
			}
 	    
 	} else if (eleccion1.equals("TIJERAS")) {
 	    if (eleccion2.equals("PIEDRA")) {
 	        ganador = nombre2;
 	    } else if (eleccion2.equals("PAPEL")) {
 	        ganador = nombre1;
 	    }else if (eleccion1.equals(eleccion2)) {
				System.out.println(nombre1 + " ha elegido " + eleccion1 + " e " + nombre2 + " " + eleccion2 + ". El resultado es un empate" );
			}	     
	 }
     return ganador;
 }
}
 

