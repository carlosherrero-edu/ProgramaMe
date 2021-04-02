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
				
				int filas=teclado.nextInt(); //dimensi�n de la matriz
				int anillos = filas/2 + filas%2; //n�mero de anillos del �rbol
				
				//inicializamos una matriz cuadrada y leemos sus valores de teclado
				//los grosores pueden llegar hasta 10^13, por eso los guardamos en una matriz de long
				long [][] grosor= new long[filas][filas];
				for (int i=0; i<filas; i++) {
					for (int j=0; j<filas; j++) {
						grosor[i][j]=teclado.nextLong();
					}
					
				}
				
				long grosorAnillo;
				
				
				//mostramos el resultado en una l�nea
				for (int i=0; i<anillos; i++) {
					
					if (i==0) {
						//el anillo inferior es especial y lo calculamos aparte
						if ( anillos == filas/2) {
							//si el n�mero de filas es par
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
				//al final imprimimos salto de l�nea
				System.out.println();

				
			
			}
		
		teclado.close();
	} //fin del main

}
