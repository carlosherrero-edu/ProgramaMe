package navidad2020.problema1;


import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Ruta del problema: 
* https://www.aceptaelreto.com/problem/statement.php?id=576
* Ruta del juez en línea:
* https://www.aceptaelreto.com/problem/send.php?id=576
 * Aceptado por Juez en Línea, envío 617167
 */

public class LeyendoDiccionario {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	
	
	public static void main(String[] args) {
	
	
		int tiempoEntrada; //tiempo necesario para leer cada entrada del diccionario, en segundos
		int sumaEntradas; // número total de entradas en el diccionario
		int tiempoTotal;// tiempo que se necesita para leer todas las entradas, en segundos
		int pagina; // número de entradas en una página
	
			
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext() ) {
				tiempoEntrada= lector.nextInt();		
				//hay que comprobar si llegamos a la condición de terminación
				if (tiempoEntrada >0) {
					sumaEntradas=0; //iniciamos a 0 el número total de entradas en el diccionario
					/*
					 * Recorremos cada página del diccionario y vamos sumando su número de entradas al total
					 */
					do {
						pagina=lector.nextInt();
						sumaEntradas +=pagina;
					} while(pagina>0);
			
		
					tiempoTotal=tiempoEntrada*sumaEntradas; //cálculo del tiempo total, en segundos
					
					//normalización en horas, minutos y segundos
		
					int minutos=tiempoTotal/60; //división entera
					int segundos= tiempoTotal%60;
					
					int horas=minutos/60; //división entera
					minutos= minutos%60;
			
					
					//salida de resultados, en el formato que nos pida el  enunciado

					System.out.format("%02d:%02d:%02d\n", horas, minutos, segundos);
					//System.out.println(tiempoTotal);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
	
			lector.close();	
		
	} //fin del main


}//din clase
