package plantillas;

import java.io.File;
import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* 
 *
 */

public class Esqueleto_AceptaElReto {
	

	
	
	public static void main(String[] args) {
		Scanner teclado=null;
		/* comentar las siguientes líneas hasta el fin del bloque catch en el juez en línea */
		File fichero;          
		try {
			
			String ruta = "C:/Users/Asus/sample.in";
			 fichero = new File(ruta);
			 teclado = new Scanner(fichero);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1); // abandonamos la aplicación si se producen erores
		}
		/* */ //Fin del comentario multilínea	
		
		//teclado = new Scanner(System.in);   //descomentar esta línea en el Juez en Línea
	
		//CASO 1: La primera entrada nos indica el número de casos que tenemos que procesar
	
			int repeticiones;

		
			
			//la primera entrada es el número de repeticiones
			repeticiones = teclado.nextInt();
			
			for (int i=0; i< repeticiones; i++) {
				
				//lectura de entradas
				
				// procesamiento
				
				//salida de resultados, en el formato que nos pida el  enunciado
				System.out.println( "*************");
			
			} //fin del for
			
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  ( teclado.hasNext() && !terminar) {
				//lectura de entradas
				
				//hay que comprobar si llegamos a la condición de terminación
				if (! <condicionTerminacion>) {
					// procesamiento
				
					//salida de resultados, en el formato que nos pida el  enunciado
					System.out.println( "*************");
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
	//CASO 3: Hemos de procesar todas las entradas hasta llegar al fin del flujo de entrada
			while (teclado.hasNext()) {
				//leemos mientras tengamos algo que leer en el flujo de entrada
				//lectura de entradas
				
				// procesamiento
				
				//salida de resultados, en el formato que nos pida el  enunciado
				System.out.println( "*************");
				
			} //fin del bucle while en el que leemos entradas
				
		
	} //fin del main


}
