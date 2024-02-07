import java.util.Scanner;

public class Ejercicio1_ppt_AmigosIndecisos {
public static void main(String[]args) {
	//Declaro el scaner
	Scanner scan_s = new Scanner(System.in);
	Scanner scan_i = new Scanner(System.in);
	
	 //Pido los nombres a los jugadores
	 System.out.println("Hola jugador1, ¿cuál es tu nombre?");
     String nombre1 = scan_s.nextLine();
	 System.out.println("Hola jugador2, ¿cuál es tu nombre?");
     String nombre2 = scan_s.nextLine();
     
     //Empieza el bucle para elegir cuántas rondas quieren jugar
     //Guardo las variables fuera del loop para poder usarlas como condición, también les pongo 1 y 0 para que sean diferentes y se ejecute si o si el bucle.
     int rondasJ1 = 0;
     int rondasJ2 = 1;
     //Mientras rondasJ1 no sea lo mismo que rondasJ2, el bucle seguirá
     while (rondasJ1 != rondasJ2) {
    	 System.out.println("Muy bien " + nombre1 + ", ¿cuántas rondas quieres jugar?");
         rondasJ1 = scan_i.nextInt();
         System.out.println("Interesante… ¿y tú, " + nombre2 +"?");
         rondasJ2 = scan_i.nextInt();
         //Si no han elegido el mismo número, se imprime esta línea y el bucle vuelve a empezar
         if (rondasJ1 != rondasJ2) {
			System.out.println("Uffff… parece que esto va para largo…");
		}
	}
     //Declaro las variables para almacenar la elección del P1, P2 y la de empate por si hay empate. También las bariables ganador para las rondas ganadas de cada uno.
	 String eleccion1 = "";
	 String eleccion2 = "";
	 int ganador1 = 0;
	 int ganador2 = 0;
	 //Variable para decir si ha habido un empate o más
	 int empate = 0;
	 
	 
	 System.out.print("Bien, me gusta que os entendáis tan bien :).");
	 //Mientras las rondas sean mayor que 0, seguirá preguntando.
	 while (rondasJ1 > 0) {
		 //Pido los datos a los usuarios y los convierto a mayuscula
		System.out.println(nombre1 + ", ¿cuál es tu elección?");
		eleccion1 = scan_s.nextLine().toUpperCase();
		System.out.println(nombre2 + ", ¿cuál es tu elección?");
		eleccion2 = scan_s.nextLine().toUpperCase();
		
		//Corrijo algun error que podría tener el usuario
		if (eleccion1.equals("TIJERA")) {
			eleccion1 = "TIJERAS";
		}

	    //Aquí comparo los resultados, si son PIEDRA PAPEL O TIJERA, luego sumo 1 a los ganadores o al empate
	    //PIEDRA
		if (eleccion1.equals("PIEDRA")) {
			//Comparo todas las posibilidades que tiene piedra contra el resto. No haré el comentario en todos los demás porque queda poco tiempo, pero hago lo mismo en todos los if's
			//Después de sumar, imprime el resultado y vuelve a ejecutar el loop
	   	    if (eleccion2.equals("PAPEL")) {
	   	        ganador2++;
	   	        //Este if lo uso para que no imprima la linea innecesariamente antes de que se acabe el juego y se muestren los resultados, como es lo mismo en todo solo lo explico aquí
	   	    	if (rondasJ1 != 1) {
	   	    	System.out.println("El ganador de la ronda es " + nombre2 + ". " + nombre1 + ", cúal es tu elección?");
	   	    	}	   	        
	   	    } else if (eleccion2.equals("TIJERAS")) {
	   	        ganador1++;
	   	    	if (rondasJ1 != 1) {
	   	    	System.out.println("El ganador de la ronda es " + nombre1 + ". " + nombre1 + ", cúal es tu elección?");
	   	    	}	   	        
	   	    }else if (eleccion1.equals(eleccion2)) {
					empate++;
					
					System.out.println(nombre1 + " ha elegido " + eleccion1 + " e " + nombre2 + " " + eleccion2 + ". El resultado es un empate" );
				}
	   	    //PAPEL
	   	} else if (eleccion1.equals("PAPEL")) {
	   	    if (eleccion2.equals("PIEDRA")) {
	   	    	ganador1++;
	   	    	if (rondasJ1 != 1) {
	   	    	System.out.println("El ganador de la ronda es " + nombre1 + ". " + nombre1 + ", cúal es tu elección?");
	   	    	}	   	        
	   	    } else if (eleccion2.equals("TIJERAS")) {
	   	    	ganador2++;
	   	    	if (rondasJ1 != 1) {
	   	    	System.out.println("El ganador de la ronda es " + nombre2 + ". " + nombre1 + ", cúal es tu elección?");
	   	    	}	   	        
	   	    }else if (eleccion1.equals(eleccion2)) {
					empate++;
					
					System.out.println(nombre1 + " ha elegido " + eleccion1 + " e " + nombre2 + " " + eleccion2 + ". El resultado es un empate" );
				}
	   	   //TIJERAS 
	   	} else if (eleccion1.equals("TIJERAS")) {
	   	    if (eleccion2.equals("PIEDRA")) {
	   	    	ganador2++;
	   	    	if (rondasJ1 != 1) {
	   	    	System.out.println("El ganador de la ronda es " + nombre2 + ". " + nombre1 + ", cúal es tu elección?");
	   	    	}	   	        
	   	    } else if (eleccion2.equals("PAPEL")) {
	   	    	ganador1++;
	   	    	if (rondasJ1 != 1) {
	   	    	System.out.println("El ganador de la ronda es " + nombre1 + ". " + nombre1 + ", cúal es tu elección?");
	   	    	}
	   	    }else if (eleccion1.equals(eleccion2)) {
					empate++;
					
						System.out.println(nombre1 + " ha elegido " + eleccion1 + " e " + nombre2 + " " + eleccion2 + ". El resultado es un empate" );
					
					
				}
	   	   //Por si algún jugador no ha puesto la palabra bien, le digo que no le entiendo 
	   	}else {
	   		System.out.println("No te entiendo");
	   		rondasJ1++; //Evito la resta de rondas, sería como repetir la ronda
			}
	    //Resto 1 a las rondas
	    rondasJ1--;
	}
	 //Muestro el resultado final
    System.out.println("FIN DEL JUEGO. RESULTADOS:");
    System.out.println(nombre1 + " ha ganado " + ganador1 + " rondas");
    System.out.println(nombre2 + " ha ganado " + ganador2 + " rondas");
    System.out.println("Ha habido " + empate + " empates");
    //Comparo resultados para imprimir si ha ganado P1 o P2
    if (ganador1 > ganador2) {
		System.out.println(nombre1 + " ha apalizado a " + nombre2);
	}else if(ganador2 > ganador1) {
		System.out.println(nombre2 + " ha apalizado a " + nombre1);
	}else {
		//Por si empatan
		System.out.println("Habéis empatado");
	}


}
}
