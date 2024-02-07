import java.util.Scanner;

public class PiramideAsteriscos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la altura de la pirámide: ");
        
        int altura = scanner.nextInt();
        
        System.out.println("¿Deseas una pirámide normal (N) o invertida (I)?");
        String tipoPiramide = scanner.next();
        
        if (tipoPiramide.equalsIgnoreCase("N")) {
            dibujarPiramideNormal(altura);
        } else if (tipoPiramide.equalsIgnoreCase("I")) {
            dibujarPiramideInvertida(altura);
        } else {
            System.out.println("Opción no válida. Debes seleccionar 'N' o 'I' para el tipo de pirámide.");
        }
        
        scanner.close();
    }
    
    public static void dibujarPiramideNormal(int altura) {
        for (int i = 1; i <= altura; i++) {
            // Imprime espacios en blanco a la izquierda
            for (int j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }
            
            // Imprime asteriscos
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            
            // Salto de línea para la siguiente fila
            System.out.println();
        }
    }
    
    public static void dibujarPiramideInvertida(int altura) {
        for (int i = altura; i >= 1; i--) {
            // Imprime espacios en blanco a la izquierda
            for (int j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }
            
            // Imprime asteriscos
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            
            // Salto de línea para la siguiente fila
            System.out.println();
        }
    }
}
