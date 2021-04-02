package doceuvas2020;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un n�mero determinado de valores de entrada
* La primera l�nea nos indica el n�mero de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 584: Duraci�n Bombillas
 * @author Asus
 *
 */

public class DuracionBombillas {
	
	
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
		
		
			int repeticiones;
	
			int duracionMax, encendidos, tiempoEncendido;
			String resultado;
		//la primera entrada es el n�mero de repeticiones
			repeticiones = teclado.nextInt();
			
			
			
			for (int i=0; i< repeticiones; i++) {
				//leemos los 3 enteros de cada l�nea
				duracionMax= teclado.nextInt();
				encendidos= teclado.nextInt();
				tiempoEncendido= teclado.nextInt();
				if (duracionMax < encendidos*tiempoEncendido) {
					resultado="HORAS";
				} else if (duracionMax > encendidos*tiempoEncendido) {
					resultado="ENCENDIDOS";
				} else {
					resultado="AMBAS";
				}
				System.out.println(resultado);
				
				
			} //fin del for exterior
			
	
	} //fin del main


}
