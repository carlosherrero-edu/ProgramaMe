package navidad2020.problema2;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 1: La primera línea indica el número de casos de prueba
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=577
* 
* Ejecución desde consola:
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *Aceptado por Juez en Línea, envío 616758
 */

public class CucharadasDeSopa {

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {

		// CASO 1: La primera entrada nos indica el número de casos que tenemos que
		// procesar

		int totales;//cucharadas de sopa totales servidas por la madre
		int mafalda; //cucharadas de sopa que como MINIMO tomó Mafalda
		int padre; //cucharadas de sopa que como MAXIMO tomó el padre
		int posibles; //combinaciones posibles válidas
		int casos; //casos de prueba

		// la primera entrada es el número de repeticiones
		casos = lector.nextInt();
		// repeticiones = Integer.parseInt(lector.nextLine()); //si usamos nextLine()
		// para lectura

		for (int i = 0; i < casos; i++) {

			// lectura de entradas
			mafalda = lector.nextInt();
			padre = lector.nextInt();
			totales = lector.nextInt();
			

			// procesamiento
			posibles=0;  //iniciamos contador de combinaciones posibles
			/*
			 * Mafalda tomó un número de cucharadas entre "mafalda" y "totales"
			 * REcorremos esos valores y comprobamos si el número de cucharadas 
			 * del padre es válido- está entre 0 y "padre"
			 */
			for (int k=mafalda; k<=totales; k++) {
				if ((totales-k)>=0 && (totales-k)<=padre) {
					posibles++;
				}
				
			}

			// salida de resultados, en el formato que nos pida el enunciado
			System.out.println(posibles);

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}//fin de la clase


