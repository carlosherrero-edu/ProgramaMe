package plantillas;

import java.util.Scanner;

/**
 * Esqueleto de programa para resolver supuestos del concurso AceptaElReto 
 * Tipo 3: Leemos casos de prueba mientras no existan más entradas
 * URL del Problema:
 * 
 * Ejecución desde consola (bin): >>> java paquete.Clase <ruta/sample.in >
 * ruta/sample.res >>> diff sample.out sample.res // para comprobar las diferencias
 */
public class PlantillaTipo3 {

	// Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		// CASO 3: Hemos de procesar todas las entradas hasta llegar al fin del flujo de
		// entrada
		while (lector.hasNext()) {
			// leemos mientras tengamos algo que leer en el flujo de entrada
			// lectura de entradas

			// procesamiento

			// salida de resultados, en el formato que nos pida el enunciado
			System.out.println("*************");

		} // fin del bucle while en el que leemos entradas
		lector.close(); // liberación del objeto Scanner

	} // fin del main

}
