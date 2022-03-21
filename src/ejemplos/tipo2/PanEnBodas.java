package ejemplos.tipo2;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:172
* https://www.aceptaelreto.com/problem/statement.php?id=172
* Ejecución desde consola:
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 */

public class PanEnBodas {
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);

	public static void main(String[] args) {
		int numComensales;
			String disposicionMesa;
			boolean terminar=false;   //condici�n de terminaci�n 
			
			//leemos mientras haya m�s l�neas y no se produzca la condici�n de terminaci�n
			while  ( !terminar && lector.hasNext() ) {
				
				
				numComensales = lector.nextInt(); //leemos el n�mero
				
				//la condici�n para terminar es que nos pasen un valor 0
				if (numComensales>0 ) {
					//leemos la cadena con la disposici�n de los comensales en la mesa
					//usamos la funci�n "trim" para eliminar posibles espacios y convertimos todo a may�sculas 
					disposicionMesa= lector.next().trim().toUpperCase();
					//iniciamos contadores del n�mero de comensajes que toman el pan de uno u otro lado
					int tomaDerecha=0, tomaIzquierda=0;
					//recorremos la cadena y vemos cu�ntos comensales toman el pan de uno u otro lado
					for (int i=0; i<numComensales; i++) {
						if (disposicionMesa.charAt(i)=='D') {
							tomaDerecha++;
						} else if (disposicionMesa.charAt(i)=='I') {
							tomaIzquierda++;
						}
						
					} //fin del recorrido de la cadena
					//imprimimos el resultado dependiendo de la variable todasPares

					if (tomaDerecha ==0 || tomaIzquierda==0) {
						//si todos los comensales tomaron el pan del mismo lado, o ninguno ha tomado a�n pan...
						System.out.println("TODOS COMEN");
					} else {
						System.out.println("ALGUNO NO COME");
						
					}
					
				} else {
					//activamos la condici�n de terminaci�n
					terminar =true;
				}
			}
		

		lector.close(); //cerramos la conexi�n con el teclado
	}

}
