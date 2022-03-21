package prenavidad2020.problema3;


import java.util.Scanner;
import java.util.TreeSet;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Ruta del problema: 
* https://www.aceptaelreto.com/problem/statement.php?id=578
* Ruta del juez en línea:
* https://www.aceptaelreto.com/problem/send.php?id=578
 *
 */

public class HaciendoInventario {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	
	
	public static void main(String[] args) {
	
	
	
		int articulos;
		TreeSet<String> inventario;
		String item;
	

		
			
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext() ) {
				articulos=Integer.parseInt(lector.nextLine()) ;			
				//hay que comprobar si llegamos a la condición de terminación
				if (articulos!=0) {
					
					//inicializar conjunto Set de cadenas tipo String
					inventario= new TreeSet<String>();
				
					
					for (int i=0; i<articulos; i++) {
						item= lector.nextLine();
						item= item.trim().toLowerCase();
						inventario.add(item);
						
					}
					
					//salida de resultados, en el formato que nos pida el  enunciado
					
					
					System.out.format("%d%n", inventario.size());
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
	
			lector.close();	
		
	} //fin del main


}
