package serie3.p335;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 1: La primera línea indica el número de casos de prueba
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=335
* Ejecución desde consola:
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO. Envío 620487
 */

public class PiramideCanicas {

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {

		// CASO 1: La primera entrada nos indica el número de casos que tenemos que
		// procesar

		int repeticiones; // número de casos de prueba a leer
		long totalCanicas;  // total de canicas que necesitaremos
		long canicasPiso;  //canicas que componen un piso de la torre
		long numPisos;  //número de pisos que nos piden construir
		/* 
		 * elijo trabajar con variables de tipo long ya que el número de canicas puede llegar a 10^18
		 */

		// la primera entrada es el número de repeticiones
		repeticiones = lector.nextInt();
		// repeticiones = Integer.parseInt(lector.nextLine()); //si usamos nextLine()
		// para lectura

		for (int i = 0; i < repeticiones; i++) {

			// lectura de entradas
			// número de pisos de la torre que queremos construir
			numPisos=lector.nextLong();
			// procesamiento
			totalCanicas=0;
			for (long k=1; k<=numPisos; k++) {
				//calculo el número de canicas del piso k
				canicasPiso= (1+k)*k/2;
				//lo sumo al total de canicas
				totalCanicas+=canicasPiso;
			}

			// salida de resultados, en el formato que nos pida el enunciado
			System.out.println(totalCanicas);

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}//fin de la clase
