package ejemplos.tipo1;

import java.util.Scanner;

/**
 * Esqueleto de programa para resolver supuestos del concurso AceptaElReto Tipo
 * 1: La primera línea indica el número de casos de prueba 
 * URL del Problema:
 * https://www.aceptaelreto.com/problem/statement.php?id=114
 * URL de la entrega en Juez en Línea:
 * https://www.aceptaelreto.com/problem/send.php?id=114
 * Ejecución desde consola: >>> java paquete.Clase <ruta/sample.in >
 * ruta/sample.res >>> diff sample.out sample.res // para comprobar las
 * diferencias
 */

public class UltimoDigitoFactorial {

	/**
	 * Función para calcular el factorial de un número entero
	 * 
	 * @param n número entero positivo
	 * @return factorial del número indicado
	 */
	static int calcularFactorial(int n) {

		int resultado = 1;

		if (n > 1) {

			for (int i = 2; i <= n; i++) {

				resultado *= i;
			}

		}

		return resultado;

	}

	// ruta base con el objeto de la clase Scanner que usaremos para leer los datos
	// de entrada
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {

		int repeticiones, numero;

		// la primera entrada es el n�mero de repeticiones
		repeticiones = lector.nextInt();

		for (int i = 0; i < repeticiones; i++) {

			numero = lector.nextInt();
			// si el n�mero es >=5, el �ltimo d�gito es 0, ya que 10=2*5 interviene en el
			// producto
			if (numero >= 5) {
				System.out.println(0);

			} else {
				// en otro caso, calculo el factorial
				int factorial = calcularFactorial(numero);
				// nos quedamos con la �ltima cifra del factorial y lo imprimimos
				System.out.println(factorial % 10);
			}

		} // fin del bucle for

		lector.close(); // liberación del objeto Scanner
	} // fin del main

}
