import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class historial_compres {
    private static Connection con = bbdd.conectarBaseDatos();
    private static int numclient = 0;
    private static Scanner scan = new Scanner(System.in);

    private static Date fechaInicio;
    private static Date fechaFinal;

    public static void main(String[] args) {
        // Pedir y validar fechas
        fechaInicio = validarFechas("Dame una fecha de inicio (formato dd/MM/yyyy): ");
        fechaFinal = validarFechas("Dame una fecha final (formato dd/MM/yyyy): ");

        // Mostrar tickets
        mostrarTickets(5, 10);  // Parámetros de ejemplo, reemplázalos con los valores reales
    }

    private static Date validarFechas(String mensaje) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        boolean fechasValidas = false;

        while (!fechasValidas) {
            try {
                System.out.print(mensaje);
                String fechaStr = scan.nextLine();
                fecha = dateFormat.parse(fechaStr);
                fechasValidas = true;
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. Inténtelo de nuevo.");
            }
        }

        return fecha;
    }

    public static void mostrarTickets(int numt, int numlin) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaInicioStr = dateFormat.format(fechaInicio);
        String fechaFinalStr = dateFormat.format(fechaFinal);
        //Cuento los registros que hay
        String x[] = {"NUMT"};
        String[] checkTiq = bbdd.select(con, "SELECT COUNT(numt) AS NUMT FROM PRF_TIQUET WHERE DATAT >= TO_DATE('"+ fechaInicioStr+"', 'DD/MM/YYYY') AND DATAT < TO_DATE('"+ fechaFinalStr +"', 'DD/MM/YYYY') + INTERVAL '1' DAY", x);
    	String[] tiqOrder = new String[Integer.parseInt(checkTiq[0])];
    	
    	for (int i = 0; i < Integer.parseInt(checkTiq[0]); i++) {
    		System.out.println("SELECT numt, rnk FROM (SELECT numt, RANK() OVER (ORDER BY numt) AS rnk FROM PRF_TIQUET WHERE DATAT >= TO_DATE('"+ fechaInicioStr +"', 'DD/MM/YYYY') AND DATAT < TO_DATE('"+ fechaFinalStr +"', 'DD/MM/YYYY') + INTERVAL '1' DAY) WHERE rnk = "+(i+1));
        	String[] ordenar = bbdd.select(con, "SELECT numt, rnk FROM (SELECT numt, RANK() OVER (ORDER BY numt) AS rnk FROM PRF_TIQUET WHERE DATAT >= TO_DATE('"+ fechaInicioStr +"', 'DD/MM/YYYY') AND DATAT < TO_DATE('"+ fechaFinalStr +"', 'DD/MM/YYYY') + INTERVAL '1' DAY) WHERE rnk = "+(i+1), x);
    		tiqOrder[i] = ordenar[0];
		}
                
        //Imprimo los registros individualmente (por estetica)
        for (int i = 0; i < Integer.parseInt(checkTiq[0]) ; i++) {
            System.out.println("-------Ticket número " + (i + 1) + "-------");
            String y[] = {"NUMT", "DATAT", "IDE", "CLIENTE", "IMPORT_TOT", "PUNTS_TIQ"};

            bbdd.print(con, "SELECT NUMT, DATAT, IDE, CLIENTE, IMPORT_TOT, PUNTS_TIQ FROM PRF_TIQUET WHERE DATAT >= TO_DATE('"
                    + fechaInicioStr + "', 'DD/MM/YYYY') AND DATAT < TO_DATE('" + fechaFinalStr
                    + "', 'DD/MM/YYYY') + INTERVAL '1' DAY  AND NUMT = " + tiqOrder[i], y);
            System.out.println("-------------------------------");
        }
    }
}