package navidad2020.problema5;

import java.util.ArrayList;
import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=580
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *Aceptado por Juez en Línea, envío 617048
 */
public class FotoMafalda {
	
	/**
	 * Tipo enumerado con los nombres de los amigos de Mafalda, incluida la propia Mafalda
	 */
	enum Amigos {
		Mafalda, 
		Felipe,
		Manolito,
		Susanita,
		Miguelito, 
		Libertad,
		Guille;
		
	}
	
	
	/**
	 * Método para buscar los amigos diferentes de Mafalda que existen en la lista de espera
	 * @param lista lista con objetos del tipo enumerado Amigos que están esperando a tomarse una foto
	 * @return  lista con los amigos distintos de Mafalda que aparecen al menos una vez en la lista de amigos que esperan
	 */
	static ArrayList<Amigos> buscarAmigos (ArrayList<Amigos> lista){
		
		ArrayList<Amigos> amigosEncontrados= new ArrayList<>();
		/*
		 * El siguiente método devuelve un array con todos los valores definidos en el tipo enumerado Amigos.
		 */
		 Amigos[] nombres=Amigos.values();
		 for (Amigos miAmigo: nombres) {
			 //si el amigo no es Mafalda y se encuentra en la lista (usando el método indexOf)
			 if (miAmigo!=Amigos.Mafalda && lista.indexOf(miAmigo)>=0) {
				 //en este caso, agregamos este amigo a la lista de amigosEncontrados
				 amigosEncontrados.add(miAmigo);
			 }
					 
		 }
		 return amigosEncontrados;
	}
	

	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	
	

	public static void main(String[] args) {
	
		ArrayList<Amigos> lista; //lista que guardará los amigos que esperan para retratarse, por el orden de llegada
		int numAmigos; //número de amigos que quieren retratarse en cada caso de prueba
		int numFotos; //número de fotos que tomamos en cada caso de prueba
		String amigo; //nombre del siguiente amigo de la lista
	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				//lectura de entradas
				numAmigos=lector.nextInt();
			
				//hay que comprobar si llegamos a la condición de terminación
				if (numAmigos>0) {
					//inicializamos la  lista de amigos en espera y el número de fotos tomadas
					
					lista= new ArrayList<>();
					numFotos=0;  
					// vamos leyendo la lista de amigos
					for (int k=0; k<numAmigos; k++) {
						amigo=lector.next();
						/*
						 * los vamos agregando al final de la lista de amigos
						 * De este modos, los primeros amigos de la lista son los que llevan más tiempo
						 */
						
						lista.add(Amigos.valueOf(amigo));
						
						/*
						 * determinar si tomamos una foto o no, según esté Mafalda en la lista
						 * buscamos entonces la primear posición en la que aparece Mafalda en la lista
						 */
					
						if (lista.indexOf(Amigos.Mafalda)>=0) {
							//Mafalda está en la lista...
							//tenemos que ver cuántos amigos distintos a la propia Mafalda están esperando en la cola
							ArrayList<Amigos> amigosEncontrados= buscarAmigos(lista);
							
							//si hay al menos 2 amigos de Mafalda...
							if (amigosEncontrados.size()>=2) {
								//tomamos una foto con Mafalda y los primeros amigos encontrados
								numFotos++;
								//eliminamos la primera ocurrencia de cada amigo que hemos encontrado en la lista
								for (Amigos miAmigo: amigosEncontrados) {
									//recordar que el método remove() elimina la PRIMERA ocurrencia, empezando por el índice 0
									lista.remove(miAmigo);
								}
								//elimino también a la propia Mafalda, que tiene que aparecer el la foto
								lista.remove(Amigos.Mafalda);
							}//si no tengo aún dos amigos, toca esperar a que lleguen más amigos...
						
						}//si Mafalda no está en la lista de amigos que esperan, no podemos tomar foto...
								
						
					} //fin de la lectura de la lista de amigos
					
				
					/*
					 * salida de resultados, en el formato que nos pida el  enunciado
					 * el primer valor es el número de fotos tomadas
					 * el segundo valor es el número de personas que quedan sin aparecer en ninguna foto, que será el tamaño de la lista
					 */
			
					System.out.printf("%d %d\n", numFotos, lista.size());
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase
