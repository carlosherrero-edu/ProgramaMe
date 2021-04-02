package doceuvas;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un n�mero determinado de valores de entrada
* La primera l�nea nos indica el n�mero de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 157: �Cu�ntos d�as faltan?
 * @author Asus
 *
 */

public class FarsanteMaryPoppins {
	
	

	
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
		
		
			int repeticiones, calibre1, calibre2;
			String entrada;
			String[] calibres = new String[2];
	
		//la primera entrada es el n�mero de repeticiones
			repeticiones = teclado.nextInt();
			
			
			
			for (int i=0; i< repeticiones; i++) {
				entrada=teclado. next().trim();   //leemos la siguiente entrada eliminando posibles espacios
				//asumimos que las entradas son correctas y estas conversiones se producen sin error
				calibres= entrada.split("-");
				
				calibre1=Integer.parseInt(calibres[0]);
				calibre2=Integer.parseInt(calibres[1]);
				/* La condici�n que deben cumplir para ser v�lidos son:
				 * deben ser consecutivos, 
				 * el menor debe ser par
				 */
				if (calibre1>calibre2) {
					//los intercambiamos
					int pivote= calibre1;
					calibre1=calibre2;
					calibre2=pivote;
				}
				//comprobamos si los calibres son correctos
				if (calibre1%2 == 0  && (calibre1+1  == calibre2)) {
					System.out.println("SI");
				} else {
					System.out.println("NO");
				}
				
		
				
			} //fin del for
			
	
	} //fin del main


}
