import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Cifrado {
	public static int codigoCifrado = 5;
	public static char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
	
	public static void main(String[] args) {

		
		//Se utiliza para darle un nombre y la ruta al fichero
		String nombreFichero = "datos.txt";
		
		try {
			//Se utiliza para crear el fichero con el nombre indicado en la variable nombreFichero
			FileWriter fileWriter = new FileWriter(nombreFichero, false);
			//Se utiliza para escribir en el fichero creado por el FileWriter
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			Scanner scanner = new Scanner(System.in);
			String frase = "";
			do {
				System.out.println("Introduce una frase");
				frase = scanner.nextLine();
				frase = cifrarMensaje(frase);
				
				bufferedWriter.write(frase);
				bufferedWriter.newLine();
			} while(frase.length() > 0);
	
			scanner.close();
			bufferedWriter.close();
			fileWriter.close();
			System.out.println("El fichero ha sido modificado correctamente");
		} catch (IOException e) {
			System.out.println("Ha habido un error de escritura: " + e);
		}
		

	}
	
	public static String cifrarMensaje(String mensaje) {
		String newMensaje = "";
		int posicionArray = -1;
		for (int i = 0; i < mensaje.length(); i++) {
			char letra = mensaje.charAt(i);
			for (int j = 0; j < alfabeto.length; j++) {
				if (letra == alfabeto[j]) {
					posicionArray = j;
				}
			}
			int posicionFinal = 0;
			if (posicionArray + codigoCifrado > alfabeto.length) {
				posicionFinal = (posicionArray + codigoCifrado) - alfabeto.length;
			}else {
				posicionFinal = posicionArray + codigoCifrado;
			}
			newMensaje = newMensaje + alfabeto[posicionFinal];
		}
		
		return newMensaje;
	}

}
