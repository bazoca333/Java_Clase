package Arrays;
import java.util.Scanner;

public class Ejercicio13Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de DNI (sin la letra): ");
        int numeroDNI = scanner.nextInt();

        char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        int resto = numeroDNI % 23;
        char letraDNI = letrasDNI[resto];

        System.out.println("El DNI completo es: " + numeroDNI + letraDNI);
    }
}
