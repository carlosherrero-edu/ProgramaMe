package serie2.p458;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=458
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *Envío aceptado: 618067
 */
public class MenteTimonel {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	public static void main(String[] args) {
		
		int numEntradas;
		long max1, max2, min1, min2;
		long valor, resultado;
	
	
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				//lectura de entradas
				//leemos primero la cantidad de valores a leer en este caso
				numEntradas=lector.nextInt();
				
				//hay que comprobar si llegamos a la condición de terminación
				if (numEntradas>0) {
					// procesamiento
					//inicializamos todos los valores
			
					max1=Long.MIN_VALUE;
					max2=Long.MIN_VALUE;
					min1=Long.MAX_VALUE;
					min2=Long.MAX_VALUE;
					//ahora hemos de leer el número de valores indicado por numEntradas
					for (int k=0; k<numEntradas; k++) {
						
						valor=lector.nextLong();
						//vemos si el nuevo valor es superior al mayor valor leído
						if (valor>max2) {
							if (valor>max1) {
								//rotar valores
								max2=max1;
								max1=valor;
							} else { // en otro caso, cambiar sólo max2
								max2=valor;
							}
						}//fin del tratamiento de valores mayores
						//hacemos el mismo tratamiento comparando con menores
						if (valor<min2) {
							//si es también inferior a min1, rotar valores
							if (valor<min1) {
								min2=min1;
								min1=valor;
							} else {
								//en este caso, cambiar sólo min2
								min2=valor;
							}
							
						}//fin tratamiento de mínimos
						
					}//fin del bucle de lectura de números
					resultado=Math.max(max1*max2, min1*min2);
				
					//salida de resultados, en el formato que nos pida el  enunciado
					System.out.println( resultado);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase
