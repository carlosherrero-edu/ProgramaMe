package serie3.p336;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Esqueleto de programa para resolver supuestos del concurso AceptaElReto Tipo
 * 3: Leemos casos de prueba mientras no existan más entradas URL del Problema:
 * https://www.aceptaelreto.com/problem/statement.php?id=336 Ejecución desde
 * consola (bin): >>> java paquete.Clase <ruta/sample.in > ruta/sample.res >>>
 * diff sample.out sample.res // para comprobar las diferencias NO HA PASADO:
 * ERROR RTE POR LLEGAR AL LÍMITE DE CASOS
 */
public class TiraAfloja {

	// Objeto de la clase Scanner que usaremos para leer los datos de entrada
	// static Scanner lector = new Scanner(System.in);
	//static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args)  {
		int numNinios; // número de niños que tenemos en cada caso
		int[] pesosEnteros;
		String[] pesosCadenas;
		double [] sumaPesos; // pesos acumulados de cada niño
		String lineaLeida;
		int indiceMitad;
		int encontrado; // posición que divide lo mejor posible el array en 2 mitades equilibradas

		// CASO 3: Hemos de procesar todas las entradas hasta llegar al fin del flujo de
		// entrada

		try (BufferedReader lector = new BufferedReader(new InputStreamReader(System.in))) {
			while (lector.ready()) {

				// leemos mientras el buffer de entrada no esté vacío

				// el primer valor es el número de niños
				try {
					numNinios = Integer.parseInt(lector.readLine().trim());
				} catch (NumberFormatException e) {
					//pasamos al siguiente caso
					continue;
				}
				
				pesosEnteros = new int[numNinios];
				sumaPesos = new double[numNinios];
				// leemos la línea con todos los pesos de los niños
				lineaLeida = lector.readLine().trim();
				pesosCadenas = lineaLeida.split("\\s+");
				for (int k = 0; k < numNinios; k++) {
					try {
						pesosEnteros[k] = Integer.parseInt(pesosCadenas[k]);
					}catch (NumberFormatException e) {
						//pasamos al siguiente caso
						continue;
					}
					
				}

				// leemos el peso del primer niño y lo guardamos en la primera celda
				sumaPesos[0] = pesosEnteros[0];
				// los siguientes los leemos y sumamos al valor acumulado en la celda anterior
				for (int k = 1; k < numNinios; k++) {
					sumaPesos[k] = sumaPesos[k - 1] + pesosEnteros[k];
				}

				// procesamiento
				/*
				 * El peso total lo tenemos guardado en la última celda del array Necesitamos
				 * buscar el primer valor más próximo a la mitad del peso total tener en cuenta
				 * que sumaPesos está ordenado, por lo que podemos usar binarySearch Si existe
				 * una celda con ese valor, nos da su posición Si no existe, nos devuelve
				 * (-indice-1), siendo indice la posición del primer elemento mayor a la mitad
				 * del peso total
				 */
				double pesoTotal = sumaPesos[numNinios - 1];
				indiceMitad = Arrays.binarySearch(sumaPesos, pesoTotal / 2);
				if (indiceMitad >= 0) {
					// si el elemento existe en el array, esa es la posición que buscamos
					encontrado = indiceMitad;
				} else {
					// posición del primer elemento en el array con un peso superior o igual a la
					// mitad
					int indiceMayor = (-1) * (indiceMitad + 1);
					// System.out.format("Posición a buscar: %d\n",indiceMayor);
					// calculamos las diferencias en valor absoluto entre las 2 posibles mitades de
					// la cuerda
					// si dividimos la cuerda en indiceMayor...
					double diferencia1 = Math.abs((pesoTotal - sumaPesos[indiceMayor]) - sumaPesos[indiceMayor]);
					// si la dividimos en el elemento anterior, indiceMayor-1 ...
					double diferencia2 = Math.abs((pesoTotal - sumaPesos[indiceMayor - 1]) - sumaPesos[indiceMayor - 1]);
					if (diferencia1 < diferencia2) {
						// dividimos en la posición de indiceMayor
						encontrado = indiceMayor;
					} else if (diferencia1 > diferencia2) {
						// dividimos en la posición anterior
						encontrado = indiceMayor - 1;
					} else {
						// no podemos dividir, en ambos casos la diferencia de pesos es la misma
						encontrado = -1000;
					}
				}

				// salida de resultados, en el formato que nos pida el enunciado
				if (encontrado >= 0) {
					System.out.format("%d %.0f %.0f\n", encontrado + 1, sumaPesos[encontrado],
							sumaPesos[numNinios - 1] - sumaPesos[encontrado]);
				} else {
					System.out.println("NO JUEGAN");
				}

			} // fin del bucle while en el que leemos entradas

		} catch (IOException e) {
			// no hacemos nada
		}

	} // fin del main

}//fin de la clase
