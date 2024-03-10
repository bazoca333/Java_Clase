import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Descifrado {
	public static char[] alfabeto = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};

	public static void main(String[] args) {
		String nombreFichero = "datos.txt";

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
				linea = descifrarMensaje(linea);

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
	
	public static String descifrarMensaje(String mensaje) {
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
			if (posicionArray - Cifrado.codigoCifrado < 0) {
				posicionFinal = (posicionArray - Cifrado.codigoCifrado) + alfabeto.length;
			}else {
				posicionFinal = posicionArray - Cifrado.codigoCifrado;
			}
			newMensaje = newMensaje + alfabeto[posicionFinal];
		}
		
		return newMensaje;
	}
}
