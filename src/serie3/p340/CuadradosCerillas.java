package serie3.p340;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 1: La primera línea indica el número de casos de prueba
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=340
* Ejecución desde consola:
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO envío 620573
 */

public class CuadradosCerillas {

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {

		// CASO 1: La primera entrada nos indica el número de casos que tenemos que
		// procesar

		int repeticiones;
		int ancho, alto;
		int numCerillas;

		// la primera entrada es el número de repeticiones
		repeticiones = lector.nextInt();
		// repeticiones = Integer.parseInt(lector.nextLine()); //si usamos nextLine()
		// para lectura

		for (int i = 0; i < repeticiones; i++) {

			// lectura de entradas
			ancho=lector.nextInt();
			alto=lector.nextInt();

			// procesamiento
			numCerillas=2*(ancho+alto)+(ancho-1)*alto+(alto-1)*ancho;

			// salida de resultados, en el formato que nos pida el enunciado
			System.out.println(numCerillas);

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}//fin de la clase
