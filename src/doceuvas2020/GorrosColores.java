package doceuvas2020;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un número determinado de valores de entrada
* La primera línea nos indica el número de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 587: Gorros de Colores
 * @author Asus
 *
 */

public class GorrosColores {
	
	
	
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
		
		
			int repeticiones;
	
			String entrada;
			int minutosRegalo;
			char color1, color2;
	
		//la primera entrada es el número de repeticiones
			repeticiones = teclado.nextInt();
			
			
			
			for (int i=0; i< repeticiones; i++) {
				//leemos la secuencia de gorros
				entrada= teclado.next().trim();
				int ninios= entrada.length();   //cantidad de niños, siempre par
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
				
				
				//mostramos el número de minutos regalados
				System.out.println(minutosRegalo);
				
				
			} //fin del for exterior
			
	
	} //fin del main


}
