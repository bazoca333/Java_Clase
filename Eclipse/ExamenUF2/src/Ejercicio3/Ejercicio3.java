package Ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {
	public static String[] nombre = new String[5];
	public static int[] edad = new int[5];
	public static String[] ciudad = new String[5];
	
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	boolean fin = false;
	//Menu
	System.out.println("-----MENU-----");
	System.out.println("1. Insertar o eliminar ciudadano");
	System.out.println("2. Buscar ciudadano por Ciudad");
	System.out.println("3. Buscar ciudadano por nombre y edad");
	System.out.println("4. Editar ciudadano");
	System.out.println("5. Ver todos los ciudadanos");
	System.out.println("6. Salir");
	
	int eleccion = Funciones_ej3.getInput(scan);
	
	while (!fin) {
		if (eleccion == 1) {
			Funciones_ej3.insertarEliminar(nombre, edad, ciudad);
		}else if (eleccion == 2) {
			Funciones_ej3.buscarCiudad(nombre, edad, ciudad);
		}else if (eleccion == 3) {
			System.out.println("añada su nombre");
			String partnom = Funciones_ej3.getStringInput(scan);
			System.out.println("Añada la edad");
			int edadpref = Funciones_ej3.getInput(scan);
			Funciones_ej3.buscarNomEdad(nombre, edad, ciudad, partnom, edadpref);
		}else if (eleccion == 4) {
			Funciones_ej3.editarPersona(nombre, edad, ciudad);
		}else if (eleccion == 5) {
			Funciones_ej3.ver_bd(nombre, edad, ciudad);
		}else if (eleccion == 6) {
			fin = true;
		}else {
			System.out.println("No te entiendo");
		}
	}
}
}//FIN SCRIPT
