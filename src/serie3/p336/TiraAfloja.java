package serie3.p336;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Esqueleto de programa para resolver supuestos del concurso AceptaElReto 
 * Tipo 3: Leemos casos de prueba mientras no existan más entradas
 * URL del Problema:
 * https://www.aceptaelreto.com/problem/statement.php?id=336
 * Ejecución desde consola (bin): >>> java paquete.Clase <ruta/sample.in >
 * ruta/sample.res >>> diff sample.out sample.res // para comprobar las diferencias
 * NO HA PASADO: ERROR RTE POR LLEGAR AL LÍMITE DE CASOS
 */
public class TiraAfloja {

	// Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector = new Scanner(System.in);
	
	static int leerNumero() {
		int leido=-1;
		try {
			 leido= Integer.parseInt(lector.next());
		
		} catch (Exception e) {
			lector.close();
			System.exit(0);
		}
		 return leido;
		
	}

	public static void main(String[] args) {
		int numNinios; //número de niños que tenemos en cada caso
		int peso;
		int[] sumaPesos; //pesos acumulados de cada niño

		int indiceMitad;
		int encontrado; //posición que divide lo mejor posible el array en 2 mitades equilibradas

		// CASO 3: Hemos de procesar todas las entradas hasta llegar al fin del flujo de
		// entrada
		while (lector.hasNext()) {
			// leemos mientras tengamos algo que leer en el flujo de entrada
			// lectura de entradas
			
			//el primer valor es el número de niños
			numNinios=leerNumero();
			
			sumaPesos=new int[numNinios];
			
			//leemos el peso del primer niño y lo guardamos en la primera celda
			sumaPesos[0]=leerNumero();
			//los siguientes los leemos y sumamos al valor acumulado en la celda anterior
			for (int k=1; k<numNinios; k++) {
				peso=leerNumero();
				
				sumaPesos[k]=sumaPesos[k-1]+peso;
			}
			//LIMPIO BUFFER
			lector.nextLine();
			
			// procesamiento
			/*
			 * El peso total lo tenemos guardado en la última celda del array
			 * Necesitamos buscar el primer valor más próximo a la mitad del peso total
			 * tener en cuenta que sumaPesos está ordenado, por lo que podemos usar binarySearch
			 * Si existe una celda con ese valor, nos da su posición
			 * Si no existe, nos devuelve  (-indice-1), siendo indice la posición del primer elemento mayor a la mitad del peso total
			 */
			int pesoTotal=sumaPesos[numNinios-1];
			indiceMitad=Arrays.binarySearch(sumaPesos, pesoTotal/2);
			if (indiceMitad>=0) {
				//si el elemento existe en el array, esa es la posición que buscamos
				encontrado=indiceMitad;
			} else {
				//posición del primer elemento en el array con un peso superior o igual a la mitad
				int indiceMayor=(-1)*(indiceMitad+1);
				//System.out.format("Posición a buscar: %d\n",indiceMayor);
				//calculamos las diferencias en valor absoluto entre las 2 posibles mitades de la cuerda
				//si dividimos la cuerda en indiceMayor...
				int diferencia1= Math.abs((pesoTotal-sumaPesos[indiceMayor])-sumaPesos[indiceMayor]);
				//si la dividimos en el elemento anterior, indiceMayor-1 ...
				int diferencia2= Math.abs((pesoTotal-sumaPesos[indiceMayor-1])-sumaPesos[indiceMayor-1]);
				if (diferencia1<diferencia2) {
					//dividimos en la posición de indiceMayor
					encontrado=indiceMayor;
				} else if (diferencia1>diferencia2) {
					//dividimos en la posición anterior
					encontrado=indiceMayor-1;
				} else {
					//no podemos dividir, ponemos un valor negativo
					encontrado=-1000;
				}
			}

			// salida de resultados, en el formato que nos pida el enunciado
			if (encontrado>=0) {
				System.out.format("%d %d %d\n", encontrado+1, sumaPesos[encontrado], sumaPesos[numNinios-1]-sumaPesos[encontrado]);
			} else {
				System.out.println("NO JUEGAN");
			}
			

		} // fin del bucle while en el que leemos entradas
		
		lector.close(); // liberación del objeto Scanner

	} // fin del main

}
