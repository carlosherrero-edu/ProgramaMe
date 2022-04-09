package serie4.p478;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Esqueleto de programa para resolver supuestos del concurso AceptaElReto Tipo
 * 2: Procesamos todas las entradas hasta encontrar una condición especial URL
 * del Problema: https://www.aceptaelreto.com/problem/statement.php?id=478
 * Ejecución desde consola(bin): >>> java paquete.Clase <ruta/sample.in >
 * ruta/sample.res >>> diff sample.out sample.res // para comprobar las
 * diferencias NO ACEPTADO: Runtime Error
 */
public class Conjuritis {

	// Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {

		int numEle;// número de elementos que leemos -armas-
		int[] valores; // array con los poderes destructivos de cada arma
		int suma; // suma de los valores de los poderes destructivos
		int poder; // valor del poder destructivo efectivo de todas las armas, excepto 2 que son
					// inútiles
		int diferencia; // diferencia entre suma y poder
		int tope; // índice del último elemento en la sublista donde vamos a buscar
		int termino1, termino2;

		// CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial,
		// que ignoraremos
		boolean terminar = false; // condición de terminación

		// leemos mientras haya más líneas y no se produzca la condición de terminación
		while (!terminar && lector.hasNext()) {

			numEle = lector.nextInt();

			// hay que comprobar si llegamos a la condición de terminación
			if (!(numEle == 0)) {
				// procesamiento
				valores = new int[numEle];
				suma = 0;
				for (int k = 0; k < numEle; k++) {
					// leemos y sumamos
					valores[k] = lector.nextInt();
					suma += valores[k];
				}
				// leemos ahora el poder efectivo
				poder = lector.nextInt();
				/*
				 * //hemos de buscar ahora 2 términos de la serie cuya suma sea igual la
				 * diferencia (suma-poder) //tomamos la sublista de los términos menores que esa
				 * diferencia Nos basamos en el hecho de que la lista está ordenada
				 */

				diferencia = suma - poder;
				int posEncontrado = Arrays.binarySearch(valores, diferencia);

				if (posEncontrado >= 0) {
					// hemos de empezar a buscar en el elemento anterior al que contiene el valor de la diferencia
					tope = posEncontrado - 1;
				} else {
					// hemos de iniciar la búsqueda en el elemento anterior a aquél donde debería
					// insertarse el valor de la diferencia.
					tope = (-1) * (posEncontrado + 1) - 1;
				}
				/*
				 * Nos iremos desplazando desde tope hasta el inicio de la lista y buscamos dos
				 * términos de la sublista entre 0 ... tope tales que la suma de sus valores sea
				 * igual a la diferencia que buscamos
				 * 
				 * 
				 */
				boolean encontrado = false;

				termino1 = -1;
				termino2 = -1; // esta inicialización es para evitar errores de compilación
				while (!encontrado && tope >= 0) {

					// vemos si existe en el array una combinación de valores que
					if (Arrays.binarySearch(valores, diferencia - valores[tope]) >= 0) {
						// hemos encontrado las dos parejas de valores que buscábamos
						termino1 = valores[Arrays.binarySearch(valores, diferencia - valores[tope])];
						termino2 = valores[tope];
						encontrado = true;
						break;

					} else {
						// no hemos encontrado aún el valor, probamos disminuyendo tope
						tope--;
					}

				} // fin del bucle while

				// salida de resultados, en el formato que nos pida el enunciado
				System.out.format("%d %d%n", termino1, termino2);
			} else {
				// activamos la condición de terminación
				terminar = true;
			}
		} // fin del while

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}// fin de la clase
