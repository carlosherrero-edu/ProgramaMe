package serie2.p457;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esqueleto de programa para resolver supuestos del concurso AceptaElReto Tipo
 * 2: Procesamos todas las entradas hasta encontrar una condición especial URL
 * del Problema: http://www.aceptaelreto.com/problem/statement.php?id=457
 * Ejecución desde consola(bin): >>> java paquete.Clase <ruta/sample.in >
 * ruta/sample.res >>> diff sample.out sample.res // para comprobar las
 * diferencias DA UN TLE
 */
public class LioCasosPrueba3 {

	// Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> listaCasos;

		int numCasos;
		int inicio;
		int salto;

		// CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial,
		// que ignoraremos
		boolean terminar = false; // condición de terminación

		// leemos mientras haya más líneas y no se produzca la condición de terminación
		while (!terminar && lector.hasNext()) {
			// lectura de entradas
			numCasos = lector.nextInt();

			// hay que comprobar si llegamos a la condición de terminación
			if (numCasos > 0) {
				// procesamiento
				// agregamos todos los casos en un ArrayList
				listaCasos = new ArrayList<>(numCasos);

				for (int k = 0; k < numCasos; k++) {
					// leemos un nuevo valorvalor y lo agregamos a la lista
					listaCasos.add(lector.nextInt());
				}

				boolean encontrado = false;
				inicio = 1; // comenzamos por situarnos sobre el segundo elemento de la lista de casos

				while (!encontrado && inicio < numCasos) {
					try {
						/*
						 *
						 */					
						int indice=inicio;
						while (indice<numCasos) {
							// leemos el número de elementos que hemos de desplazarnos en la lista
							salto = listaCasos.get(indice);
							//vemos si hay elemento en la posición de índice+salto.Si no lo hay, se generará excepción
							listaCasos.get(indice+salto);
							//avanzamos a la siguiente posición del último elemento leído
							indice= indice+salto+1;

						} // repetimos el proceso hasta agotar toda la lista o encontrar una excepción
						// si no se ha producido ninguna excepción al recorrer toda la lista, hemos
						// encontrado el valor que buscábamos
						encontrado = true;

					} catch (Exception e) {
						// si hay excepción, repetimos desde el siguiente valor de la lista
						inicio++;
					}

				} // fin del bucle whie

				// salida de resultados, en el formato que nos pida el enunciado
				/*
				 * el número de elementos de la lista hasta "inicio" es el valor que buscamos
				 */
				System.out.println(inicio);
			} else {
				// activamos la condición de terminación
				terminar = true;
			}
		} // fin del while

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}// fin de la clase
