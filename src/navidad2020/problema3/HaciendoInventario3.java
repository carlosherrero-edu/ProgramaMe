package navidad2020.problema3;


import java.util.Arrays;

import java.util.Scanner;


/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Ruta del problema: 
* https://www.aceptaelreto.com/problem/statement.php?id=578
* Ruta del juez en línea:
* https://www.aceptaelreto.com/problem/send.php?id=578
 * Aceptado envío 619384
 */

public class HaciendoInventario3 {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	
	
	public static void main(String[] args) {
	
	
	
		int articulos;     //número de artículos en cada caso de prueba
		String[] inventario;  //array de cadenas para guardar los artículos
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
					inventario= new String[articulos];
			
					for (int i=0; i<articulos; i++) {
						//leemos un nuevo artículo
						item= lector.nextLine();
						//eliminamos del nombre espacios al principio/final y lo convertimos todo a minúsculas
						item= item.trim().toLowerCase();
						inventario[i]=item;
					}
					//una vez leídos todos los valores, ordenamos la lista
					Arrays.sort(inventario);
					//y hacemos una ruptura de secuencia; contamos cuántos valores diferentes hay en la lista
					int diferentes=1;
					String anterior=inventario[0];
					for (String valor: inventario) {
						if (!valor.equals(anterior)) {
							//si encontramos un nuevo valor, hacemos ruptura de secuencia
							anterior=valor;
							diferentes++;
						}
					
					}
					
					//salida de resultados, en el formato que nos pida el  enunciado				
					// sólo tenemos que mostrar el número de elementos en la lista, que sabemos son diferentes
					System.out.format("%d%n", diferentes);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
	
			lector.close();	
		
	} //fin del main


}
