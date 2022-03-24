package serie1.p402;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* http://www.aceptaelreto.com/problem/statement.php?id=402
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO Envío 617341
 */
public class DimensionesPuzzle {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	public static void main(String[] args) {
		int numPiezas; //número de piezas del puzzle
		int mayor, menor;
	
	
	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				//lectura de entradas
				numPiezas=lector.nextInt();
				//hay que comprobar si llegamos a la condición de terminación
				if (numPiezas>0) {
					// comenzamos por el número más próximo por exceso a la raíz cuadrada de numPiezas
					mayor=(int)Math.ceil(Math.sqrt(numPiezas));
					// ...y también por el número más próximo por defecto a la raíz cuadrada de numPiezas
					menor=(int)Math.floor(Math.sqrt(numPiezas));
					
					//buscamos el primer múltiplo entero desde mayor o desde menor
					while (numPiezas%mayor !=0 && numPiezas%menor !=0 ) {
						mayor++;
						menor--;
						
					}
					//cuando abandonemos el bucle, habremos encontrado el lado mayor o el menor
					if (numPiezas%menor ==0) {
						//encontramos el lado menor
						mayor=numPiezas/menor;
					}
				
					//salida de resultados, en el formato que nos pida el  enunciado
					System.out.println( mayor);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase
