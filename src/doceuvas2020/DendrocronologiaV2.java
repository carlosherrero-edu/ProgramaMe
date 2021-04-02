package doceuvas2020;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un número indeterminado de valores de entrada
* La condición de terminación es una última línea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 591: Dendrocronologia
 * @author Asus
 *
 */
public class DendrocronologiaV2 {
	
	
	
	public static void main(String[] args) {
		
		Scanner teclado=null;
		/* comentar las siguientes líneas hasta el fin del bloque catch el juez en línea */
		File fichero;          
		try {
			
			String ruta = "C:/Users/Alumno/sample.in";
			 fichero = new File(ruta);
			 teclado = new Scanner(fichero);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1); // abandonamos la aplicación si se producen erores
		}
			
		//teclado = new Scanner(System.in);   //descomentar esta línea en el Juez en Línea
		
	
			//leemos mientras haya más entradas por teclado
			while  ( teclado.hasNext()) {
				
				//el primer número es la dimensión de la matriz
				int tamanio=teclado.nextInt(); //dimensión de la matriz
				
				int anillos = tamanio/2 + tamanio%2; //número de anillos del árbol
				
				//inicializamos un array con los grosores de cada anillo, de tipo long
				long[] grosor= new long[anillos];
				long valor;
				//iniciamos también un contador con la fila que estamos leyendo
		
				//primera parte de la matriz que hemos de procesar
				for (int fila=1; fila<=anillos; fila++) {
					//la fila K contiene valores de K anillos
					for (int col=1; col<=tamanio; col++) {
						//leemos el siguiente valor
						valor= teclado.nextLong();
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
						valor= teclado.nextLong();
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
				
			
				// a continuación mostramos el resultado.
				// hemos de recorrer el array de anillos en sentido inverso
			
				for (int i=anillos-1; i>=0 ; i--) {
					//hay que agregar un espacio final, excepto para el último elemento
					if (i>0) {
						System.out.format("%d ", grosor[i]);
					} else {
						System.out.format("%d", grosor[i]);
					}
					
				}
				
				//agregamos al final un salto de línea
				
				System.out.println();
		
				} // no hay más elementos que leer

		teclado.close();
	} //fin del main

}
