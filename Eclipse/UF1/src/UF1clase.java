import java.util.Scanner;

public class UF1clase {
	public static void main(String[] args) {
		String mul = "multiplicacion";
		String sum = "suma";
		String res = "resta";
		String div = "division";

		Scanner scan_n = new Scanner(System.in);
		Scanner scan_s = new Scanner(System.in);

		String parar = "si";

		while (parar.equals("si") || parar.equals("Si")) {

			System.out.println("Esta es una calculadora, dime qué quieres hacer");
			System.out.println("--------------------------------------------");
			System.out.println("Suma = +");
			System.out.println("Resta = -");
			System.out.println("Multiplicación = x|*");
			System.out.println("División = /");

			System.out.println("--------------------------------------------");
			System.out.println("Escribe 'Parar' para cerrar la aplicación");

			String estado = scan_s.nextLine();

			if (estado.equals("+")) {

				System.out.println("Ok, pon el primer número: ");
				int n1 = scan_n.nextInt();
				System.out.println("Ahora el siguiente: ");
				int n2 = scan_n.nextInt();
				int result = n1 + n2;
				System.out.println("El resultado es: " + result);

			} else if (estado.equals("-")) {
				System.out.println("Ok, pon el primer número: ");
				int n1 = scan_n.nextInt();
				System.out.println("Ahora el siguiente: ");
				int n2 = scan_n.nextInt();
				int result = n1 - n2;
				System.out.println("El resultado es: " + result);
			}

			else if (estado.equals("x") || estado.equals("*")) {
				System.out.println("Ok, pon el primer número: ");
				int n1 = scan_n.nextInt();
				System.out.println("Ahora el siguiente: ");
				int n2 = scan_n.nextInt();
				int result = n1 * n2;
				System.out.println("El resultado es: " + result);
			}

			else if (estado.equals("/")) {
				System.out.println("Ok, pon el primer número: ");
				int n1 = scan_n.nextInt();
				System.out.println("Ahora el siguiente: ");
				int n2 = scan_n.nextInt();
				int result = n1 / n2;
				System.out.println("El resultado es: " + result);
			}

			if (!estado.equals("Parar")) {
				System.out.println(" ");
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("Quieres realizar otra operación?");
				String par = scan_s.nextLine();
				parar = par;
			} else if (estado.equals("parar") || estado.equals("Parar")) {
				System.out.println("Se está cerrando el programa...");
				parar = "no";
			}

		}
		System.out.println("Programa cerrado");

	}
}
