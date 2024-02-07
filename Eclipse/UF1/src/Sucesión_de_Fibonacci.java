import java.util.Scanner;

public class Sucesión_de_Fibonacci {
public static void main(String[]args) {
	Scanner scan_n = new Scanner(System.in);
	Scanner scan_s = new Scanner(System.in);
	System.out.println("Dime los números que quieres en la sucesión");
	int vueltas = scan_n.nextInt();
	int num1 = 0;
	int num2 = 1;
	boolean change = true;
	
	for (int i = 0; i < vueltas; i++) {
		if (change == true) {
			System.out.println(num1);
			num1 = num1 + num2;
			change = false;
		}else if (change == false) {
			System.out.println(num2);
			num2 = num1 + num2;
			change = true;
		}
		
	}
}
}
