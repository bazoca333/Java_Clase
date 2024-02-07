package EjercicioMorse;

public class morse {
	private static char[] abecedario = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	 private static String[] morse = {".-", "-...", "-.-.","-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."  };
	    
public static String convertirMorse(String frase) {
	 String fraseConvertida = "";
	 for (int i = 0; i < frase.length(); i++) {
	 for (int j = 0; j < abecedario.length; j++) {
			if (frase.charAt(i) == abecedario[j]) {
				fraseConvertida += morse[j] + " ";
			}
		}
	 }
 return fraseConvertida;
 }

public static String convertirLetras(String morseinput) {
	 String fraseConvertida = "";
	 String almacenarLetra = "";
	 
	 
	 
	 for (int i = 0; i < morseinput.length(); i++) {
		if (morseinput.charAt(i) == ' ') {
			for (int j = 0; j < abecedario.length; j++) {
				if (almacenarLetra.equals(morse[j]) ) {
					fraseConvertida += abecedario[j];
					almacenarLetra = "";
				}				 
			}
		}else {
			almacenarLetra += morseinput.charAt(i);
		}
	}
	return fraseConvertida;
}

public static void verificarMorse(String morseinput) {
    String currentWord = "";
    String currentLetter = "";

    for (int i = 0; i < morseinput.length(); i++) {
        char currentChar = morseinput.charAt(i);

        if (currentChar == ' ' || i == morseinput.length() - 1) {
            if (i == morseinput.length() - 1) {
                currentLetter += currentChar;
            }

            boolean letraValida = false;
            for (int j = 0; j < morse.length; j++) {
                if (currentLetter.equals(morse[j])) {
                    letraValida = true;
                    break;
                }
            }

            if (!letraValida) {
                System.out.println("Codigo inválio: " + currentLetter);
                continue;
            }

            currentWord += currentLetter;
            currentLetter = "";

            if (currentChar == ' ') {
                System.out.println("Codigo válido: " + currentWord);
                currentWord = "";
            }
        } else {
            currentLetter += currentChar;
        }
    }

}

}

