package doceuvas2020;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un n�mero determinado de valores de entrada
* La primera l�nea nos indica el n�mero de valores a leer; los siguientes se leen por bucle
 * Usamos un fichero de entrada con casos de prueba
 * corresponde al problema 586: Calendarios de Bolsillo
 * @author Asus
 *
 */

public class CalendariosBolsillo {
	
	static int dimeMenor (int[] lista) {		
			int masPeque= lista[0]; //lo inicializo con el primero
					
						
						for ( int elemento : lista) {  //recorro la lista
							 if (masPeque >  elemento) {
					                masPeque = elemento;
					            }
							
						}
		
		return masPeque;
	}//fin del m�todo
	
	
	static int dimeMayor (int[] lista) {	
		int masPeque= lista[0]; //lo inicializo con el primero
				
					
					for ( int elemento : lista) {  //recorro la lista
						 if (masPeque <  elemento) {
				                masPeque = elemento;
				            }
						
					}		
	
	return masPeque;
	
	
}//fin del m�todo
	
	
	static boolean buscarEnLista (int[] lista, int buscado) {
		
		boolean encontrado=false;
		
		for (int elemento: lista) {
			if (elemento == buscado) {
				encontrado = true;
			}
		}
		return encontrado;
	}// fin del m�todo
	
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
	
			int numCalendarios, menor, mayor, huecos;
			int anios[];
	
		//la primera entrada es el n�mero de repeticiones
			repeticiones = teclado.nextInt();
			
			
			
			for (int i=0; i< repeticiones; i++) {
				
				//la segunda entrada es el n�mero de calendarios;
				numCalendarios= teclado.nextInt();
				// en las siguientes entradas leemos los a�os de los calendarios
				anios= new int[numCalendarios];
				for (int k=0; k<numCalendarios; k++) {
					anios[k]= teclado.nextInt();
				}
				//una vez le�dos, hemos de identificar el menor y el mayor a�o
				menor = dimeMenor(anios);
				mayor= dimeMayor(anios);
				//inicializamos el n�mero de huecos a 0
				huecos=0;
				//recorremos la secuencia de a�os, salvo los dos extremos, y vemos cu�ntos huecos tenemos
				for (int k= menor+1; k<=mayor-1; k++) {
					//vemos si el a�o est� en la lista
					if (!buscarEnLista(anios,k)) {
						//si no lo encuentra, hay un hueco m�s
						huecos++;
					}
				}
				//mostramos el n�mero de huecos
				System.out.println(huecos);
				
				
			} //fin del for exterior
			
	
	} //fin del main


}
