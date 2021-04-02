package plantillas.ej_caso1;

import java.io.File;
import java.util.Scanner;

/**
* Ejemplo de programa de AceptaElREto que lee un n�mero determinado de valores de entrada
* La primera l�nea nos indica el n�mero de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 114: Ultimo D�gito de Factorial
 * @author Asus
 *
 */

public class UltimoDigitoFactorial {
	

	static int calcularFactorial (int n) {
	
		int resultado =1;
		
		if (n>1) {
			
			for (int i=2 ; i<=n ; i++) {
				
				resultado *= i;
			}
			
			
		} 
		
		return resultado;
		
	}
		
		
	
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
	
	
			int repeticiones, numero;

		
			
			//la primera entrada es el n�mero de repeticiones
			repeticiones = teclado.nextInt();
			
			for (int i=0; i< repeticiones; i++) {
				
				
				numero = teclado.nextInt();
				//si el n�mero es >=10, el �ltimo d�gito es 0, ya que 10 interviene en el producto
				if (numero >=10) {
					System.out.println(0);
					
				} else {
					//en otro caso, calculo el factorial
					int factorial = calcularFactorial(numero);
					//nos quedamos con la �ltima cifra del factorial y lo imprimimos
					System.out.println( factorial % 10);
				}
				
				
				
			} //fin del for
				
		
	} //fin del main


}
