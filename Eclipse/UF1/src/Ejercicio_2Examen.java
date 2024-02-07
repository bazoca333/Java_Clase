import java.util.Scanner;

public class Ejercicio_2Examen {
    public static void main(String[] args) {
        // Declaro el scanner para pedir el número
        Scanner scan_n = new Scanner(System.in);

        System.out.println("Soy una calculadora de números factoriales, dime un número:");
        // Le pido el número al usuario
        int numero = scan_n.nextInt();
        // Declaro la variable factorial para que empiece siempre en 1 y se vaya multiplicando por i
        int factorial = 1;
        //Hago que resultado siempre empieze en 1(como factorial) y luego le ire sumando los demas numeros
        String resultado = "1";
        
        //Este bucle seguirá ejecutandose hasta que i sea igual que el numero, sirve para calcular los numeros factoriales una determinada cantidad de numeros y no infinita
        for (int i = 2; i <= numero; i++) {
            factorial *= i;
            // Actualizo la string resultado con el valor actual de i
            resultado += " * " + i;
            System.out.println(resultado + " = " + factorial);
        }

    }
}
