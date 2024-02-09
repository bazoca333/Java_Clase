import java.sql.Connection;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;

import oracle.sql.DATE;

public class nova_compra {
	private static Connection con = bbdd.conectarBaseDatos();
	private static Scanner scan = new Scanner(System.in);
	private static Scanner scan_s = new Scanner(System.in);
	
	private static int numClient = 0;
	private static String codiProd = "";
	private static int stockProducto = 0;
	
	private static int numt = 0;
	private static int numlin = 0;
	private static String cantProducto = "";
	private static float totlin = 0;
	
	private static float precioTotal = 0;
	private static int totalPuntos = 0;
	
public static void main(String[] args) {
	
   	
//Hacer un select hasta que encuentre un cliente válido
	while (bbdd.datoEncontrado == false) {
		System.out.println("----------------------------------------------------------");
		System.out.println("Porfavor, introduzca su código de cliente");
		System.out.println("----------------------------------------------------------");
		
        numClient = getInput(scan);

		String[] a = {"NOM", "COGNOMS"};
	    bbdd.print(con, "SELECT NOM, COGNOMS FROM PRF_CLIENT where NUMCLI = " + numClient , a);

	}
	bbdd.datoEncontrado = false;
	CrearTiquet(numClient);
	mostrarMenu();
 
	 
	

}
private static void mostrarMenu() {
	int eleccion = 0;
	System.out.println("-----SUBMENÚ PER FER UNA COMPRA-----");
	System.out.println("1. Nova línia de compra  ");
	System.out.println("2. Anul·lació de línia de compra ");
	System.out.println("3. Finalitzar compra i generar tiquet");
	eleccion = getInput(scan);
	
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
			}else if (Integer.parseInt(cantProducto) < 0) {
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
	String x[] = {"NUMLIN"};
	String[] b = bbdd.select(con, "SELECT NUMLIN FROM PRF_LINTIQ WHERE numtiq = " + numt, x);
	
	if (b.length > 0 && b[0].length() > 0) {
		mostrarLineas();
		System.out.println("Qué linea desea eliminar?");
		int deleteLinea = getInput(scan);	
		bbdd.delete(con, "DELETE FROM PRF_LINTIQ WHERE NUMLIN = " + deleteLinea);
		
		System.out.println();
		System.out.println("-----LINEAS RESTANTES: -----");
		System.out.println();
		mostrarLineas();

	}else {
		mostrarLineas();
	}
	System.out.println();
	mostrarMenu();
}

private static void finalitzarCompra() {
	System.out.println("-----Tiquet número "+numt+": -----");
	String[] a = {"NUMT", "DATAT", "NOM", "COGNOMS"};
    bbdd.print(con, "SELECT numt, datat, c.nom, c.cognoms  FROM PRF_TIQUET t INNER JOIN PRF_CLIENT c ON c.numcli = t.cliente WHERE numt = " + numt , a);
    System.out.println("-------------------------------");

    //Buscar lineas para el for
    String x[] = {"NUMLIN"};
	String[] b = bbdd.select(con, "SELECT NUMLIN FROM PRF_LINTIQ WHERE numtiq = " + numt, x);
    
	if (b.length > 0 && b[0].length() > 0) {
	    numlin = Integer.parseInt(b[0]);
		for (int i = 0; i < numlin; i++) {
			String[] titulo = {"TOTLIN"};
			String s = "SELECT TOTLIN FROM PRF_LINTIQ where numtiq = " + numt +" AND numlin = " + (i+1);
			String[] eurosLinea = bbdd.select(con, s, titulo);
		    //Sumo puntos y euros
		    System.out.println(eurosLinea[0]);
		    precioTotal += Float.parseFloat(eurosLinea[0]);
		    
		}
	    totalPuntos = Math.round(precioTotal*10);
		bbdd.update(con, "UPDATE PRF_Client SET TOTPUNTS = (SELECT TOTPUNTS FROM PRF_Client WHERE numcli = " + numClient + ") + " + totalPuntos + " WHERE numcli = " + numClient);

	    
	} else {
	    System.out.println("No hay líneas de este tiquet");
	}
    
    System.out.println("-----Total de la compra: " + String.format("%.2f", precioTotal) + "€");
    System.out.println("-----Puntos agregados al usuario: " + totalPuntos);
    System.out.println();
    mostrarMenu();
}

	

private static void mostrarLineas() {
	String x[] = {"NUMLIN"};
	String[] b = bbdd.select(con, "SELECT NUMLIN FROM PRF_LINTIQ WHERE numtiq = " + numt, x);
	
	if (b.length > 0 && b[0].length() > 0) {
	    numlin = Integer.parseInt(b[0]);
		for (int i = 0; i < numlin; i++) {
			System.out.println("-------Línea de tiquet " + (i+1) + "-------");
			String[] a = {"NUMTIQ", "NUMLIN", "NOMPR", "QUANTITAT", "TOTLIN"};
		    bbdd.print(con, "SELECT NUMTIQ, NUMLIN, NOMPR, QUANTITAT, TOTLIN FROM PRF_LINTIQ l "
		    		+ "INNER JOIN PRF_PRODUCT p ON l.prod = p.CODBARRES  where l.NUMTIQ = " + numt + " AND l.numlin = " + (i+1) , a);
		    System.out.println("-------------------------------");
	}
	} else {
	    System.out.println("No hay líneas de este tiquet");
	}
	

}

public static int getInput(Scanner scanner) {
    boolean inputValid = false;
    int eleccion = 0;

    while (!inputValid) {
        if (scanner.hasNextInt()) {
            eleccion = scanner.nextInt();
            inputValid = true;
        } else {
            System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
            scanner.next();
        }
    }

    return eleccion;
}


}//FIN
