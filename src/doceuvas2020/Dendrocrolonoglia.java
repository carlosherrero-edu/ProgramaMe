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
public class Dendrocrolonoglia {
	
	
	static long sumarCirculo (long [][] grosores, int comienzo) {
		
		long suma = 0L;
		int fila, col;
		int dimension= grosores.length;
		
		//sumamos fila superior 
		fila=comienzo;
		for ( col=comienzo;  col< dimension-comienzo-1; col++) {
			suma += grosores[fila][col];
		}
		
		//sumamos columna derecha
		col= dimension-comienzo-1;
		for ( fila=comienzo;  fila< dimension-comienzo-1; fila++) {
			suma += grosores[fila][col];
		}
		
		//sumamos fila inferior
		fila= dimension-comienzo-1;
		for ( col=dimension-comienzo-1;  col>comienzo; col--) {
			suma += grosores[fila][col];
		}
		
		//sumamos columna izquierda
		col=comienzo;
				for ( fila=dimension-comienzo-1;  fila>comienzo; fila--) {
					suma += grosores[fila][col];
				}
		
		
		return suma;
	}
	


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
				
				int filas=teclado.nextInt(); //dimensión de la matriz
				int anillos = filas/2 + filas%2; //número de anillos del árbol
				
				//inicializamos una matriz cuadrada y leemos sus valores de teclado
				//los grosores pueden llegar hasta 10^13, por eso los guardamos en una matriz de long
				long [][] grosor= new long[filas][filas];
				for (int i=0; i<filas; i++) {
					for (int j=0; j<filas; j++) {
						grosor[i][j]=teclado.nextLong();
					}
					
				}
				
				long grosorAnillo;
				
				
				//mostramos el resultado en una línea
				for (int i=0; i<anillos; i++) {
					
					if (i==0) {
						//el anillo inferior es especial y lo calculamos aparte
						if ( anillos == filas/2) {
							//si el número de filas es par
							grosorAnillo = sumarCirculo(grosor, anillos-1);
						} else {
							//sumamos el valor de la celda central
							grosorAnillo = grosor[anillos-1][anillos-1];
						}
					} else {
						grosorAnillo = sumarCirculo(grosor, anillos-1-i );
					}
					//dejamos un espacio en blanco entre cada resultado
					System.out.format("%d ", grosorAnillo);
					
				}
				//al final imprimimos salto de línea
				System.out.println();

				
			
			}
		
		teclado.close();
	} //fin del main

}
