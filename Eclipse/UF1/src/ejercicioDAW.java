import java.util.Scanner;

public class ejercicioDAW {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nombreapellidos = scan.nextLine();

        // Dividir la cadena en palabras individuales usando el método split
        String[] array = nombreapellidos.split("a");

        // Imprimir las palabras por separado
        for (String palabra : array) {
            System.out.println(palabra);
        }
    }
}
