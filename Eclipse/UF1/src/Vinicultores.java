import java.util.Scanner;

public class Vinicultores {
	public static void main(String[]args) {
		//Pedirle al usuarioel tipo de uva, su tamaño y los kilos
		Scanner scan_n = new Scanner(System.in);
		Scanner scan_s = new Scanner(System.in);
		System.out.println("Qué tipo de uva traes señor cliente? (A o B)" );
		String tipo = scan_s.nextLine();
		System.out.println("Y de qué tamaño son sus uvas? (1 o 2)");
		int tamaño = scan_n.nextInt();
		System.out.println("Cuantos kg trae?");
		int kg = scan_n.nextInt();
				
		//Declarar los tipos de uvas y el tamaño
		String tipoA = "A";
		String tipoB = "B";
		
		double precio = 0;
		
		//Calcular cuanto recibirá un productor por la uva
		switch (tamaño) {
		case 1:
			if (tipo == tipoA) {
				precio = 0.20 * kg;
			}else if (tipo == tipoB) {
				precio = 0.30 * kg;
			}
			break;

		case 2:
			if (tipo == tipoA) {
				precio = 0.30 * kg;
			}else if (tipo == tipoB) {
				precio = 0.50 * kg;
			}
			break;
		
		}
		
		//Imprimir el resultado
		
		System.out.println("El precio es: " + precio);
	}
}
