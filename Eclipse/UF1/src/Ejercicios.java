import java.util.Scanner;

public class Ejercicios {
public static void main(String[]args) {
	
	
	Scanner scan_n = new Scanner(System.in);
	Scanner scan_s = new Scanner(System.in);
	
	int randomnum = (int)(Math.random()*100);
	int num = -1;
	int intentos = 10;
	
	while (num != randomnum && intentos != 0) {
		System.out.println("Adivina el número... >:)");
		int scan = scan_n.nextInt();
		if (scan == randomnum) {
			num = scan;
			System.out.println("Adivinaste el número :c");
			System.out.println("Pensaba que el número " + randomnum + " era difícil ;-;");
			
		}else  {
			System.out.println("Fallaste >:P");
			intentos--;
			scan = -1;
		}
		
		if (intentos == 0 && num != randomnum) {
			System.out.println("-------------------------");
			System.out.println("El número era: " + randomnum);
			System.out.println("-------------------------");

			
		}
		
	}
	
	
	}
}
