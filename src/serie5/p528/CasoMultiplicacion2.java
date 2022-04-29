package serie5.p528;

import java.util.Locale;
import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=528
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACCEPTED, una vez sustituidas todas las variables enteras por long
 */
public class CasoMultiplicacion2 {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	

	/**
	 * Método para calcular los subconjutos posibles de 2 elementos en un conjunto de N
	 * @param n entero largo con el número de elementos del conjunto
	 * @return entero largo con el total de subconjuntos de 2 elementos distintos
	 */
	static long calcularCombinaciones (long n) {
		
		
		return n*(n-1)/2;
	}
	

	public static void main(String[] args) {
	
	long numeros;
	double valor;
	lector.useLocale(Locale.US); //para tomar el . como separador decimal
	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				numeros=lector.nextLong();
				
				//hay que comprobar si llegamos a la condición de terminación
				if (!(numeros ==0)) {
					// procesamiento
					long cerosUnos=0; //valores iguales a 0 ó 1
					long masUno=0;
					long menosUno=0;
					
					long totales=0; //entero largo por si acaso excede el rango
					
					//todos los valores son mayores o iguales a 0
					for (long k=0; k<numeros; k++) {
						valor=lector.nextDouble();
						// consideramos que un valor es 0 -1 si la diferencia en valor absoluto es inferior a 10^-3
						if (valor==0||valor==1) {
							cerosUnos++;
						} else if (valor<1) {
							menosUno++;
						} else {
							masUno++;
						}
					}
					
					//calculo las combinaciones de todos los elementos tomados de 2 en dos
					totales=calcularCombinaciones(numeros);
					//de aquí quito las combinaciones posibles de cada número estrictamente mayor de 1 
					//con cada número estrictamente menor de 1
					totales= totales-masUno*menosUno;
					
				
			
				
					//salida de resultados, en el formato que nos pida el  enunciado
					System.out.println( totales);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase
