package serie3.p333;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 2: Procesamos todas las entradas hasta encontrar una condición especial
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=333
* Ejecución desde consola(bin):
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO envío 625226
 */
public class NumerosBicapicua {
	
	
	//Objeto de la clase Scanner que usaremos para leer los datos de entrada
	static Scanner lector =new Scanner (System.in);
	
	/**
	 * Función para determinar si un número entero es capicúa
	 * @param numero número pasado como cadena
	 * @return Verdadero si es capicúa, Falso en otro caso
	 */
	static boolean esCapicua(String numero) {
		String numeroAlReves=""; //cadena con el 'inverso' del número
		/*
		 * caso especial: cualquier cadena con 1 sola cifra se considera capicúa
		 */
		if (numero.length()==1) {
			return true;
		} 
		//otro caso especial: si empieza por 0, no lo consideramos capicúa
		else if (numero.charAt(0)=='0') {
			return false;
		} else {
			//construimos caracter a caracter el número al revés
			for (int k=0; k<numero.length();k++) {
				numeroAlReves=numero.charAt(k)+numeroAlReves;
			}
			
			return numero.equals(numeroAlReves);
		}
		
		
	}

	public static void main(String[] args) {
	
	int numero;
	String numeroCad;
	String numero1, numero2;
	boolean esBicapicua;
	
	
		
		//CASO 2: Hemos de procesar todas las entradas hasta llegar a un caso especial, que ignoraremos
		boolean terminar=false;   //condición de terminación 

			
			//leemos mientras haya más líneas y no se produzca la condición de terminación
			while  (!terminar && lector.hasNext()) {
				numero=lector.nextInt();
				
				//hay que comprobar si llegamos a la condición de terminación
				if (!(numero ==0)) {
					// procesamiento
					// si sólo tiene una cifra, no puede ser bicapicua
					if (numero<10) {
						esBicapicua=false;
					} else {
						//convertimos el número a cadena
						numeroCad=Integer.toString(numero);
						//hacemos un bucle mientras encontremos 2 capicúas o lleguemos al final
						esBicapicua=false;
						int posicion=1;
						
						while (!esBicapicua && posicion<numeroCad.length() ) {
							
							//extraemos las dos subcadenas  en que puedo dividir numeroCad
							numero1=numeroCad.substring(0, posicion);  //no incluye posicion
							numero2=numeroCad.substring(posicion);
							
							
							//comprobamos si ambos números son capicúas
							if(esCapicua(numero1) && esCapicua(numero2)) {
								//el número es bicapicúa, paramos el bucle
								esBicapicua=true;
							}
							//incrementamos la posición de corte
							posicion++;
						}
					
					} //fin del procesamiento
				
					//salida de resultados, en el formato que nos pida el  enunciado
					System.out.println( esBicapicua?"SI":"NO");
				} else {
					//activamos la condición de terminación
					terminar =true;
				}
			} //fin del while
			
			lector.close(); // liberación del objeto Scanner
		
	} //fin del main


}//fin de la clase
