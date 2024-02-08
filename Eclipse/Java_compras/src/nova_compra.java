import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

import oracle.sql.DATE;

public class nova_compra {
	private static Connection con = bbdd.conectarBaseDatos();
	private static Scanner scan = new Scanner(System.in);
	private static Scanner scan_s = new Scanner(System.in);
	
	private static String codiProd = "";
	private static String codBarresProd = "";
	private static int stockProducto = 0;
	
public static void main(String[] args) {
	int numClient = 1;
    LocalDate fechaActual = LocalDate.now();
   	
//Hacer un select hasta que encuentre un cliente válido
	while (bbdd.datoEncontrado == false) {
		System.out.println("----------------------------------------------------------");
		System.out.println("Porfavor, introduzca su código de cliente");
		System.out.println("----------------------------------------------------------");

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
    boolean productoAgotado = true;
    boolean continuar = true;
    while (productoAgotado) {
		System.out.println("----------------------------------------------------------");
        System.out.println("---Por favor, escriba el código de un producto---");
        System.out.println("'XXX' para salir");
		System.out.println("----------------------------------------------------------");

        codiProd = scan_s.nextLine().toUpperCase();
        
        if (codiProd.equals("XXX")) {
       	 productoAgotado = false;
       	 continuar = false;
		}else {
	        String y[] = {"NOMPR", "PREUD1", "STOCK"};
	        String[] checkProduct = bbdd.select(con, "SELECT NOMPR, PREUD1, STOCK FROM PRF_PRODUCT WHERE codbarres = '" + codiProd + "'", y);
	        if (checkProduct.length > 0) {
		        bbdd.print(con, "SELECT NOMPR, PREUD1, STOCK FROM PRF_PRODUCT WHERE codbarres = '" + codiProd + "'", y);
			       
		        // Hacer select stock
		        String x[] = {"STOCK"};
		        String[] stockDisponible = bbdd.select(con, "SELECT STOCK FROM PRF_PRODUCT WHERE codbarres = '" + codiProd + "'", x);
		        stockProducto = Integer.parseInt(stockDisponible[0]);
		        if (stockDisponible.length > 0 && stockDisponible[0].equals("0")) {
		            System.out.println("Lo siento, el producto está agotado.");
		        } else {
		            productoAgotado = false; 
		        }
			}else {
                System.out.println("El producto no existe");
			}
		}    
    }
    if (continuar) {
    	while (continuar) {
    		System.out.println("----------------------------------------------------------");
        	System.out.println("Cuántas unidades del producto le gustaría comprar?");
        	System.out.println("El stock actual del producto elegido es de: " + stockProducto);
        	System.out.println("'XXX' para salir");
    		System.out.println("----------------------------------------------------------");

            String cantProducto = scan_s.nextLine().toUpperCase();
            
            if (cantProducto.equals("XXX")) {
              	 continuar = false;
       		}else {
                if (Integer.parseInt(cantProducto) <= stockProducto) {
                	continuar = false;
        		}else {
        			System.out.println("Lo siento, no hay suficiente stock.");
        		}
			}
            

		}


	}
    }


private static void anularLinia() {
	
}

private static void finalitzarCompra() {
	
}



}//FIN
