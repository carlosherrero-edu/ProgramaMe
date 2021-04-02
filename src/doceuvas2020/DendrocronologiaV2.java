package doceuvas2020;
import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero indeterminado de valores de entrada
* La condici�n de terminaci�n es una �ltima l�nea con algo especial (en este caso, dos ceros)
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 591: Dendrocronologia
 * @author Asus
 *
 */
public class DendrocronologiaV2 {
	
	
	
	public static void main(String[] args) {
		
		Scanner teclado=null;
		/* comentar las siguientes l�neas hasta el fin del bloque catch el juez en l�nea */
		File fichero;          
		try {
			
			String ruta = "C:/Users/Alumno/sample.in";
			 fichero = new File(ruta);
			 teclado = new Scanner(fichero);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1); // abandonamos la aplicaci�n si se producen erores
		}
			
		//teclado = new Scanner(System.in);   //descomentar esta l�nea en el Juez en L�nea
		
	
			//leemos mientras haya m�s entradas por teclado
			while  ( teclado.hasNext()) {
				
				//el primer n�mero es la dimensi�n de la matriz
				int tamanio=teclado.nextInt(); //dimensi�n de la matriz
				
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

		teclado.close();
	} //fin del main

}
