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
 */
public class CasoMultiplicacion {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	
	
	//cálculo de factoriales
	/**
	 * Función para el cálculo del factorial de un número entero
	 * @param n número entero, mayor o igual a 0
	 * @return entero largo con el valor del factorial
	 */
	static long calcularFactorial (int n) {
		long producto=1;
		int factor=n;
		while(factor>0) {
			producto*=factor;
			factor--;
		}
		return producto;
	}
	
	/**
	 * Función para el cálculo de las combinaciones de m sobre n , supuesto que m>=n
	 * Nos da el número de subconjuntos de n elementos distintos que se pueden formar con m elementos
	 * @param m  entero positivo
	 * @param n entero positivo, con la condición de que m>=n
	 * @return número de subconjuntos de n elementos distintos, entero largo
	 * Por optimizar, simplifica la fórmula típica   m!/(n! (m-n)!)
	 */
	static long calcularCombinaciones (int m,int n) {
		long resultado=1;
		int tope= (n > m-n)? n:(m-n);
		for (int k=m; k>tope; k--) {
			resultado*=k;
		}
		
		return resultado/calcularFactorial(m-tope);
	}
	

	public static void main(String[] args) {
	
	int numeros;
	double valor;
	lector.useLocale(Locale.US); //para tomar el . como separador decimal
	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				numeros=lector.nextInt();
				
				//hay que comprobar si llegamos a la condición de terminación
				if (!(numeros ==0)) {
					// procesamiento
					int cerosUnos=0; //valores iguales a 0 ó 1
					int masUno=0;
					int menosUno=0;
					
					long totales=0; //entero largo por si acaso excede el rango
					
					//todos los valores son mayores o iguales a 0
					for (int k=0; k<numeros; k++) {
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
					
					//todas las parejas de números mayores de uno dan productos mayores o iguales que los números
					if (masUno>=2)
						totales+=calcularCombinaciones(masUno,2);
					
					//todas las parejas de números menores de uno dan productos menores o iguales que los números
					if (menosUno>=2)
						totales+=calcularCombinaciones(menosUno,2);
					
					//para los ceros y los unos, todas las parejas posibles entre ellos dan productos iguales a los números

					if (cerosUnos>=2)
						totales+=calcularCombinaciones(cerosUnos,2);
					
					//además, cada cero-uno puede combinarse con todos los demás números y dar un resultado menor/mayor o igual a ambos
				
						totales+= cerosUnos*(masUno+menosUno);
				
			
				
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
