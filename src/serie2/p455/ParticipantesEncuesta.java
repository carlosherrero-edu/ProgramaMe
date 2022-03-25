package serie2.p455;

import java.util.Scanner;

/**
* Esqueleto de programa para resolver supuestos del concurso AceptaElReto
* Tipo 1: La primera línea indica el número de casos de prueba
* URL del Problema:
* http://www.aceptaelreto.com/problem/statement.php?id=455
* Ejecución desde consola:
* >>> java   paquete.Clase <ruta/sample.in > ruta/sample.res
 *>>> diff sample.out sample.res  // para comprobar las diferencias
 *ACEPTADO Envío 617869
 */

public class ParticipantesEncuesta {

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);
	
	/**
	 * Cálculo del máximo común divisor de 2 números enteros por el algoritmo de Euclides
	 * @param num1 primer número
	 * @param num2 segundo número, se supone que num1>num2
	 * @return valor de su máximo común divisor
	 */
	static int calcularMcd(int num1, int num2) {
		 int resto;
		 do {
		
			 resto=num1%num2; //resto de la división entera entre num1 y num2
			 if (resto>0) {
				 //para el paso siguiente, usamos la propiedad de que mcd(num1, num2)=mcd(num2, resto)
				 num1=num2;
				 num2=resto;
				 
			 }

		 }while (resto>0);
		 return num2;  
	}

	public static void main(String[] args) {

		// CASO 1: La primera entrada nos indica el número de casos que tenemos que
		// procesar

		int repeticiones;
		int dato;  //dato a procesar, en tantos por 10000

		// la primera entrada es el número de repeticiones
		repeticiones = lector.nextInt();
		// repeticiones = Integer.parseInt(lector.nextLine()); //si usamos nextLine()
		// para lectura

		for (int i = 0; i < repeticiones; i++) {

			// lectura de entradas
			dato=lector.nextInt();

			// procesamiento; necesitamos calcular el máximo común divisor entre el dato leído y 10000
			int mcd=calcularMcd(dato,10000);

			// salida de resultados, en el formato que nos pida el enunciado
			System.out.println(10000/mcd);

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner

	} // fin del main

}//fin de la clase
