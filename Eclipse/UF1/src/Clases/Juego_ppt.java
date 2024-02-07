package Clases;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Juego_ppt {
	 public static void main(String[] args)
	 {
		 
		 Scanner scan_s = new Scanner(System.in);
		 
		 
		 //IA
		 Random rand = new Random();
		 int int_random = rand.nextInt(2);
	     String eleccion2 = "";
	     String nombre2 = "IA";
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
		 String eleccion1 = "";
		 String nombre1 = "";
		 String ganador = "";
		 
		 System.out.println("Nombre del jugador 1:");
	      nombre1 = scan_s.nextLine();
		 
	      //Bucle elección
		 while (fin == false) {
			 System.out.println("Elección del jugador 1:");
		      eleccion1 = scan_s.nextLine().toUpperCase();
		     if (eleccion1.equals("TIJERA")) {
				eleccion1 = "TIJERAS";
			}

		     
		     if (eleccion1.equals("PIEDRA")) {
		    	    if (eleccion2.equals("PAPEL")) {
		    	        ganador = nombre2;
		    	        fin = true;
		    	    } else if (eleccion2.equals("TIJERAS")) {
		    	        ganador = nombre1;
		    	        fin = true;
		    	    }else if (eleccion1.equals(eleccion2)) {
						empate = true;
						fin = true;
						System.out.println(nombre1 + " ha elegido " + eleccion1 + " e " + nombre2 + " " + eleccion2 + ". El resultado es un empate" );
					}
		    	    
		    	} else if (eleccion1.equals("PAPEL")) {
		    	    if (eleccion2.equals("PIEDRA")) {
		    	        ganador = nombre1;
		    	        fin = true;
		    	    } else if (eleccion2.equals("TIJERAS")) {
		    	        ganador = nombre2;
		    	        fin = true;
		    	    }else if (eleccion1.equals(eleccion2)) {
						empate = true;
						fin = true;
						System.out.println(nombre1 + " ha elegido " + eleccion1 + " e " + nombre2 + " " + eleccion2 + ". El resultado es un empate" );
					}
		    	    
		    	} else if (eleccion1.equals("TIJERAS")) {
		    	    if (eleccion2.equals("PIEDRA")) {
		    	        ganador = nombre2;
		    	        fin = true;
		    	    } else if (eleccion2.equals("PAPEL")) {
		    	        ganador = nombre1;
		    	        fin = true;
		    	    }else if (eleccion1.equals(eleccion2)) {
						empate = true;
						fin = true;
						System.out.println(nombre1 + " ha elegido " + eleccion1 + " e " + nombre2 + " " + eleccion2 + ". El resultado es un empate" );
					}
		    	    
		    	}else {
		    		System.out.println("No te entiendo");
				}
		}
	     
	      //imprimir resultado
	     if (empate == false) {
	 		System.out.println(nombre1 + " ha elegido " + eleccion1 + " e " + nombre2 + " " + eleccion2 + ". " + ganador + " es el/la ganador/a" );
		}
	     
	 }
}
