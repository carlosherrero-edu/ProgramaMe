package doceuvas;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un n�mero determinado de valores de entrada
* La primera l�nea nos indica el n�mero de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 373: Cubos Visibles
 * @author Asus
 *
 */

public class CubosVisibles {
	
	
	public static void main(String[] args) {
		Scanner teclado=null;
		/* comentar las siguientes l�neas hasta el fin del bloque catch el juez en l�nea */
		File fichero;          
		try {
			
			String ruta = "C:/Users/Asus/sample.in";
			 fichero = new File(ruta);
			 teclado = new Scanner(fichero);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1); // abandonamos la aplicaci�n si se producen erores
		}
		
			
			//teclado = new Scanner(System.in);   //descomentar esta l�nea en el Juez en L�nea
		
		
			int repeticiones;
	
			int dimension;   //dimensi�n del cubo
			long cubosVisibles; //elegimos tipo long porque, al poder llegar dimension a 10^6, puede desbordar la precisi�n de int
	
		//la primera entrada es el n�mero de repeticiones
			repeticiones = teclado.nextInt();
			
			
			
			for (int i=0; i< repeticiones; i++) {
				dimension = teclado.nextInt();
				//sumanos inicialmente los cubos visibles en las caras superior e inferior
				//en cada operaci�n hay que hacer el casting a (long) para evitar el desbordamiento de memoria
				cubosVisibles=(long)2*dimension*dimension;
				//si la dimensi�n es mayor de 2, hay que sumar los cubos visibles en las caras interiores
				if (dimension>2) {
					//hay (dimension-2)   caras interiores
					cubosVisibles += (long)(dimension-2)*(4*dimension-4);
				}
				System.out.println(cubosVisibles);
				
				
			} //fin del for exterior
			
	
	} //fin del main


}
