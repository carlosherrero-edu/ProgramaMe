package plantillas.ej_caso3;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un n�mero indeterminado de valores de entrada
* Tenemos por tanto que leer entradas hasta que lleguemos al final del fichero o flujo de entrada
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 435: El PIjote
 * @author Asus
 *
 */

public class Pijote {

	static final int ASCII_0 = 48;     //posici�n ASCII del d�gito 0; la del d�gito 9 es 57
	
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
		
			//array donde guardamos las frecuencias de cada d�gito
			int frecuencias[] = new int[10];
			String numero;
			int digito;
			boolean esSubnormal;
			
			while (teclado.hasNext()) {
				//leemos mientras tengamos algo que leer en el flujo de entrada
				numero= teclado.next(); //leemos el siguiente n�mero, como cadena
				
				//inicializamos el array con el n�mero de frecuencias
				for (int i=0; i<10; i++) {
					frecuencias[i]=0;
				}
				
				for (int k=0; k<numero.length(); k++) {    
					//bucle para extraer cada d�gito del n�mero le�do
					//leemos el d�gito , lo convertimos a su c�digo ASCII y restamos el valor ASCII de 0, 48
					digito = (int)numero.charAt(k) - ASCII_0;
					frecuencias[digito]++;    //incrementamos en 1 la frecuencia del correspondiente d�gito
				}
				//una vez le�do el n�mero, tenemos que comprobar si todas las frecuencias son mayores que 0 e iguales
				esSubnormal=true;     //variable booleana para definir si el n�mero es "subnormal" 
				for (int i=1; i<10; i++) {
					if (frecuencias[i]==0|| frecuencias[i] != frecuencias[0]) {
						esSubnormal = false;
					}
				}
				//mostramos el resultado
				System.out.println(esSubnormal ? "subnormal": "no subnormal");
				
				
				
			} //fin del bucle while en el que leemos entradas
			
		
			
	
	} //fin del main


}
