package Funciones;

import java.util.Iterator;

public class Morse {

    private static String[] abecedario = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    // Array con el código Morse correspondiente a cada letra
    private static String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."  };
    
	public static void main(String[] args) {
		encontrarMorse();
	}
	
	private static void	encontrarMorse() {
		String letra_buscar = "K";
		for (int i = 0; i < abecedario.length; i++) {
			if (letra_buscar.equals(abecedario[i])) {
				System.out.println(morse[i]);
			}
		}
	}

}
