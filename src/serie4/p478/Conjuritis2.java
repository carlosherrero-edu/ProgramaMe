package serie4.p478;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Esqueleto de programa para resolver supuestos del concurso AceptaElReto Tipo
 * 2: Procesamos todas las entradas hasta encontrar una condición especial URL
 * del Problema: https://www.aceptaelreto.com/problem/statement.php?id=478
 * Ejecución desde consola(bin): >>> java paquete.Clase <ruta/sample.in >
 * ruta/sample.res >>> diff sample.out sample.res // para comprobar las
 * diferencias 
 * ACEPTADO ENVÍO xxxxx
 */
public class Conjuritis2 {

	// Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {

		int numEle;// número de elementos que leemos -armas-
		long[] valores; // array con los poderes destructivos de cada arma
		long suma; // suma de los valores de los poderes destructivos
		long poder; // valor del poder destructivo efectivo de todas las armas, excepto 2 que son
					// inútiles
		long diferencia; // diferencia entre suma y poder
		
		long termino1, termino2;

		// CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial,
		// que ignoraremos
		boolean terminar = false; // condición de terminación

		// leemos mientras haya más líneas y no se produzca la condición de terminación
		while (!terminar && lector.hasNext()) {

			numEle = lector.nextInt();

			// hay que comprobar si llegamos a la condición de terminación
			if (!(numEle == 0)) {
				/*
				 * 5*10⁵*2*10*5=10*10¹0=10¹1---> puede exceder int: usar long
				 * 
				 */
				// procesamiento
				valores = new long[numEle];
				suma = 0;
				for (int k = 0; k < numEle; k++) {
					// leemos y sumamos
					valores[k] = lector.nextLong();
					suma += valores[k];
				}
				// leemos ahora el poder efectivo de todos los conjuros
				poder = lector.nextLong();
				/*
				 * Nos basamos en el hecho de que la lista está ordenada,
				 * aunque podemos ordenarla previamente
				 */
				Arrays.sort(valores);

				diferencia = suma - poder;
				
				/*
				 * Buscamos dos términos de la lista que sumen el valor de "diferencia"
				 * El enunciado nos garantiza que hay solución y es única
				 * Nos iremos desplazando desde el comienzo hasta un valor de la lista que exceda diferencia
				 *  y buscamos dos términos de la sublista tales que la suma de sus valores sea
				 * igual a la diferencia que buscamos
	
				 */
				int indice=0; //empezamos la búsqueda en el primer elemento
				boolean encontrado = false;

				termino1 = -1;
				termino2 = -1; // esta inicialización es para evitar errores de compilación
				while (!encontrado && valores[indice]<diferencia) {

					// vemos si existe en el array una combinación de valores que sumen 'diferencia'
					int segundo=Arrays.binarySearch(valores, diferencia - valores[indice]);
					if (segundo>= 0) {
						// hemos encontrado las dos parejas de valores que buscábamos
						termino1 = valores[indice];
						termino2 = valores[segundo];
						encontrado = true;
						break;

					} else {
						// no hemos encontrado aún el valor, aumentamos el índice de búsqueda en 1
						indice++;
					}

				} // fin del bucle while

				// salida de resultados, en el formato que nos pida el enunciado
				System.out.printf("%d %d", termino1, termino2);
				System.out.println();
			} else {
				// activamos la condición de terminación
				terminar = true;
			}
		} // fin del while

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}// fin de la clase
