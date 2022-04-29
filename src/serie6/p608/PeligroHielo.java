package serie6.p608;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=608
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACeptado Envío 626906
 */
public class PeligroHielo {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	

	public static void main(String[] args) {
	
	int mediciones; //número de mediciones de temperatura
	int avisos; //número de avisos dados por peligro de hielo
	int temperatura; //temperaturas que vamos leyendo
	int medicionesMas7;
	
	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				mediciones=lector.nextInt();
				
				//hay que comprobar si llegamos a la condición de terminación
				if (!(mediciones ==0)) {
					// procesamiento
					/* 
					 * jay que ir leyendo las mediciones de temperatura
					 * si se encuentra una <=4 grados, se hace sonar la alarma en 2 casos
					 * a) Es la primera medición <=4 grados
					 * b) Desde que se disparó por última vez la alarma, se ha encontrado una medición >=7 grados
					 */
					avisos=0; //reiniciar número de avisos
					medicionesMas7=0; //reiniciar número de mediciones sobre 7 grados
					//leer las mediciones de temperatura
					for (int k=1; k<=mediciones; k++) {
						temperatura=lector.nextInt();
						if (temperatura<=4) {
							//si no ha habido antes ninguna alerta
							if (avisos==0) {
								//activamos primer aviso y reiniciamos medicionesMas7
								avisos++;
								medicionesMas7=0;
							} else {
								if (medicionesMas7>0) {
									//si hubo alguna medición sobre 7 grados, se genera aviso y se reinicia medicionesMas7
									avisos++;
									medicionesMas7=0;
								}
							}
							
							
						} else if (temperatura>=7) {
							medicionesMas7++;
							
						}
						
					}
				
					//salida de resultados, en el formato que nos pida el  enunciado
					System.out.println( avisos);
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase
