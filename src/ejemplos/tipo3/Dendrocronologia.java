package ejemplos.tipo3;

import java.util.Scanner;



/**
 * Esqueleto de programa para resolver supuestos del concurso AceptaElReto 
 * Tipo 3: Leemos casos de prueba mientras no existan más entradas
 * URL del Problema: 591
 * 
 * Ejecución desde consola (bin): >>> java paquete.Clase <ruta/sample.in >
 * ruta/sample.res >>> diff sample.out sample.res // para comprobar las diferencias
 */
public class Dendrocronologia {
	
	// Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector = new Scanner(System.in);
	
	public static void main(String[] args) {
	
			//leemos mientras haya m�s entradas por teclado
			while  ( lector.hasNext()) {
				
				//el primer n�mero es la dimensi�n de la matriz
				int tamanio=lector.nextInt(); //dimensi�n de la matriz
				
				int anillos = tamanio/2 + tamanio%2; //n�mero de anillos del �rbol
				
				//inicializamos un array con los grosores de cada anillo, de tipo long
				long[] grosor= new long[anillos];
				long valor;
				//iniciamos tambi�n un contador con la fila que estamos leyendo
		
				//primera parte de la matriz que hemos de procesar
				for (int fila=1; fila<=anillos; fila++) {
					//la fila K contiene valores de K anillos
					for (int col=1; col<=tamanio; col++) {
						//leemos el siguiente valor
						valor= lector.nextLong();
						if (col>=fila && col<= (tamanio+1-fila)) {
							//pertenece al anillo K
							grosor[fila-1] += valor;
						} else if (col< fila) {
							//pertenece al anillo dado por col
							grosor[col-1] += valor;
						} else {
							//pertenece al anillo dado por tamanio+1-col
							grosor[tamanio-col] += valor;
						}
					}
					
				}
				
				//procesamos ahora la segunda parte de la matriz
				for (int fila=anillos+1; fila<=tamanio; fila++) {
					//la fila K contiene valores de (tamanio+1-k) anillos
					int anillos_fila=tamanio+1-fila;
					for (int col=1; col<=tamanio; col++) {
						//leemos el siguiente valor
						valor= lector.nextLong();
						if (col>=anillos_fila && col<= (tamanio+1-anillos_fila)) {
							//pertenece al anillo K
							grosor[anillos_fila-1] += valor;
						} else if (col< anillos_fila) {
							//pertenece al anillo dado por col
							grosor[col-1] += valor;
						} else {
							//pertenece al anillo dado por tamanio+1-col
							grosor[tamanio-col] += valor;
						}
					}
					
				}
				
			
				// a continuaci�n mostramos el resultado.
				// hemos de recorrer el array de anillos en sentido inverso
			
				for (int i=anillos-1; i>=0 ; i--) {
					//hay que agregar un espacio final, excepto para el �ltimo elemento
					if (i>0) {
						System.out.format("%d ", grosor[i]);
					} else {
						System.out.format("%d", grosor[i]);
					}
					
				}
				
				//agregamos al final un salto de l�nea
				
				System.out.println();
		
				} // no hay m�s elementos que leer

		lector.close();
	} //fin del main

}
