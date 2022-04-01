package serie2.p457;


import java.util.ArrayList;
import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* http://www.aceptaelreto.com/problem/statement.php?id=457
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *
 */
public class LioCasosPruebaArrayList {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	public static void main(String[] args) {
		ArrayList<Integer >listaCasos;  //  lista dinámica de casos
		int numCasos;
		int perdido;
		int salto;
		int indice;
	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				//lectura de entradas
				numCasos=lector.nextInt();
				
				//hay que comprobar si llegamos a la condición de terminación
				if (numCasos>0) {
					// procesamiento
					//agregamos todos los casos en una lista que instanciamos previamente
					listaCasos= new ArrayList<>();
					
					for (int k=0; k<numCasos; k++) {
						//leemos un nuevo valorvalor y lo agregamos a la lista
						listaCasos.add(lector.nextInt());
					}
					/*
					 * Cuando hayamos leído la lista, la longitud del primer caso
					 * puede fluctuar entre 1 y numCasos
					 * hemos de buscar el valor más pequeño que haga la lista consistente
					 * iremos probando con valores desde el más pequeño -el 1-
					 */
					
					perdido=1; //empezamos suponiendo que el valor perdido y que buscamos  1
					boolean encontrado=false;
					
					while (!encontrado && perdido <=numCasos) {
						try {
							/*
							 * Vamos a ir recorriendo valores de la lista según un salto
							 * Al terminar, el siguiente valor será el salto, el número de valores que deberemos recorrer
							 * Si se produce una excepción, significa que el valor de partida no era el correcto
							 */
							
								//nos situamos en el nodo de la lista indicado por "perdido"
								indice=perdido;	
								while (indice <numCasos) {
							
									salto=listaCasos.get(indice);
									/*
									 * Si el salto es superior al número de elementos que quedan por leer
									 * generamos una excepción para salir del bucle y tomar otro valor de perdido
									 */
									if (salto>(numCasos-indice-1)) {
										throw new Exception("Valor imposible");
									}
									//vemos si esta posición existe y no provoca excepción
									int extremo=listaCasos.get(indice+salto);
			
									//siguiente elemento que hemos de leer
									indice= indice+salto+1;
																	
			
								} //repetimos el proceso
							//si no se ha producido ninguna excepción al recorrer toda la lista, hemos encontrado el valor que buscábamos
							encontrado=true;
							
						} catch (Exception e) {
							//si hay excepción, repetimos con otro valor del valor perdido y que estamos buscando
							perdido++;
						}
						
					}//fin del bucle whie
					
				
					//salida de resultados, en el formato que nos pida el  enunciado
					System.out.println(perdido);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase
