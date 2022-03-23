package navidad2020.problema3;


import java.util.Scanner;
import java.util.TreeSet;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Ruta del problema: 
* https://www.aceptaelreto.com/problem/statement.php?id=578
* Ruta del juez en línea:
* https://www.aceptaelreto.com/problem/send.php?id=578
 *ACeptado por Juez en Línea, envío 616675
 */

public class HaciendoInventario {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	
	
	public static void main(String[] args) {
	
	
	
		int articulos;     //número de artículos en cada caso de prueba
		TreeSet<String> inventario;  //lista de la colección TreeSet para guardar los artículos, evitando duplicados
		String item;   // cadena para leer cada artículo
	

		
			
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext() ) {
				articulos=Integer.parseInt(lector.nextLine()) ;			
				//hay que comprobar si llegamos a la condición de terminación
				if (articulos!=0) {
					
					/*
					 * inicializar conjunto Set de cadenas tipo String
					 * Usamos una colección descendiente de Set porque automáticamente rechazan elementos duplicados
					 * Podría haberse desarrollado con ArrayList, verificando antes que no está por el método contains(objeto)
					 */
					inventario= new TreeSet<String>();
				
					
					for (int i=0; i<articulos; i++) {
						//leemos un nuevo artículo
						item= lector.nextLine();
						//eliminamos del nombre espacios al principio/final y lo convertimos todo a minúsculas
						item= item.trim().toLowerCase();
						//lo agregamos a la lista TreeSet; lo incorporará si aún no está en la lista
						inventario.add(item);
						
					}
					
					//salida de resultados, en el formato que nos pida el  enunciado				
					// sólo tenemos que mostrar el número de elementos en la lista, que sabemos son diferentes
					System.out.format("%d%n", inventario.size());
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
	
			lector.close();	
		
	} //fin del main


}
