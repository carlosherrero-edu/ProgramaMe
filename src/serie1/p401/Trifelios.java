package serie1.p401;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 1: La primera línea indica el número de casos de prueba
* URL del Problema:
* http://www.aceptaelreto.com/problem/statement.php?id=401
* Ejecución desde consola:
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO envío 617329
 */

public class Trifelios {

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);
	
	static boolean sonTrifelios(String palabra1, String palabra2) {
		 return esTrifelio(palabra1,palabra2) && esTrifelio(palabra2, palabra1);
	}
	
	static boolean esTrifelio (String palabra1, String palabra2) {
		/*
		 * Para que palabra1 sea trifelio de palabra2 , debe cumplirse lo siguiente:
		 * palabra2 debe estar dentro de la secuencia   palabra1.concat(palabra1), comenzando en una posición distinta de la primera
		 * al extraer palabra2 de la secuencia palabra1.concat(palabra1), debe quedar palabra1
		 */
		boolean resultado=false;
		String secuencia=palabra1.concat(palabra1);
		if (secuencia.indexOf(palabra2)>0) {
			//tomamos los trozos de la secuencia antes y después de "palabra2"
			String trozo1= secuencia.substring(0, secuencia.indexOf(palabra2) );
			String trozo2= secuencia.substring(secuencia.indexOf(palabra2)+palabra2.length());
			if ( trozo1.concat(trozo2).equals(palabra1)) {
				//se cumplen todas las condiciones
				resultado=true;
			}
		}
		return resultado;
	}

	public static void main(String[] args) {
		String palabra1, palabra2;

		// CASO 1: La primera entrada nos indica el número de casos que tenemos que
		// procesar

		int repeticiones;

		// la primera entrada es el número de repeticiones
		repeticiones = lector.nextInt();
		// repeticiones = Integer.parseInt(lector.nextLine()); //si usamos nextLine()
		// para lectura

		for (int i = 0; i < repeticiones; i++) {

			// lectura de entradas, que son 2 palabras. Las convertimos a mayúsculas y eliminamos posibles espacios blancos
			palabra1= lector.next().toLowerCase().trim();
			palabra2= lector.next().toLowerCase().trim();

			// procesamiento
			//en ambas palabras, sustituimos "v" por "b" - podría hacerse al revés
			palabra1=palabra1.replace('v', 'b');
			palabra2=palabra2.replace('v', 'b');

			// salida de resultados, en el formato que nos pida el enunciado
			if (sonTrifelios(palabra1,palabra2)) {
				System.out.println("SI");
			} else {
				System.out.println("NO");
			}
			

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}//fin de la clase
