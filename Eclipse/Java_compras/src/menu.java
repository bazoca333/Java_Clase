import java.sql.Connection;
import java.util.Scanner;

public class menu {
	public static Connection con;
	String[] a = new String[10];
	String[] b = new String[10];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Ejemplo de uso con la tabla ACTOR y las columnas NACTOR NOMBRE FECHAN
		Connection con = bbdd.conectarBaseDatos();
//		String[] a = {"NACTOR", "NOMBRE", "FECHAN"};
//		bbdd.print(con, "SELECT * FROM ACTOR", a);
//		System.out.println("Insert");
//		bbdd.insert(con, "INSERT INTO ACTOR (\"NACTOR\", \"NOMBRE\", \"FECHAN\")\n"
//				+ "VALUES (2, 'John Doe', TO_DATE('2024-01-18', 'YYYY-MM-DD'))");
//		bbdd.print(con, "SELECT * FROM ACTOR", a);
//		System.out.println("Update");
//		bbdd.update(con, "UPDATE ACTOR\n"
//				+ "SET \"NOMBRE\" = 'New Name'\n"
//				+ "WHERE \"NACTOR\" = 2 ");
//		bbdd.print(con, "SELECT * FROM ACTOR", a);
//		System.out.println("Delete");
//		bbdd.delete(con, "DELETE FROM ACTOR\n"
//				+ "WHERE \"NACTOR\" = 2");
//		bbdd.print(con, "SELECT * FROM ACTOR", a);
//		System.out.println("Select");
//		String[] b = bbdd.select(con, "SELECT * FROM ACTOR", a);
//		for (int i = 0; i < a.length; i++) {
//			System.out.println("Columna " + a[i] + " resultado " + b[i]);
//		}
		System.out.println("----------------------------------------------------------");
		System.out.println("MENÚ");
		System.out.println("1. Nova compra");
		System.out.println("2. Devolució d’una compra");
		System.out.println("3. Consulta de punts");	
		System.out.println("4. Consultar d’historial de compres");
		System.out.println("5. Sortir");
		System.out.println("----------------------------------------------------------");


		int eleccion = scan.nextInt();
		switch (eleccion) {
		case 1:
			nova_compra.main(args);
			break;

		default:
			break;
		}
//		String[] a = {"IDCLIENTE", "NOMBRE"};
//		bbdd.print(con, "SELECT * FROM CLIENTES", a);
	
	}

}
