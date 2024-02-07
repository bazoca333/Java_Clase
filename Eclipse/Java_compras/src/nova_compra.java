import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

import oracle.sql.DATE;

public class nova_compra {
	private static Connection con = bbdd.conectarBaseDatos();
	private static Scanner scan = new Scanner(System.in);
	private static Scanner scan_s = new Scanner(System.in);

	
public static void main(String[] args) {
	int numClient = 1;
    LocalDate fechaActual = LocalDate.now();
   	
//Hacer un select hasta que encuentre un cliente válido
	while (bbdd.datoEncontrado == false) {
		System.out.println("Porfavor, introduzca su código de cliente");
		numClient = scan.nextInt();
		String[] a = {"NOM", "COGNOMS"};
	    bbdd.print(con, "SELECT NOM, COGNOMS FROM PRF_CLIENT where NUMCLI = " + numClient , a);

	}
	bbdd.datoEncontrado = false;
	CrearTiquet(numClient);
	mostrarMenu();
 
	 
	

}
private static void mostrarMenu() {
	System.out.println("-----SUBMENÚ PER FER UNA COMPRA-----");
	System.out.println("1. Nova línia de compra  ");
	System.out.println("2. Anul·lació de línia de compra ");
	System.out.println("3. Finalitzar compra i generar tiquet");	
	
	int eleccion = scan.nextInt();
	switch (eleccion) {
	case 1:
		novaLinia();
		break;
	case 2:
		anularLinia();
		break;
	case 3:
		finalitzarCompra();
		break;
	default:
		break;
	}
}
private static void CrearTiquet(int client) {
	String x[] = {"NUMT"};
	 String[] b = bbdd.select(con, "SELECT NUMT FROM PRF_TIQUET", x);


	 int numt = Integer.parseInt(b[0]) +1;

	 bbdd.insert(con, "INSERT INTO PRF_TIQUET  (\"NUMT\", \"DATAT\", \"CLIENTE\", \"IDE\" , \"IMPORT_TOT\", \"PUNTS_TIQ\" )\n"
	 + "VALUES ("+ numt +" , SYSDATE , " + client + ", 1 ,0, 0 )");
	
}

//OPCIONES SUBMENÚ

private static void novaLinia() {
	System.out.println("Por favor, escriba el código de un producto");
	while (bbdd.datoEncontrado == false) {
		String codiProd = scan_s.nextLine();
		String y[] = {"NOMPR", "PREUD1", "STOCK"};
		bbdd.print(con, "SELECT NOMPR, PREUD1, STOCK FROM PRF_PRODUCT WHERE codbarres = '"+codiProd+"'", y);
		
		//Hacer select stock
		String x[] = {"STOCK"};
		String[] stockDisponible = bbdd.select(con, "SELECT STOCK FROM PRF_PRODUCT WHERE codbarres = '"+codiProd+"'", x);

		if (stockDisponible[0].equals("0")) {
			bbdd.datoEncontrado = true;
			
		}else if (codiProd.equals("XXX")) {
			bbdd.datoEncontrado = true;
		}
	}
	bbdd.datoEncontrado = false;
	System.out.println("Hola");
	
}

private static void anularLinia() {
	
}

private static void finalitzarCompra() {
	
}



}//FIN
