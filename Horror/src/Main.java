import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Julio
 *
 */
public class Main {

	static BufferedReader in = new BufferedReader(new InputStreamReader(
			System.in));
	static PrintStream out = System.out;

	/**
	 * @param args
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws IOException, ParseException {

		int opc;
		boolean noSalir = true;

		do {
			mostrarMenu();
			opc = leerOpcion();
			noSalir = ejecutarAccion(opc);
		} while (noSalir);

	}

	static public void mostrarMenu() {

		out.println("*****************************");
		out.println("     MENU DE HORROR     ");
		out.println("*****************************");

		out.println("1. Revertir String");
		out.println("2. Multiplos y mensajes");
		out.println("3. Datos");
		out.println("4. Salir");
		out.println("\n");

	}

	static public int leerOpcion() throws java.io.IOException {

		out.print("Seleccione su opcion: ");
		int opcion = Integer.parseInt(in.readLine());
		out.println();

		return opcion;

	}

	static boolean ejecutarAccion(int opcion) throws java.io.IOException,
	ParseException {
		boolean noSalir = true;

		switch (opcion) {

		case 1: // Introducir Fecha

			out.println("    Ingrese la palabra a revertir :   " + "\n");
			String palabra = in.readLine();

			out.println(reverse(palabra));

			break;

		case 2: // Comparar Fecha

			out.println();

			break;

		case 3: // ToString

			out.println();
			// out.print(miAmigo.toString());

			break;

		case 4: // Salir

			noSalir = false;
			out.println("Gracias");
			break;

		default: // Cualquier otro valor dado por el usuario se considera
			// invalido

			out.println("Opcion invalida");
			out.println();
			break;
		}

		return noSalir;
	}

	public static String reverse(String s) {
		int length = s.length(), last = length - 1;
		char[] chars = s.toCharArray();
		for (int i = 0; i < length / 2; i++) {
			char c = chars[i];
			chars[i] = chars[last - i];
			chars[last - i] = c;
		}
		return new String(chars);
	}

}
