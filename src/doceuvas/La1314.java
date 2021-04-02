package doceuvas;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un n�mero determinado de valores de entrada
* La primera l�nea nos indica el n�mero de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 372: La farsante de Mary Poppins
 * @author Asus
 *
 */

public class La1314 {
	
	

	
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
			String palabra, palabraAlReves, resultado;
			int longitud;  //longitud de la palabra le�da
	
		//la primera entrada es el n�mero de repeticiones
			repeticiones = teclado.nextInt();
			
			
			
			for (int i=0; i< repeticiones; i++) {
				palabra=teclado. next().trim();   //leemos la siguiente palabra eliminando posibles espacios
				
				palabraAlReves="";   //iniciamos con cadena vac�a donde guardamos la palabra al rev�s
				longitud= palabra.length();
				//vamos invirtiendo todas las posiciones
				for (int k=0; k<longitud; k++) {
					palabraAlReves = palabra.charAt(k)+ palabraAlReves;
					
				}
				//la �ltima operaci�n consiste en  escribir la primera letra en may�scula si lo estaba la primera letra de la palabra pasada
			
				if ( longitud>0 && palabra.charAt(0)>='A' && palabra.charAt(0)<='Z' ){
					//si comienza por may�scula, hacemos el cambio.
					if (longitud>1) {
					resultado= palabraAlReves.substring(0,1).toUpperCase() + 
							palabraAlReves.substring(1,longitud-1)+ 
							palabraAlReves.substring(longitud-1, longitud).toLowerCase();	
					} else {
						resultado = palabraAlReves.toUpperCase();
					}
				} else {
					resultado = palabraAlReves;
				}
				
				//
				System.out.println(resultado);
				
		
				
			} //fin del for exterior
			
	
	} //fin del main


}
