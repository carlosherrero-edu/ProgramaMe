package serie1.p405;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* http://www.aceptaelreto.com/problem/statement.php?id=405
*
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO, envío 617325
 */
public class ImprimiendoPaginasSueltas {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	//separadores que usaremos para la salida
	static final String SEP1="-";
	static final String SEP2=",";
	
	static String agregarASecuencia(int inicio, int fin) {
		if (inicio < fin) {
			return Integer.toString(inicio)+SEP1+Integer.toString(fin)+SEP2;
		} else {
			//ambos índices son iguales
			return Integer.toString(inicio)+SEP2;
			
		}
	}

	public static void main(String[] args) {
		int numPagina; //número de la última página que leemos
		int inicio, actual, esperada, fin;
		String salida;
	
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				//lectura de entradas
				numPagina=lector.nextInt();			
				//hay que comprobar si llegamos a la condición de terminación
				if (! (numPagina==0)) {
					salida=""; //iniciamos la cadena de salida
					 inicio=numPagina;
					 actual=numPagina;
					while (numPagina!=0) {
						esperada=actual+1; //esperamos que la siguiente página sea la correlativa a la actual
						//leemos la siguiente página
						numPagina=lector.nextInt();
						
							if (numPagina!=0 && numPagina==esperada) {
								//la siguiente página leída es la página consecutiva a la actual
								actual=numPagina;
							} else {
								//se rompe la secuencia correlativa, por lo que iniciamos nueva secuencia
								fin=actual;  // la secuencia termina en la última página leída
								salida+=agregarASecuencia(inicio, fin);
								actual=numPagina;
								inicio=numPagina;
								
							}
						
						
					}//fin del bucle while
				
					//salida de resultados, en el formato que nos pida el  enunciado
					//hay que eliminar el último caracter de salida
					salida=  salida.substring(0, salida.length()-1);
					System.out.println( salida);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase
