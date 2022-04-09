package serie4.p474;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 1: La primera línea indica el número de casos de prueba
* URL del Problema:
* https://www.aceptaelreto.com/problem/statement.php?id=474
* Ejecución desde consola:
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO envío 623232
 */

public class AmigableVecino {

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {

		// CASO 1: La primera entrada nos indica el número de casos que tenemos que
		// procesar

		int repeticiones;
		int posSpider, posBomba1, posBomba2;
		int distancia;

		// la primera entrada es el número de repeticiones
		repeticiones = lector.nextInt();
		// repeticiones = Integer.parseInt(lector.nextLine()); //si usamos nextLine()
		// para lectura

		for (int i = 0; i < repeticiones; i++) {

			// lectura de entraadas con las posiciciones de Spiderman y las bombas
			posSpider= lector.nextInt();
			posBomba1= lector.nextInt();
			posBomba2=lector.nextInt();

			// procesamiento
			
			if (posBomba1>=posSpider && posBomba2>=posSpider) {
				//caso1: Si ambas posiciones están a la derecha de Spiderman
				distancia= Math.max(posBomba1, posBomba2)-posSpider;
			} else if  (posBomba1<=posSpider && posBomba2<=posSpider) {
				//caso 2: si ambas posiciones están a la izquierda de Spiderman
				distancia= posSpider- Math.min(posBomba1, posBomba2);
		}	else {
			//una posición está a la derecha y otra a la izquierda
			if (Math.abs(posBomba1-posSpider)< Math.abs(posBomba2-posSpider)) {
				//Spider primero desactiva la bomba 1 y luego regresa para desactivar bomba 2
				distancia= 2*Math.abs(posBomba1-posSpider)+Math.abs(posBomba2-posSpider);
			} else {
				distancia= Math.abs(posBomba1-posSpider)+2*Math.abs(posBomba2-posSpider);
			}
				
		}
				

			// salida de resultados, en el formato que nos pida el enunciado
			System.out.println(distancia);

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}//fin de la clase
