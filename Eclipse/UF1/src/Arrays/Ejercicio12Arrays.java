package Arrays;
	import java.util.Scanner;
	
	public class Ejercicio12Arrays {
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
	
		int[] alturas = new int[10];
		System.out.println("Dime 10 alturas");
		
		int mediaAltura =0;
		
		for (int i = 0; i < alturas.length; i++) {
			alturas[i] = scan.nextInt();
		}
		
		for (int i = 0; i < alturas.length; i++) {
			mediaAltura = mediaAltura + alturas[i];
		}
		
		mediaAltura = mediaAltura/alturas.length;
		
		int superiorMedia = 0;
		int inferiorMedia = 0;
		for (int i = 0; i < alturas.length; i++) {
			if (alturas[i] >= mediaAltura) {
				superiorMedia++;
			}else {
				inferiorMedia++;
			}
		}
		
		System.out.println("La media es: " + mediaAltura);
		System.out.println("Hay " + superiorMedia + " personas más altas que la media");
		System.out.println("Hay " + inferiorMedia + " personas menos altas que la media");
		
	}
	}
