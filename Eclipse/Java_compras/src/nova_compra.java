import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

import oracle.sql.DATE;

public class nova_compra {
	private static Connection con = bbdd.conectarBaseDatos();
	private static Scanner scan = new Scanner(System.in);
	private static Scanner scan_s = new Scanner(System.in);
	
	private static String codiProd = "";
	private static int stockProducto = 0;
	
	private static int numt = 0;
	private static int numlin = 0;
	private static String cantProducto = "";
	private static float totlin = 0;
	
public static void main(String[] args) {
	int numClient = 1;
    LocalDate fechaActual = LocalDate.now();
   	
//Hacer un select hasta que encuentre un cliente válido
	while (bbdd.datoEncontrado == false) {
		boolean inputValid = false;
		while (!inputValid) {
			System.out.println("----------------------------------------------------------");
			System.out.println("Porfavor, introduzca su código de cliente");
			System.out.println("----------------------------------------------------------");
			
			if (scan.hasNextInt()) {
                numClient = scan.nextInt();
                inputValid = true;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
                scan.next();
            }
		}
		
		
		String[] a = {"NOM", "COGNOMS"};
	    bbdd.print(con, "SELECT NOM, COGNOMS FROM PRF_CLIENT where NUMCLI = " + numClient , a);

	}
	bbdd.datoEncontrado = false;
	CrearTiquet(numClient);
	mostrarMenu();
 
	 
	

}
private static void mostrarMenu() {
	int eleccion = 0;
	boolean inputValid = false;
	while (!inputValid) {
		System.out.println("-----SUBMENÚ PER FER UNA COMPRA-----");
		System.out.println("1. Nova línia de compra  ");
		System.out.println("2. Anul·lació de línia de compra ");
		System.out.println("3. Finalitzar compra i generar tiquet");
		
		if (scan.hasNextInt()) {
			eleccion = scan.nextInt();
			inputValid = true;
        } else {
            System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
            scan.next();
        }
	}
	

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


	 numt = Integer.parseInt(b[0]) +1;

	 bbdd.insert(con, "INSERT INTO PRF_TIQUET  (\"NUMT\", \"DATAT\", \"CLIENTE\", \"IDE\" , \"IMPORT_TOT\", \"PUNTS_TIQ\" )\n"
	 + "VALUES ("+ numt +" , SYSDATE , " + client + ", 1 ,0, 0 )");	
	
}

//OPCIONES SUBMENÚ

private static void novaLinia() {
    boolean productoAgotado = true;
    boolean continuar = true;
    boolean crearLinia = false;
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

            cantProducto = scan_s.nextLine().toUpperCase();
            
            if (cantProducto.equals("XXX")) {
              	 continuar = false;
       		}else if (cantProducto.equals("0")) {
				System.out.println("Ingrese un número válido");
			}else {	
                if (Integer.parseInt(cantProducto) <= stockProducto) {
                	crearLinia = true;
                	continuar = false;          
        		}else {
        			System.out.println("Lo siento, no hay suficiente stock.");
        		}
			}
		}
    	
    	if (crearLinia) {
    		String x[] = {"NUMLIN"};
    		String[] b = bbdd.select(con, "SELECT NUMLIN FROM PRF_LINTIQ WHERE numtiq = " + numt, x);

    		if (b.length > 0 && b[0].length() > 0) {
    		    numlin = Integer.parseInt(b[0]) + 1;
    		} else {
    		    numlin = 1;
    		}

    		//Buscar el precio del producto y multiplicarlo por la cantidad
    		String y[] = {"PREUD1"};
    		String[] preuObj = bbdd.select(con, "SELECT PREUD1 FROM PRF_PRODUCT WHERE codbarres = '" + codiProd + "'", y);
    		totlin = Float.parseFloat(preuObj[0]) * Integer.parseInt(cantProducto);

    		//Crear insert a la PRF_LINTIQ
    		 bbdd.insert(con, "INSERT INTO PRF_LINTIQ  (NUMTIQ, NUMLIN, PROD, QUANTITAT , TOTLIN)\n"
    		 + "VALUES ("+ numt +" , " + numlin + " , " + codiProd + ", " + Integer.parseInt(cantProducto) + " ," + totlin + ")");	

    		 
    		 bbdd.update(con, "UPDATE PRF_PRODUCT SET STOCK = (SELECT STOCK FROM PRF_PRODUCT WHERE CODBARRES = '" + codiProd + "') - " + cantProducto + " WHERE CODBARRES = '" + codiProd + "'");
		}

    	mostrarMenu();
	}
    }//FIN


private static void anularLinia() {
	
}

private static void finalitzarCompra() {
	
}


}//FIN
