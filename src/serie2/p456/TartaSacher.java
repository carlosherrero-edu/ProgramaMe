package serie2.p456;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 1: La primera línea indica el número de casos de prueba
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=456
* Ejecución desde consola:
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO Envío 617843
 */

public class TartaSacher {

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {

		// CASO 1: La primera entrada nos indica el número de casos que tenemos que
		// procesar

		int repeticiones;
		int ancho, alto;  //cuadritos que existen a lo ancho y lo alto en una tableta
		int cuadritosReceta; //cuadritos necesarios en la receta original

		// la primera entrada es el número de repeticiones
		repeticiones = lector.nextInt();
		// repeticiones = Integer.parseInt(lector.nextLine()); //si usamos nextLine()
		// para lectura

		for (int i = 0; i < repeticiones; i++) {

			// lectura de entradas
			ancho=lector.nextInt();
			alto=lector.nextInt();
			cuadritosReceta=lector.nextInt();

			// procesamiento
			/* Hago la división entera entre los cuadritos necesarios y los cuadritos en cada receta
			 * Si la división no es entera, además sumo 1
			 */
			
			int tabletasNecesarias= cuadritosReceta/(ancho*alto)  + (cuadritosReceta%(ancho*alto)==0?0:1);
			// salida de resultados, en el formato que nos pida el enunciado
			System.out.println(tabletasNecesarias);

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}//fin de la clase
