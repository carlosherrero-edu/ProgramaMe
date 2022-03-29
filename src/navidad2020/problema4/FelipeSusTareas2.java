package navidad2020.problema4;


import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

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
 *Aceptado por Juez en Lïnea, envío 619408
 */
public class FelipeSusTareas2 {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	public static void main(String[] args) {
	
		int numeroTareas;          //número de tareas que ha realizado Felipe
		int prioridad, duracion;    //prioridad y duración de cada tarea
		int metrica;            //métrica indicando el nivel de prioridad de la tarea
		TreeMap<Integer,Integer> tablaTareas;  //lista de objetos de la clase Tarea, donde guardamos cada tarea de Felipe
	
	
	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				numeroTareas= lector.nextInt();
				
				//hay que comprobar si llegamos a la condición de terminación
				if (numeroTareas>0) {
					
					//inicializo la lista de tareas. Uso TreeMap, pues me garantiza orden por la clave
					tablaTareas=new TreeMap<Integer,Integer>();
					// procesamiento para cada tarea o línea
					for (int k=0;k<numeroTareas; k++) {
						//leo los campos prioridad y duracion
						prioridad=lector.nextInt();
						duracion=lector.nextInt();
						//creo un nuevo objeto Tarea y lo agrego a la lista
						
						metrica=1000*prioridad+ (1000-duracion);
						if (tablaTareas.containsKey(metrica)) {
							tablaTareas.put(metrica, tablaTareas.get(metrica)+1);
							
						} else {
							//en caso contrario, lo agrego con 1 ocurrencia
							tablaTareas.put(metrica, 1);
						}
						
														
					}
					
				
					//salida de resultados, en el formato que nos pida el  enunciado
					//genero la lista de claves ordenadas de mayor a menor valor
					Set<Integer> listaClaves= tablaTareas.descendingKeySet();
					int repeticiones;
					for (Integer clave : listaClaves) {
						//deshacemos la función de conversión
						prioridad=clave/1000;
						duracion= 1000-( clave%1000);
						repeticiones=tablaTareas.get(clave);
						//mostramos la salida para cada vez que se repite la clave
						for (int k=1; k<=repeticiones; k++) {
							System.out.format("%d %d\n", prioridad,duracion);
						}
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


