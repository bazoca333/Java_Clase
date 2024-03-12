package Practica1_UF3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class main {
	public static String[] array = new String[10];
	
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	Scanner scan_s = new Scanner(System.in);
	
	System.out.println("----MENU----");
	System.out.println("1. Introducir elemento");
	System.out.println("2. Escribir en fichero txt");
	System.out.println("3. Escribir fichero binario");
	int eleccion = scan.nextInt();
	if (eleccion == 1) {
		System.out.println("Escriba la frase");
		String frase = scan_s.nextLine();
		introducirUnElemento(frase);
		mostrarArray();
	}else if (eleccion == 2) {
		System.out.println("Escriba una frase vacía para terminar");
		escribirFicheroTxt();
		leerFicheroTxt();
	}else if (eleccion == 3) {
		escribirFicheroBinario();
		leerFicheroBinario();
	}else {
		
	}
	
}

public static void introducirUnElemento(String elemento) {
	//Comprovar si el elemento es válido
	if (!elemento.equals("") || !elemento.equals(" ")) {
		int pos = -1;
		//buscar ultima posicion vacía
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null || array[i].equals(" ")) {
				pos = i;
				break;
			}
			System.out.println("hola" + i);
		}
		array[pos] = elemento;
	}else {
		System.out.println("Elemento no válido");
	}
}

public static void mostrarArray() {
	for (int i = 0; i < array.length; i++) {
		if (array[i] == null || array[i].equals(" ")) {
			System.out.println("Posición "+ i + ": vacío");
		}else {
			System.out.println("Posición "+ i + ": " + array[i]);
		}
	}
}

public static void escribirFicheroTxt() {
	//Se utiliza para darle un nombre y la ruta al fichero
			String nombreFichero = "FicheroTexto.txt";
			
			try {
				FileWriter fileWriter = new FileWriter(nombreFichero, false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				Scanner scanner = new Scanner(System.in);
				String frase = "";
				do {
					System.out.println("Introduce una frase");
					frase = scanner.nextLine();
					boolean fraseValida = false;
					for (int i = 0; i < frase.length(); i++) {
						if (frase.charAt(i) == 'a' || frase.charAt(i) == 'e') {
							fraseValida = true;
						}
					}
					
					if (fraseValida) {
						bufferedWriter.write(frase);
						bufferedWriter.newLine();
					}

				} while(frase.length() > 0);
		
				scanner.close();
				bufferedWriter.close();
				fileWriter.close();
				System.out.println("El fichero ha sido modificado correctamente");
			} catch (IOException e) {
				System.out.println("Ha habido un error de escritura: " + e);
			}
}

public static void leerFicheroTxt() {
	String nombreFichero = "FicheroTexto.txt";

	try {
		// Creamos un objeto de tipo FileReader para abrir un fichero de lectura
		FileReader fileReader = new FileReader(nombreFichero);
		// Utilizamos el Buffered para recibir lo que hay en el fichero y transformarlo
		// en c�digo Java
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String linea = null;
		do {
			// Leemos el contenido del fichero
			linea = bufferedReader.readLine();

			// Si no ha acabado de leer el fichero, printamos el valor de l�nea
			if (linea != null) {
				System.out.println(linea);
			}
		} while (linea != null);

		bufferedReader.close();
		fileReader.close();

	} catch (IOException e) {
		System.out.println("Ha habido un error al intentar abrir el fichero" + e);
	}

}

public static void escribirFicheroBinario() {
    // Ponemos el nombre del fichero que vamos a escribir. Si no existe, lo crea.
    String nombreFichero = "FicheroBinario.bin";

    try {
        // Lo utilizamos para crear el fichero a partir del nombre
        FileOutputStream fileOutputStream = new FileOutputStream(nombreFichero);
        // Este objeto traduce todos los datos de Java a binario
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una frase");
        String frase = scanner.nextLine();

        if (frase.length() > 10) {
            // Si la longitud es mayor a 10
            System.out.println("La siguiente frase tiene una longitud mayor de 10.");
            dataOutputStream.writeInt(frase.length());
            dataOutputStream.writeUTF(frase);
        } else {
            // Si la longitud es menor o igual a 10
            System.out.println("La siguiente frase tiene una longitud menor a 10.");
            // Verificar si la frase solo tiene una misma vocal
            boolean tieneUnaVocal = false;
            for (char letra : frase.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(letra) != -1) {
                    if (tieneUnaVocal) {
                        tieneUnaVocal = false;
                        break;
                    } else {
                        tieneUnaVocal = true;
                    }
                }
            }
            dataOutputStream.writeBoolean(tieneUnaVocal);
            dataOutputStream.writeUTF(frase);
        }

        scanner.close();
        dataOutputStream.close();
        fileOutputStream.close();
    } catch (IOException e) {
        System.out.println("Error en la escritura del fichero " + e);
    } catch (InputMismatchException e2) {
        System.out.println("Ha habido un error al leer los datos del usuario");
    } catch (Exception e3) {
        System.out.println("Ha habido un error no controlado " + e3);
    }
}

public static void leerFicheroBinario() {
	String nombreFichero = "FicheroBinario.bin";
	
	try {
		//Lo utilizamos para crear el fichero a partir del nombre
		FileOutputStream fileOutputStream = new FileOutputStream(nombreFichero);
		//Este objeto traduce todos los datos de Java a binario
		DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
		
		dataOutputStream.close();
		fileOutputStream.close();
	//Capturamos el error cuando el fichero indicado no exista
	} catch (FileNotFoundException e1) {
		System.out.println("Fichero no encontrado " + e1);
	//Capturamos el error si ha habido un error de escrtura
	} catch (IOException e) {
		System.out.println("Error en la escritura del fichero " + e);
	//Capturamos el error si en el scanner nos envían una letra en vez de un número en el nextInt()
	} catch (InputMismatchException e2) {
		System.out.println("Ha habido al leer los datos del usuario");
	//Capturamos cualquier otra excepción
	} catch (Exception e3) {
		System.out.println("Ha habido un error no controlado " + e3);
	}
}
    }//FIN CLASE
