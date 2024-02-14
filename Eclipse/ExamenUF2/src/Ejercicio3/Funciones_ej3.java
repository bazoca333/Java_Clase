package Ejercicio3;

import java.util.Scanner;

public class Funciones_ej3 {
private static Scanner scan = new Scanner(System.in);
private static Scanner scan_s = new Scanner(System.in);
		
public static void insertarEliminar(String[] nombre, int[] edad, String[] ciudad) {
	 System.out.println("¿Desea añadir (A) o eliminar (E) un ciudadano?");
     char opcion = scan_s.next().toUpperCase().charAt(0);

     if (opcion == 'A') {
         boolean done = false;
         for (int i = 0; i < nombre.length; i++) {
             if (!done) {
                 if (nombre[i] == null) {
                     System.out.println("Por favor, ponga su nombre aquí:");
                     nombre[i] = getStringInput(scan_s);

                     System.out.println("Por favor, ahora ponga su edad aquí:");
                     edad[i] = getInput(scan);

                     System.out.println("Por último, ponga su ciudad aquí:");
                     ciudad[i] = getStringInput(scan_s);
                     done = true;
                     System.out.println("Usuario registrado correctamente.");
                     Ejercicio3.main(null);
                 }
             }
         }
     } else if (opcion == 'E') {
         System.out.println("Ingrese el nombre del ciudadano que desea eliminar:");
         String nombreEliminar = getStringInput(scan_s);

         boolean encontrado = false;
         for (int i = 0; i < nombre.length; i++) {
             if (nombre[i] != null && nombre[i].equalsIgnoreCase(nombreEliminar)) {
                 nombre[i] = null;
                 edad[i] = 0; 
                 ciudad[i] = null;
                 encontrado = true;
                 System.out.println("Usuario eliminado correctamente.");
                 break;
             }
         }

         if (!encontrado) {
             System.out.println("Usuario no encontrado.");
             Ejercicio3.main(null);
         }
     } else {
         System.out.println("Opción no válida. Por favor, elija A para añadir o E para eliminar.");
     }
}

public static void buscarCiudad(String[] nombre, int[] edad, String[] ciudad) {
	System.out.println("En qué ciudad reside usted?");
	String ciudadInput = getStringInput(scan_s);

	for (int i = 0; i < ciudad.length; i++) {
		int contador = 1;
		if (ciudad[i] != null && ciudad[i].equals(ciudadInput)) {
		System.out.println("-----Residente " + contador + "-----");
		System.out.println("Nombre: " + nombre[i]);
		System.out.println("Edad: " + edad[i]);
		System.out.println("Ciudad: " + ciudad[i]);
		System.out.println("---------------------");
		contador++;
		}
	}
	
	Ejercicio3.main(null);
}


public static void buscarNomEdad(String[] nombre, int[] edad, String[] ciudad, String partNom, int edadpref) {
	 for (int i = 0; i < nombre.length; i++) {
			int contador = 1;

			if (nombre[i] != null) {
		        if (nombre[i].toLowerCase().contains(partNom.toLowerCase()) && edad[i] == edadpref) {
		    		System.out.println("-----Residente " + contador + "-----");
		    		System.out.println("Nombre: " + nombre[i]);
		    		System.out.println("Edad: " + edad[i]);
		    		System.out.println("Ciudad: " + ciudad[i]);
		    		System.out.println("---------------------");	
		    		contador++;
		        }
			}
	    }
	 Ejercicio3.main(null);
}

public static void editarPersona(String[] nombre, int[] edad, String[] ciudad) {
	boolean encontrado = false;
	String buscar_usu = getStringInput(scan_s);

	for (int i = 0; i < ciudad.length; i++) {
		if (!encontrado) {
			if (buscar_usu != null && buscar_usu.toLowerCase().equals(nombre[i].toLowerCase())) {
				System.out.println("Usuario encontrado. Proporcione la nueva información:");

			    System.out.println("Nuevo nombre:");
			    nombre[i] = getStringInput(scan_s);

			    System.out.println("Nueva edad:");
			    edad[i] = getInput(scan);

			    System.out.println("Nueva ciudad:");
			    ciudad[i] = getStringInput(scan_s);

			    System.out.println("Usuario editado correctamente.");
			    encontrado = true;
			}
		}
	}
if (!encontrado) {
	System.out.println("No hemos encontrado el usuario: '" + buscar_usu + "'");
}else {
	System.out.println("Usuario editado correctamente");
}
Ejercicio3.main(null);
	
}

public static void ver_bd(String[] nombre, int[] edad, String[] ciudad) {
	int users = 0;
	for (int i = 0; i < ciudad.length; i++) {
		int contador = 1;
		if (ciudad[i] != null) {
    		System.out.println("-----Residente " + contador + "-----");
    		System.out.println("Nombre: " + nombre[i]);
    		System.out.println("Edad: " + edad[i]);
    		System.out.println("Ciudad: " + ciudad[i]);
    		System.out.println("---------------------");
    		contador++;
    		users++;
		}
	}
	
	if (users == 0) {
		System.out.println("Error: no hay usuarios");
	}
	Ejercicio3.main(null);
}

public static int getInput(Scanner scanner) {
    boolean inputValid = false;
    int eleccion = 0;

    while (!inputValid) {
        if (scanner.hasNextInt()) {
            eleccion = scanner.nextInt();
            inputValid = true;
        } else {
            System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
            scanner.next();
        }
    }

    return eleccion;
}

public static String getStringInput(Scanner scanner) {
    boolean inputValid = false;
    String entrada = "";

    while (!inputValid) {
        if (scanner.hasNext()) {
            entrada = scanner.next();

            try {
                Integer.parseInt(entrada);
                System.out.println("Entrada no válida. Por favor, ingrese una cadena válida (que no sea un número).");
                scanner.nextLine();
            } catch (NumberFormatException e) {
                inputValid = true;
            }
        } else {
            System.out.println("Entrada no válida. Por favor, ingrese una cadena válida.");
            scanner.nextLine(); 
        }
    }

    return entrada;
}
}
