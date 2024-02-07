import java.util.Scanner;

public class Ejercicio4_examen {
    public static void main(String[] args) {

        Scanner scan_s = new Scanner(System.in);
        System.out.println("Dime una frase y te invierto las mayusculas y minusculas");
        String frase = scan_s.nextLine();
        //donde guardare la nueva string
        String resultado = "";

        //Este bucle se ejecutara tantas veces como caracteres tenga la frase y asi podremos cambiar todas las letras
        for (int i = 0; i < frase.length(); i++) {
        	//defino la variable caracter que la usare para comparar si es mayuscula o minuscula la letra
        	char caracter = frase.charAt(i);
        	
        	//Si es mayuscula se convierte a minuscula
        	if (Character.isUpperCase(caracter)) {
        		char min = Character.toLowerCase(caracter);		
				resultado = resultado+min;
				//Lo contrario que el anterior
			}else if (Character.isLowerCase(caracter)){
				char may = Character.toUpperCase(caracter);		
				resultado = resultado+may;
			}else {
				//Por si hay un espacio o un caracter especial
				resultado = resultado + caracter;
			}
        }
            
        System.out.println(resultado);

    }
}
