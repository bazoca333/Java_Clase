import java.sql.Connection;
import java.util.Scanner;

public class Devolucio_compra {
	private static Connection con = bbdd.conectarBaseDatos();
	private static Scanner scan = new Scanner(System.in);
	private static Scanner scan_s = new Scanner(System.in);
	
	private static String numTiquet = "";
	private static int numlin = 0;

public static void main(String[] args) {
	boolean continuar = true;
	
	while (continuar == true) {
		
		System.out.println("----------------------------------------------------------");
        System.out.println("---Por favor, escriba el código de un tiquet---");
        System.out.println("'XXX' para salir");
		System.out.println("----------------------------------------------------------");
 
        numTiquet = scan_s.nextLine().toUpperCase();
        
		if (numTiquet.equals("XXX")) {
	       	 continuar = false;
	       	menu.main(args);
			}else {
				String x[] = {"NUMT"};
		    	String[] checkTiq = bbdd.select(con, "SELECT numt FROM PRF_TIQUET WHERE numt = " + numTiquet, x);
		        if (checkTiq.length > 0) {
		        	
		        	String y[] = {"NUMT", "DATAT", "IDE", "CLIENTE", "IMPORT_TOT", "PUNTS_TIQ"};
		        	bbdd.print(con, "SELECT NUMT, DATAT, IDE, CLIENTE, IMPORT_TOT, PUNTS_TIQ FROM PRF_TIQUET WHERE numt = '" + numTiquet + "'", y);
				    
		        	System.out.println();
		        	nova_compra.mostrarLineas(Integer.parseInt(numTiquet), numlin);
		        	continuar = false;
		        	
		        	System.out.println("Está seguro de eliminar el tiquet?");
		        	System.out.println("1. Sí");
		        	System.out.println("2. No");
		        	
		        	continuar = true;
		        	while (continuar) {
		        		int respuesta = nova_compra.getInput(scan);
		        		if (respuesta == 1) {
		        			
		        			bbdd.update(con, "UPDATE PRF_CLIENT SET totpunts = totpunts - (SELECT punts_tiq FROM PRF_TIQUET WHERE numt = "+numTiquet+") WHERE numcli = (SELECT cliente FROM PRF_TIQUET WHERE numt = "+numTiquet+")");
		        			System.out.println("Se eliminarán todas las lineas y el tiquet");
		        			bbdd.delete(con, "DELETE FROM PRF_LINTIQ WHERE numtiq = " + numTiquet);
		        			bbdd.delete(con, "DELETE FROM PRF_TIQUET WHERE numt = " + numTiquet);
		        			
		        			
		        			continuar = false;
		        		}else if (respuesta == 2) {
		        			System.out.println("Se cancela el delete");
		        			Devolucio_compra.main(args);
		        			
		        		}else {
		        			System.out.println("Por favor, ponga una de las 2 opciones");
		        		}
		        	}
		        	menu.main(args);
				
		        }else {
	                System.out.println("El ticket no existe");
				}
        

    	
	}

	

}//Fin while
}
}
