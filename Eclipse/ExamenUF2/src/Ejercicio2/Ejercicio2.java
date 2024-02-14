package Ejercicio2;
import java.util.Scanner;

public class Ejercicio2 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	double ancho;
	double alto;
	
	System.out.println("Por favor, ponga el ancho y el alto de un rectángulo");
	System.out.println("Ancho: ");
	ancho = scan.nextDouble();
	System.out.println("Alto: ");
	alto = scan.nextDouble();
	
	double a = Rectangulo.calcularArea(alto, ancho);
	double p = Rectangulo.calcularPerimetro(alto, ancho);
	
	System.out.println("El area del rectangulo es de " + a + " y el perímetro es de " + p);
}

}
