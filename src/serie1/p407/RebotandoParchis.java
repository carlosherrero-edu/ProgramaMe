package serie1.p407;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* http://www.aceptaelreto.com/problem/statement.php?id=407
* 
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO Envío 617324
 */
public class RebotandoParchis {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	public static void main(String[] args) {
		int casillas; //casillas del tablero
		int posicion; //posición donde estamso en el tablero
		int tirada; //última tirada obtenida
		int destino; //casilla donde nos situaremos al final
	
	
	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				//lectura de entradas
				casillas=lector.nextInt();
				posicion=lector.nextInt();
				tirada=lector.nextInt();
				
				//hay que comprobar si llegamos a la condición de terminación
				if (! (casillas==0 && posicion==0 && tirada==0) ){
					// procesamiento
					if (posicion+tirada<=casillas) {
						//en este caso no hay rebote
						destino=posicion+tirada;
					} else {
						//en caso contrario, sí hay rebote
						destino= casillas-(tirada-(casillas-posicion));
					}
				
					//salida de resultados, en el formato que nos pida el  enunciado
					System.out.println( destino);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase
