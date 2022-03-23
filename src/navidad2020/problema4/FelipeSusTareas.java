package navidad2020.problema4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=579
* URL del Juez en Línea:
* https://www.aceptaelreto.com/problem/send.php?id=579
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *Aceptado por Juez en Lïnea, envío 616938
 */
public class FelipeSusTareas {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	public static void main(String[] args) {
	
		int numeroTareas;          //número de tareas que ha realizado Felipe
		int prioridad, duracion;    //prioridad y duración de cada tarea
		ArrayList<Tarea> lista;    //lista de objetos de la clase Tarea, donde guardamos cada tarea de Felipe
	
	
	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				numeroTareas= lector.nextInt();
				
				//hay que comprobar si llegamos a la condición de terminación
				if (numeroTareas>0) {
					//inicializo la lista de tareas
					lista=new ArrayList<>(numeroTareas);
					// procesamiento para cada tarea o línea
					for (int k=0;k<numeroTareas; k++) {
						//leo los campos prioridad y duracion
						prioridad=lector.nextInt();
						duracion=lector.nextInt();
						//creo un nuevo objeto Tarea y lo agrego a la lista
	
						lista.add(new Tarea(prioridad,duracion));									
					}
					//una vez leídas , las ordeno por su "orden natural", definido por el método compareTo de la clase Tarea
					Collections.sort(lista);
				
					//salida de resultados, en el formato que nos pida el  enunciado
					for (Tarea t : lista) {
						System.out.format("%d %d\n", t.getPrioridad(),t.getDuracion());
					}
					//separador entre cada lista de tareas
					System.out.println("---");
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase

//clase no pública para gestionar y ordenar las las tareas
	class Tarea implements Comparable<Tarea>{
		
		//propiedades
		int prioridad;
		int duracion;
		
		//constructor
		Tarea(int prioridad, int duracion){
			this.prioridad=prioridad;
			this.duracion=duracion;
		}
		
		
		//getters
	public int getPrioridad() {
			return this.prioridad;
		}



		public int getDuracion() {
			return this.duracion;
		}



	/**
	 *  Este método compara el objeto Tarea que lo recibe con otro objeto Tarea o
	 *  En una ordenación , aparece antes el objeto con mayor valor de prioridad
	 *  Para igual valor de prioridad, aparece antes el objeto con menor duración de la tarea
	 */
	@Override
	public int compareTo(Tarea o) {
		// TODO Auto-generated method stub
		if ( this.getPrioridad() <o.getPrioridad()) {
			return +1;
		} else if (this.getPrioridad() >o.getPrioridad()) {
			return -1;
		} else {
			if (this.getDuracion()<o.getDuracion()) {
				return -1;
			} else if (this.getDuracion()>o.getDuracion()) {
				return +1;
			} else {
				return 0;
			}
		}
	}
		
	} //fin de la clase Tarea
