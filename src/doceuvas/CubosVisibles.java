package doceuvas;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un número determinado de valores de entrada
* La primera línea nos indica el número de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 373: Cubos Visibles
 * @author Asus
 *
 */

public class CubosVisibles {
	
	
	public static void main(String[] args) {
		Scanner teclado=null;
		/* comentar las siguientes líneas hasta el fin del bloque catch el juez en línea */
		File fichero;          
		try {
			
			String ruta = "C:/Users/Asus/sample.in";
			 fichero = new File(ruta);
			 teclado = new Scanner(fichero);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1); // abandonamos la aplicación si se producen erores
		}
		
			
			//teclado = new Scanner(System.in);   //descomentar esta línea en el Juez en Línea
		
		
			int repeticiones;
	
			int dimension;   //dimensión del cubo
			long cubosVisibles; //elegimos tipo long porque, al poder llegar dimension a 10^6, puede desbordar la precisión de int
	
		//la primera entrada es el número de repeticiones
			repeticiones = teclado.nextInt();
			
			
			
			for (int i=0; i< repeticiones; i++) {
				dimension = teclado.nextInt();
				//sumanos inicialmente los cubos visibles en las caras superior e inferior
				//en cada operación hay que hacer el casting a (long) para evitar el desbordamiento de memoria
				cubosVisibles=(long)2*dimension*dimension;
				//si la dimensión es mayor de 2, hay que sumar los cubos visibles en las caras interiores
				if (dimension>2) {
					//hay (dimension-2)   caras interiores
					cubosVisibles += (long)(dimension-2)*(4*dimension-4);
				}
				System.out.println(cubosVisibles);
				
				
			} //fin del for exterior
			
	
	} //fin del main


}
