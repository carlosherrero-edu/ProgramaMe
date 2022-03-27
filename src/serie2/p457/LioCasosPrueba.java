package serie2.p457;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* http://www.aceptaelreto.com/problem/statement.php?id=457
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *DA UN TLE
 */
public class LioCasosPrueba {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	public static void main(String[] args) {
		ArrayList<Integer> listaCasos;
		ListIterator<Integer> iterador;
		int numCasos;
		int perdido;
		int salto;
	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				//lectura de entradas
				numCasos=lector.nextInt();
				
				//hay que comprobar si llegamos a la condición de terminación
				if (numCasos>0) {
					// procesamiento
					//agregamos todos los casos en un ArrayList
					listaCasos=new ArrayList<>(numCasos);
					for (int k=0; k<numCasos; k++) {
						//leemos un nuevo valorvalor y lo agregamos a la lista
						listaCasos.add(lector.nextInt());
					}
					/*
					 * Cuando hayamos leído la lista, la longitud del primer caso
					 * puede fluctuar entre 1 y numCasos
					 * hemos de buscar el valor más pequeño que haga la lista consistente
					 */
					
					perdido=1; //empezamos suponiendo que el valor perdido es 1
					boolean encontrado=false;
					
					while (!encontrado && perdido <=numCasos) {
						try {
							/*
							 * Vamos a ir recorriendo valores de la lista según un salto
							 * Al terminar, el siguiente valor será el salto, el número de valores que deberemos recorrer
							 * Si se produce una excepción, significa que el valor de partida no era el correcto
							 */
								//valores del salto inicial
								salto=perdido;
								int cuenta=0;
								//nos situamos al comienzo del iterador
								iterador= listaCasos.listIterator();							
								while (iterador.hasNext()) {
									/*
									 * el primer elemento que leemos es el salto 
									 * lo leemos a partir de la segunda iteración
									 */
									if (cuenta>0) {
										salto= iterador.next();	
									}
									//avanzar el número de elementos indicado por salto, sin guardarlo
									for (int s=0; s<salto;s++) {
										//avanzamos un valor, sin guardarlo
										iterador.next();
										
									}
									//incrementamos cuenta
									cuenta++;
								} //repetimos el proceso
							//si no se ha producido ninguna excepción al recorrer toda la lista, hemos encontrado el valor que buscábamos
							encontrado=true;
							
						} catch (Exception e) {
							//si hay excepción, repetimos con otro valor del valor perdido y que estamos buscando
							perdido++;
						}
						
					}//fin del bucle whie
					
				
					//salida de resultados, en el formato que nos pida el  enunciado
					System.out.println( perdido);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase
