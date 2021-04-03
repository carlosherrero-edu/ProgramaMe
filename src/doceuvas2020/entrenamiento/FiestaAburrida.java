package doceuvas2020.entrenamiento;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un n�mero determinado de valores de entrada
* La primera l�nea nos indica el n�mero de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 117: La Fiesta Aburrida
 * @author Asus
 *
 */

public class FiestaAburrida {

	
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
	
		//la primera entrada es el n�mero de repeticiones
			repeticiones = teclado.nextInt();
			String nombre;
			
			
			
			for (int i=0; i< repeticiones; i++) {
				teclado.next();  //ignoramos la primera palabra, "Soy"
				nombre= teclado.next().trim();  //nos quedamos con el nombre
				System.out.printf("Hola, %s.\n",nombre);
				
				
			} //fin del for con las repeticiones
			
	
	} //fin del main


}
