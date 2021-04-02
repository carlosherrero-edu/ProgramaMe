package doceuvas;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un número determinado de valores de entrada
* La primera línea nos indica el número de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 372: La farsante de Mary Poppins
 * @author Asus
 *
 */

public class La1314 {
	
	

	
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
			String palabra, palabraAlReves, resultado;
			int longitud;  //longitud de la palabra leída
	
		//la primera entrada es el número de repeticiones
			repeticiones = teclado.nextInt();
			
			
			
			for (int i=0; i< repeticiones; i++) {
				palabra=teclado. next().trim();   //leemos la siguiente palabra eliminando posibles espacios
				
				palabraAlReves="";   //iniciamos con cadena vacía donde guardamos la palabra al revés
				longitud= palabra.length();
				//vamos invirtiendo todas las posiciones
				for (int k=0; k<longitud; k++) {
					palabraAlReves = palabra.charAt(k)+ palabraAlReves;
					
				}
				//la última operación consiste en  escribir la primera letra en mayúscula si lo estaba la primera letra de la palabra pasada
			
				if ( longitud>0 && palabra.charAt(0)>='A' && palabra.charAt(0)<='Z' ){
					//si comienza por mayúscula, hacemos el cambio.
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
