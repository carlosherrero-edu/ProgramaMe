package doceuvas2020;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un n�mero determinado de valores de entrada
* La primera l�nea nos indica el n�mero de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 587: Gorros de Colores
 * @author Asus
 *
 */

public class GorrosColores {
	
	
	
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
	
			String entrada;
			int minutosRegalo;
			char color1, color2;
	
		//la primera entrada es el n�mero de repeticiones
			repeticiones = teclado.nextInt();
			
			
			
			for (int i=0; i< repeticiones; i++) {
				//leemos la secuencia de gorros
				entrada= teclado.next().trim();
				int ninios= entrada.length();   //cantidad de ni�os, siempre par
				minutosRegalo=0;
				
				for (int k=0; k<ninios; k=k+2) {
					color1= entrada.charAt(k);
					color2= entrada.charAt(k+1);
					if (color1==color2) {
						//2 aciertos
						minutosRegalo +=2;
					} else {
						//1 acierto
						minutosRegalo++;
					}
				}
				
				
				//mostramos el n�mero de minutos regalados
				System.out.println(minutosRegalo);
				
				
			} //fin del for exterior
			
	
	} //fin del main


}
