package doceuvas2020;

import java.io.File;
import java.util.Scanner;


/**
* Ejemplo de programa de AceptaElREto que lee un número determinado de valores de entrada
* La primera línea nos indica el número de valores a leer; los siguientes se leen por bucle
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
	}//fin del método
	
	
	static int dimeMayor (int[] lista) {	
		int masPeque= lista[0]; //lo inicializo con el primero
				
					
					for ( int elemento : lista) {  //recorro la lista
						 if (masPeque <  elemento) {
				                masPeque = elemento;
				            }
						
					}		
	
	return masPeque;
	
	
}//fin del método
	
	
	static boolean buscarEnLista (int[] lista, int buscado) {
		
		boolean encontrado=false;
		
		for (int elemento: lista) {
			if (elemento == buscado) {
				encontrado = true;
			}
		}
		return encontrado;
	}// fin del método
	
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
	
			int numCalendarios, menor, mayor, huecos;
			int anios[];
	
		//la primera entrada es el número de repeticiones
			repeticiones = teclado.nextInt();
			
			
			
			for (int i=0; i< repeticiones; i++) {
				
				//la segunda entrada es el número de calendarios;
				numCalendarios= teclado.nextInt();
				// en las siguientes entradas leemos los años de los calendarios
				anios= new int[numCalendarios];
				for (int k=0; k<numCalendarios; k++) {
					anios[k]= teclado.nextInt();
				}
				//una vez leídos, hemos de identificar el menor y el mayor año
				menor = dimeMenor(anios);
				mayor= dimeMayor(anios);
				//inicializamos el número de huecos a 0
				huecos=0;
				//recorremos la secuencia de años, salvo los dos extremos, y vemos cuántos huecos tenemos
				for (int k= menor+1; k<=mayor-1; k++) {
					//vemos si el año está en la lista
					if (!buscarEnLista(anios,k)) {
						//si no lo encuentra, hay un hueco más
						huecos++;
					}
				}
				//mostramos el número de huecos
				System.out.println(huecos);
				
				
			} //fin del for exterior
			
	
	} //fin del main


}
