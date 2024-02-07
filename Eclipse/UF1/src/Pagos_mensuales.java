import java.util.Scanner;

public class Pagos_mensuales {
	public static void main(String[]args) {
		Scanner scan_n = new Scanner(System.in);
		
		System.out.println("----BUCLE CON WHILE----");

		int mesi = 1;
		int meses = scan_n.nextInt();
		int precio_final = 0;
		int precio_inicial = 10;
		
		while(meses <=20) {
				precio_final = precio_final+ precio_inicial;
				precio_inicial = precio_inicial*2;
				mesi++;
				
				if ( mesi == meses) {
					precio_final = precio_final+ precio_inicial;
					precio_inicial = precio_inicial*2;
					mesi++;
					System.out.println("El usuario pagará: " + precio_final);
				}
		}
		
		
		int precio_final2 = 0;
		int precio_inicial2 = 10;
		System.out.println(" ");
		System.out.println("----BUCLE CON FOR----");
		
		int meses2 = scan_n.nextInt();

		for (int i = 1; i <= meses2; i++) {
			precio_final2 = precio_final2+ precio_inicial2;
			precio_inicial2 = precio_inicial2*2;
			
			if (i == 20) {
				System.out.println("El usuario pagará: " + precio_final2);
			}

		}
		
	}
}
