import java.sql.Connection;
import java.util.Scanner;

public class Devolucio_compra {
	private static Connection con = bbdd.conectarBaseDatos();
	private static Scanner scan = new Scanner(System.in);
	private static Scanner scan_s = new Scanner(System.in);
	
	private static String numTiquet = "";

public static void main(String[] args) {
	boolean tiquetEncontrado = false;
	boolean continuar = true;
	
	while (continuar == true) {
		
		System.out.println("----------------------------------------------------------");
        System.out.println("---Por favor, escriba el código de un tiquet---");
        System.out.println("'XXX' para salir");
		System.out.println("----------------------------------------------------------");
 
        numTiquet = scan_s.nextLine().toUpperCase();
        
		if (numTiquet.equals("XXX")) {
	       	 tiquetEncontrado = false;
	       	 continuar = false;
			}else {
				String x[] = {"NUMT"};
		    	String[] checkTiq = bbdd.select(con, "SELECT numt FROM PRF_TIQUET WHERE numt = " + numTiquet, x);
		        if (checkTiq.length > 0) {
		        	String y[] = {"NOMPR", "PREUD1", "STOCK"};
		        	bbdd.print(con, "SELECT NOMPR, PREUD1, STOCK FROM PRF_PRODUCT WHERE codbarres = '" + numTiquet + "'", y);
				    
		        	tiquetEncontrado = true;
		        	
				}else {
	                System.out.println("El producto no existe");
				}
        

    	
	}
	System.out.println("hola");

}//Fin while
}
}
