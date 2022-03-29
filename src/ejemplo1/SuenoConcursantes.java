package ejemplo1;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* 
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 */
public class SuenoConcursantes {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
		static Scanner lector =new Scanner (System.in);
		

		public static void main(String[] args) {
			int numNoches;
			int horaIni, horaFin;
			int minIni, minFin;

			int horasTot, minTot;
			String cadena;
		
		
		
			
			//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
			boolean terminar=false;   //condición de terminación 

				
				//leemos mientras haya más líneas y no se produzca la condición de terminación
				while  (!terminar && lector.hasNext()) {
					//lectura de entradas
					numNoches=lector.nextInt();
					
					//hay que comprobar si llegamos a la condición de terminación
					if (numNoches>0) {
						// procesamiento
						horasTot=0;
						minTot=0;
						for (int k=0; k<numNoches; k++) {
							
							cadena=lector.next();
							//extraigo de la cadena los campos relevantes
							horaIni=Integer.parseInt(cadena.substring(0, 2));
							minIni=Integer.parseInt(cadena.substring(3, 5));
							horaFin=Integer.parseInt(cadena.substring(6, 8));
							minFin=Integer.parseInt(cadena.substring(9));
							
							//hago los cálculos
							//supuesto 1: Ambas horas estan entre 22 h  y medianoche
							//supuesto 2: Ambas horas son posteriores a medianoche hasta las 10 h
							if ((horaIni>=22 && horaFin>=22) ||  
								(horaIni<=10 && horaFin<=10) 	){
								horasTot+=(horaFin-horaIni);
								minTot+=(minFin-minIni);
							} else {
								//supuesto 3: una hora es anterior y la otra posterior a medianoche
								//calcular la diferencia entre el minuto anterior a medianoche y la primera hora
								horasTot+=(23-horaIni);
								minTot+=(59-minIni)+1;//para incluir medianoche
								//calcular ahora la diferencia entre la segunda hora y medianoche
								horasTot+=(horaFin-0);
								minTot+=(minFin-0);
							}
						} //fin de lectura de datos
					
						//salida de resultados, en el formato que nos pida el  enunciado
						if (minTot<0) {
							int exceso= ((-1)*minTot)/60 +(minTot%60==0?0:1);
							horasTot-= exceso;
							minTot+=60*exceso;
						}
						
						horasTot= horasTot+ minTot/60;  //división entera
						minTot= minTot%60;
						System.out.printf( "%02d:%02d\n",horasTot, minTot);
					} else {
						//activamos la condición de terminación
						terminar =true;
					}
				} //fin del while
				
				lector.close(); // liberación del objeto Scanner
			
		} //fin del main


}//fin de la clase
