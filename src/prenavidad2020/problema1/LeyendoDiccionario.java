package prenavidad2020.problema1;


import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Ruta del problema: 
* https://www.aceptaelreto.com/problem/statement.php?id=576
* Ruta del juez en línea:
* https://www.aceptaelreto.com/problem/send.php?id=576
 *
 */

public class LeyendoDiccionario {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	
	
	public static void main(String[] args) {
	
	
		int tiempoEntrada;
		int sumaEntradas, tiempoTotal;
		int pagina;
	
			
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext() ) {
				tiempoEntrada= lector.nextInt();		
				//hay que comprobar si llegamos a la condición de terminación
				if (tiempoEntrada >0) {
					sumaEntradas=0; //suma de las entradas que existen entre todas las páginas
					do {
						pagina=lector.nextInt();
						sumaEntradas +=pagina;
					} while(pagina>0);
			
		
					tiempoTotal=tiempoEntrada*sumaEntradas; //cálculo del tiempo total
					
					int horas=0;
					int minutos=0;
			
					
					//salida de resultados, en el formato que nos pida el  enunciado
					if (tiempoTotal>59) {
						minutos=tiempoTotal/60;  //división entera
						tiempoTotal= tiempoTotal%60;
					}
					
					if (minutos>59) {
						horas=minutos/60;  //división entera
						minutos= minutos%60;
					}
					
					System.out.format("%02d:%02d:%02d%n", horas, minutos, tiempoTotal);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
	
			lector.close();	
		
	} //fin del main


}
